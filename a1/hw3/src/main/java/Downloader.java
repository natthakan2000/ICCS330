import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
    public static void methodOne(String inputUrl) throws IOException {
        int connectionTimeout = 10000;
        int readTimeout = 10000;
        String ext = FilenameUtils.getExtension(inputUrl);
        FileUtils.copyURLToFile(new URL(inputUrl), new File("test1."+ext), connectionTimeout, readTimeout);
    }
    public static void methodTwo(String inputUrl){
        String ext = FilenameUtils.getExtension(inputUrl);
        try (BufferedInputStream in = new BufferedInputStream(new URL(inputUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("test2."+ext)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void methodThree(String inputUrl) throws IOException {
        String ext = FilenameUtils.getExtension(inputUrl);
        URL url = new URL(inputUrl);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("test3."+ext);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}

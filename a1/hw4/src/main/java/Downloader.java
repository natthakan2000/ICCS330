import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.*;
import java.net.URL;
import java.util.Objects;

public class Downloader{
    CloseableHttpClient closeableHttpClient;
    public void fileDownloader(String inputUrl, String filePath) {
        try {
            HttpGet httpGet = new HttpGet(inputUrl);
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            if(responseCode<=200) {
                InputStream inputStream = httpEntity.getContent();
                createDir(filePath.replaceFirst(Objects.requireNonNull(FilenameUtils.getName(new URL(inputUrl).getPath())),""));
                FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
                int in;
                while ((in = inputStream.read()) != -1) {
                    fileOutputStream.write(in);
                }
                inputStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void terminateDownload() {
        try {
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void input() {
        closeableHttpClient = HttpClientBuilder.create().build();
    }
    public void createDir(String downloadPath){
        File files = new File(downloadPath);
        if (!files.exists()) {
            if (files.mkdirs()) {
            } else {
                System.exit(1);
            }
        }
    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputUrl = "https://muic.mahidol.ac.th/eng/wp-content/downloads/calendar/academic_calendar_2020-2021.pdf";
        Downloader.methodOne(inputUrl);
        Downloader.methodTwo(inputUrl);
        Downloader.methodThree(inputUrl);
    }
}

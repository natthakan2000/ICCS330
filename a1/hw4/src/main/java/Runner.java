import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Runner {
    private String domain = "https://ooc.cs.muzoo.io/docs/";
    private String inputPath = "/Users/natthakan/muic/iccs330/a1/hw4";
    private HashSet<String> visited = new HashSet<>();
    private Downloader downloader = new Downloader();
    private HashSet<String> resources = new HashSet<>();
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public void run(String inputurl){
        setDomain(inputurl);
        prepareDownload();
        bfs(inputurl);
        download();
        result();
    }
    private void prepareDownload() {
        System.out.println("running");
        inputPath = "/Users/natthakan/muic/iccs330/a1/hw4"; //Path for downloaded file location (required)
        downloader.createDir(inputPath);
        downloader.input();
    }
    private void result(){
        int total = download();
        System.out.println("Total number of words is: "+ total);
        downloader.terminateDownload();
    }
    private int counter(String html){
        Document document = null;
        String text = null;
        try {
            document = Jsoup.parse(new File(html), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            assert document != null;
            text = document.body().text();
        }catch(NullPointerException e){
            e.getStackTrace();
        }
        if (text == null || text.isEmpty()) {
            return 0;
        }else{
            StringTokenizer str = new StringTokenizer(text);
            return str.countTokens();
        }
    }
    private int download(){
        int temp = 0;
        for (String inputUrl: visited ) {
            String filePath = inputPath +inputUrl.replaceFirst(getDomain(),"");
            downloader.fileDownloader(inputUrl,filePath);
            if(Files.exists(Paths.get(filePath))) {
                extractor(filePath);
            }
            temp += counter(filePath);
        }
        return temp;
    }
    public void extractor(String filePath) {
        Document document = null;
        try {
            document = Jsoup.parse(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert document != null;
        Elements source = document.select("[src]");
        Elements links = document.select("link[href]");
        for (Element src : source) {
            String newPath = src.attr("src").replaceAll("\\.\\./","");
            if(resources.contains(newPath)){
                continue;
            }
            resources.add(newPath);
            downloader.fileDownloader(domain+newPath, inputPath+newPath.replaceFirst(getDomain(),""));
            //downloader.fileDownloader(domain+newPath, inputPath +newPath.replaceFirst(getDomain(),""));
        }
        for (Element link : links) {
            String newPath = link.attr("href").replaceAll("\\.\\./","");
            //downloader.fileDownloader(domain+newPath, inputPath +newPath.replaceFirst(getDomain(),""));
            if(resources.contains(newPath)){
                continue;
            }
            resources.add(newPath);
            downloader.fileDownloader(domain+newPath, inputPath+newPath.replaceFirst(getDomain(),""));
        }
    }
//    private HashSet<String> findNeighbors(String inputUrl){
//        HashSet<String> neighbors = new HashSet<>();
//        Document document = null;
//        try {
//            document = Jsoup.connect(inputUrl).get();
//        } catch (IOException e) {
//            return new HashSet<>();
//        }
//        assert document != null;
//        Elements links = document.select("a[href]");
//        for (Element link : links) {
//            String neighborLink = link.attr("abs:href");
//            if(neighborLink.startsWith(getDomain())) {
//                neighbors.add(neighborLink.replaceFirst("%.*/?", "").replaceFirst("#.*/?", "").replaceAll("\\?.*", ""));
//            }
//        }
//        return neighbors;
//    }
    private HashSet<String> getNeighbour(String inputUrl){
        HashSet<String> neighbours = new HashSet<>();
        Document doc;
        try {
            doc = Jsoup.connect(inputUrl).get();
        } catch (IOException e) {
            return new HashSet<>();
        }
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String neighbourLink = link.attr("abs:href");
            if(neighbourLink.startsWith(getDomain())){
                neighbours.add(neighbourLink.replaceFirst("%.*\\/?","").replaceFirst("#.*\\/?","").replaceAll("\\?.*",""));
            }
        }
        return neighbours;
    }
    private void bfs(String inputUrl){
        //System.out.println("running2");
        visited.add(inputUrl);
        HashSet<String> frontiers = getNeighbour(inputUrl);
        while(!frontiers.isEmpty()){
            HashSet<String> newFrontiers = new HashSet<>();
            for (String urlFrontier: frontiers) {
                if(visited.contains(urlFrontier)) continue;
                String filePath = inputPath+urlFrontier.replaceFirst(getDomain(),"");
                downloader.fileDownloader(urlFrontier,filePath);
                if(Files.exists(Paths.get(filePath))) {
                    extractor(filePath);
                }
                counter(filePath);
                visited.add(urlFrontier);
                newFrontiers.addAll(getNeighbour(urlFrontier));
            }
            frontiers = newFrontiers;
            frontiers.removeAll(visited);
        }
    }
}

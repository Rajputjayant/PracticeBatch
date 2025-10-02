package Sep17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class FindBrokenLink {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
 //       allLinks.addAll(driver.findElements(By.tagName("img")));
        for(WebElement links:allLinks){
            String hrefLink= links.getAttribute("href");
            if(hrefLink==null || hrefLink.isEmpty())
                continue;
            URL urlobj = new URL(hrefLink);
            HttpURLConnection httpURLConnection=(HttpURLConnection)urlobj.openConnection();
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400)
                System.out.println("Its Link Broken" + hrefLink + "Status Code" + httpURLConnection.getResponseCode());
        }

    }
}

package Sep17;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MyFirstSeleniumProgram {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://datatables.net/examples/data_sources/ajax.html");
        Thread.sleep(3000);
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        System.out.println("Size" +allLinks.size());
        for(WebElement links:allLinks){
            if(!links.getText().isEmpty() && links.getText().length()<5)
                System.out.println(links.getText());

        }
    }

    // get all button
    // get all div
    // get all input field
}

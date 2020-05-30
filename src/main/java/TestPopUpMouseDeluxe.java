import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestPopUpMouseDeluxe {
    static WebDriver driver;
    static String browser = "opera";

    public static void main(String[] args) {
        if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("You set an incorrect browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://deluxe-menu.com//popup-mode-sample.html");

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement link1 = driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));

        Actions action = new Actions(driver);

        action.contextClick(link1).perform();
        WebElement link2 = driver.findElement(By.id("dm2m1i1tdT"));
        action.moveToElement(link2).perform();
        WebElement link3 = driver.findElement(By.id("dm2m2i4tdT"));
        action.moveToElement(link3).perform();
        WebElement link4 = driver.findElement(By.id("dm2m4i1tdT"));
        action.moveToElement(link4).perform();
        WebElement link5 = driver.findElement(By.id("dm2m6i1tdT"));
        action.moveToElement(link5).perform();
    }
}

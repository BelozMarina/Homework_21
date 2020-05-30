import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class TestClipboard {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.operadriver().setup();

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("for MacBook, chrome does not support the execution of commands through COMMAND");
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            System.out.println("for MacBook, chrome does not support the execution of commands through COMMAND");
        } else {
            System.out.println("You set an incorrect browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        WebElement select = driver.findElement(By.xpath("//input[@id='identifierId']"));
        select.sendKeys(("vasya@google.com"));
        select.sendKeys(Keys.COMMAND, "a");
        select.sendKeys(Keys.COMMAND, "c");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        select.sendKeys(Keys.COMMAND, "v");

    }
}

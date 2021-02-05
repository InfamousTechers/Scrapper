import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */
public class ScraperConfiguration {
    private final String PATH = "/users/brandonpahla/Projects/InfamousTechers/Scrapper";
    private final String DRIVERPROPERTY = "webdriver.chrome.driver";

    public ScraperConfiguration(String URL, String driverPath){
        // System Property for Chrome Driver
        System.setProperty(DRIVERPROPERTY, driverPath);
    }

    public ScraperConfiguration(String URL){
        System.setProperty(DRIVERPROPERTY, PATH);
    }

    public WebDriver getDriver(String webBrowser){
        if (webBrowser.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();
        else if (webBrowser.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (webBrowser.equalsIgnoreCase("safari"))
            return new SafariDriver();
        else
            return new ChromeDriver();

    }

    public void openVula(WebDriver driver){
        driver.navigate().to("https://vula.uct.ac.za/portal");
    }

    public void logIn(WebDriver driver,String userName, String password){
        driver.findElement(By.id("loginLink1")).click();
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
    }

    public CompScie goToCSC(WebDriver dr){
        return new CompScie(dr);
    }
}

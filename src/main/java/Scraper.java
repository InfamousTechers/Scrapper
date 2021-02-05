
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */


public class Scraper {

    public static void main(String[] args) {

        ScraperConfiguration config = new ScraperConfiguration("https://vula.uct.ac.za/portal");//this constructor can take a driver path also

        WebDriver driver = config.getDriver("chrome");

        config.openVula(driver);

        config.logIn(driver, "StudentNumber", "Password");

        config.goToCSC(driver);

        CompScie csc = config.goToCSC(driver);

        Document document = csc.goToAssignments();

        StaticMethods.getCompScieAssignments(document);// also returns an Hashmap<String, String>
    }

}

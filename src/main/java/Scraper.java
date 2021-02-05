
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */


public class Scraper {
    private static final String cscXpath = "//*[@id=\"topnav\"]/li[13]/a[2]";
    private static final String cscAssignmentXpath = "//*[@id=\"toolMenu\"]/ul/li[9]/a";

    public static void main(String[] args) {

        ScraperConfiguration config = new ScraperConfiguration("https://vula.uct.ac.za/portal");//this constructor can take a driver path also

        WebDriver driver = config.getDriver("chrome");

        config.openVula(driver);

        config.logIn(driver, "UserName", "Password");

        config.goToCSC(driver,cscXpath);

        CompScie csc = config.goToCSC(driver, cscXpath);

        Document document = csc.goToAssignments(cscAssignmentXpath);

        StaticMethods.getCompScieAssignments(document);// also returns an Hashmap<String, String>
    }

}

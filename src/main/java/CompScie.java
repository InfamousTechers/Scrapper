import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */
public class CompScie {
    private WebDriver dr;
    public CompScie(WebDriver dr) {
        this.dr = dr;
        dr.findElement(new By.ByXPath("//*[@id=\"topnav\"]/li[13]/a[2]")).click();
    }

    public Document goToAssignments(){
        //Scroll the pane first so that Assignment will be clickable
        JavascriptExecutor js = (JavascriptExecutor) dr;
        WebElement assignmentsTab = dr.findElement(new By.ByXPath("//*[@id=\"toolMenu\"]/ul/li[9]/a"));

        //scroll until assignmentsTab is found
        js.executeScript("arguments[0].scrollIntoView();", assignmentsTab);

        //click on it
        String assignmentsURL = assignmentsTab.getAttribute("href");
        dr.get(assignmentsURL);

        return passContePageToJsoup(dr.getPageSource());

    }

    private Document passContePageToJsoup(String pageContent){
        return Jsoup.parse(pageContent);
    }




}

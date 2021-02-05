import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */
public class MathStats extends Course{

    public MathStats(WebDriver dr, String Xpath) {
        super(dr);
        goToCourse(Xpath);
    }

    @Override
    public Document goToAssignments(String AssignmentsXpath) {
        //Scroll the pane first so that Assignment will be clickable
        JavascriptExecutor js = (JavascriptExecutor) dr;
        WebElement assignmentsTab = dr.findElement(new By.ByXPath(AssignmentsXpath));

        //scroll until assignmentsTab is found
        js.executeScript("arguments[0].scrollIntoView();", assignmentsTab);

        //click on it
        String assignmentsURL = assignmentsTab.getAttribute("href");
        dr.get(assignmentsURL);

        return passContePageToJsoup(dr.getPageSource());
    }

    @Override
    public HashMap<String, String> getAssignments(String AssignmentsXpath) {
        this.getAssignments(AssignmentsXpath);
        HashMap<String, String> assignments = new HashMap<>(0);

        //getAssignments

        return assignments;

    }

    //test method
    @Override
    public Document goToAnnouncements(String announcementsXpath) {
        //Scroll the pane first so that Assignment will be clickable
        JavascriptExecutor js = (JavascriptExecutor) dr;
        WebElement assignmentsTab = dr.findElement(new By.ByXPath(announcementsXpath));

        //scroll until assignmentsTab is found
        js.executeScript("arguments[0].scrollIntoView();", assignmentsTab);

        //click on it
        String assignmentsURL = assignmentsTab.getAttribute("href");
        dr.get(assignmentsURL);

        return passContePageToJsoup(dr.getPageSource());
    }

    @Override
    public HashMap<String, String> getAnnouncements(String AnnouncementsXpath) {
        return null;
    }

    @Override
    public Document goToTests(String TestXpath) {
        return null;
    }

    @Override
    public HashMap<String, String> getUpComingTests(String TestXpath) {
        return null;
    }

    @Override
    public Document goToGradeBook(String GradeBookXpath) {
        return null;
    }

    @Override
    public HashMap<String, String[]> getMarks(String GradeBookXpath) {
        return null;
    }

    @Override
    void goToCourse(String courseTabXpath) {
        dr.findElement(new By.ByXPath(courseTabXpath)).click();
    }
}

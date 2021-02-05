import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */
public abstract class Course {
    WebDriver dr;

    public Course(WebDriver dr){
        this.dr = dr;
    }

    abstract void goToCourse(String courseTabXpath);


    public abstract Document goToAssignments(String AssignmentsXpath);


    public abstract HashMap<String, String> getAssignments(String AssignmentsXpath);


    public abstract Document goToAnnouncements(String AnnouncementsXpath);


    public abstract HashMap<String, String> getAnnouncements(String AnnouncementsXpath);


    public abstract Document goToTests(String TestXpath);


    public abstract HashMap<String, String> getUpComingTests(String TestXpath);


    public abstract Document goToGradeBook(String GradeBookXpath);


    public abstract HashMap<String, String[]> getMarks(String GradeBookXpath);


    Document passContePageToJsoup(String pageContent){
        return Jsoup.parse(pageContent);
    }



}

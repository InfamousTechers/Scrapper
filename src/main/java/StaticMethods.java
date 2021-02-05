
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.invoke.SwitchPoint;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


/**
 * @author brandonpahla
 * @email brandon.m.paahla@gmail.com
 */
public class StaticMethods {
    private static ArrayList<String> compScieAssignments = new ArrayList<>(0);
    private static HashMap<String, String> compScieAssignmentsDictionary  = new HashMap<>(0);
    private static LocalDate date = LocalDate.now();

    public static HashMap<String, String> getCompScieAssignments(Document doc){
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Elements col = cols.get(1).select("a");
            String todayzDate = date.toString();
            String[] dueDate = cols.select("span").text().split(" ");
            boolean thereIsADueData = dueDate.length !=0;
            if(thereIsADueData){
                if(dateIsPending(dueDate)){
                    compScieAssignmentsDictionary.put(col.attr("title"),cols.select("span").text());// Keys: Name of the Assignment , Values: DueDates
                    System.out.println(col.attr("title")+ "    " + cols.select("span").text());
                }
                System.out.println(col.attr("title")+ "    " + cols.select("span").text());
            }
        }
        return compScieAssignmentsDictionary;
    }

    private static boolean dateIsPending(String[] dueDate){
        String[] curentDate= date.toString().split("-"); // [yyyy, mm, dd]
        int currentYear = Integer.parseInt(curentDate[0]);
        int currentMonth = Integer.parseInt(curentDate[1]);
        int currentDay = Integer.parseInt(curentDate[2]);
        int dueYear = Integer.parseInt(dueDate[2]);
        int dueDay ; // Change month name to month number
        return currentYear==dueYear && currentMonth<=1;
    }




}

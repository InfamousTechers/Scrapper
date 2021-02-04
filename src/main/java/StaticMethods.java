
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    /**
     *the formate of the Date is "yyyy mm dd"
     */
    public static HashMap<String, String> getCompScieAssignments(Document doc){
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Elements col = cols.get(1).select("a");
            String today = date.toString();
            String[] dueDate = cols.select("span").text().split(" ");
            boolean thereIsADueData = dueDate.length !=0;
            if(thereIsADueData){
                if(dateIsPending(today, dueDate)){
                    compScieAssignmentsDictionary.put(col.attr("title"),cols.select("span").text());// Keys: Name of the Assignment , Values: DueDates
                    System.out.println(col.attr("title")+ "    " + cols.select("span").text());
                }
            }
        }
        return compScieAssignmentsDictionary;
    }

    private static boolean dateIsPending(String today, String[] dueDate){
        String[] todayDate= today.split("-");
        int currentMonth = Integer.parseInt(todayDate[1]);
        int dueDateMonth = getMonthNumber(dueDate[1]);
        int currentDay = Integer.parseInt(todayDate[2]);
        int dueDateDay = Integer.parseInt(dueDate[0]);
        return todayDate[0].equalsIgnoreCase(dueDate[2]) && (currentMonth <= dueDateMonth) && (currentDay <= dueDateDay);
    }

    private static int getMonthNumber(String month){
        try{
            Date date = new SimpleDateFormat("MMM").parse(month);//put your month name here
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int monthNumber=cal.get(Calendar.MONTH);
            return monthNumber+1;

        }
        catch(Exception e)
        {
            return -1;
        }
    }


}

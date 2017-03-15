package magasin.modele.charts;

import magasin.modele.json.SellerParser;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Meriveri on 14/03/2017.
 */
public class Charts
{
        String DATA_PATH = System.getProperty("user.dir")+File.separator+"ihm"+File.separator+"data"+File.separator+"magasin"+File.separator+"sales"+File.separator+"sales.json";
        File file = new File(DATA_PATH);

        List<String> sellers;
        int qtYear;
        int qtMonth;
        int qtDay;
        int qtHour;
        List<JSONObject> sales;

        HashMap<String, Integer> sellersSales = new HashMap<>();

    public Charts() throws IOException {

        SellerParser parser = new SellerParser(file);
        sellers = parser.getSallers();
        Calendar c = new GregorianCalendar();
        int year = Calendar.YEAR;
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;

        for(; year > 2013 ; year--)
        {
            c.add(year, -1);
            c.add(month, -1);
            c.add(day, -1);

            qtYear = parser.getYearSales(year);
            qtMonth = parser.getMonthSales(year, month);
            qtDay = parser.getDaySales(year, month, day);
        }

        for(int i = 0; i < sellers.size(); i++)
        {
            sellersSales.put(sellers.get(i), parser.getSellerSales(sellers.get(i)));
        }

        sales = parser.getSales();

    }

    public List<String> getSellers() {
        return sellers;
    }

    public HashMap<String, Integer> getSellersSales() {
        return sellersSales;
    }

    public int getYear(int year) throws IOException
    {
        SellerParser parser = new SellerParser(file);
        return parser.getYearSales(year);
    }

    public int getWeek(int day) throws IOException {
        int q=0;
        SellerParser parser = new SellerParser(file);
        for(int i = 0 ; i < parser.getSales().size(); i++)
        {
            if(parser.getSales().get(i).getInt("Semaine")==day)
            {
                System.out.println("igetin");
                q++;
            }
        }
        return q;
    }

//    public int getWeek(int week) throws IOException
//    {
 //       SellerParser parser = new SellerParser(file);
  //      return parser.getWeekSales(week);}


    public List<JSONObject> getSales() {return sales;}
}

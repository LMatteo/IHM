package magasin.modele.charts;

import magasin.modele.json.SellerParser;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Meriveri on 14/03/2017.
 */
public class Charts
{
        String DATA_PATH = "/../../data/magasin/sales/sales.json";

        List<String> sellers;
        int qtYear;
        int qtMonth;
        int qtDay;
        int qtHour;

        HashMap<String, Integer> sellersSales = new HashMap<>();

    public Charts() throws IOException {
        File file = new File(DATA_PATH);

        SellerParser parser = new SellerParser(file);
        sellers = parser.getSallers();

        Calendar c = new GregorianCalendar();
        int year = Calendar.YEAR;
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;

        for(; year > 2014 ; year--)
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

    }

    public List<String> getSellers() {
        return sellers;
    }

    public HashMap<String, Integer> getSellersSales() {
        return sellersSales;
    }

    public int getQtDay() {
        return qtDay;
    }

    public int getQtMonth() {
        return qtMonth;
    }

    public int getQtHour() {
        return qtHour;
    }

    public int getQtYear() {
        return qtYear;
    }
}

package magasin.modele.json;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meriveri on 14/03/2017.
 */
public class SellerParser extends JsonParser{

    String FILE = System.getProperty("user.dir")+File.separator+"data"+File.separator+"magasin"+File.separator+"sales"+File.separator+"sales.json";

    public static String readJsonFile(String filename) throws IOException {
        try (InputStream is = new FileInputStream(filename)) {
            return IOUtils.toString(is, String.valueOf(StandardCharsets.UTF_8));
        }
    }

    private JSONArray json= new JSONArray(readJsonFile(FILE));


    public SellerParser(File file) throws IOException {
        super(file);
    }

    public List<JSONObject> getSales()
    {
        List<JSONObject> sales = new ArrayList<JSONObject>();
        JSONArray array = this.json;
        for (int i = 0; i < array.length() ; i++)
        {
            sales.add((JSONObject) array.get(i));
        }
        return sales;
    }

    public List<String> getSallers()
    {
        List<JSONObject> sales;
        List<String> sellers = new ArrayList<>();
        sales = getSales();
        for(int i = 0 ; i < sales.size(); i++)
        {
            if(!sellers.contains(sales.get(i).getString("Vendeur")))
               sellers.add((String) sales.get(i).getString("Vendeur"));
        }
        return sellers;
    }

    public int getSellerSales(String seller)
    {
        int qt = 0;
        List<JSONObject> sales;
        sales = getSales();

        for(int i = 0 ; i < sales.size(); i++)
        {
            if(sales.get(i).getString("Vendeur").equals(seller))
            {
                qt++;
            }
        }
        return qt;
    }

    public int getYearSales(int year)
    {
        int qt = 0;
        List<JSONObject> sales;
        sales = getSales();

        for (int i = 0 ; i < sales.size() ; i++)
        {
            if ((int)sales.get(i).getInt("Annee") == year)
                qt++;
        }

        return qt;
    }

    public int getMonthSales(int year, int month)
    {
        int qt = 0;
        List<JSONObject> sales ;
        sales = getSales();

        for (int i = 0 ; i < sales.size() ; i++)
        {
            if ((int)sales.get(i).getInt("Annee") == year && (int)sales.get(i).getInt("Mois") == month )
                qt++;
        }

        return qt;
    }

    public int getDaySales(int year, int month, int day)
    {
        {
            int qt = 0;
            List<JSONObject> sales;
            sales = getSales();

            for (int i = 0 ; i < sales.size() ; i++)
            {
                if ((int)sales.get(i).getInt("Annee") == year && (int)sales.get(i).getInt("Mois") == month && (int)sales.get(i).getInt("Jour")==day)
                    qt++;
            }
            return qt;
        }
    }

    public int getHourSales(int year, int month, int day,String hour)
    {
        {
            int qt = 0;
            List<JSONObject> sales;
            sales = getSales();

            for (int i = 0; i < sales.size(); i++) {
                if ((int)sales.get(i).getInt("Annee") == year && (int)sales.get(i).getInt("Mois") == month && (int)sales.get(i).getInt("Jour") == day && (String) sales.get(i).getString("Heure") == hour)
                    qt++;
            }
            return qt;
        }
    }


}

package magasin.modele.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meriveri on 14/03/2017.
 */
public class SellerParser extends JsonParser{

    public String FILE = File.separator+"data"+File.separator+"magasin"+File.separator+"sales"+File.separator+"sales.json";
    private JSONObject json= new JSONObject(FILE);;


    public SellerParser(File file) throws IOException {
        super(file);
    }

    public List<JSONObject> getSales()
    {
        List<JSONObject> sales = new ArrayList<JSONObject>();
        JSONArray array = this.json.getJSONArray("ventes");
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
               sellers.add(sales.get(i).getString("Vendeur"));
        }
        return sellers;
    }

    public int getSellerSales(String seller)
    {
        int qt = 0;
        List<JSONObject> sales = new ArrayList<JSONObject>();
        sales = getSales();

        for(int i = 0 ; i < sales.size(); i++)
        {
            if(sales.get(i).getString("Vendeur") == seller)
            {
                qt++;
            }
        }
        return qt;
    }

    public int getYearSales(int year)
    {
        int qt = 0;
        List<JSONObject> sales = new ArrayList<JSONObject>();
        sales = getSales();

        for (int i = 0 ; i < sales.size() ; i++)
        {
            if (sales.get(i).getInt("Annee") == year)
                qt++;
        }

        return qt;
    }

    public int getMonthSales(int year, int month)
    {
        int qt = 0;
        List<JSONObject> sales = new ArrayList<JSONObject>();
        sales = getSales();

        for (int i = 0 ; i < sales.size() ; i++)
        {
            if (sales.get(i).getInt("Annee") == year && sales.get(i).getInt("Mois") == month )
                qt++;
        }

        return qt;
    }

    public int getDaySales(int year, int month, int day)
    {
        {
            int qt = 0;
            List<JSONObject> sales = new ArrayList<JSONObject>();
            sales = getSales();

            for (int i = 0 ; i < sales.size() ; i++)
            {
                if (sales.get(i).getInt("Annee") == year && sales.get(i).getInt("Mois") == month && sales.get(i).getInt("Jour")==day)
                    qt++;
            }
            return qt;
        }
    }

    public int getHourSales(int year, int month, int day,String hour)
    {
        {
            int qt = 0;
            List<JSONObject> sales = new ArrayList<JSONObject>();
            sales = getSales();

            for (int i = 0; i < sales.size(); i++) {
                if (sales.get(i).getInt("Annee") == year && sales.get(i).getInt("Mois") == month && sales.get(i).getInt("Jour") == day && sales.get(i).getString("Heure") == hour)
                    qt++;
            }
            return qt;
        }
    }


}

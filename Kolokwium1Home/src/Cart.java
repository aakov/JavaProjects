import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Product> products = new ArrayList<>();
    public void addProduct(Product product, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            products.add(product);
        }
    }

    public double getPrice(int year, int month)
    {
        double price = 0;
        for (int i = 0; i < products.size(); i++)
        {
            price = price + products.get(i).getPrice(year,month);
        }
        return  price;
    }

    public double getInflation(int year1, int month1, int year2, int month2)
    {
        int months = (year2 - year1)*12 + month2-month1;
        return (getPrice(year2,month2)-getPrice(year1,month1))/getPrice(year1,month1)*100/months*12;
    }
}

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FoodProduct extends Product{
    HashMap<String, Double[]> prices = new HashMap<String, Double[]>();
    String province;
    public FoodProduct(String name, HashMap<String, Double[]> prices) {
        super(name);
        this.prices = prices;
    }

    public static FoodProduct fromCsv(Path path) {
        String name;
        HashMap<String, Double[]> prices = new HashMap<String, Double[]>();

        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine(); // odczytuję pierwszą linię i zapisuję ją jako nazwa
            scanner.nextLine();  // pomijam drugą linię z nagłówkiem tabeli
            while (scanner.hasNext()){
                String line[] = scanner.nextLine().split(";");
                String province = line[0];
                Double[] price = Arrays.stream(line).skip(1) // odczytuję kolejną linię i dzielę ją na tablicę
                        .map(value -> value.replace(",", ".")) // zamieniam polski znak ułamka dziesiętnego - przecinek na kropkę
                        .map(Double::valueOf) // konwertuję string na double
                        .toArray(Double[]::new);
                prices.put(province,price);
            }

            scanner.close();

            return new FoodProduct(name, prices);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public double getPrice(int year, int month, String province) {
        if (month < 1 || month > 12 || year < 2010 || year > 2022 || (year == 2022 && month > 3))
        {
            throw new IndexOutOfBoundsException();
        }
        else {
            return prices.get(province)[(year-2010)*12 + month - 1];
        }
    }

    @Override
    public double getPrice(int year, int month) {
        if (month < 1 || month > 12 || year < 2010 || year > 2022 || (year == 2022 && month > 3))
        {
            throw new IndexOutOfBoundsException();
        }
        else {
            double avg = 0;
            for(Double[] value : prices.values()) {
                avg += value[((year-2010)*12)+(month-1)];
            }
            return avg/prices.size();
        }

    }
}

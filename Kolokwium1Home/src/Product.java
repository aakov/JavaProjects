import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Product {
    private String name;
    //private static List<Product> products = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    public static void clearProducts(){
        products.clear();
    }
    public static void addProducts(Function<Path,Product> function,Path path) {
        try {
            List<Product> newProducts = Files.list(path)
                    .map(csvFilePath -> function.apply(csvFilePath))
                    .toList();
            products.addAll(newProducts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // A straight-up better solution bur doesn't meet the requirements
//    public static void addProducts(String type, Path path) {
//        if(type == "NonFoodProduct") {
//            File file_path = new File(String.valueOf(path));
//
//            for(String file : file_path.list()) {
//                products.add(NonFoodProduct.fromCsv(Path.of(path + "/" + file)));
//            }
//        }
//        if(type == "FoodProduct") {
//            File file_path = new File(String.valueOf(path));
//            for(String file : file_path.list()) {
//                products.add(FoodProduct.fromCsv(Path.of(path + "/" + file)));
//            }
//        }
//    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice(int year, int month);

    public static Product getProduct (String prefix) throws AmbigiousProductException, IndexOutOfBoundsException
    {
        List<Product> result = products.stream()
                .filter(product -> product.getName().startsWith(prefix))
                .toList();
//        for (int i = 0; i < products.size(); i++)
//        {
//            if (products.get(i).getName().startsWith(prefix)){
//                result.add(products.get(i));
//            }
//        }
        switch(result.size()) {
            case 0: throw new IndexOutOfBoundsException(prefix);
            case 1: return result.get(0);
            default: throw new AmbigiousProductException(result.stream()
                    .map(product -> product.getName())
                    .collect(Collectors.toList()));
        }
    }

}

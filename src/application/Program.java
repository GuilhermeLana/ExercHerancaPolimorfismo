package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++){

            System.out.println("Product #"+i+" data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            switch (type) {
                case 'c':
                    list.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.println("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(sc.next());
                    list.add(new UsedProduct(name, price, manufactureDate));
                    break;
                case 'i':
                    System.out.println("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customsFee));
                    break;
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product : list ) {

            System.out.println(product.priceTag());

        }

        sc.close();

    }
}

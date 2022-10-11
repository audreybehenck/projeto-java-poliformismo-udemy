package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		List<Product> list = new ArrayList<>();
		
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Product #"+ (i+1) +" data:");
			System.out.println("Common, used or imported (c/u/i)? ");
			char priceTag = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			if (priceTag == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if (priceTag == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
			else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println("\nPRICE TAG");
		
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		sc.close();	}
}

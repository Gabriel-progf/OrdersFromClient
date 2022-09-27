package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Order order = new Order();
		
		OrderItem orderI = new OrderItem();
		
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		System.out.println("Enter order data: ");
		sc.nextLine();
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		Integer n = sc.nextInt();
		sc.nextLine();
		
		order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		for (int i =0; i< n; i++) {
			System.out.println("Enter "+ (i+1) +"# item date: ");
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			
			orderI = new OrderItem(new Product(nameProduct, priceProduct), quantity);
			order.addItem(orderI);

			}
		
		System.out.println("ORDER SUMMARY: ");
		
		System.out.println(order);
		
		
		sc.close();
		

	}

}

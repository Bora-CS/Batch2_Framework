package BoraTech;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class GenerateFakeData {

	public static void main(String[] args) {
		
//		double price = faker.number().randomDouble(2, 5, 50);
//		String itemName = faker.book().title().replace("'", " ");
//		int id = faker.number().numberBetween(101, 110);
//		double quantity = faker.number().numberBetween(1, 3);
//		double total = price * quantity;
//		Date from = new Date(2017, 1, 1, 0, 0);
//		Date to = new Date(2018, 12, 31, 0, 0);
//		Date orderDate = faker.date().between(from, to);
//		
//		Faker faker = new Faker();
//		
//		int id = 1;
//		
//		for (int i = 0; i < 10; i++) {
//			String firstName = faker.name().firstName();
//			String lastName = faker.name().lastName();
//			String phoneNumber = faker.phoneNumber().cellPhone();
//			String email = firstName + "." + lastName + "@gmail.com";
//			System.out.println(id + " " + firstName + "\t" + lastName + "\t" + email + "\t" + phoneNumber);
//			id++;
//		}
		
		Date myDate = new Date();
		
		System.out.println(myDate);
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(myDate);
		
		System.out.println(timeStamp);
	}

}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the numberof taxplayer: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Taxpayer #" + i + " data:");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.println("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				Individual x = new Individual(name, anualIncome, healthExpenditures);
				list.add(x);
			}
			else {
				System.out.println("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(TaxPayer tp : list) {
			
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
		}
		double sum = 0.0;
		for(TaxPayer tp : list) {
			sum += tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
		}
		System.out.println();
		System.out.println("TOTL TAX: $ " + String.format("%.2f", sum));
		
		sc.close();

	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.Paypal;
import services.ProcessPayment;

public class Program {

	public static void main(String[] args) throws ParseException {
			
		
	Locale.setDefault(Locale.US);
	Scanner read = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.println("Enter contract number");
    System.out.print("Number:");
    int number = read.nextInt();
    read.nextLine();
    System.out.print("Date (dd/MM/yyyy):");
    Date date = sdf.parse(read.nextLine());
    System.out.print("Contract Value:");
    double value = read.nextDouble();
    System.out.print("Enter number of installments:");
    int numberInstallments = read.nextInt();
    
    Contract contract = new Contract(number, date, value);
    
    ProcessPayment processPayment = new ProcessPayment(contract, new Paypal());
    processPayment.processInstallment(numberInstallments);
    
    
    
    System.out.println("Installment:");
    for (int i=0; i<numberInstallments; i++) {
    		System.out.println(contract.toString(i));
    }
    
	}

}

package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ProcessPayment {
	
	private Contract contract;
	private PaymentService paymentService;
	
	public ProcessPayment(Contract contract,PaymentService paymentService) {
		this.contract = contract;
		this.paymentService = paymentService;
	}

   public void processInstallment(int numberMounths) {
	   Installment[] installmentList = new Installment[numberMounths];
	   Calendar cal = Calendar.getInstance(); 
	   for (int i=1; i<numberMounths+1; i++) {
		   cal.setTime(contract.getDate()); 
		   cal.add(Calendar.MONTH,i);
		   Date date = cal.getTime();
		   double valueInstallment = contract.getTotalValue()/numberMounths;
		   valueInstallment += (paymentService.fee(valueInstallment)*i);
		   installmentList[i-1] = new Installment(date, valueInstallment+ paymentService.tax(valueInstallment));
	   }
	   
	       contract.setInstallment(installmentList);

	   
	   
	   
   }
	
	

}

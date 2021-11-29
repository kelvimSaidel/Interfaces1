package services;

public class Paypal implements PaymentService {
	
	
	@Override
	public Double fee(double Installment) {
		return Installment * 0.01;
	}
	@Override
	public Double tax(double Installment) {
		return Installment * 0.02;
	}

}

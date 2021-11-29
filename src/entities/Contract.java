package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Contract {
	
	
	private Integer number;
	private Date date;
	private Double totalValue;

	private Installment[] installment;
	
	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;	
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}	

	public Installment[] getInstallment() {
		return installment;
	}

	public void setInstallment(Installment[] installment) {
		this.installment = installment;
	}
	

	public String toString(int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(installment[i].getDueDate())+" - "+installment[i].getAmount();
	}
}

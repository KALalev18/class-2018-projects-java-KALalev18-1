package Models;

import java.util.Objects;

public class User_Payment {
	private int Payment_ID;
	private String Payment_Date;
	private String Payment_Type;
	private float Payment_Costs;

	public User_Payment(int payment_ID, String payment_Date, String payment_Type, float payment_Costs) {
		this.Payment_ID = payment_ID;
		this.Payment_Date = payment_Date;
		this.Payment_Type = payment_Type;
		this.Payment_Costs = payment_Costs;
	}

	public int getPayment_ID() {
		return Payment_ID;
	}

	public void setPayment_ID(int payment_ID) {
		Payment_ID = payment_ID;
	}

	public String getPayment_Date() {
		return Payment_Date;
	}

	public void setPayment_Date(String payment_Date) {
		Payment_Date = payment_Date;
	}

	public String getPayment_Type() {
		return Payment_Type;
	}

	public void setPayment_Type(String payment_Type) {
		Payment_Type = payment_Type;
	}

	public float getPayment_Costs() {
		return Payment_Costs;
	}

	public void setPayment_Costs(float payment_Costs) {
		Payment_Costs = payment_Costs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Payment_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
        {
        	return true;
        }
        if (obj == null || getClass() != obj.getClass()) 
        {
        	return false;
        }
        User_Payment payment = (User_Payment) obj;
        return Objects.equals(Payment_ID, payment.Payment_ID);
	}

	@Override
	public String toString() {
		return "User_Payment [Payment_ID=" + Payment_ID + ", Payment_Date=" + Payment_Date + ", Payment_Type="
				+ Payment_Type + ", Payment_Costs=" + Payment_Costs + "]";
	}

	
}

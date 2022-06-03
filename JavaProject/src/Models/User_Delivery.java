package Models;

import java.util.Objects;

public class User_Delivery {
	private int Delivery_ID;
	private int User_ID;
	private int Payment_ID;
	private String Arrival_Date;
	private String Delivery_Status;
	private String Departure_Date;
	private String Delivery_Address;

	public User_Delivery(int delivery_ID, int user_ID, int payment_ID, String arrival_Date, String delivery_Status,
			String departure_Date, String delivery_Address) {
		this.Delivery_ID = delivery_ID;
		this.User_ID = user_ID;
		this.Payment_ID = payment_ID;
		this.Arrival_Date = arrival_Date;
		this.Delivery_Status = delivery_Status;
		this.Departure_Date = departure_Date;
		this.Delivery_Address = delivery_Address;
	}

	public int getDelivery_ID() {
		return Delivery_ID;
	}

	public void setDelivery_ID(int delivery_ID) {
		Delivery_ID = delivery_ID;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public int getPayment_ID() {
		return Payment_ID;
	}

	public void setPayment_ID(int payment_ID) {
		Payment_ID = payment_ID;
	}

	public String getArrival_Date() {
		return Arrival_Date;
	}

	public void setArrival_Date(String arrival_Date) {
		Arrival_Date = arrival_Date;
	}

	public String getDelivery_Status() {
		return Delivery_Status;
	}

	public void setDelivery_Status(String delivery_Status) {
		Delivery_Status = delivery_Status;
	}

	public String getDeparture_Date() {
		return Departure_Date;
	}

	public void setDeparture_Date(String departure_Date) {
		Departure_Date = departure_Date;
	}

	public String getDelivery_Address() {
		return Delivery_Address;
	}

	public void setDelivery_Address(String delivery_Address) {
		Delivery_Address = delivery_Address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Delivery_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		User_Delivery delivery = (User_Delivery) obj;
		return Objects.equals(Delivery_ID, delivery.Delivery_ID);
	}

	@Override
	public String toString() {
		return "User_Delivery [Delivery_ID=" + Delivery_ID + ", User_ID=" + User_ID + ", Payment_ID=" + Payment_ID
				+ ", Arrival_Date=" + Arrival_Date + ", Delivery_Status=" + Delivery_Status + ", Departure_Date="
				+ Departure_Date + ", Delivery_Address=" + Delivery_Address + "]";
	}

}

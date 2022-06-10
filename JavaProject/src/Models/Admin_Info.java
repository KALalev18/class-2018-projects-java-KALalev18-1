package Models;

import java.util.Objects;

public class Admin_Info {
	private int Admin_ID;
	private String Admin_Email;
	private String Admin_Password;
	private String Admin_First_Name;
	private String Admin_Last_Name;
	private String Admin_Phone_Number;

	public Admin_Info(int admin_ID, String admin_Email, String admin_Password, String admin_First_Name,
			String admin_Last_Name, String admin_Phone_Number) {

		Admin_ID = admin_ID;
		Admin_Email = admin_Email;
		Admin_Password = admin_Password;
		Admin_First_Name = admin_First_Name;
		Admin_Last_Name = admin_Last_Name;
		Admin_Phone_Number = admin_Phone_Number;
	}

	public int getAdmin_ID() {
		return Admin_ID;
	}

	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}

	public String getAdmin_Email() {
		return Admin_Email;
	}

	public void setAdmin_Email(String admin_Email) {
		Admin_Email = admin_Email;
	}

	public String getAdmin_Password() {
		return Admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}

	public String getAdmin_First_Name() {
		return Admin_First_Name;
	}

	public void setAdmin_First_Name(String admin_First_Name) {
		Admin_First_Name = admin_First_Name;
	}

	public String getAdmin_Last_Name() {
		return Admin_Last_Name;
	}

	public void setAdmin_Last_Name(String admin_Last_Name) {
		Admin_Last_Name = admin_Last_Name;
	}

	public String getAdmin_Phone_Number() {
		return Admin_Phone_Number;
	}

	public void setAdmin_Phone_Number(String admin_Phone_Number) {
		Admin_Phone_Number = admin_Phone_Number;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Admin_Info admin = (Admin_Info) obj;
		return Objects.equals(Admin_ID, admin.Admin_ID);
	}

	public int hashCode() {
		return Objects.hash(Admin_ID);
	}

}

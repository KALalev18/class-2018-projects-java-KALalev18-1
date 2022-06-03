package Models;

import java.util.Objects;

public class User_Info {
	private int User_ID;
	private int Registration_ID;
	private String User_Email;
	private String User_Password;
	private String First_Name;
	private String Last_Name;
	private String Phone_Number;

	public User_Info(int user_ID, int registration_ID, String user_Email, String user_Password, String first_Name,
			String last_Name, String phone_Number) {
		this.User_ID = user_ID;
		this.Registration_ID = registration_ID;
		this.User_Email = user_Email;
		this.User_Password = user_Password;
		this.First_Name = first_Name;
		this.Last_Name = last_Name;
		this.Phone_Number = phone_Number;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public int getRegistration_ID() {
		return Registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		Registration_ID = registration_ID;
	}

	public String getUser_Email() {
		return User_Email;
	}

	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}

	public String getUser_Password() {
		return User_Password;
	}

	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public boolean equals(Object obj) {
        if (this == obj) 
        {
        	return true;
        }
        if (obj == null || getClass() != obj.getClass()) 
        {
        	return false;
        }
        User_Info user = (User_Info) obj;
        return Objects.equals(User_ID, user.User_ID);
    }
	
	public int hashCode() {
		return Objects.hash(User_ID);
	}

	public String toString() {
		return "User [User_ID=" + User_ID + ", Registration_ID=" + Registration_ID + ", User_Email=" + User_Email
				+ ", User_Password=" + User_Password + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Phone_Number=" + Phone_Number + "]";
	}
	
	
}

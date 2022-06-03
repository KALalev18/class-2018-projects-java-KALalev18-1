package Models;

import java.util.Objects;

public class Registration {
	private int Registration_ID;

	public Registration(int registration_ID) {

		this.Registration_ID = registration_ID;
	}

	public int getRegistration_ID() {
		return Registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		this.Registration_ID = registration_ID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Registration_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Registration registration = (Registration) obj;
		return Objects.equals(Registration_ID, registration.Registration_ID);
	}

	@Override
	public String toString() {
		return "Registration [Registration_ID=" + Registration_ID + "]";
	}

}

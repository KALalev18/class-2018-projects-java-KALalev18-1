package Models;

import java.util.Objects;

public class Field_Info {
	private int Field_ID;
	private String Field_Type;
	private String Field_Size;
	private String Sports_Location;
	private int Field_Support;

	public Field_Info(int field_ID, String field_Type, String field_Size, String sports_Location, int field_Support) {

		this.Field_ID = field_ID;
		this.Field_Type = field_Type;
		this.Field_Size = field_Size;
		this.Sports_Location = sports_Location;
		this.Field_Support = field_Support;
	}

	public int getField_ID() {
		return Field_ID;
	}

	public void setField_ID(int field_ID) {
		Field_ID = field_ID;
	}

	public String getField_Type() {
		return Field_Type;
	}

	public void setField_Type(String field_Type) {
		Field_Type = field_Type;
	}

	public String getField_Size() {
		return Field_Size;
	}

	public void setField_Size(String field_Size) {
		Field_Size = field_Size;
	}

	public String getSports_Location() {
		return Sports_Location;
	}

	public void setSports_Location(String sports_Location) {
		Sports_Location = sports_Location;
	}

	public int getField_Support() {
		return Field_Support;
	}

	public void setField_Support(int field_Support) {
		Field_Support = field_Support;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Field_ID);
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
        Field_Info field = (Field_Info) obj;
        return Objects.equals(Field_ID, field.Field_ID);
	}

	@Override
	public String toString() {
		return "Field_Info [Field_ID=" + Field_ID + ", Field_Type=" + Field_Type + ", Field_Size=" + Field_Size
				+ ", Sports_Location=" + Sports_Location + ", Field_Support=" + Field_Support + "]";
	}

}

package Models;

import java.util.Objects;

public class Construction_Properties {
	
	private int Material_ID;
	private int Field_ID;
	private int Materials_Count;
	private int Number_Of_Builders;

	public Construction_Properties(int material_ID, int field_ID, int materials_Count, int number_Of_Builders) {

		this.Material_ID = material_ID;
		this.Field_ID = field_ID;
		this.Materials_Count = materials_Count;
		this.Number_Of_Builders = number_Of_Builders;
	}

	public int getMaterial_ID() {
		return Material_ID;
	}

	public void setMaterial_ID(int material_ID) {
		Material_ID = material_ID;
	}

	public int getField_ID() {
		return Field_ID;
	}

	public void setField_ID(int field_ID) {
		Field_ID = field_ID;
	}

	public int getMaterials_Count() {
		return Materials_Count;
	}

	public void setMaterials_Count(int materials_Count) {
		Materials_Count = materials_Count;
	}

	public int getNumber_Of_Builders() {
		return Number_Of_Builders;
	}

	public void setNumber_Of_Builders(int number_Of_Builders) {
		Number_Of_Builders = number_Of_Builders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Material_ID);
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
        Construction_Properties construction = (Construction_Properties) obj;
        return Objects.equals(Material_ID, construction.Material_ID);
	}

	@Override
	public String toString() {
		return "Construction_Properties [Material_ID=" + Material_ID + ", Field_ID=" + Field_ID + ", Materials_Count="
				+ Materials_Count + ", Number_Of_Builders=" + Number_Of_Builders + "]";
	}
	
}

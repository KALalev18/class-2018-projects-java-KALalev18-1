package Models;

import java.util.Objects;

public class Store_Products {
	private int Product_ID;
	private int Delivery_ID;
	private int Material_ID;
	private String Product_Type;
	private float Product_Price;
	private int Product_Quantity;

	public Store_Products(int product_ID, int delivery_ID, int material_ID, String product_Type, float product_Price,
			int product_Quantity) {

		this.Product_ID = product_ID;
		this.Delivery_ID = delivery_ID;
		this.Material_ID = material_ID;
		this.Product_Type = product_Type;
		this.Product_Price = product_Price;
		this.Product_Quantity = product_Quantity;
	}
	
	public int getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}

	public int getDelivery_ID() {
		return Delivery_ID;
	}

	public void setDelivery_ID(int delivery_ID) {
		Delivery_ID = delivery_ID;
	}

	public int getMaterial_ID() {
		return Material_ID;
	}

	public void setMaterial_ID(int material_ID) {
		Material_ID = material_ID;
	}

	public String getProduct_Type() {
		return Product_Type;
	}

	public void setProduct_Type(String product_Type) {
		Product_Type = product_Type;
	}

	public float getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(float product_Price) {
		Product_Price = product_Price;
	}

	public int getProduct_Quantity() {
		return Product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Product_ID);
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
        Store_Products products = (Store_Products) obj;
        return Objects.equals(Product_ID, products.Product_ID);
	}

	@Override
	public String toString() {
		return "Store_Products [Product_ID=" + Product_ID + ", Delivery_ID=" + Delivery_ID + ", Material_ID="
				+ Material_ID + ", Product_Type=" + Product_Type + ", Product_Price=" + Product_Price
				+ ", Product_Quantity=" + Product_Quantity + "]";
	}

}

package obj;

public class Ingredient {
	private String name;
	private float quantity;
	private String unit;
	
	
	/*--------CONSTRUCTOR--------*/
	
	public Ingredient(String name, float quantity, String unit) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	
	/*--------GETTER--------*/
	
	public String getIngredient() {
		return name;
	}
	
	public float getQuantity() {
		return quantity;
	}
	
	public String getUnit() {
		return unit;
	}
	
	
	/*--------SETTER--------*/
	
	public void setIngredient(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	/*--------TO STRING--------*/
	
	public String toString() {
		return "["+name+", "+quantity+", "+unit+"]";
	}
}

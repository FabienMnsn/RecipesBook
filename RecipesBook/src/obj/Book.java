package obj;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private final String name;
	private final int volume;
	private List<Recipe> recipeList;
	
	/*--------CONSTRUCTOR--------*/
	public Book(String name, int volume) {
		this.name = name;
		this.volume = volume;
		recipeList = new ArrayList<>();
	}
	
	/*--------GETTER--------*/
	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVolume() {
		return volume;
	}
	
	/*--------BOOK UTILS--------*/
	public void addRecipe(Recipe r) {
		recipeList.add(r);
	}
	
	/*--------TO STRING--------*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("/*________________________COOKING BOOK________________________*/\n");
		s.append("/*________________________"+name+", volume "+volume+"________________________*/\n\n");
		for(Recipe r : recipeList) {
			s.append(r.toString());
			s.append("--------------------------------------------------------------------------\n");
		}
		s.append("/*________________________COOKING BOOK________________________*/\n");
		return s.toString();
	}
}

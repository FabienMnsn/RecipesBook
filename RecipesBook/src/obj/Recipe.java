package obj;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private String recipeName;
	private int duration;
	private float score;
	private int proportions;
	private boolean containsMeat;
	private boolean cooked;
	private List<Ingredient> ingredientsList;
	private String content;
	
	
	/*--------CONSTRUCTOR--------*/
	
	public Recipe(String recipeName, int duration, float score, int proportions, boolean containsMeat, boolean cooked, String content) {
		this.recipeName = recipeName;
		this.duration = duration;
		this.score = score;
		this.proportions = proportions;
		this.containsMeat = containsMeat;
		this.cooked = cooked;
		ingredientsList = new ArrayList<>();
		this.content = content;
	}
	
	
	/*--------GETTER--------*/
	
	public String getRecipeName() {
		return recipeName;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public float getScore() {
		return score;
	}
	
	public int getProportions() {
		return proportions;
	}
	
	public boolean getContainsMeat() {
		return containsMeat;
	}
	
	public boolean getCooked() {
		return cooked;
	}
	
	public List<Ingredient> getIngredientsList(){
		return ingredientsList;
	}
	
	public String getContent() {
		return content;
	}
	
	
	/*--------SETTER--------*/
	
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
	public void setProportions(int proportions) {
		this.proportions = proportions;
	}
	
	public void setContainsMeat(boolean containsMeat) {
		this.containsMeat = containsMeat;
	}
	
	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	/*--------LIST UTILS--------*/
	
	public void addIngredient(Ingredient i) {
		ingredientsList.add(i);
	}
	
	public boolean removeIngredient(Ingredient i) {
		if(ingredientsList.contains(i)) {
			ingredientsList.remove(i);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*--------TO STRING--------*/
	
	public String toString() {
		String vegan = "";
		String hot = "";
		StringBuilder s = new StringBuilder();
		s.append("NOM : "+recipeName+"\n");
		s.append("TEMPS DE REALISATION : "+duration+" minutes\n");
		s.append("NOTE DELA RECETTE : "+score+"/5\n");
		s.append("PROPORTIONS : "+proportions+" personne(s)\n");
		if(containsMeat)
			vegan = "Oui";
		else
			vegan = "Non";
		s.append("CONTIENT DE LA VIANDE : "+vegan+"\n");
		if(cooked)
			hot = "Oui";
		else
			hot = "Non";
		s.append("CUISSON REQUISE : "+hot+"\n");
		s.append("INGREDIENTS : \n");
		for(Ingredient i : ingredientsList) {
			s.append(i.toString()+"\n");
		}
		s.append("DESCRIPTIF DE LA RECETTE : "+content+"\n");
		return s.toString();
	}
	
}


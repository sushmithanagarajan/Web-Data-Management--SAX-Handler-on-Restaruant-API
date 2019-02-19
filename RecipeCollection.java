import java.util.ArrayList;
import java.util.List;

public class RecipeCollection {
	
	String cuisine;
	List<Recipe> recipeList = new ArrayList<>();
	
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
}

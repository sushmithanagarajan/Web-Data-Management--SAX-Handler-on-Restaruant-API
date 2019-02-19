
public class Recipe {
	
	String id;
	String title;
	String date;
	String comment;
	Nutrition nutrition;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Nutrition getNutrition() {
		return nutrition;
	}
	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}
	
}

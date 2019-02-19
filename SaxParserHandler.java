import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserHandler extends DefaultHandler {
	
	private ArrayList<RecipeCollection> recipeCollectionList = new ArrayList<>();
	private Stack<String> elementStack = new Stack<>();
	private Stack<RecipeCollection> collectionStack = new Stack<>();
	private Stack<Recipe> recipeStack = new Stack<>();
	
	@Override
	public void startDocument() {
		
	}
	
	@Override
	public void endDocument() {
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		this.elementStack.push(qName);
		
		if("collection".equals(qName)) {
			RecipeCollection recipeCollection = new RecipeCollection();
			this.collectionStack.push(recipeCollection);
		}
		
		if("recipe".equals(qName)) {
			Recipe recipe = new Recipe();
			if(attributes != null && attributes.getLength() != 0) {
				recipe.setId(attributes.getValue(0));
			}
			
			this.recipeStack.push(recipe);
		}
		
		if("nutrition".equals(qName)) {
			Recipe recipe = (Recipe) this.recipeStack.peek();
			Nutrition nutrition = new Nutrition();
			if(attributes != null && attributes.getLength() != 0) {
				nutrition.setCalories(attributes.getValue(0));
				nutrition.setCarbohydrates(attributes.getValue(1));
				nutrition.setFats(attributes.getValue(2));
				nutrition.setProteins(attributes.getValue(3));
				nutrition.setAlcohol(attributes.getValue(4));
			}
			recipe.setNutrition(nutrition);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		this.elementStack.pop();
		
		if("collection".equals(qName)) {
			RecipeCollection recipeCollection = (RecipeCollection) this.collectionStack.pop();
			this.recipeCollectionList.add(recipeCollection);
		}
		
		if("recipe".equals(qName)) {
			Recipe recipe = (Recipe) this.recipeStack.pop();
			RecipeCollection recipeCollection = (RecipeCollection) this.collectionStack.peek();
			recipeCollection.getRecipeList().add(recipe);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String value = new String(ch, start, length).trim();
		
		if(value.length() == 0) {
			return;
		}
		
		if("cuisine".equals(this.elementStack.peek())) {
			RecipeCollection recipeCollection = (RecipeCollection) this.collectionStack.peek();
			recipeCollection.setCuisine(value);
		}
		
		if("title".equals(this.elementStack.peek())) {
			Recipe recipe = (Recipe) this.recipeStack.peek();
			recipe.setTitle(value);
		}
		
		if("date".equals(this.elementStack.peek())) {
			Recipe recipe = (Recipe) this.recipeStack.peek();
			recipe.setDate(value);
		}
		
		if("comment".equals(this.elementStack.peek())) {
			Recipe recipe = (Recipe) this.recipeStack.peek();
			recipe.setComment(value);
		}
	}
	
	public ArrayList<RecipeCollection> getRecipeCollection() {
		return recipeCollectionList;
	}
	
}
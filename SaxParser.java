import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxParser {
	
	public static void main(String args[]) {
		
		List<RecipeCollection> recipeCollection = new ArrayList<>();
		
		try {
			
			File xmlFile = new File("src/XML_Document.xml");
			
			SaxParserHandler saxHandler = new SaxParserHandler();
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(saxHandler);
			InputSource source = new InputSource(new FileInputStream(xmlFile));
			xmlReader.parse(source);
			recipeCollection = saxHandler.getRecipeCollection();
			for(int collCounter = 0 ; collCounter < recipeCollection.size() ; collCounter++) {
				System.out.println(recipeCollection.get(collCounter).getCuisine());
				RecipeCollection recCollection = recipeCollection.get(collCounter);
				for(int recCounter = 0 ; recCounter < recCollection.getRecipeList().size() ; recCounter ++) {
					Recipe recipe = recCollection.getRecipeList().get(recCounter);
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("Id : " + recipe.getId());
					System.out.println("Title : " + recipe.getTitle());
					System.out.println("Date : " + recipe.getDate());
					System.out.println("Comment : " + recipe.getComment());
					Nutrition nutrition = recipe.getNutrition();
					System.out.println("--------Nutrition--------");
					System.out.println("Calories : " + nutrition.getCalories());
					System.out.println("Carbohydrates : " + nutrition.getCarbohydrates());
					System.out.println("Fats : " + nutrition.getFats());
					System.out.println("Proteins : " + nutrition.getProteins());
					System.out.println("Alcohol : " + nutrition.getAlcohol());
					System.out.println("---------------------------------------------------------------------------");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
								
	}
	
}

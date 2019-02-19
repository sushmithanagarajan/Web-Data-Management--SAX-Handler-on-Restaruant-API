import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
	
	public static void main(String args[]) {
		
		try {
			
			File inputFile = new File("src/XML_Document.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document document = docBuilder.parse(inputFile);
			document.getDocumentElement().normalize();
			System.out.println("Root Element : " + document.getDocumentElement().getNodeName());
			NodeList collectionList = document.getElementsByTagName("collection");
			for(int colCounter = 0 ; colCounter < collectionList.getLength() ; colCounter ++) {
				Node collectionNode = collectionList.item(colCounter);
				System.out.println(collectionNode.getNodeName());
				if(collectionNode.getNodeType() == Node.ELEMENT_NODE) {
					Element collectionElement = (Element) collectionNode;
					System.out.println("Cuisine : " + collectionElement.getElementsByTagName("cuisine").item(0).getTextContent());
					NodeList recipeList = collectionElement.getElementsByTagName("recipe");
					for(int recipeCounter = 0 ; recipeCounter < recipeList.getLength() ; recipeCounter ++) {
						Node recipeNode = recipeList.item(recipeCounter);
						System.out.println(recipeNode.getNodeName());
						if(recipeNode.getNodeType() == Node.ELEMENT_NODE) {
							Element recipeElement = (Element) recipeNode;
							Node nutritionNode = recipeElement.getElementsByTagName("nutrition").item(0);
							Element nutritionElement = (Element) nutritionNode ;
							System.out.println(recipeElement.getAttribute("id"));
							System.out.println(recipeElement.getElementsByTagName("title").item(0).getTextContent());
							System.out.println(recipeElement.getElementsByTagName("comment").item(0).getTextContent());
							System.out.println(nutritionElement.getAttribute("calories"));
						}
					}
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

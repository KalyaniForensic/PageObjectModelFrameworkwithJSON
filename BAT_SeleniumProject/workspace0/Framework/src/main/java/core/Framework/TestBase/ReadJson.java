package core.Framework.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import core.Framework.PageLibrary.PageAction;

public class ReadJson {

	
	public static String readJsonParameter(String KeyName,String JsonFile){
	
		JSONParser pars= new JSONParser();
		
		try
		{
			Object obj = pars.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\core\\Framework\\PageLocators\\" + JsonFile +".json" ));
			JSONObject jsObject = (JSONObject)obj;
			return (String)jsObject.get(KeyName);
		}
		catch(FileNotFoundException e) {e.printStackTrace(); return null;}
		catch(IOException e) { e.printStackTrace(); return null;}
		catch(ParseException e) {e.printStackTrace(); return null;}
		catch(Exception e) {e.printStackTrace(); return null;}	
	}
	
	
	public static List<PageAction> getPageActions(String pageName, String JsonFile){
			JSONParser pars= new JSONParser();
		
		List<PageAction> list = new ArrayList<PageAction>();
		try
		{		
			Object obj = pars.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\core\\Framework\\PageLocators\\" + JsonFile +".json" ));
			JSONObject jsObject = (JSONObject)obj;
			
			 // get an array from the JSON object
			JSONArray actions= (JSONArray) jsObject.get(pageName);
			// take the elements of the json array
			for(int i=0; i<actions.size(); i++){
			System.out.println("The " + i + " element of the array: "+actions.get(i));
			}
			Iterator i = actions.iterator();
			// take each value from the json array separately
			while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			PageAction action = new PageAction();
			action.setElementAttributeType(innerObj.get("elementAttributeType").toString());
			action.setElementAttributeValue(innerObj.get("elementAttributeValue").toString());
			action.setActionMeta(innerObj.get("actionMeta").toString());
			action.setActionValue(innerObj.get("actionValue").toString());
			action.setElementName(innerObj.get("elementName").toString());
			list.add(action);
			}
			
			// handle a structure into the json object
			

			return list;
						
		}
		catch(FileNotFoundException e) {e.printStackTrace(); return null;}
		catch(IOException e) { e.printStackTrace(); return null;}
		catch(ParseException e) {e.printStackTrace(); return null;}
		catch(Exception e) {e.printStackTrace(); return null;}
	}
}

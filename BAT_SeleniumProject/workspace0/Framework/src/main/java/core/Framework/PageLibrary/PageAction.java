package core.Framework.PageLibrary;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.openqa.selenium.InvalidArgumentException;

import com.google.common.base.Throwables;

import core.Framework.TestUtils.ActionMeta;






public class PageAction {

	protected String elementName;
	public String elementAttributeType;
	public String elementAttributeValue;
	protected ActionMeta action =ActionMeta.NONE;
	protected String actionMeta;
	protected String actionQualifier;
	protected String actionValue;
	protected String value;

	
	
public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		
		
	 this.elementName = elementName;
	}

	public ActionMeta ActionMetaType(){
		return action;
	}
	public String getElementAttributeType() {
		return elementAttributeType;
	}

	public void setElementAttributeType(String elementAttributeType) {
		this.elementAttributeType = elementAttributeType;
	}

	public String getElementAttributeValue() {
		return elementAttributeValue;
	}

	public void setElementAttributeValue(String elementAttributeValue) {
		this.elementAttributeValue = elementAttributeValue;
	}

	public String getActionQualifier() {
		return actionQualifier;
	}

	public void setActionQualifier(String actionQualifier) {
		this.actionQualifier = actionQualifier;
	}

	public String getActionValue() {
		return actionValue;
	}

	public void setActionValue(String actionValue) {
		this.actionValue =actionValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setActionMeta(String actionMeta) {
		
		String actionCap = actionMeta.toUpperCase();
		
		switch (actionCap){
		case "CLICK":
			action=ActionMeta.CLICK;
			break;
		case "LINK":
			action=ActionMeta.LINK;
			break;		
		case "SELECTBYTEXT":
			action=ActionMeta.SELECTEXT;
			break;
		case "ENTRY":
			action=ActionMeta.ENTER;
			break;
		case "SELECTCHECKBOX":
			action=ActionMeta.CHECKBOX;
			break;
		case "RTCLICK":
			action=ActionMeta.CHECKBOX;
			break;
		case "SCROLL":
			action=ActionMeta.CHECKBOX;
			break;
		default :
			action=ActionMeta.NONE;
			break;
			//throw new InvalidArgumentException(actionMeta);
		}
		
		this.actionMeta = actionMeta;
	}

public String getElement(){
	return elementName;
}

public String getAttributeType(){
	
	return elementAttributeType;
}

public String getActionMeta(){
	
  return actionMeta;
}
}


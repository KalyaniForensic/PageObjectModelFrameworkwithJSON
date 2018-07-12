package core.Framework.TestUtils;

import java.util.List;

import com.mongodb.util.JSON;

import core.Framework.PageLibrary.PageAction;

public class BindJson {
	 
		 public static  void  SetActionValue(PageAction action, IReadFile reader){
			 	
			 	if(action.ActionMetaType() != ActionMeta.CLICK ){
			 		action.setValue(reader.getValue(action.getElementName()));
			 	}
			}
		 
		 public static  void SetActionValues(List<PageAction> actionlist, IReadFile reader){
			 
			 for (PageAction pa : actionlist) 
				{
				  SetActionValue(pa, reader);
				}
				
			}
		 
}

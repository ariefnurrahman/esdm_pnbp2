package reporting.form.util;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listgroup;
import org.zkoss.zul.Listitem;

public class ListboxUtil
{
  public static void clearChildFromListcell(Listitem li, int indexColumn)
  {
    Listcell lcCol = (Listcell)li.getChildren().get(indexColumn);
    lcCol.getChildren().clear();
  }
  
  public static Object getObjectFromListcell(Listitem li, int indexColumn) { Object resObj = null;
    
    Listcell lcCol = (Listcell)li.getChildren().get(indexColumn);
    resObj = lcCol.getFirstChild();
    
    return resObj;
  }
  
  public static Object getObjectFromListcell(Listgroup lg, int indexColumn) {
    Object resObj = null;
    
    Listcell lcCol = (Listcell)lg.getChildren().get(indexColumn);
    resObj = lcCol.getFirstChild();
    
    return resObj;
  }
  
  public static void setObjectToListCell(Listitem li, Object comp) {
    Listcell lc = new Listcell();
    lc.appendChild((Component)comp);
    lc.setStyle("vertical-align:top");
    lc.setParent(li);
  }
  
  public static void setObjectToListCell(Listitem li, Object comp, String style) {
    Listcell lc = new Listcell();
    lc.appendChild((Component)comp);
    lc.setStyle(style);
    lc.setParent(li);
  }
  
  public static void setObjectToListCell(Listgroup lg, Object comp) {
    Listcell lc = new Listcell();
    lc.appendChild((Component)comp);
    lc.setStyle("vertical-align:top");
    lc.setParent(lg);
  }
  
  public static void setObjectToListCell(Listitem li, int indexColumn, Object comp) {
    Listcell lc = (Listcell)li.getChildren().get(indexColumn);
    lc.appendChild((Component)comp);
    lc.setParent(li);
  }
  
  public static void setObjectToListitem(Listitem li, List<Object> lstObj) {
    for (Object obj : lstObj) {
      setObjectToListCell(li, obj);
    }
  }
}


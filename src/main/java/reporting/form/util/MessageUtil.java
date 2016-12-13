package reporting.form.util;

import org.zkoss.zul.Messagebox;

public class MessageUtil
{
  public static void confirmation(String strMessage, org.zkoss.zk.ui.event.EventListener el) {
    try {
      Messagebox.show(strMessage, "Confirmation", 
        48, 
        "z-msgbox z-msgbox-question", el);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void information(String strMessage) {
    try {
      Messagebox.show(strMessage, "Information", 1, 
        "z-msgbox z-msgbox-information", null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void warning(String strMessage) {
    try {
      Messagebox.show(strMessage, "Warning", 1, 
        "z-msgbox z-msgbox-exclamation", null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void error(String strMessage) {
    try {
      Messagebox.show(strMessage, "Error", 1, 
        "z-msgbox z-msgbox-error", null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

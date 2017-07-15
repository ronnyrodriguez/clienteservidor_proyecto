package ec.org.camariweb.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class cUtil {
    public static void addSucessMessage(String msgtit, String msgdet){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("sucessInfo", facesMsg);
    }
    public static void addErrorFatalMessage(String msgtit, String msgdet){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("sucessInfo", facesMsg);
    }
    public static void addWarningMessage(String msgtit, String msgdet){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("sucessInfo", facesMsg);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudFactura;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class ingreso {
     
    private String text1;
     
    private String text2;
 
    public String getText1() {
        return text1;
    }
 
    public void setText1(String text1) {
        this.text1 = text1;
    }
 
    public String getText2() {
        return text2;
    }
 
    public void setText2(String text2) {
        this.text2 = text2;
    }
     
    public void save() {
        int b;
        String a = getText1();
        b=Integer.parseInt(a);        
        clsCliente c=new clsCliente(b,null,null,null);
        clsFactura f=new clsFactura(0, c, null, b, b, b);
                  
       // FacesContext.getCurrentInstance().addMessage(crudFactura.save(f), new FacesMessage("Data Saved"));
    }
     
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
     
    public void resetFail() {
        this.text1 = null;
        this.text2 = null;
         
        FacesMessage msg = new FacesMessage("Model reset, but it won't work properly.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
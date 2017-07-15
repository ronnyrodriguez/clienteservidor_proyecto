/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudCliente;
import ec.org.camariweb.funciones.crudFactura;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class cFactura {

    private clsFactura newFactura;
    private clsFactura selectedFactura;
    private List<clsFactura> lista;
   
    public cFactura() {
        newFactura = new clsFactura();
        cargarDatos();
    }
    public void insertar(){
        if (crudFactura.save(newFactura)) { //linea guarda el cliente 
           newFactura = new clsFactura();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    private void eliminar(){
        if (crudFactura.delete(selectedFactura)) {
            newFactura = new clsFactura();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    private void actualizar(){
        if (crudFactura.update(selectedFactura)) {
            newFactura = new clsFactura();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    public clsFactura getNewFactura() {
        return newFactura;
    }

    public void setNewFactura(clsFactura newFactura) {
        this.newFactura = newFactura;
    }

    public clsFactura getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(clsFactura selectedFactura) {
        this.selectedFactura = selectedFactura;
    }

    public List<clsFactura> getLista() {
        return lista;
    }

    public void setLista(List<clsFactura> lista) {
        this.lista = lista;
    }
    public void cargarDatos(){
     lista= crudFactura.findbyAll();
    }
}

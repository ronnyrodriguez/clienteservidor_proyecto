package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class cProducto {
    private clsProducto newProducto;
    private clsProducto selectedProducto;
    private List<clsProducto> lista;

    public cProducto() {
        newProducto = new clsProducto();
        cargarDatos();
    }
    
    public void insertar(){
        if (crudProducto.save(newProducto)) { //linea guarda el cliente 
           newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        if (crudProducto.delete(selectedProducto)) {
            newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudProducto.update(selectedProducto)) {
            newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    
    
    private void cargarDatos() {
        lista= crudProducto.findbyAll();
    }

    public clsProducto getNewProducto() {
        return newProducto;
    }

    public void setNewProducto(clsProducto newProducto) {
        this.newProducto = newProducto;
    }

    public clsProducto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(clsProducto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public List<clsProducto> getLista() {
        return lista;
    }

    public void setLista(List<clsProducto> lista) {
        this.lista = lista;
    }
    
    
    
    
}

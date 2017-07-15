/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.controlador;
import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.funciones.crudCliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rocby
 */
@ManagedBean
@RequestScoped
public class DespelgableCliente {

    private String[] selectedCities;
    private List<String> cities;
    private List<clsCliente> lista;
     
    @PostConstruct
    public void init() {
         
        cargarDatos();
        cities = new ArrayList<String>();        
        for (clsCliente lista1 : lista) {
            cities.add(lista1.getNombre());
        }
    }
 
    public String[] getSelectedCities() {
        return selectedCities;
    }
    private void cargarDatos() {
        lista= crudCliente.findbyAll();
    }
 
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
    public List<String> getCities() {
        return cities;
    }
    
}

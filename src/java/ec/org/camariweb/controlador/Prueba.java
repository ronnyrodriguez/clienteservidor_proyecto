package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.clsReporte;

import ec.org.camariweb.funciones.crudFactura;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class Prueba implements Serializable {

    private PieChartModel pieModel1;
    private List<clsFactura> lista;
    private clsFactura newFactura;
    private clsReporte newRep;
    private List<clsReporte> listaR;

    @PostConstruct
    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createPieModels() {
        createPieModel1();
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        cargarDatos();
        for (clsFactura lista1 : lista) {
            pieModel1.set((String) lista1.getClienteid().getNombre(), (int) lista1.getTotal());
        }
        pieModel1.setTitle("COMPRAS X CADA CLIENTE");
        pieModel1.setLegendPosition("w");
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void cargarDatos() {
        lista = clsReporte.E2();
    }

    public List<clsFactura> getLista() {
        return lista;
    }

    public void setLista(List<clsFactura> lista) {
        this.lista = lista;
    }

    public clsFactura getNewFactura() {
        return newFactura;
    }

    public void setNewFactura(clsFactura newFactura) {
        this.newFactura = newFactura;
    }

    public List<clsReporte> getListaR() {
        return listaR;
    }

    public void setListaR(List<clsReporte> listaR) {
        this.listaR = listaR;
    }

    public clsReporte getNewRep() {
        return newRep;
    }

    public void setNewRep(clsReporte newRep) {
        this.newRep = newRep;
    }

}

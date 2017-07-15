package ec.org.camariweb.entidades;
import java.util.Date;

public class clsFactura {
     private int _n;
     private clsCliente _clienteid;
     private Date _fecha;
     private double _subtotal;
     private double _iva;
     private double _total;

    public clsFactura() {
    }

    public clsFactura(int _n, clsCliente _clienteid, Date _fecha, double _subtotal, double _iva, double _total) {
        this._n = _n;
        this._clienteid = _clienteid;
        this._fecha = _fecha;
        this._subtotal = _subtotal;
        this._iva = _iva;
        this._total = _total;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }

    public int getN() {
        return _n;
    }

    public void setN(int _n) {
        this._n = _n;
    }

    public clsCliente getClienteid() {
        return _clienteid;
    }

    public void setClienteid(clsCliente _clienteid) {
        this._clienteid = _clienteid;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public double getIva() {
        return _iva;
    }

    public void setIva(double _iva) {
        this._iva = _iva;
    }

    @Override
    public String toString() {
        return "clsFactura{" + "_n=" + _n + ", _clienteid=" + _clienteid + ", _fecha=" + _fecha + ", _subtotal=" + _subtotal + ", _iva=" + _iva + ", _total=" + _total + '}';
    }

   
          
}

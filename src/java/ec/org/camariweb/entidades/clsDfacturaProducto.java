package ec.org.camariweb.entidades;

public class clsDfacturaProducto {
    private int _id;
    private clsFactura _nfactura;
    private clsProducto _productoid;
    private double _cantidad;
    private double _subtotal;

    public clsDfacturaProducto() {
    }

    public clsDfacturaProducto(int _id, clsFactura _nfactura, clsProducto _productoid, double _cantidad, double _subtotal) {
        this._id = _id;
        this._nfactura = _nfactura;
        this._productoid = _productoid;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public clsFactura getNfactura() {
        return _nfactura;
    }

    public void setNfactura(clsFactura _nfactura) {
        this._nfactura = _nfactura;
    }

    public clsProducto getProductoid() {
        return _productoid;
    }

    public void setProductoid(clsProducto _productoid) {
        this._productoid = _productoid;
    }

    public double getCantidad() {
        return _cantidad;
    }

    public void setCantidad(double _cantidad) {
        this._cantidad = _cantidad;
    }

    @Override
    public String toString() {
        return "clsDfacturaProducto{" + "_id=" + _id + ", _nfactura=" + _nfactura + ", _productoid=" + _productoid + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }
    
    
}

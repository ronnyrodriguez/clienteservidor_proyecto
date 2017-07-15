package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.entidades.clsDfacturaProducto;
import java.util.ArrayList;

public class crudDfactura_producto {
    public boolean save(clsDfacturaProducto cdf){
        boolean resultado = false;
        String sql = "INSERT INTO public.dfacturaproducto(nfactura,productoid,cantidad,subtotal) VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        
        lstPar.add(new Parametro(1, cdf.getNfactura().getN()));
        lstPar.add(new Parametro(2, cdf.getProductoid().getId())); 
        lstPar.add(new Parametro(3, cdf.getCantidad()));
        lstPar.add(new Parametro(4, cdf.getSubtotal())); 
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public boolean delete(clsDfacturaProducto cdf) {
        boolean res=false;
        String sql = "DELETE FROM public.dfacturaproducto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cdf.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                //System.out.println(e.getMessage());
                System.out.println("Error" + e.getMessage());
            }
        return res;
    }

    public boolean update(clsDfacturaProducto cdf) {
        boolean res = false;
        String sql = "UPDATE public.dfacturaproducto " +
                "SET nfactura=?,productoid=?,cantidad=?,subtotal=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, cdf.getNfactura().getN()));
        lstPar.add(new Parametro(2, cdf.getProductoid().getId())); 
        lstPar.add(new Parametro(3, cdf.getCantidad()));
        lstPar.add(new Parametro(4, cdf.getSubtotal()));
        lstPar.add(new Parametro(5,cdf.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsDfacturaProducto> findbyAll() {
        ArrayList<clsDfacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT id,nfactura,productoid,cantidad, subtotal "+
                "FROM public.dfacturaproducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacturaProducto dfp = null;
            while (cres.next())
            {
                dfp = new clsDfacturaProducto();
                dfp.setId(cres.getInt("id"));
              //  dfp.setNfactura(crudFactura.findbyId(cres.getInt("nfactura"));
              //  dfp.setProductoid(crudProducto.findbyId(cres.getInt("productoid"));
                dfp.setCantidad(cres.getDouble("cantidad"));
                dfp.setSubtotal(cres.getDouble("subtotal"));
                listado.add((dfp));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsDfacturaProducto findbyId(clsDfacturaProducto ins) {
        clsDfacturaProducto dfp = null;
        String sql = "SELECT id,nfactura,productoid,cantidad, subtotal"
                + " FROM public.dfacturaproducto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                dfp = new clsDfacturaProducto();
                dfp.setId(cres.getInt("id"));
              //  dfp.setNfactura(crudFactura.findbyId(cres.getInt("nfactura"));
              //  dfp.setProductoid(crudProducto.findbyId(cres.getInt("productoid"));
                dfp.setCantidad(cres.getDouble("cantidad"));
                dfp.setSubtotal(cres.getDouble("subtotal"));           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dfp;
    }
    public static clsDfacturaProducto findbyId(int ide) {
        clsDfacturaProducto dfp = null;
        String sql = "SELECT id,nfactura,productoid,cantidad, subtotal"
                + " FROM public.dfacturaproducto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                dfp = new clsDfacturaProducto();
                dfp.setId(cres.getInt("id"));
              //  dfp.setNfactura(crudFactura.findbyId(cres.getInt("nfactura"));
              //  dfp.setProductoid(crudProducto.findbyId(cres.getInt("productoid"));
                dfp.setCantidad(cres.getDouble("cantidad"));
                dfp.setSubtotal(cres.getDouble("subtotal"));              
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dfp;
    }
}

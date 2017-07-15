package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.entidades.clsProducto;
import java.util.ArrayList;

public class crudProducto {
    public static boolean save(clsProducto cliente){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre,stock,precioventa) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getNombre()));
        lstPar.add(new Parametro(2, cliente.getStock()));
        lstPar.add(new Parametro(3, cliente.getPrecioventa()));        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsProducto cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsProducto cliente) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre=?,stock=?,precioventa=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, cliente.getNombre()));
        lstPar.add(new Parametro(2, cliente.getStock()));
        lstPar.add(new Parametro(3, cliente.getPrecioventa()));  
        lstPar.add(new Parametro(4,cliente.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id,nombre,stock,precioventa "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecioventa(cres.getDouble("precioventa"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsProducto findbyId(clsProducto ins) {
        clsProducto cliente = null;
        String sql = "SELECT id,nombre,stock,precioventa FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsProducto();
                cliente.setId(cres.getInt("id"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setStock(cres.getInt("stock"));
                cliente.setPrecioventa(cres.getDouble("precioventa"));             
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsProducto findbyId(int ide) {
        clsProducto cliente = null;
        String sql = "SELECT id,nombre,stock,precioventa FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsProducto();
                cliente.setId(cres.getInt("id"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setStock(cres.getInt("stock"));
                cliente.setPrecioventa(cres.getDouble("precioventa"));           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static ArrayList<clsProducto> findbyStock(double stock) {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id,nombre,stock,precioventa "+
                "FROM public.producto WHERE stock < ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(1, new Parametro (1,stock));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecioventa(cres.getDouble("precioventa"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}

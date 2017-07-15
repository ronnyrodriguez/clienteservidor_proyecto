/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsDfacturaProducto;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudCliente;
import java.util.ArrayList;

public class clsReporte {

    public ArrayList<clsFactura> mayorcf() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT  cliente.ruc, factura.clienteid,cliente.nombre,factura.fecha,"
                + "  factura.total,factura.n FROM  public.cliente INNER JOIN public.factura ON"
                + "  cliente.id = factura.clienteid ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next()) {
                factura = new clsFactura();
                factura.setClienteid(crudCliente.findbyId(cres.getInt("cliente.id")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                factura.setN(cres.getInt("n"));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    //Deber *****************************************************
    //ejercicio 1 
    public static ArrayList<clsFactura> E1() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT \"public\".factura.\"n\",\"public\".factura.fecha,\n"
                + "\"public\".factura.total,\"public\".cliente.id,\"public\".cliente.ruc,\"public\".cliente.nombre\n"
                + "FROM \"public\".cliente INNER JOIN \"public\".factura \n"
                + "ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n"
                + "WHERE \"public\".factura.total > '1000.00'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("n"));
                fac.setFecha(cres.getDate("fecha"));
                fac.setTotal(cres.getDouble("total"));
                fac.setClienteid(crudCliente.findbyId(cres.getInt("clienteid")));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    //ejercicio 2 
    public static ArrayList<clsFactura> E2() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT  factura.clienteid,cliente.nombre,"
                + "  sum(factura.total) FROM  public.cliente INNER JOIN public.factura ON "
                + "  cliente.id = factura.clienteid "
                + "  GROUP BY factura.clienteid, cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next()) {
                factura = new clsFactura();
                factura.setClienteid(crudCliente.findbyId(cres.getInt("clienteid")));
                factura.setTotal(cres.getDouble("sum"));
                listado.add((factura));            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsFactura> E3() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre,\n"
                + "Count(\"public\".factura.numerofac) AS \"TotalFacturas\"\n"
                + "FROM\n"
                + "\"public\".factura\n"
                + "INNER JOIN \"public\".cliente ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("TotalFacturas"));
                fac.setClienteid(crudCliente.findbyId(cres.getInt("id")));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsFactura> E4() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre,\n"
                + "Count(\"public\".factura.numerofac) AS \"TotalFactura\",\n"
                + "Sum(\"public\".factura.total) AS \"Valor\"\n"
                + "FROM\n"
                + "\"public\".factura\n"
                + "INNER JOIN \"public\".cliente ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("TotalFactura"));
                fac.setClienteid(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("Valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsFactura> E5() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre,\n"
                + "Count(\"public\".factura.numerofac) AS \"N° Facturas\",\n"
                + "Sum(\"public\".factura.total) AS valor\n"
                + "FROM\n"
                + "\"public\".cliente\n"
                + "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre\n"
                + "ORDER BY\n"
                + "\"N° Facturas\" DESC\n"
                + "LIMIT 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("N° Facturas"));
                fac.setClienteid(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsFactura> E6() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre,\n"
                + "Count(\"public\".factura.numerofac) AS \"N° Facturas\",\n"
                + "Sum(\"public\".factura.total) AS valor\n"
                + "FROM\n"
                + "\"public\".cliente\n"
                + "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".cliente.\"id\",\n"
                + "\"public\".cliente.ruc,\n"
                + "\"public\".cliente.nombre\n"
                + "ORDER BY\n"
                + "\"N° Facturas\" ASc\n"
                + "LIMIT 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("N° Facturas"));
                fac.setClienteid(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsFactura> E7() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "Count(\"public\".factura.numerofac) AS \"N° Facturas\",\n"
                + "Sum(\"public\".factura.total) AS valor\n"
                + "FROM\n"
                + "\"public\".factura\n"
                + "ORDER BY\n"
                + "\"N° Facturas\" ASC";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next()) {
                fac = new clsFactura();
                fac.setN(cres.getInt("N° Facturas"));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsDfacturaProducto> E8() {
        ArrayList<clsDfacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre,\n"
                + "Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n"
                + "Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n"
                + "FROM\n"
                + "\"public\".producto\n"
                + "INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre\n"
                + "ORDER BY\n"
                + "cantidad DESC\n"
                + "LIMIT 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacturaProducto pro = null;
            while (cres.next()) {
                pro = new clsDfacturaProducto();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setProductoid(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsDfacturaProducto> E9() {
        ArrayList<clsDfacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre,\n"
                + "Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n"
                + "Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n"
                + "FROM\n"
                + "\"public\".producto\n"
                + "INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre\n"
                + "ORDER BY\n"
                + "cantidad ASC\n"
                + "LIMIT 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacturaProducto pro = null;
            while (cres.next()) {
                pro = new clsDfacturaProducto();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setProductoid(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static ArrayList<clsDfacturaProducto> E10() {
        ArrayList<clsDfacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre,\n"
                + "Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n"
                + "Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n"
                + "FROM\n"
                + "\"public\".producto\n"
                + "INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n"
                + "GROUP BY\n"
                + "\"public\".producto.\"id\",\n"
                + "\"public\".producto.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfacturaProducto pro = null;
            while (cres.next()) {
                pro = new clsDfacturaProducto();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setProductoid(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

}

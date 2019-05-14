/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Producto;

/**
 *
 * @author Juan Carlos Lopez
 */
public interface productoDao {
    public List<Producto> listarProductos();
    public List<Producto> listarProductos2();
    public void newProducto(Producto producto);
    public void updateProducto(Producto producto);
    public void deleteProducto(Producto producto);
    public List<Producto> listarProductosStock();
    
    
    public void incrementarProducto(Session session, String CodBarra) throws Exception;
    
    //metodo utilizado en la factura, facturaBean
    public Producto obtenerProductoPorCodBarra(Session session, String CodBarra) throws Exception;
    
}

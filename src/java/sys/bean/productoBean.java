/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sys.dao.productoDao;
import sys.imp.productoDaoImp;
import sys.model.Producto;

@ManagedBean
@ViewScoped
public class productoBean {

    private List<Producto> listaProductos;
    private List<Producto> listaProductos2;
    private Producto producto;
    
    private List<Producto> listaProductosStock;

    public productoBean() {
        
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void setListaProductos2(List<Producto> listaProductos2) {
        this.listaProductos2 = listaProductos2;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        productoDao pDao = new productoDaoImp();
        listaProductos=pDao.listarProductos();
        return listaProductos;
    }
    
    public List<Producto> getListaProductos2() {
        productoDao pDao = new productoDaoImp();
        listaProductos2=pDao.listarProductos2();
        return listaProductos2;
    }
    
    public void prepararNuevoProducto(){
        producto = new Producto();
    }

    public List<Producto> getListaProductosStock() {
        productoDao pDao = new productoDaoImp();
        listaProductos=pDao.listarProductos();
        return listaProductosStock;
    }

    public void setListaProductosStock(List<Producto> listaProductosStock) {
        this.listaProductosStock = listaProductosStock;
      
    }
    
    public void nuevoProducto(){
        productoDao pDao= new productoDaoImp();
        pDao.newProducto(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se agrego el producto"));

    }
    
    public void modificarProducto(){
        productoDao pDao= new productoDaoImp();
        pDao.updateProducto(producto);
        producto = new Producto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se modifico el producto"));

    }
    
    public void eliminarProducto(){
        productoDao pDao= new productoDaoImp();
        pDao.deleteProducto(producto);
        producto = new Producto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se elimino el producto"));

    }
    
    /*public void incrementarProducto(){
        productoDao pDao= new productoDaoImp();
        pDao.incrementarProducto(producto);
        producto = new Producto();
        
    }*/
    
}

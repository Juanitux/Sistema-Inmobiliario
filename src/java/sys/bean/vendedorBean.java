/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sys.dao.vendedorDao;
import sys.imp.vendedorDaoImp;
import sys.model.Vendedor;

@ManagedBean
@ViewScoped
public class vendedorBean {

    private List<Vendedor> listaVendedors;
    private Vendedor vendedor;

    private List<Vendedor> vendedoresFiltrados;
    
    public vendedorBean() {
        vendedor = new Vendedor();
    }

    public List<Vendedor> getVendedoresFiltrados() {
        return vendedoresFiltrados;
    }

    public void setVendedoresFiltrados(List<Vendedor> vendedoresFiltrados) {
        this.vendedoresFiltrados = vendedoresFiltrados;
    }

    public void setListaVendedors(List<Vendedor> listaVendedors) {
        this.listaVendedors = listaVendedors;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getListaVendedors() {
        vendedorDao vDao = new vendedorDaoImp();
        listaVendedors=vDao.listarVendedor();
        return listaVendedors;
    }
    
    public void prepararNuevoVendedor(){
        vendedor = new Vendedor();
    }
    
    public void nuevoVendedor(){
        vendedorDao vDao= new vendedorDaoImp();
        vDao.newVendedor(vendedor);
    }
    
    public void modificarVendedor(){
        vendedorDao vDao= new vendedorDaoImp();
        vDao.updateVendedor(vendedor);
        vendedor = new Vendedor();
    }
    
    public void eliminarVendedor(){
        vendedorDao vDao= new vendedorDaoImp();
        vDao.deleteVendedor(vendedor);
        vendedor = new Vendedor();
    }
    
}


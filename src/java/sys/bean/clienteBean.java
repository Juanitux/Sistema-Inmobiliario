/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sys.dao.clienteDao;
import sys.imp.clienteDaoImp;
import sys.model.Cliente;

@ManagedBean
@ViewScoped
public class clienteBean {

    private List<Cliente> listaClientes;
    private Cliente cliente;
    
    private List<Cliente> clientesFiltrados;

    public clienteBean() {
    }

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }

    
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        if(listaClientes==null){
            clienteDao cDao = new clienteDaoImp();
            listaClientes=cDao.listarClientes();
            
        }
        return listaClientes;      
    }
    
    public void prepararNuevoCliente(){
        cliente = new Cliente();
    }
    
    public void nuevoCliente(){
        clienteDao cDao= new clienteDaoImp();
        cDao.newCliente(cliente);
    }
    
    public void modificarCliente(){
        clienteDao cDao= new clienteDaoImp();
        cDao.updateCliente(cliente);
        cliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Cliente agregado al Detalle"));

    }
    
    public void eliminarCliente(){
        clienteDao cDao= new clienteDaoImp();
        cDao.deleteCliente(cliente);
        cliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Cliente eliminado al Detalle"));

    }
    
}

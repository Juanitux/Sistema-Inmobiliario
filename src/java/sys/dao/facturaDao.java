/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import org.hibernate.Session;
import sys.model.Factura;

/**
 *
 * @author Juan Carlos Lopez
 */
public interface facturaDao {
    //Obtener el ultimo registro en la tabla factura de la BD
    public Factura obtenerUltimoRegistro (Session session)throws Exception;
    
    //Averiguar si la tabla factura posee registros
    public Long obtenerTotalRegistroEnFactura(Session session);
    
    //Metodo para guardar el registro en la tabla factura de la BD
    public boolean guardarVentaFactura (Session session, Factura factura) throws Exception;
    
}

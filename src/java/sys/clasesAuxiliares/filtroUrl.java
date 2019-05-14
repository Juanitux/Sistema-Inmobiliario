/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.clasesAuxiliares;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Carlos Lopez
 */
public class filtroUrl implements PhaseListener{

    //Metodos utilizados para restringir el acceso a las URLS si el usuario no hace login
    @Override
    public void afterPhase(PhaseEvent event) {
            FacesContext facesContext = event.getFacesContext();
            
            //Capturar el nombre de la pagina actual 
            String currentPage = facesContext.getViewRoot().getViewId();
            
            //Crear una variable booleana para comprobar si es la pagina de login la que se capturo
            boolean isPageLogin= currentPage.lastIndexOf("login.xhtml") > -1 ? true : false;
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            
            /*se recupera un object del String que se guardo, para ello se toma de la session al usuario que se
            definio en el login bean            */
            Object usuario = session.getAttribute("usuario");
            
            
            
            if (!isPageLogin && usuario==null) {//si no es la pagina de logueo y el usuario es nulo,
                NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
                nHandler.handleNavigation(facesContext,null, "/login.xhtml");
                
            }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
      }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}

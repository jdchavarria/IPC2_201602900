/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Alessandra
 */
@Path("serviciowebport")
public class ServicioWebPort {

    private paqueteServicio_client.ServicioWeb port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioWebPort
     */
    public ServicioWebPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method Suma
     * @param numero1 resource URI parameter
     * @param numero2 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.lang.Integer>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("suma/")
    public JAXBElement<Integer> getSuma(@QueryParam("numero1")
            @DefaultValue("0") int numero1, @QueryParam("numero2")
            @DefaultValue("0") int numero2) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.Integer result = port.suma(numero1, numero2);
                return new JAXBElement<java.lang.Integer>(new QName("http//lang.java/", "integer"), java.lang.Integer.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private paqueteServicio_client.ServicioWeb getPort() {
        try {
            // Call Web Service Operation
            paqueteServicio_client.ServicioWeb_Service service = new paqueteServicio_client.ServicioWeb_Service();
            paqueteServicio_client.ServicioWeb p = service.getServicioWebPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}


package paqueteServicio;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Suma")
    public Integer Suma(@WebParam(name = "numero1") int numero1, @WebParam(name = "numero2") int numero2) {
        //TODO write your implementation code here:
        return numero1 + numero2;
    }
    
    @WebMethod(operationName = "Multiplicar")
    public Integer Multiplicar(@WebParam(name = "numero3") int numero3, @WebParam(name="numero4") int numero4){
        return numero3 + numero4;
    }
}

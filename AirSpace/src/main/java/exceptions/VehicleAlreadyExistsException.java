package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class VehicleAlreadyExistsException extends RuntimeException  {
	
	public VehicleAlreadyExistsException(){
		  super("Vehicle with specified id allready exists");
	  }
	private static final long serialVersionUID = 1L;
}

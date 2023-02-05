package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class RentacarDoesntExistException extends RuntimeException  {
	
	public RentacarDoesntExistException(){
		  super("Rentacar company with specified id doesnt exists");
	  }
	private static final long serialVersionUID = 1L;
}

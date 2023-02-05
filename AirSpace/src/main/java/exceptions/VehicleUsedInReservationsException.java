package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class VehicleUsedInReservationsException extends RuntimeException  {
	
	public VehicleUsedInReservationsException(){
		  super("Vehicle with specified id is already in use in reservations. But it will not show up in further queries.");
	  }
	private static final long serialVersionUID = 1L;
}

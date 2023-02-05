package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BranchOfficeAlreadyInUse extends RuntimeException  {
	
	public BranchOfficeAlreadyInUse(){
		  super("Branchoffice with specified id is already in use and cannot be deleted.");
	  }
	private static final long serialVersionUID = 1L;
}

package ie.cct.farm.farm;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9027096523299287588L;

	public NotAcceptableException(String msg) {
		super(msg);
	}

	
}

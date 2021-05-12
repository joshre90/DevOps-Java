package ie.cct.farm.farm;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This was a testing exception
@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class TeapotException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7874951012336582163L;

	public TeapotException(String msg) {
		super(msg);
	}

	
}

package spring.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public Object exceptHandle1(Exception e) {
		String errMsg1 = "Error: Exception";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg1);
	}

	@ExceptionHandler(MyCustomException.class)
	public Object exceptHandle2(MyCustomException e) {
		String errMsg2 = "Error: MyCustomException";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg2);
	}
	
}

class MyCustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MyCustomException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}	
}
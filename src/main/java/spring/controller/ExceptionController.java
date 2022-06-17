package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {
	
	@GetMapping("/exceptaction.controller")
    public void processExceptionAction() throws Exception {
    	//throw new Exception();
		throw new MyCustomException("warning");
    }
	
}

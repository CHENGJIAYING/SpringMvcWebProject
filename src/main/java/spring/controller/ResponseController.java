package spring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@GetMapping(path="/responsebody.controller")
	@ResponseBody
	public String processResponseBodyAction() {
		return "Have a nice day !!";
	}
	
	@GetMapping(path="/responsebody2.controller",produces = "text/HTML;charset=UTF-8")
	@ResponseBody
	public String processResponseBodyAction2() {
		return "Have a nice day 2,您好!!";
	}
	@GetMapping(path="/responseentity.controller")
	@ResponseBody
	public ResponseEntity<String> processResponseEntity() {
		return new ResponseEntity<String>("Custom Status Code(403 Forbidden)",HttpStatus.FORBIDDEN);
	}
	@GetMapping(path="/responseentity2.controller")
	@ResponseBody
	public ResponseEntity<String> processResponseEntity2() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("Custom Headers", headers , HttpStatus.OK);
	}

}
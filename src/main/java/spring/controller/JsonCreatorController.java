package spring.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.model.House;

@Controller
public class JsonCreatorController {
	
	@GetMapping("/jsoncreate.controller")
	@ResponseBody
	public String processJsonAction() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Nice House");
		
		ObjectMapper om1 = new ObjectMapper();
		String jsonStr = om1.writeValueAsString(hBean1);
		
		House hBean2 = om1.readValue(jsonStr, House.class);
		System.out.println(hBean2.getHouseid() + " " + hBean2.getHousename());
		
		return "jsonStr:" + jsonStr;
	}
	
	@GetMapping("/jsoncreate2.controller")
	@ResponseBody   // application/json
	public House processJsonAction2() throws JsonProcessingException {
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("Happy House");
		
		return hBean2;
	}
	
	@GetMapping("/jsoncreate3.controller")
	@ResponseBody   // application/json
	public ArrayList<House> processJsonAction3() throws JsonProcessingException {
		
		House hBean3 = new House();
		hBean3.setHouseid(1003);
		hBean3.setHousename("Great House");
		
		House hBean4 = new House();
		hBean4.setHouseid(1004);
		hBean4.setHousename("Beautiful House");
		
		ArrayList<House> lists = new ArrayList<House>();
		lists.add(hBean3);
		lists.add(hBean4);
		
		return lists;
	}

}


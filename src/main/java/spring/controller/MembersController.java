package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Members;

@Controller
public class MembersController {
	
	//@RequestMapping(path = "/membersmain.controller", method = RequestMethod.GET)
	//@GetMapping(path = "/membersmain.controller")
	@GetMapping("/membersmain.controller")
	public String processMainAction(Model m) {
//		Members mem = new Members();
		Members mem = new Members("kitty","female",18);
		m.addAttribute("members", mem);
		return "members";
	}
	//@RequestMapping(path = "/addMembers", method = RequestMethod.POST)
	@PostMapping("/addMembers")
	public String processAction(@ModelAttribute("members") Members mem2, BindingResult result, Model m2) {
		if(result.hasErrors()) {
			return "membersError";
		}
		
		m2.addAttribute("mName", mem2.getMemberName());
		m2.addAttribute("mGender", mem2.getGender());
		m2.addAttribute("mAge", mem2.getAge());
		
		return "membersResult";		
	}
}


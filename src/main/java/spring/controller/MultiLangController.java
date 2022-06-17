package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiLangController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/resultmultilang.controller")
	public String processMultiLangAction() {
		String errMsg = messageSource.getMessage("program.error", null,LocaleContextHolder.getLocale());
		
		System.out.println("locale ="+LocaleContextHolder.getLocale());
		System.out.println("errMsg ="+errMsg);
		
		return "multiLangResult";
	}
	

}

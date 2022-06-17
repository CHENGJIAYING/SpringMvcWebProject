package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//相當於MVC-servlet.xml的java程式組態
//@Configuration
//@ComponentScan(basePackages = {"spring"})
//@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Bean
	public InternalResourceViewResolver irViewResolver() {
		InternalResourceViewResolver irvrl = new InternalResourceViewResolver();
		irvrl.setPrefix("/WEB-INF/pages/");
		irvrl.setSuffix(".jsp");
		irvrl.setOrder(6);
		return irvrl;
	}

}

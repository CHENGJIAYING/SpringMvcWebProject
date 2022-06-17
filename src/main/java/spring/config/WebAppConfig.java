package spring.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//相當於MVC-servlet.xml的java程式組態
@Configuration
@ComponentScan(basePackages = { "spring" })
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "membersmain.controller");
		registry.addViewController("/funny.sweet").setViewName("form");
		registry.addViewController("/showresources.info").setViewName("showResources");
	}

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
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		return commonsMultipartResolver;
	}
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setPrettyPrint(true);
		return mappingJackson2JsonView;
	}
	@Bean
	public Jaxb2Marshaller jaxbMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("spring");
		return jaxb2Marshaller;
	}
	@Bean
	public ContentNegotiatingViewResolver negociateViewResolver() {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		
		ArrayList<View> list = new ArrayList<View>();
		list.add(jsonView());
		
		contentNegotiatingViewResolver.setDefaultViews(list);
		return contentNegotiatingViewResolver;
	}

}

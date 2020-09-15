package finalProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import finalProject.Interceptor.CertificationInterceptor;


public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CertificationInterceptor())
				.addPathPatterns("/**/*")
				.excludePathPatterns("/register/**/")
				.excludePathPatterns("/login")
				.excludePathPatterns("/static/**/")
				.excludePathPatterns("/chatting")
				.excludePathPatterns("/chat/**");
	}
}

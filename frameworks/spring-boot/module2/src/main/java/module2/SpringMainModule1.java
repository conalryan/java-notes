package module2;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
 
@ComponentScan(basePackages="module2")
@SpringBootApplication
public class SpringMainModule1 extends SpringBootServletInitializer{
	
	@Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringMainModule1.class);
    }
 
	public static void main(String[] args) {
        SpringApplication.run(SpringMainModule1.class, args);
    }
}
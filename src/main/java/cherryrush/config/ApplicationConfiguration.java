package cherryrush.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("cherryrush")
@PropertySource("classpath:level-design.properties")
public class ApplicationConfiguration {
	// spring configuration class
}

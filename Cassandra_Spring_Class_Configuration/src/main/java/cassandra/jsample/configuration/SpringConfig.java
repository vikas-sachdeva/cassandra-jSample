package cassandra.jsample.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "cassandra.jsample")
@Import(value = CassandraConfig.class)
public class SpringConfig {

}

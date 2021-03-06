package be.brouwers.restservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableEntityLinks;

@Configuration
@ComponentScan
@EnableEntityLinks
@EnableSpringDataWebSupport
public class CreateRestControllerBeans {}

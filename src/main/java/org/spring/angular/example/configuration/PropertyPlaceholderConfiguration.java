package org.spring.angular.example.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class PropertyPlaceholderConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        final PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new FileSystemResource("/opt/apps/spring-mybatis-example/conf-override.properties"),
        });

        return propertyPlaceholderConfigurer;
    }

}

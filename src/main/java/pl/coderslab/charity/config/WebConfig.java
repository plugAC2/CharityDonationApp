package pl.coderslab.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.converters.CategoryModelConverter;
import pl.coderslab.charity.converters.InstitutionModelConverter;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(getCategoryConverter());
        registry.addConverter(getInstitutionConverter());
    }

    @Bean
    public CategoryModelConverter getCategoryConverter() {
        return new CategoryModelConverter();
    }

    @Bean
    public InstitutionModelConverter getInstitutionConverter() {
        return new InstitutionModelConverter();
    }
}

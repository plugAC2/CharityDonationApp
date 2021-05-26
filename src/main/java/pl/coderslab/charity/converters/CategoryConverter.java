package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.services.CategoryService;


public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.getRecordById(Long.parseLong(s)).orElseThrow();
    }
}

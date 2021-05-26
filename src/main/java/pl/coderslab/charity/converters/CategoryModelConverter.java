package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.factories.CategoryEntityModelMapper;
import pl.coderslab.charity.models.CategoryModel;
import pl.coderslab.charity.services.CategoryService;

public class CategoryModelConverter implements Converter<String, CategoryModel> {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryEntityModelMapper mapper;

    @Override
    public CategoryModel convert(String source) {
        return mapper.createModelFromEntity(categoryService.getRecordById(Long.parseLong(source)).orElseThrow());
    }
}

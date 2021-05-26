package pl.coderslab.charity.factories;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.models.CategoryModel;
import pl.coderslab.charity.repositories.CategoryRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class CategoryEntityModelMapper implements EntityModelMapper<Category, CategoryModel> {

    @NonNull
    private final CategoryRepository categoryRepository;

    @Override
    public Category createEntityFromModel(CategoryModel categoryModel) {
        return Category.builder()
                .name(categoryModel.getName())
                .build();
    }

    @Override
    public CategoryModel createModelFromEntity(Category category) {
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}

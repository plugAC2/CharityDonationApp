package pl.coderslab.charity.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.factories.CategoryEntityModelMapper;
import pl.coderslab.charity.models.CategoryModel;
import pl.coderslab.charity.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService implements CrudService<Category, CategoryModel> {

    @NonNull
    private final CategoryRepository categoryRepository;

    @NonNull
    private final CategoryEntityModelMapper factory;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryModel> getAllModel() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(factory::createModelFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void newRecord(CategoryModel categoryModel) {
        categoryRepository.save(factory.createEntityFromModel(categoryModel));
    }

    @Override
    public void newRecordDirect(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getRecordById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void changeRecord(Long id, CategoryModel categoryModel) {
        Category categoryChanges = factory.createEntityFromModel(categoryModel);
        Optional<Category> categoryToBeChanged = getRecordById(id);
        categoryToBeChanged.stream()
                .peek(y -> y.setName(categoryChanges.getName()))
                .forEach(this::newRecordDirect);
    }

    @Override
    public void deleteRecordById(Long id) {
        categoryRepository.deleteById(id);
    }
}

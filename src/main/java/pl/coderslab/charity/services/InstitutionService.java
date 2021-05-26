package pl.coderslab.charity.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.factories.InstitutionEntityModelMapper;
import pl.coderslab.charity.models.InstitutionModel;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InstitutionService implements CrudService<Institution, pl.coderslab.charity.models.InstitutionModel> {

    @NonNull
    private final InstitutionRepository institutionRepository;

    @NonNull
    private final InstitutionEntityModelMapper factory;

    @Override
    public List<Institution> getAll() {
        return institutionRepository.findAll();
    }

    @Override
    public List<pl.coderslab.charity.models.InstitutionModel> getAllModel() {
        List<Institution> institutions = institutionRepository.findAll();
        return institutions.stream()
                .map(factory::createModelFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void newRecord(pl.coderslab.charity.models.InstitutionModel institutionModel) {
        institutionRepository.save(factory.createEntityFromModel(institutionModel));
    }

    @Override
    public void newRecordDirect(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public Optional<Institution> getRecordById(Long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public void changeRecord(Long id, InstitutionModel institutionModel) {
        Institution institutionChanges = factory.createEntityFromModel(institutionModel);
        Optional<Institution> institutionToBeChanged = getRecordById(id);
        institutionToBeChanged.stream()
                .peek(y -> {
                    y.setName(institutionChanges.getName());
                    y.setDescription(institutionChanges.getDescription());
                })
                .forEach(this::newRecordDirect);
    }

    @Override
    public void deleteRecordById(Long id) {
        institutionRepository.deleteById(id);
    }
}

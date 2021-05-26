package pl.coderslab.charity.factories;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

@RequiredArgsConstructor
@Component
public class InstitutionEntityModelMapper implements EntityModelMapper<Institution, pl.coderslab.charity.models.InstitutionModel> {

    @NonNull
    private final InstitutionRepository institutionRepository;

    @Override
    public Institution createEntityFromModel(pl.coderslab.charity.models.InstitutionModel institutionModel) {
        return Institution.builder()
                .name(institutionModel.getName())
                .description(institutionModel.getDescription())
                .build();
    }

    @Override
    public pl.coderslab.charity.models.InstitutionModel createModelFromEntity(Institution institution) {
        return pl.coderslab.charity.models.InstitutionModel.builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .build();
    }

}

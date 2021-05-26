package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.factories.InstitutionEntityModelMapper;
import pl.coderslab.charity.models.InstitutionModel;
import pl.coderslab.charity.services.InstitutionService;

public class InstitutionModelConverter implements Converter<String, InstitutionModel> {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private InstitutionEntityModelMapper mapper;


    @Override
    public InstitutionModel convert(String source) {
        return mapper.createModelFromEntity(institutionService.getRecordById(Long.parseLong(source)).orElseThrow());
    }
}

package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.InstitutionService;


public class InstitutionConverter implements Converter<String, Institution> {

    @Autowired
    private InstitutionService institutionService;

    @Override
    public Institution convert(String s) {
        return institutionService.getRecordById(Long.parseLong(s)).orElseThrow();
    }
}
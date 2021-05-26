package pl.coderslab.charity.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.factories.DonationEntityModelMapper;
import pl.coderslab.charity.models.DonationModel;
import pl.coderslab.charity.repositories.DonationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DonationService implements CrudService<Donation, DonationModel> {

    @NonNull
    private final DonationRepository donationRepository;

    @NonNull
    private final DonationEntityModelMapper factory;

    @Override
    public List<Donation> getAll() {
        return donationRepository.getOneHundredDonations();
    }

    @Override
    public List<DonationModel> getAllModel() {
        List<Donation> donations = donationRepository.getOneHundredDonations();
        return donations.stream()
                .map(factory::createModelFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void newRecord(DonationModel donationModel) {
        donationRepository.save(factory.createEntityFromModel(donationModel));
    }

    @Override
    public void newRecordDirect(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Optional<Donation> getRecordById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public void changeRecord(Long id, DonationModel donationModel) {
        Donation donationChanges = factory.createEntityFromModel(donationModel);
        Optional<Donation> donationToBeChange = getRecordById(id);
        donationToBeChange.stream()
                .peek(y -> {
                    y.setQuantity(donationChanges.getQuantity());
                    y.setCategories(donationChanges.getCategories());
                    y.setInstitution(donationChanges.getInstitution());
                    y.setStreet(donationChanges.getStreet());
                    y.setCity(donationChanges.getCity());
                    y.setZipCode(donationChanges.getZipCode());
                    y.setPickUpDate(donationChanges.getPickUpDate());
                    y.setPickUpTime(donationChanges.getPickUpTime());
                    y.setPickUpComment(donationChanges.getPickUpComment());
                })
                .forEach(this::newRecordDirect);
    }

    @Override
    public void deleteRecordById(Long id) {
        donationRepository.deleteById(id);
    }

    public Integer addAllSacks(){
        return donationRepository.sacksAmount();
    }

    public Long addAllDonations(){
        return donationRepository.count();
    }
}

package pl.coderslab.charity.factories;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.models.DonationModel;
import pl.coderslab.charity.repositories.DonationRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class DonationEntityModelMapper implements EntityModelMapper<Donation, DonationModel> {

    @NonNull
    private final DonationRepository donationRepository;

    @Override
    public Donation createEntityFromModel(DonationModel donationModel) {
        return Donation.builder()
                .quantity(donationModel.getQuantity())
                //.categories(donationModel.getCategories())
                //.institution(donationModel.getInstitution())
                .street(donationModel.getStreet())
                .city(donationModel.getCity())
                .zipCode(donationModel.getZipCode())
                .pickUpDate(donationModel.getPickUpDate())
                .pickUpTime(donationModel.getPickUpTime())
                .pickUpComment(donationModel.getPickUpComment())
                .build();
    }

    @Override
    public DonationModel createModelFromEntity(Donation donation) {
        return DonationModel.builder()
                .id(donation.getId())
                .quantity(donation.getQuantity())
                //.categories(donation.getCategories())
                //.institution(donation.getInstitution())
                .street(donation.getStreet())
                .city(donation.getCity())
                .zipCode(donation.getZipCode())
                .pickUpDate(donation.getPickUpDate())
                .pickUpTime(donation.getPickUpTime())
                .pickUpComment(donation.getPickUpComment())
                .build();
    }

}

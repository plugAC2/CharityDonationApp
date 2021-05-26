package pl.coderslab.charity.models;

import lombok.*;
import pl.coderslab.charity.entities.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonationModel {

    private Long id = 0L;
    private Integer quantity;
    @Singular
    private List<CategoryModel> categories;
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private String telephoneNumber;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}

package pl.coderslab.charity.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstitutionModel {

    private Long id = 0L;
    private String name;
    private String description;
}

package pl.coderslab.charity.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryModel {

    private Long id = 0L;
    private String name;
}

package vn.edu.leading.shop.controllers.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private Long id;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    private String birthDay;

    private String photo;

    private String notes;
}

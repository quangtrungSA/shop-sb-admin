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
public class ShipperDTO {

    private Long id;

    @NotNull
    private String shipperName;

    private String phone;
}

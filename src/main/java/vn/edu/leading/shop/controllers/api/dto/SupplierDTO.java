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
public class SupplierDTO {
    private Long id;

    @NotNull
    private String supplierName;

    private String contactName;

    private String address;

    private String city;

    private String postalCode;

    private String Country;

    private String phone;
}

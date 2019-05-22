package vn.edu.leading.shop.controllers.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

    private Long id;

    private String customerName;

    private String contactName;

    private String address;

    private String city;

    private String postalCode;

    private String country;
}

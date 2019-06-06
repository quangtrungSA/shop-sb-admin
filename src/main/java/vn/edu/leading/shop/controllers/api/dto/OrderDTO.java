package vn.edu.leading.shop.controllers.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private Long id;

    private Long customerId;

    private Long employeeId;

    private Long shipperId;

    private String orderDate;
}

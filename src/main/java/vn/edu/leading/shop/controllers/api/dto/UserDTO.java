package vn.edu.leading.shop.controllers.api.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String urlImage;
}

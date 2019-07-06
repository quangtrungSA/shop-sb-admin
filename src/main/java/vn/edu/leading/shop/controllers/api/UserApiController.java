package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.CategoryDTO;
import vn.edu.leading.shop.controllers.api.dto.UserDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.UserModel;
import vn.edu.leading.shop.services.UserService;

import javax.validation.Valid;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UserModel userModel = userService.findById(id);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.findById(id);
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}

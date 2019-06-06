package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.EmployeeDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.EmployeeModel;
import vn.edu.leading.shop.services.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/OrderDetail")
public class OrderDetailApiController {

    private final EmployeeService employeeService;

    public OrderDetailApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        EmployeeModel employeeModel = employeeService.findById(id).orElseThrow(() -> new ObjectNotFoundException("employee"));
        return new ResponseEntity<>(employeeModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setFirstName(employeeDTO.getFirstName());
        employeeModel.setLastName(employeeDTO.getLastName());
        employeeModel.setBirthDate(employeeModel.getBirthDate());
        employeeModel.setNotes(employeeDTO.getNotes());
        employeeModel.setPhoto(employeeDTO.getPhoto());
        return new ResponseEntity(employeeService.save(employeeModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = employeeService.findById(id).orElseThrow(() -> new ObjectNotFoundException("employee"));
        employeeModel.setFirstName(employeeDTO.getFirstName());
        employeeModel.setLastName(employeeDTO.getLastName());
        employeeModel.setBirthDate(employeeModel.getBirthDate());
        employeeModel.setNotes(employeeDTO.getNotes());
        employeeModel.setPhoto(employeeDTO.getPhoto());
        return new ResponseEntity(employeeService.save(employeeModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.findById(id).orElseThrow(() -> new ObjectNotFoundException("employee"));
        return new ResponseEntity<>(employeeService.delete(id), HttpStatus.OK);
    }
}

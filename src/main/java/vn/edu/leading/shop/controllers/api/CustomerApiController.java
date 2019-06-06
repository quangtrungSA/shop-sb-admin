package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.CustomerDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.services.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerApiController {

    private final CustomerService customerService;

    public CustomerApiController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CustomerModel customerModel = customerService.findById(id).orElseThrow(() -> new ObjectNotFoundException("customer"));
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerName(customerDTO.getCustomerName());
        customerModel.setContactName(customerDTO.getContactName());
        customerModel.setCountry(customerModel.getCountry());
        customerModel.setAddress(customerDTO.getAddress());
        customerModel.setPostalCode(customerDTO.getPostalCode());
        customerModel.setCity(customerDTO.getPostalCode());
        return new ResponseEntity(customerService.save(customerModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        CustomerModel customerModel = customerService.findById(id).orElseThrow(() -> new ObjectNotFoundException("customer"));
        customerModel.setCustomerName(customerDTO.getCustomerName());
        customerModel.setContactName(customerDTO.getContactName());
        customerModel.setCountry(customerModel.getCountry());
        customerModel.setAddress(customerDTO.getAddress());
        customerModel.setPostalCode(customerDTO.getPostalCode());
        customerModel.setCity(customerDTO.getPostalCode());
        return new ResponseEntity(customerService.save(customerModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerService.findById(id).orElseThrow(() -> new ObjectNotFoundException("customer"));
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }
}

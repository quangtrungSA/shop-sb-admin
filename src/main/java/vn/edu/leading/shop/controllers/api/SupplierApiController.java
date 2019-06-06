package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.SupplierDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.services.SupplierService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierApiController {

    private final SupplierService supplierService;

    public SupplierApiController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        SupplierModel supplierModel = supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("suppliere"));
        return new ResponseEntity<>(supplierModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody SupplierDTO supplierDTO) {
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setSupplierName(supplierDTO.getSupplierName());
        supplierModel.setContactName(supplierDTO.getContactName());
        supplierModel.setAddress(supplierDTO.getAddress());
        supplierModel.setCity(supplierDTO.getCity());
        supplierModel.setCountry(supplierDTO.getCountry());
        supplierModel.setPhone(supplierDTO.getPhone());
        supplierModel.setPostalCode(supplierDTO.getPostalCode());
        return new ResponseEntity(supplierService.save(supplierModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplierDTO) {
        SupplierModel supplierModel = supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("supplier"));
        supplierModel.setSupplierName(supplierDTO.getSupplierName());
        supplierModel.setContactName(supplierDTO.getContactName());
        supplierModel.setAddress(supplierDTO.getAddress());
        supplierModel.setCity(supplierDTO.getCity());
        supplierModel.setCountry(supplierDTO.getCountry());
        supplierModel.setPhone(supplierDTO.getPhone());
        supplierModel.setPostalCode(supplierDTO.getPostalCode());
        return new ResponseEntity(supplierService.save(supplierModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("supplier"));
        return new ResponseEntity<>(supplierService.delete(id), HttpStatus.OK);
    }
}

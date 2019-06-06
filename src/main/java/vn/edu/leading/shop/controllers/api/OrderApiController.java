package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.EmployeeDTO;
import vn.edu.leading.shop.controllers.api.dto.OrderDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.models.EmployeeModel;
import vn.edu.leading.shop.models.OrderModel;
import vn.edu.leading.shop.models.ShipperModel;
import vn.edu.leading.shop.services.CustomerService;
import vn.edu.leading.shop.services.EmployeeService;
import vn.edu.leading.shop.services.OrderService;
import vn.edu.leading.shop.services.ShipperService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderApiController {

    private final OrderService orderService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final ShipperService shipperService;

    public OrderApiController(OrderService orderService, EmployeeService employeeService, CustomerService customerService, ShipperService shipperService) {
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.shipperService = shipperService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        OrderModel orderModel = orderService.findById(id).orElseThrow(() -> new ObjectNotFoundException("employee"));
        return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody OrderDTO orderDTO) {
        CustomerModel customerModel = customerService.findById(orderDTO.getCustomerId()).orElseThrow(()-> new ObjectNotFoundException("customer"));
        ShipperModel shipperModel = shipperService.findById(orderDTO.getShipperId()).orElseThrow(()-> new ObjectNotFoundException("shipper"));
        EmployeeModel employeeModel = employeeService.findById(orderDTO.getEmployeeId()).orElseThrow(()-> new ObjectNotFoundException("employee"));
        OrderModel orderModel = new OrderModel();
        orderModel.setCustomerModel(customerModel);
        orderModel.setEmployeeModel(employeeModel);
        orderModel.setShipperModel(shipperModel);
        orderModel.setOrderDate(orderDTO.getOrderDate());
        return new ResponseEntity(orderService.save(orderModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody OrderDTO orderDTO) {
        CustomerModel customerModel = customerService.findById(orderDTO.getCustomerId()).orElseThrow(()-> new ObjectNotFoundException("customer"));
        ShipperModel shipperModel = shipperService.findById(orderDTO.getShipperId()).orElseThrow(()-> new ObjectNotFoundException("shipper"));
        EmployeeModel employeeModel = employeeService.findById(orderDTO.getEmployeeId()).orElseThrow(()-> new ObjectNotFoundException("employee"));
        OrderModel orderModel = orderService.findById(id).orElseThrow(() -> new ObjectNotFoundException("order"));
        orderModel.setCustomerModel(customerModel);
        orderModel.setEmployeeModel(employeeModel);
        orderModel.setShipperModel(shipperModel);
        orderModel.setOrderDate(orderDTO.getOrderDate());
        return new ResponseEntity(employeeService.save(employeeModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        orderService.findById(id).orElseThrow(() -> new ObjectNotFoundException("order"));
        return new ResponseEntity<>(orderService.delete(id), HttpStatus.OK);
    }
}

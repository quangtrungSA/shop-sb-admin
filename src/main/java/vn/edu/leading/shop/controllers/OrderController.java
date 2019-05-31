package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.OrderModel;
import vn.edu.leading.shop.services.CustomerService;
import vn.edu.leading.shop.services.EmployeeService;
import vn.edu.leading.shop.services.OrderService;
import vn.edu.leading.shop.services.ShipperService;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final ShipperService shipperService;

    public OrderController(OrderService orderService, CustomerService customerService, EmployeeService employeeService, ShipperService shipperService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.shipperService = shipperService;
    }


    @GetMapping("/orders")
    public String list(Model model) {
        model.addAttribute("orders", orderService.findAll());

        return "orders/list";
    }

    @GetMapping("/admin/orders")
    public String list1(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("shippers", shipperService.findAll());
        return "admin/pages/orders";
    }

    @PostMapping("/admin/orders")
    public String save(@Valid OrderModel order, BindingResult result, RedirectAttributes redirect, Model model) {
        if (result.hasErrors()) {
            return "admin/pages/orders";
        }
        orderService.save(order);
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("shippers", shipperService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved order successfully!");
        return "admin/pages/orders";
    }

    @GetMapping("/orders/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (orderService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted order successfully!");
            return "redirect:/admin/orders";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/admin/orders";
        }
    }
}

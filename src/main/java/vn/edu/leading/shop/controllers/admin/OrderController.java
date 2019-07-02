package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.OrderModel;
import vn.edu.leading.shop.services.OrderService;
import vn.edu.leading.shop.services.ShipperService;

import javax.validation.Valid;
import java.time.Instant;

@Controller
public class OrderController {

    private final OrderService orderService;

    private final ShipperService shipperService;

    public OrderController(OrderService orderService, ShipperService shipperService) {
        this.orderService = orderService;
        this.shipperService = shipperService;
    }


    @GetMapping("/admin/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("shippers", shipperService.findAll());
        return "admin/pages/orders";
    }

    @PostMapping("admin/orders")
    public String save(@Valid OrderModel order, BindingResult result, RedirectAttributes redirect, Model model) {
        if (result.hasErrors()) {
            return "admin/pages/orders";
        }
        if (order.getId() == null) {
            order.setOrderDate(String.valueOf(Instant.now()));
        }
        orderService.save(order);
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("shippers", shipperService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved order successfully!");
        return "admin/pages/orders";
    }

    @GetMapping("/orders/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect, Model model) {
        if (orderService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted order successfully!");
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("shippers", shipperService.findAll());
            return "admin/pages/orders";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("shippers", shipperService.findAll());
            return "admin/pages/orders";
        }
    }
}
package vn.edu.leading.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.OrderDetailModel;
import vn.edu.leading.shop.services.CustomerService;
import vn.edu.leading.shop.services.OrderDetailService;
import vn.edu.leading.shop.services.OrderService;
import vn.edu.leading.shop.services.ProductService;

import javax.validation.Valid;

@Controller
public class OrderDetailController {

    private final OrderDetailService orderDetailService;
    private final ProductService productService;
    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderDetailController(OrderDetailService orderDetailService, ProductService productService, OrderService orderService, CustomerService customerService) {
        this.orderDetailService = orderDetailService;
        this.productService = productService;
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @GetMapping("/orderDetails")
    public String list(Model model) {
        model.addAttribute("orderDetails", orderDetailService.findAll());
        return "orderDetails/list";
    }

    @GetMapping("/admin/orderDetails")
    public String list1(Model model) {
        model.addAttribute("orderDetails", orderDetailService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "admin/pages/orderDetails";
    }

    @GetMapping("/orderDetails/add")
    public String add(Model model) {
        model.addAttribute("orderDetailModel", new OrderDetailModel());
        return "orderDetails/form";
    }

    @GetMapping("/orderDetails/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("orderDetailModel", orderDetailService.findById(id));
        return "orderDetails/form";
    }

    @PostMapping("/admin/orderDetails")
    public String save(@Valid OrderDetailModel orderDetail, BindingResult result, RedirectAttributes redirect, Model model) {
        if (result.hasErrors()) {
            return "admin/pages/orderDetails";
        }
        orderDetailService.save(orderDetail);
        model.addAttribute("orderDetails", orderDetailService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved orderDetails successfully!");
        return "admin/pages/orderDetails";
    }

    @GetMapping("/orderDetails/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (orderDetailService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted orderDetails successfully!");
            return "redirect:/admin/orderDetails";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/admin/orderDetails";
        }
    }
}

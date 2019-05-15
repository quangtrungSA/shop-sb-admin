package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.OrderDetailModel;
import vn.edu.leading.shop.services.OrderDetailService;

import javax.validation.Valid;

@Controller
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/orderDetails")
    public String list(Model model) {
        model.addAttribute("orderDetails", orderDetailService.findAll());
        return "orderDetails/list";
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

    @PostMapping("/orderDetails/save")
    public String save(@Valid OrderDetailModel orderDetail, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "orderDetails/form";
        }
        orderDetailService.save(orderDetail);
        redirect.addFlashAttribute("successMessage", "Saved orderDetails successfully!");
        return "redirect:/orderDetails";
    }

    @GetMapping("/orderDetails/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (orderDetailService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted orderDetails successfully!");
            return "redirect:/orderDetails";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/orderDetails";
        }
    }
}

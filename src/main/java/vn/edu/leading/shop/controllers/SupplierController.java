package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.services.SupplierService;

import javax.validation.Valid;

@Controller
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public String list(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "suppliers/list";
    }

    @GetMapping("suppliers/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/suppliers";
        }
        model.addAttribute("suppliers", supplierService.search(term));
        return "suppliers/list";
    }

    @GetMapping("/suppliers/add")
    public String add(Model model) {
        model.addAttribute("supplierModel", new SupplierModel());
        return "suppliers/form";
    }

    @GetMapping("/suppliers/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("supplierModel", supplierService.findById(id));
        return "suppliers/form";
    }

    @PostMapping("/suppliers/save")
    public String save(@Valid SupplierModel supplier, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "suppliers/form";
        }
        supplierService.save(supplier);
        redirect.addFlashAttribute("successMessage", "Saved supplier successfully!");
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (supplierService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted supplier successfully!");
            return "redirect:/suppliers";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/suppliers";
        }
    }
}

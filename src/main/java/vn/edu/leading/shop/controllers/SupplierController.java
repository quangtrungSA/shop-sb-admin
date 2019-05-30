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

    @GetMapping("admin/suppliers")
    public String list1(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "admin/pages/suppliers";
    }

    @GetMapping("suppliers/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/suppliers";
        }
        model.addAttribute("suppliers", supplierService.search(term));
        return "suppliers/list";
    }



    @PostMapping("/admin/suppliers")
    public String save(@Valid SupplierModel supplier, BindingResult result, RedirectAttributes redirect,Model model) {
        if (result.hasErrors()) {
            return "admin/pages/suppliers";
        }
        supplierService.save(supplier);
        model.addAttribute("suppliers",supplierService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved supplier successfully!");
        return "admin/pages/suppliers";
    }

    @GetMapping("/suppliers/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (supplierService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted supplier successfully!");
            return "redirect:/admin/suppliers";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/admin/suppliers";
        }
    }
}

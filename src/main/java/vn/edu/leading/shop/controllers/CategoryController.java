package vn.edu.leading.shop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.services.CategoryService;

import javax.validation.Valid;

@Controller
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/categories")
    public String list1(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/pages/categories";
    }

    @GetMapping("categories/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/categories";
        }
        model.addAttribute("categories", categoryService.search(term));
        return "categories/list";
    }

    @PostMapping("/admin/categories")
    public String save(@Valid CategoryModel category, RedirectAttributes redirect, Model model) {
        categoryService.save(category);
        model.addAttribute("categories", categoryService.findAll());
        redirect.addFlashAttribute("successMessage", "Saved category successfully!");
        return "admin/pages/categories";
    }

    @GetMapping("/categories/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (categoryService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted category successfully!");
            return "redirect:/admin/categories";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/admin/categories";
        }
    }
}

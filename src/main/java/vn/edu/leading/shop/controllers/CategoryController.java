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
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.repositories.BaseRepository;
import vn.edu.leading.shop.services.BaseService;

import javax.validation.Valid;

@Controller
public class CategoryController extends BaseController<CategoryModel> {

    public CategoryController(BaseRepository<CategoryModel, ?> baseRepository, BaseService<CategoryModel> baseService) {
        super(baseRepository, baseService);
    }

    @GetMapping("/categories")
    public String list(Model model) {
        model.addAttribute("categories", baseService.findAll());
        return "categories/list";
    }

    @GetMapping("categories/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/categories";
        }
        model.addAttribute("categories", baseService.search("categoryName", term));
        return "categories/list";
    }

    @GetMapping("/categories/add")
    public String add(Model model) {
        model.addAttribute("categoryModel", new CategoryModel());
        return "categories/form";
    }

    @GetMapping("/categories/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categoryModel", baseService.findById(id));
        return "categories/form";
    }

    @PostMapping("/categories/save")
    public String save(@Valid CategoryModel category, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "categories/form";
        }
        baseService.save(category);
        redirect.addFlashAttribute("successMessage", "Saved category successfully!");
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (baseService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted category successfully!");
            return "redirect:/categories";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/categories";
        }
    }
}

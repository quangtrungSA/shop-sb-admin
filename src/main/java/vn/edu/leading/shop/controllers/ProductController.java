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
import vn.edu.leading.shop.models.ProductModel;
import vn.edu.leading.shop.services.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    @GetMapping("products/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/products";
        }
        model.addAttribute("products", productService.search(term));
        return "products/list";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        model.addAttribute("productModel", new ProductModel());
        return "products/form";
    }

    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productModel", productService.findById(id));
        return "products/form";
    }

    @PostMapping("/products/save")
    public String save(@Valid ProductModel product, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "products/form";
        }
        productService.save(product);
        redirect.addFlashAttribute("successMessage", "Saved product successfully!");
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (productService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted product successfully!");
            return "redirect:/products";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/products";
        }
    }
}

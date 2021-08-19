package com.codingdojo.PyC.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.PyC.Models.Category;
import com.codingdojo.PyC.Models.Product;
import com.codingdojo.PyC.Models.ProductCategory;
import com.codingdojo.PyC.Services.CategoryService;
import com.codingdojo.PyC.Services.ProductService;




@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;

	public ProductController(ProductService productService,CategoryService categoryService) {
			
			this.productService = productService;
			this.categoryService = categoryService;
		}
	

	
@RequestMapping("/")
public String start() {
return "redirect:products/new";
	}

@GetMapping("products/new")
public String newProduct(@ModelAttribute("product") Product product) {
    return "product/newProduct.jsp";
}

@PostMapping("products/new") 
public String nuevoproducto(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	if(result.hasErrors()) {
		return "product/newProduct.jsp";
	}
	else {
		productService.createProduct(product); 
		return "redirect:/categories/new";
	}
}

@GetMapping("categories/new")
public String addCategory(@ModelAttribute("category")Category category, Model model) {
	
	return"category/newCategory.jsp";
	
}

@PostMapping("categories/new")
public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	if(result.hasErrors()) {
		
		return"category/newCategory.jsp";
	}
	else {
		
		categoryService.createCategory(category);
		return "redirect:/products/new";
		
	}
}



@GetMapping("/products/{productId}")
public String showproduct(@PathVariable("productId")Long id,@ModelAttribute("productCategory") ProductCategory productcategory,Model model) {
	
	model.addAttribute("product",productService.findProduct(id));
	model.addAttribute("categories",productService.categoriesForProduct(productService.findProduct(id)));
	return"product/showProduct.jsp";
}


@PostMapping("/products/{productId}")
public String unircategoria(@PathVariable("productId")Long Id,@ModelAttribute("productCategory") ProductCategory productCategory,BindingResult result) {
	productCategory.setProduct(productService.findProduct(Id));
	productService.sumarCategoriaAProducto(productCategory);
	
	return"redirect:/products/"+Id;
}




@GetMapping("categories/{categoryId}")
public String categoryAddProduct(@ModelAttribute("productCategory")ProductCategory productCategory,@PathVariable("categoryId")Long id, Model model) {
	model.addAttribute("category",productService.findCategory(id));
	model.addAttribute("products",productService.productsForCategories(categoryService.findCategory(id)));
	
	return "category/showCategory.jsp";
}

@PostMapping("categories/{categoryId}")
public String addProductToCategory(@ModelAttribute("productCategory")ProductCategory productCategory, @PathVariable("categoryId")Long id, Model model) {
	productCategory.setCategory(productService.findCategory(id));
	productService.sumarCategoriaAProducto(productCategory);
	return"redirect:/categories/"+id;
}


}






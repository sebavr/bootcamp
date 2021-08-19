package com.codingdojo.PyC.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.PyC.Models.Category;
import com.codingdojo.PyC.Models.Product;
import com.codingdojo.PyC.Models.ProductCategory;
import com.codingdojo.PyC.Repo.CategoryRepo;
import com.codingdojo.PyC.Repo.ProductCategoryRepo;
import com.codingdojo.PyC.Repo.ProductRepo;



@Service
public class ProductService {
	private final ProductRepo productRepo;
	private final ProductCategoryRepo productCategoryRepo;
	private final CategoryRepo categoryRepo;

	public ProductService(ProductRepo productRepo, ProductCategoryRepo productCategoryRepo,CategoryRepo categoryRepo) {
	
		this.productRepo = productRepo;
		this.productCategoryRepo=productCategoryRepo;
		this.categoryRepo = categoryRepo;
	}
	
	//devolviendo todas las canciones
    public List<Product> allProducts() {
        return productRepo.findAll();
    }
    
    public void sumarCategoriaAProducto(ProductCategory productCategory) {
    	productCategoryRepo.save(productCategory);
    }
    
    public List<Category> categoriesForProduct(Product product) {
        return categoryRepo.findByProductsNotContains(product);  
    } 
    
    public List<Product> productsForCategories(Category category) {
        return productRepo.findByCategoriesNotContains(category);  
    } 
    
    
    
    //Creando una cancion
    public Product createProduct(Product p) {
        return productRepo.save(p);
    }
    
  //Obteniendo la información de una cancion
    public Product findProduct(Long id) {
        Optional<Product> Product = productRepo.findById(id);
        if(Product.isPresent()) {
            return Product.get();
        } else {
            return null;
        }
    }
    
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
 //eliminar una cancion
    
    public void deleteProduct(Long id) {
    	productRepo.deleteById(id);
    }
  
    
    
}
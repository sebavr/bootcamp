package com.codingdojo.PyC.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.PyC.Models.Category;
import com.codingdojo.PyC.Models.Product;
import com.codingdojo.PyC.Repo.CategoryRepo;



@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;

	public CategoryService(CategoryRepo categoryRepo) {
	
		this.categoryRepo = categoryRepo;
	}
	
	//devolviendo todas las canciones
    public List<Category> allCategorys() {
        return categoryRepo.findAll();
    }
    
    //Cateogrias por producto
    public List<Category> categoriesForProduct(Product product) {
        return categoryRepo.findByProductsNotContains(product);  
    } 
    
    //Creando una cancion
    public Category createCategory(Category p) {
        return categoryRepo.save(p);
    }
    
  //Obteniendo la información de una cancion
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deleteCategory(Long id) {
    	categoryRepo.deleteById(id);
    }
    //actualizar una cancion
    public Category updateLanguage(Category song) {
		return categoryRepo.save(song);
		
	}
}
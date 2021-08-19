package com.codingdojo.MVC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.MVC.models.Book;
import com.codingdojo.MVC.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	//Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
   //eliminar un libro
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    //actualizar
    
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Book b=new Book();
    	b.setId(id);
    	b.setDescription(desc);
    	b.setTitle(title);
    	b.setNumberOfPages(numOfPages);
    	b.setLanguage(lang);
    	
    	
    	return bookRepository.save(b);
		
	}

}

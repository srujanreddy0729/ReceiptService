package com.example.BookApplication.Controller;

import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Service.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("books")
    public List<Book> getAllBooks(){
         return service.getAllBooks();
    }

    @PostMapping("loadData")
    public String loadData(){
        service.saveAllBooks();
        return "LoadedData";
    }

    @GetMapping("book/{id}")
    public Book getBook(@PathVariable("id") int bookId){
        return service.findBook(bookId);
    }

    @PostMapping("book")
    public Book addBook(@RequestBody Book book){
        service.addBook(book);
        return service.findBook(book.getId());
    }

    @PutMapping("book")
    public Book updateBook(@RequestBody Book book){
        service.addBook(book);
        return service.findBook(book.getId());
    }

    @DeleteMapping("book/{id}")
    public String deleteBook(@PathVariable int id){
         service.deleteBook(id);
        return "Deleted Book";
    }
}

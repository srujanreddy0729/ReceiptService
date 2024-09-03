package com.example.BookApplication.Service;

import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void saveAllBooks(){
        repo.saveAll(loadData());
    }

    public Book findBook(int bookId) {
        return repo.findById(bookId).orElse(new Book());
    }

    public void addBook(Book book) {
        repo.save(book);
    }

    public void deleteBook(int bookId) {
        repo.deleteById(bookId);
    }

    public List<Book> loadData() {
        List<Book> allBooks=new ArrayList<>(Arrays.asList(
                new Book(1,"Life is Good","John","v2.14"),
                new Book(2,"Bad Life","Smith","v2.24"),
                new Book(3,"One","Warner","v2.16")
        ));
        return allBooks;
    }
}

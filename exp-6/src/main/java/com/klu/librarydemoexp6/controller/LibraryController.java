package com.klu.librarydemoexp6.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.librarydemoexp6.model.Book;

@RestController
public class LibraryController {

    // In-memory list to store books
    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. Return total book count
    @GetMapping("/count")
    public int getBookCount() {
        return 200;
    }

    // 3. Return sample price
    @GetMapping("/price")
    public double getPrice() {
        return 599.99;
    }

    // 4. Return list of book titles
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList(
                "Spring Boot Guide",
                "Java Programming",
                "Microservices Architecture",
                "REST API Development"
        );
    }

    // 5. Return book details by ID using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. Search book using RequestParam
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "You searched for book: " + title;
    }

    // 7. Get books by author name
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. Add book using POST
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. View all added books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
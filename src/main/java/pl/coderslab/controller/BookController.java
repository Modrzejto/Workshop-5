package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    MockBookService mbs = new MockBookService();
    @RequestMapping("/helloBook")
    @ResponseBody
    public Book helloBook() {
        return new Book(1L, "isbn", "title", "author", "publisher", "type");
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<Book> allBooks() {
        return mbs.getAllBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mbs.addBook(book);
    }

    //curl -X POST -i -H "Content-Type: application/json" -d '{"isbn":"34321","title":"Thinking in Java", "publisher":"Helion","type":"programming", "author":"Bruce Eckel"}' http://localhost:8080/books

    @GetMapping("/{id:\\d+}")
    @ResponseBody
    public Book getBookById(@PathVariable Long id) {
        return mbs.getBookById(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        mbs.updateBook(book);
    }

    //curl -X PUT -i -H "Content-Type: application/json" -d '{"id":1,"isbn":"32222","title":"Thinking in C#", "publisher":"IT Books", "type":"programming", "author":"Bruce Eckel"}' http://localhost:8080/books

    @DeleteMapping("/{id:\\d+}")
    public void deleteBook(@PathVariable Long id) {
        mbs.deleteBook(id);
    }

    //curl -X DELETE -i  http://localhost:8080/books/1
}

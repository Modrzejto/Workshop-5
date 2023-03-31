package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {
    @Getter
    @Setter
    private List<Book> list;
    private static Long nextId = 4L;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion",
                "programming"));

        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));

        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    public List<Book> getAllBooks() {
        return list;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    public Book getBookById(Long id) {
        for (Book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(Book book) {
        Book newBook = getBookById(book.getId());
        newBook.setIsbn(book.getIsbn());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setPublisher(book.getPublisher());
        newBook.setType(book.getType());

        list.set(Math.toIntExact(book.getId() - 1), book);
    }

    public void deleteBook(Long id) {
        list.remove(Math.toIntExact(id - 1));
    }
}

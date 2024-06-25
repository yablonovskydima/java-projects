package com.lesson.lesson15.webcontroller;

import com.lesson.lesson15.domain.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController
{
    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> showBooks()
    {
        return books;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        book.setId(UUID.randomUUID().toString());
        books.add(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{name}")
    public String deleteBook(@PathVariable String name)
    {
        books.removeIf(book -> book.getName().toLowerCase().equals(name.toLowerCase()));

        return "Book with name " + name + " was deleted";
    }

    @PutMapping("/{name}")
    public String editBook(@RequestBody Book newBook, @PathVariable String name)
    {
        for (Book i:books)
        {
            if(i.getName().toLowerCase().equals(name.toLowerCase()))
            {
                i.setId(UUID.randomUUID().toString());
                i.setName(newBook.getName());
                i.setDescription(newBook.getDescription());
                i.setAuthor(newBook.getAuthor());
                i.setPagesCount(newBook.getPagesCount());
                i.setCoverType(newBook.getCoverType());
                i.setPrice(newBook.getPrice());
                return "Book with id " + i.getId() + " was updated";
            }
        }
        return "Book not found";
    }

    @GetMapping("/min-price")
    public ResponseEntity<Book> minPrice()
    {
        Book minprice = books.stream()
                .min(Comparator.comparingInt(Book::getPrice))
                .orElseThrow();

        return ResponseEntity.ok(minprice);
    }

    @GetMapping("/max-price")
    public ResponseEntity<Book> maxPrice()
    {
        Book maxprice =  books.stream()
                .max(Comparator.comparingInt(Book::getPrice))
                .orElseThrow();

        return ResponseEntity.ok(maxprice);
    }

    @GetMapping("/author/{name}")
    public List<Book> findByAuthor(@PathVariable String author)
    {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getAuthor().toLowerCase().equals(author.toLowerCase()))
                .collect(Collectors.toList());
        return foundBooks;
    }

    @GetMapping("/min-pages")
    public ResponseEntity<Book> minPages()
    {
        Book minpages =  books.stream()
                .min(Comparator.comparingInt(Book::getPagesCount))
                .orElseThrow();

        return ResponseEntity.ok(minpages);
    }

    @GetMapping("/max-pages")
    public ResponseEntity<Book> maxPages()
    {
        Book maxpages =  books.stream()
                .max(Comparator.comparingInt(Book::getPagesCount))
                .orElseThrow();

        return ResponseEntity.ok(maxpages);
    }

    @GetMapping("/cover-type/{type}")
    public List<Book> findByCover(@PathVariable String type)
    {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getCoverType().toLowerCase().equals(type.toLowerCase()))
                .collect(Collectors.toList());
        return foundBooks;
    }
}

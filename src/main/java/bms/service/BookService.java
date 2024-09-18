package bms.service;

import bms.domain.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getBooks();
    Book getBookById(Book book);
    List<Book> getBooksByFeatures(Book book);
    Book updateBook(Book book);
    Boolean deleteBook(Book book);
}

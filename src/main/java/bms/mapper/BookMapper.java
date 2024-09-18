package bms.mapper;

import bms.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    Book addBook(Book book);
    List<Book> getBooks();
    Book getBookById(Book book);
    List<Book> getBooksByFeatures(Book book);
    Book updateBook(Book book);
    Boolean deleteBook(Book book);
}

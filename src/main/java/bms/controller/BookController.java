package bms.controller;

import bms.domain.Book;
import bms.domain.ResponseBody;
import bms.service.BookService;
import bms.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("book")
    public ResponseBody getBookById(@RequestBody Book book) {
        if((book = bookService.getBookById(book)) != null)
            return ResponseBody.success(StatusCode.OK, "Success", book);
        else
            return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot get targeted book");
    }

    @PostMapping("book")
    public ResponseBody createNewBook(@RequestBody Book book) {
        if((book = bookService.addBook(book)) != null)
            return ResponseBody.success(StatusCode.OK, "Have created a new book", book);
        else
            return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot insert a new book");
    }

    @PutMapping("book")
    public ResponseBody updateBook(@RequestBody Book book) {
        if(bookService.updateBook(book) != null)
            return ResponseBody.success(StatusCode.OK, "Have updated targeted book", book);
        else
            return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot update targeted book");
    }

    @DeleteMapping("book")
    public ResponseBody deleteBook(@RequestBody Book book) {
        return ResponseBody.success(StatusCode.OK, "Have deleted targeted book", bookService.deleteBook(book));
    }

}

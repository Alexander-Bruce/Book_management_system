package bms.service.impl;

import bms.config.security.model.UserPrincipal;
import bms.domain.Book;
import bms.mapper.BookMapper;
import bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Book addBook(Book book) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			book.setCreatedUser(((UserPrincipal) authentication.getPrincipal()).getUser().getId());
			return bookMapper.addBook(book);
		}

		return null;
	}

	@Override
	public List<Book> getBooks() {
		return bookMapper.getBooks();
	}

	@Override
	public Book getBookById(Book book) {
		return bookMapper.getBookById(book);
	}

	@Override
	public List<Book> getBooksByFeatures(Book book) {
		return bookMapper.getBooksByFeatures(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookMapper.updateBook(book);
	}

	@Override
	public Boolean deleteBook(Book book) {
		return bookMapper.deleteBook(book);
	}

}

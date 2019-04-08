package com.jamayette.service;

import com.jamayette.model.Book;

import java.util.List;

public interface IBookService {

	List<Book> findAllBooks();

	boolean saveBook(Book book);

	Book findBookById(Integer id);

	boolean editBook(Book book);

	Boolean deleteBook(Integer id);

}

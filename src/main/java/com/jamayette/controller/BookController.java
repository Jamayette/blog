package com.jamayette.controller;

import com.jamayette.model.Book;
import com.jamayette.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {

	private final IBookService bookService;

	@RequestMapping("/book")
	public String findAllBooks(Model model) {
		List<Book> bookList = bookService.findAllBooks();
		model.addAttribute("bookList", bookList);
		return "book/list";
	}

	@RequestMapping("/m/book/create")
	public String createBook() {
		return "book/create";
	}

	@RequestMapping(value = "/m/book/create/submit")
	public String saveBook(Book book) {
		boolean b = bookService.saveBook(book);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/book/edit/{id}")
	public String editBook(@PathVariable Integer id, Model model) {
		Book book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "book/edit";
	}

	@RequestMapping(value = "/m/book/edit/submit")
	public String editSubmit(Book book) {
		boolean b = bookService.editBook(book);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/book/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		Boolean b = bookService.deleteBook(id);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

}

package com.jamayette.service.impl;

import com.jamayette.mapper.BookMapper;
import com.jamayette.model.Book;
import com.jamayette.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBookService {

	private final BookMapper bookMapper;

	@Override
	public List<Book> findAllBooks() {
		Example example = new Example(Book.class);
		example.setOrderByClause("id desc");
		List<Book> bookList = bookMapper.selectByExample(example);
		List<Book> showList = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getStatus() != 0) {
				showList.add(book);
			}
		}
		return showList;
	}

	@Override
	public boolean saveBook(Book book) {
		try {
			book.setStatus(1);
			bookMapper.insert(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Book findBookById(Integer id) {
		return bookMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editBook(Book book) {
		try {
			bookMapper.updateByPrimaryKeySelective(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteBook(Integer id) {
		try {
			Book book = bookMapper.selectByPrimaryKey(id);
			book.setStatus(0);
			bookMapper.updateByPrimaryKey(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

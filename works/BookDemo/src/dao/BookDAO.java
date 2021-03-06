package dao;

import java.util.List;

import entity.Book;

public class BookDAO {

	public List<Book> listAll() {
		String sql = "select * from book";
		return BaseDao.preparedQuery(Book.class, sql);
	}
	
	public void addBook(Book book) {
		String sql = "insert into book (bookName, price, author, publisher, publishDate) values (?, ?, ?, ?, ?)";
		BaseDao.preparedUpdate(sql, book.getBookName(), book.getPrice(), book.getAuthor(), book.getPublisher(), book.getPublishDate());
	}
	
	public void deleteBook(Book book) {
		String sql = "delete from book where id = ?";
		BaseDao.preparedUpdate(sql, book.getId());
	}

}

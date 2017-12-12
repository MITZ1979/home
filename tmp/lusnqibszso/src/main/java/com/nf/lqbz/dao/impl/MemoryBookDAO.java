package com.nf.lqbz.dao.impl;

import com.nf.lqbz.dao.BookDAO;
import com.nf.lqbz.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookDAO implements BookDAO {
    // 使用 ArrayList 模拟数据库
    private static List<Book> books = new ArrayList<>();

    @Override
    public Book getByName(String name) {
        for (Book book : books) {
            if(book.getName().contains(name)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void remove(String name) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if(!book.getName().equalsIgnoreCase(name)) {
                bookList.add(book);
            }
        }
        books = bookList;
    }
}

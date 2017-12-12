package com.nf.lqbz.dao;

import com.nf.lqbz.entity.Book;


import java.util.List;

public interface BookDAO {
    Book getByName(String name);
    List<Book> getAll();
    void save(Book book);
    void remove(String name);
}

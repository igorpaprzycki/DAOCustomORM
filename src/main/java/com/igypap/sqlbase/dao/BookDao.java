package com.igypap.sqlbase.dao;

import com.igypap.sqlbase.domain.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by igypap on 27.11.16.
 */
public interface BookDao {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAll() throws SQLException;
}

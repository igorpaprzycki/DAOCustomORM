package com.igypap.sqlbase;

import com.igypap.sqlbase.dao.BookDao;
import com.igypap.sqlbase.dao.BookDaoSqlite;
import com.igypap.sqlbase.domain.Book;

import java.sql.SQLException;

/**
 * Created by igypap on 27.11.16.
 */
public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Pozytywne myślenie", "Brian Tracy", 25);
        BookDao bookDaoSqlite = new BookDaoSqlite(book1);
        bookDaoSqlite.addBook(book1);
        book1 = new Book("Clean Code", "Robert C. Martin", 464);

        bookDaoSqlite.addBook(book1);
        bookDaoSqlite.removeBook(book1);
        try {
            System.out.println(bookDaoSqlite.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

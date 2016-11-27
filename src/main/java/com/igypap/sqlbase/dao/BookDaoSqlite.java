package com.igypap.sqlbase.dao;

import com.igypap.sqlbase.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by igypap on 27.11.16.
 */
public class BookDaoSqlite implements BookDao {

    private Connection connection;

    public BookDaoSqlite() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        createTable();
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Books " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "author TEXT NOT NULL, " +
                "pages INTEGER DEFAULT 0" +
                ")";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookDaoSqlite bookDaoSqlite = new BookDaoSqlite();
        Book book1 = new Book("Brian Tracy", "Pozytywne myślenie", 25);
        bookDaoSqlite.addBook(book1);
        //bookDaoSqlite.removeBook(book1);
        try {
            System.out.println(bookDaoSqlite.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        String title = book.getTitle();
        String author = book.getAuthor();
        int pages = book.getPages();
        String sql = "INSERT INTO Books(title, author, pages) VALUES(" +
                "'" + title + "', " + "'" + author + "', " + pages + ")";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeBook(Book book) {
        String title = book.getTitle();
        String author = book.getAuthor();
        int pages = book.getPages();
        String sql = "DELETE FROM Books WHERE(" +
                "title='" + title + "' AND author=" + "'" + author + "' AND pages=" + pages + ")";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() throws SQLException {
        String sql = "SELECT * FROM Books";
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Book> books = new ArrayList<Book>();
        while (resultSet.next()) {
            books.add(new Book(resultSet.getString("author"), resultSet.getString("title"), resultSet.getInt("pages")));
        }
        return books;

    }
}

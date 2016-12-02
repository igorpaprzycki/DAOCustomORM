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


    public BookDaoSqlite(Book book) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        createTable(book);
    }

    private void createTable(Book book) {
        String sql = ORMParser.createTable(book, "id");

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addBook(Book book) {

        String sql = null;
        try {
            sql = ORMParser.insertIntoTable(book, "id");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(Book book) {
        String sql = null;
        try {
            sql = ORMParser.deleteFromTable(book, "id");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() throws SQLException {
        String sql = "SELECT * FROM Book";
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

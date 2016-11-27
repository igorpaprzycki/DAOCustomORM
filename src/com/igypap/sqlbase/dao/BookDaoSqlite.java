package com.igypap.sqlbase.dao;

import com.igypap.sqlbase.domain.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookDaoSqlite();
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}

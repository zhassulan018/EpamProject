package model;

import entity.Book;
import org.apache.log4j.Logger;
import utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utility.Const.*;

public class BookModel{
    final static Logger logger = Logger.getLogger(BookModel.class);

    public static void addBook(Book book) throws Exception {
        Connection connection = null;
        String sql = INSERT_BOOK_WITH_URL;
        if(book.getUrl() == null) sql = INSERT_BOOK;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            if(book.getUrl() == null){
                statement.setString(1, book.getName());
                statement.setDouble(2, book.getCost());
                statement.setString(3, book.getBriefInfo());
                statement.setInt(4, book.getAmount());
            }else {
                statement.setString(1, book.getName());
                statement.setDouble(2, book.getCost());
                statement.setString(3, book.getUrl());
                statement.setString(4, book.getBriefInfo());
                statement.setInt(5, book.getAmount());
            }
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

    public static Book getById(Long id){
        Connection connection = null;
        Book book = null;

        try{
            connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BOOK_BY_ID+id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                book = new Book();
                book.setId(resultSet.getLong(DATABASE_BOOK_ID));
                book.setAmount(resultSet.getInt(AMOUNT));
                book.setUrl(resultSet.getString(URL));
                book.setCost(resultSet.getDouble(COST));
                book.setBriefInfo(resultSet.getString(BRIEF_INFO));
                book.setName(resultSet.getString(NAME));
            }
            resultSet.close();
            statement.close();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
        return book;
    }

    public static List<Book> getBooksLike(String name){
        Connection connection = null;
        List<Book> books = new ArrayList<>();

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK_LIKE);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong(DATABASE_BOOK_ID));
                book.setName(resultSet.getString(NAME));
                book.setCost(resultSet.getDouble(COST));
                book.setUrl(resultSet.getString(URL));
                book.setAmount(resultSet.getInt(AMOUNT));
                book.setBriefInfo(resultSet.getString(BRIEF_INFO));
                books.add(book);
            }
            preparedStatement.close();
            connection.commit();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return books;
    }
    public static List<Book> getAllBooks(){
        Connection connection = null;
        List<Book> books = new ArrayList<>();

        try {
            connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong(DATABASE_BOOK_ID));
                book.setName(resultSet.getString(NAME));
                book.setCost(resultSet.getDouble(COST));
                book.setUrl(resultSet.getString(URL));
                book.setAmount(resultSet.getInt(AMOUNT));
                book.setBriefInfo(resultSet.getString(BRIEF_INFO));
                books.add(book);
            }
            preparedStatement.close();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return books;
    }
}

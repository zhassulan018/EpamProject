package model;

import entity.Basket;
import entity.User;
import org.apache.log4j.Logger;
import utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utility.Const.*;

public class BasketModel {
    final static org.apache.log4j.Logger logger = Logger.getLogger(BasketModel.class);
    public static void addBasketItem(Long userId, Long bookId){
        Connection connection = null;

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(INSERT_BASKET_ITEM);
            statement.setLong(1,userId);
            statement.setLong(2,bookId);
            statement.executeUpdate();
            connection.commit();
            statement.close();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

    public static Basket getBasket(Long userId,Long bookId){
        Connection connection = null;
        Basket basket = null;

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BASKET_ITEM);
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                basket = new Basket();
                basket.setBought(resultSet.getBoolean(BOUGHT));
                basket.setAmount(resultSet.getInt(AMOUNT));
                basket.setUserId(resultSet.getLong(USER_ID));
                basket.setBookId(resultSet.getLong(BOOK_ID));
            }
            preparedStatement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }

        return basket;
    }

    public static List<Basket> getBasketItems(User user){
        Connection connection = null;
        List<Basket> basketList = new ArrayList<>();
        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BASKET_ITEMS);
            preparedStatement.setLong(1,user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Basket basket = new Basket();
                basket.setAmount(resultSet.getInt(AMOUNT));
                basket.setUserId(resultSet.getLong(USER_ID));
                basket.setBookId(resultSet.getLong(BOOK_ID));
                basket.setBought(resultSet.getBoolean(BOUGHT));
                basketList.add(basket);
            }
            connection.commit();
            preparedStatement.close();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }

        return basketList;
    }

    public static List<Basket> getOrderItems(User user){
        Connection connection = null;
        List<Basket> basketList = new ArrayList<>();
        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_ITEMS);
            preparedStatement.setLong(1,user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Basket basket = new Basket();
                basket.setAmount(resultSet.getInt(AMOUNT));
                basket.setUserId(resultSet.getLong(USER_ID));
                basket.setBookId(resultSet.getLong(BOOK_ID));
                basket.setBought(resultSet.getBoolean(BOUGHT));

                basketList.add(basket);
            }
            preparedStatement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }

        return basketList;
    }

    public static void deleteBasketItem(Long bookId,User user){
        Connection connection = null;

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(DELETE_BASKET_ITEM);
            statement.setLong(1,bookId);
            statement.setLong(2,user.getId());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

    public static void changeBasketItemState(User user){
        Connection connection = null;

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPDATE_BASKET_ITEMS);
            statement.setLong(1,user.getId());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

    public static void updateBasketItem(int amount,Long bookId,Long userId){
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPDATE_BASKET_ITEM);
            statement.setInt(1,amount);
            statement.setLong(2,bookId);
            statement.setLong(3,userId);
            statement.executeUpdate();
            connection.commit();
            statement.close();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }
}

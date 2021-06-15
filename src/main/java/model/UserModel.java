package model;

import entity.User;
import org.apache.log4j.Logger;
import utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static utility.Const.*;

public class UserModel {
    final static Logger logger = Logger.getLogger(UserModel.class);

    public static void addUser(User user) throws Exception {
        Connection connection = null;

        User checkUser = findByEmail(user.getEmail());

        if(checkUser != null){
            throw new Exception("Duplicate user");
        }

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getPhone());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }

    }

    public static User findByEmail(String email) {
        User user = null;
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
            statement.setString(1,email);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                user = new User();
                user.setId(result.getLong(1));
                user.setFirstName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));
                user.setRoleId(result.getInt(6));
                user.setPhone(result.getString(7));
            }
            connection.commit();
            result.close();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return user;
    }

    public static void updateUserInfo(User user){
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_INFO);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getPhone());
            statement.setString(4,user.getEmail());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

    public static void updateUserPassword(User user){
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PASSWORD);
            statement.setString(1,user.getPassword());
            statement.setString(2,user.getEmail());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }

}

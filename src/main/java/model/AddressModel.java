package model;

import entity.Address;
import entity.User;
import org.apache.log4j.Logger;
import utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static utility.Const.INSERT_ADDRESS;

public class AddressModel{
    final static Logger logger = Logger.getLogger(AddressModel.class.getName());

    public static void addAddress(Address address, User user) throws Exception {
        Connection connection = null;
        String sql = INSERT_ADDRESS;
        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getNumHouse());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            statement.close();
            connection.commit();
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
    }
}

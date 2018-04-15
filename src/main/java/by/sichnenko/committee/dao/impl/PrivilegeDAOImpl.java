package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.PrivilegeDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Privilege;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrivilegeDAOImpl implements PrivilegeDAO {
    @Override
    public List<Privilege> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_PRIVILEGES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Privilege> privileges = new ArrayList<>();
                while (resultSet.next()) {
                    Privilege privilege = new Privilege();
                    privilege.setPrivilegeId(resultSet.getLong(SQLFieldConstant.ID));
                    privilege.setName(resultSet.getString(SQLFieldConstant.NAME));
                    privileges.add(privilege);
                }
                return privileges;
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(Privilege item) throws DAOException {
        return false;
    }

    @Override
    public void update(Privilege item) throws DAOException {

    }
}

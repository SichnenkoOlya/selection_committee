package by.sichnenko.committee.exception;

import java.sql.SQLException;

public class DAOException  extends SQLException {
    public DAOException(){
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }
}


package exception;

import java.sql.SQLException;

public class RepositoryException extends SQLException{
    public RepositoryException(){
    }

    public RepositoryException(Exception e){
        super(e);
    }

    public RepositoryException(String message){
        super(message);
    }

    public RepositoryException(String message, Exception e){
        super(message, e);
    }
}
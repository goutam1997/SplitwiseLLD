package exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException() {
        System.out.println("User Name already exists!!!. Please choose another name");
    }
}

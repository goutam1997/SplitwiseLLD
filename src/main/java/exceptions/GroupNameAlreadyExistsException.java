package exceptions;

public class GroupNameAlreadyExistsException extends RuntimeException {
    public GroupNameAlreadyExistsException() {
        System.out.println("Group Name already exists!!!. Please choose different name");
    }
}

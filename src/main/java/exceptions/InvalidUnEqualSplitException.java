package exceptions;

public class InvalidUnEqualSplitException extends RuntimeException {
    public InvalidUnEqualSplitException() {
        System.out.println("Invalid split found!!!. Please recheck");
    }
}

package servicelocator;

public class LocatorError extends Exception {
    public LocatorError(Exception ex) {
        super(ex);
    }
    public LocatorError(String ex) {
        super(ex);
    }
}

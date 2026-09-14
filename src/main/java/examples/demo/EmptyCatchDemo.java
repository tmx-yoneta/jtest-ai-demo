package examples.demo;

public class EmptyCatchDemo {
    public void parseNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
        }
    }
}

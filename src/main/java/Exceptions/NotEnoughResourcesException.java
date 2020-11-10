package Exceptions;

public class NotEnoughResourcesException extends Exception {
    private int amount;

    public NotEnoughResourcesException(String s) {
        super(s);
    }

    public NotEnoughResourcesException(String str, int amount) {
        super(str);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}

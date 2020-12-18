package utils;

public enum CommandEnum {
    ADD(1), DELETE(2), LIST(3);

    private int number;

    CommandEnum(int num) {
        this.number = num;
    }

    public int getNumber() {
        return number;
    }
}

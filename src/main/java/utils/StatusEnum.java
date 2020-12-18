package utils;

public enum StatusEnum {
    START(1), STOP(-1), TRY(0);

    private int status;

    StatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

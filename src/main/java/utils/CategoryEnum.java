package utils;

public enum CategoryEnum {
    MAIN(""), STATION("역"), LINE("노선"), SECTION("구간");

    private String korean;

    CategoryEnum(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}

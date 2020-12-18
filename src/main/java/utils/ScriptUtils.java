package utils;

public class ScriptUtils {

    public static final String MAIN_MENU = "\n## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String STATION_MENU = "\n## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String LINE_MENU = "\n## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String[][] ASK_ABOUT_SECTION = { {},
        {"\n## 노선을 입력하세요.", "\n## 역이름을 입력하세요.", "\n## 순서를 입력하세요."},
        {"\n## 삭제할 구간의 노선을 입력하세요.", "\n## 삭제할 구간의 역을 입력하세요."}
    };
    public static final String ERROR_TYPE = "\n[ERROR] 숫자를 입력해주세요.";
    public static final String ERROR_OUT_OF_RANGE = "\n[ERROR] 노선 범위를 넘어섭니다.";
    public static final String ERROR_TOO_SMALL = "\n[ERROR] 노선에 남은 지하철 역이 2개 이상이어야 삭제 가능합니다.";
    public static final String ERROR_ALREADY_EXIST = "\n[ERROR] 노선에 지하철 역이 이미 존재합니다.";
    public static String SECTION_MENU = "\n## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String INFO_MAP = "\n## 지하철 노선도";
    public static final String INFO_BAR = "---";
    public static final String INFO = "\n[INFO] ";


    public static String INFO_ADD(CategoryEnum category) {
        if (category == CategoryEnum.STATION) {
            return INFO + category.getKorean() + "이 등록되었습니다.";
        }
        return INFO + "지하철 " + category.getKorean() + "이 등록되었습니다.";
    }

    public static String INFO_DELETE(CategoryEnum category) {
        if (category == CategoryEnum.STATION) {
            return INFO + category.getKorean() + "이 삭제되었습니다.";
        }
        return INFO + "지하철 " + category.getKorean() + "이 삭제되었습니다.";
    }



    public static final String[] ASK_TERMINAL = {
        "\n등록할 노선의 상행 종점역 이름을 입력하세요.", "\n## 등록할 노선의 하행 종점역 이름을 입력하세요."
    };

    public static final String ASK_NAME(CategoryEnum category, int selection) {
        if (selection == CommandEnum.ADD.getNumber()) {
            return "\n## 등록할 " + category.getKorean() + " 이름을 입력하세요.";
        }
        return "\n## 삭제할 " + category.getKorean() + " 이름을 입력하세요.";
    }


    public static final String ERROR_BAD_SELECTION = "\n[ERROR] 선택할 수 없는 기능입니다.";
    public static final String ERROR_TOO_SHORT = "\n[ERROR] 역 이름은 2자 이상이어야 합니다.";

    public static String ERROR_DUPLICATE(CategoryEnum category) {
        return "\n[ERROR] 이미 등록된 " + category.getKorean() + " 이름입니다.";
    }

    public static String ERROR_NO(CategoryEnum category) {
        return "\n[ERROR] 없는 " + category.getKorean() + " 이름입니다.";
    }

    public static String ERROR_NOTHING(CategoryEnum category) {
        return "\n[ERROR] 조회할 " + category.getKorean() + "이 없습니다.";
    }
}

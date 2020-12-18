package subway.view;

import java.util.Scanner;

public class BaseView {

    private BaseView() { }

    public static void printAsk(String ask) {
        System.out.println(ask);
    }

    public static String inputAnswer(Scanner scanner) {
        String selection = scanner.nextLine();
        return selection;
    }
}

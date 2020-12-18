package subway.view;

import java.util.Scanner;
import utils.InitUtils;
import utils.ScriptUtils;
import utils.ValidationUtils;

public class DetailView {
    private DetailView() { }

    public static String askName(Scanner scanner, String script) {
        BaseView.printAsk(script);
        String name = BaseView.inputAnswer(scanner);
        try {
            ValidationUtils.validateNameLength(name);
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static int askNumber(Scanner scanner, String script) {
        BaseView.printAsk(script);
        String answer = BaseView.inputAnswer(scanner);
        try {
            return Integer.parseInt(answer);
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_TYPE);
            return -1;
        }
    }
}

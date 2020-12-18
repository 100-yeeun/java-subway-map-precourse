package subway.controller;

import java.util.Scanner;
import subway.domain.service.SectionService;
import subway.view.BaseView;
import utils.CategoryEnum;
import utils.StaticUtils;
import utils.ScriptUtils;
import utils.StatusEnum;
import utils.ValidationUtils;

public class MainController {
    public static int selection = StatusEnum.START.getStatus();

    private MainController() { }

    public static void runProgram(Scanner scanner) {
        while (selection != StatusEnum.STOP.getStatus()) {
            BaseView.printAsk(ScriptUtils.MAIN_MENU);
            selection = ValidationUtils.validateSelection(
                BaseView.inputAnswer(scanner),
                StaticUtils.MAIN_EXIT_SIGN,
                StaticUtils.MENU_START,
                StaticUtils.MAIN_MENU_LENGTH
            );
            if (selection <= StatusEnum.TRY.getStatus()) {
                continue;
            }
            executeSelection(scanner);
        }
    }

    private static void executeSelection(Scanner scanner) {
        if (selection == CategoryEnum.STATION.ordinal()) {
            StationController.runProgram(scanner);
            return;
        }
        if (selection == CategoryEnum.LINE.ordinal()) {
            LineController.runProgram(scanner);
            return;
        }
        if (selection == CategoryEnum.SECTION.ordinal()) {
            SectionController.runProgram(scanner);
            return;
        }
        SectionService.getMap();
    }
}

package subway.controller;

import java.util.Scanner;
import subway.domain.service.StationService;
import subway.view.BaseView;
import subway.view.DetailView;
import utils.CategoryEnum;
import utils.CommandEnum;
import utils.ScriptUtils;
import utils.StaticUtils;
import utils.StatusEnum;
import utils.ValidationUtils;

public class StationController {
    public static final CategoryEnum category = CategoryEnum.STATION;

    public static int selection;

    public static void runProgram(Scanner scanner) {
        BaseView.printAsk(ScriptUtils.STATION_MENU);
        selection = ValidationUtils.validateSelection(
            BaseView.inputAnswer(scanner), StaticUtils.EXIT_SIGN, StaticUtils.MENU_START, StaticUtils.MENU_LENGTH);
        if (selection <= StatusEnum.TRY.getStatus()) {
            return;
        }
        executeSelection(scanner);
    }

    private static void executeSelection(Scanner scanner) {
        if (selection == CommandEnum.LIST.getNumber()) {
            StationService.showList();
            return;
        }
        String name = DetailView.askName(scanner, ScriptUtils.ASK_NAME(category, selection));
        if (name == null) {
            return;
        }
        if (selection == CommandEnum.DELETE.getNumber()) {
            StationService.deleteStation(name);
            return;
        }
        StationService.createStation(name);
    }
}

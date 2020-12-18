package subway.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.service.LineService;
import subway.domain.service.StationService;
import subway.view.BaseView;
import subway.view.DetailView;
import utils.CategoryEnum;
import utils.CommandEnum;
import utils.ScriptUtils;
import utils.StaticUtils;
import utils.StatusEnum;
import utils.ValidationUtils;

public class LineController {
    private static final CategoryEnum category = CategoryEnum.LINE;

    static int selection;

    public static void runProgram(Scanner scanner) {
        BaseView.printAsk(ScriptUtils.LINE_MENU);
        selection = ValidationUtils.validateSelection(
            BaseView.inputAnswer(scanner), StaticUtils.EXIT_SIGN, StaticUtils.MENU_START, StaticUtils.MENU_LENGTH);
        if (selection <= StatusEnum.TRY.getStatus()) {
            return;
        }
        executeSelection(scanner);
    }

    private static void executeSelection(Scanner scanner) {
        if (selection == CommandEnum.LIST.getNumber()) {
            LineService.showList();
            return;
        }
        String name = DetailView.askName(scanner, ScriptUtils.ASK_NAME(category, selection));
        if (name == null) {
            return;
        }
        if (selection == CommandEnum.DELETE.getNumber()) {
            LineService.deleteLine(name);
            return;
        }
        askDetail(scanner, name);
    }

    private static void askDetail(Scanner scanner, String name) {
        List<Station> terminals = new ArrayList<>();
        for (String script : ScriptUtils.ASK_TERMINAL) {
            String terminalName = DetailView.askName(scanner, script);
            if (terminalName == null) {
                return;
            }
            Station terminal = StationService.findStation(terminalName);
            if (terminal == null) {
                return;
            }
            terminals.add(terminal);
        }
        LineService.createLine(name, terminals);
    }
}

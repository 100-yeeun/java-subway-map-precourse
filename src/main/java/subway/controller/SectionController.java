package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
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

public class SectionController {
    private static final CategoryEnum category = CategoryEnum.SECTION;

    static int selection;

    public static void runProgram(Scanner scanner) {
        BaseView.printAsk(ScriptUtils.SECTION_MENU);
        selection = ValidationUtils.validateSelection(
            BaseView.inputAnswer(scanner), StaticUtils.EXIT_SIGN, StaticUtils.MENU_START, StaticUtils.SECTION_MENU_LENGTH);
        if (selection <= StatusEnum.TRY.getStatus()) {
            return;
        }
        executeSelection(scanner);
    }

    private static void executeSelection(Scanner scanner) {
        try {
            Line line = askLine(scanner);
            Station station = askStation(scanner);
            if (selection == CommandEnum.ADD.getNumber()) {
                addSection(line, station, askOrder(scanner, line));
                return;
            }
            deleteSection(line, station);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addSection(Line line, Station station, int order) {
        LineService.addStation(line, station, order);
        System.out.println(ScriptUtils.INFO_ADD(category));
    }

    public static void deleteSection(Line line, Station station) {
        LineService.deleteStation(line, station);
        System.out.println(ScriptUtils.INFO_DELETE(category));
    }

    private static int askOrder(Scanner scanner, Line line) {
        int order = DetailView.askNumber(scanner, ScriptUtils.ASK_ABOUT_SECTION[selection][2]);
        if (order < StaticUtils.MENU_START && order > line.getStations().size()) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_OUT_OF_RANGE);
        }
        return order;
    }

    public static Line askLine(Scanner scanner) {
        String answer = DetailView.askName(scanner, ScriptUtils.ASK_ABOUT_SECTION[selection][0]);
        try {
            return LineService.findLine(answer);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Station askStation(Scanner scanner) {
        String answer = DetailView.askName(scanner, ScriptUtils.ASK_ABOUT_SECTION[selection][1]);
        try {
            return StationService.findStation(answer);
        } catch (Exception e) {
            throw e;
        }
    }

}

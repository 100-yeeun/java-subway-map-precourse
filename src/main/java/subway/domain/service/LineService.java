package subway.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import utils.CategoryEnum;
import utils.CommandEnum;
import utils.InitUtils;
import utils.ScriptUtils;
import utils.StaticUtils;

public class LineService {
    private static final CategoryEnum category = CategoryEnum.LINE;

    private LineService() { }

    public static void init() {
        for (int i = 0; i < InitUtils.INIT_LINE.length; i++) {
            List<Station> terminals = new ArrayList();
            for (int j = 0; j < InitUtils.INIT_TEMINAL[i].length; j++) {
                terminals.add(StationService.findStation(InitUtils.INIT_TEMINAL[i][j]));
            }
            LineRepository.addLine(new Line(InitUtils.INIT_LINE[i], terminals));
        }
    }

    public static void createLine(String name, List<Station> terminals) {
        try {
            validateDuplication(name, CommandEnum.ADD.getNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        LineRepository.addLine(new Line(name, terminals));
        System.out.println(ScriptUtils.INFO_ADD(category));
    }

    public static void deleteLine(String name) {
        try {
            validateDuplication(name, CommandEnum.DELETE.getNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        LineRepository.deleteLineByName(name);
        System.out.println(ScriptUtils.INFO_DELETE(category));
    }

    public static void showList() {
        try {
            List<Line> lines = LineRepository.lines();
            if (lines.size() == StaticUtils.NOTHING) {
                throw new Exception(ScriptUtils.ERROR_NOTHING(category));
            }
            for (Line line : lines) {
                System.out.print(ScriptUtils.INFO + line.getName());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateDuplication(String name, int command) {
        String script = ScriptUtils.ERROR_DUPLICATE(category);
        boolean validation = LineRepository.findNoLine(name);
        if (command == CommandEnum.DELETE.getNumber()) {
            script = ScriptUtils.ERROR_NO(category);
            validation = !validation;
        }
        if (!validation) {
            throw new IllegalArgumentException(script);
        }
    }

    public static Line findLine(String answer) {
        try {
            return LineRepository.findLine(answer);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ScriptUtils.ERROR_NO(category));
        }
    }

    public static void addStation(Line line, Station station, int order) {
        if (line.getStations().contains(station)) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_ALREADY_EXIST);
        }
        line.addStation(station, order);
    }

    public static void deleteStation(Line line, Station station) {
        if (line.getStations().size() <= 2) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_TOO_SMALL);
        }
        line.deleteStation(station);
    }
}

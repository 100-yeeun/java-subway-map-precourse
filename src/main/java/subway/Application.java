package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.domain.service.LineService;
import subway.domain.service.SectionService;
import subway.domain.service.StationService;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        StationService.init();
        LineService.init();
        MainController.runProgram(scanner);
    }
}

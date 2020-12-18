package subway.domain.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import utils.ScriptUtils;

public class SectionService {

    private SectionService() {
    }

    public static void getMap() {
        System.out.print(ScriptUtils.INFO_MAP);
        for (Line line : LineRepository.lines()) {
            System.out.println(ScriptUtils.INFO + line.getName());
            System.out.print(ScriptUtils.INFO_BAR);
            for (Station station : line.getStations()) {
                System.out.print(ScriptUtils.INFO + station.getName());
            }
            System.out.println();
        }
        System.out.println();
    }
}

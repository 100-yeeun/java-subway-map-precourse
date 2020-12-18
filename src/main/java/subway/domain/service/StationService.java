package subway.domain.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.imageio.spi.ServiceRegistry;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import utils.CategoryEnum;
import utils.CommandEnum;
import utils.InitUtils;
import utils.ScriptUtils;
import utils.StaticUtils;

public class StationService {
    private static final CategoryEnum category = CategoryEnum.STATION;

    private StationService() { }

    public static void init() {
        for (String name : InitUtils.INIT_STATION) {
            StationRepository.addStation(new Station(name));
        }
    }

    public static void createStation(String name) {

        StationRepository.addStation(new Station(name));
        System.out.println(ScriptUtils.INFO_ADD(category));
    }

    public static void deleteStation(String name) {
        try {
            if (StationRepository.findNoStation(name)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_NO(category));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        StationRepository.deleteStation(name);
        System.out.println(ScriptUtils.INFO_DELETE(category));
    }

    public static void showList() {
        try {
            List<Station> stations = StationRepository.stations();
            if (stations.size() == StaticUtils.NOTHING) {
                throw new Exception(ScriptUtils.ERROR_NOTHING(category));
            }
            for (Station station : stations) {
                System.out.print(ScriptUtils.INFO + station.getName());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Station findStation(String name) {
        try {
            Station station = StationRepository.findStation(name);
            return station;
        } catch (NoSuchElementException e) {
            System.out.println(ScriptUtils.ERROR_NO(category));
            return null;
        }
    }

    public static void validateDuplication(String answer, int command) {
        String script = ScriptUtils.ERROR_DUPLICATE(category);
        boolean validation = StationRepository.findNoStation(answer);
        if (command == CommandEnum.DELETE.getNumber()) {
            script = ScriptUtils.ERROR_NO(category);
            validation = !validation;
        }
        if (!validation) {
            throw new IllegalArgumentException(script);
        }
    }
}

package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> terminals) {
        this.name = name;
        this.stations = terminals;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station, int order) {
        stations.add(order-1, station);
    }

    public void deleteStation(Station station) {
        stations.remove(station);
    }
}

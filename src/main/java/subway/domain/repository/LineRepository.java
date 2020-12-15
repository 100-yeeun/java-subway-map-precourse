package subway.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean findNoLine(String name) {
        return lines.stream().noneMatch(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLine(String name) {
        return lines.stream().filter(line ->
            Objects.equals(line.getName(), name)).collect(Collectors.toList()).get(0);
    }
}

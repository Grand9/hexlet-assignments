package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        List<Home> sortedHomes = homes.stream()
                .sorted(java.util.Comparator.comparingDouble(Home::getArea))
                .collect(Collectors.toList());

        List<Home> firstNHomes = sortedHomes.stream()
                .limit(n)
                .collect(Collectors.toList());

        List<String> result = firstNHomes.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        return result;
    }
}
// END

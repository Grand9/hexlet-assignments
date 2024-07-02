package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
// BEGIN
public class App {

    public static void save(Path pathToCarData, Car car) throws IOException {
        String carString = car.serialize();
        Files.writeString(pathToCarData, carString);
    }

    public static Car extract(Path pathToCarFile) throws IOException {
        String carString = Files.readString(pathToCarFile);
        return Car.unserialize(carString);
    }
}
// END

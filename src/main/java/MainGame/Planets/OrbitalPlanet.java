package MainGame.Planets;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class OrbitalPlanet extends SpacePlanets {
    private static String nameClass = "E:\\JavaProjects\\SpaceWar\\" + OrbitalPlanet.class.getSimpleName() + ".txt";

    public OrbitalPlanet() throws IOException {
        createFile();
        fillingFiles();
    }

    @Override
    public void createFile() throws IOException {
        if (Files.isRegularFile(Path.of(nameClass))) {
            System.out.println("Файл орбитальной станции уже был создан");
        } else {
            Files.createFile(Path.of(nameClass));
            System.out.println("Файл орбитальной станции был создан");
        }
    }

    public static String getNameClass() {
        return nameClass;
    }

    @Override
    public void fillingFiles() throws IOException {
        synchronized (Locker.lockerOrbit) {
            try (FileWriter fileWriter = new FileWriter(nameClass)) {
                fileWriter.write("Earth and Mars");
                fileWriter.flush();
            } catch (IOException ioException) {
                System.out.println("Не удалось записать файл");
            }
        }


    }
}

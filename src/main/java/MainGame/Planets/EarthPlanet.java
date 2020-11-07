package MainGame.Planets;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class EarthPlanet extends SpacePlanets implements Runnable {

    private static String nameClass = "E:\\JavaProjects\\SpaceWar\\" + EarthPlanet.class.getSimpleName() + ".txt";

    private static EarthPlanet earthPlanet;

    static {
        try {
            earthPlanet = new EarthPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private EarthPlanet() throws IOException {
        createFile();
    }

    public static EarthPlanet getEarthPlanet() throws IOException {
        if (earthPlanet == null)
            earthPlanet = new EarthPlanet();
        return earthPlanet;
    }

    public String getNameClass() {
        return nameClass;
    }

    @Override
    public void createFile() throws IOException {
        if (Files.isRegularFile(Path.of(nameClass))) {
            System.out.println("Файл планеты Земля уже был создан");
        } else {
            Files.createFile(Path.of(nameClass));
            System.out.println("Файл планеты Земля был создан");
        }
    }

    @Override
    public void fillingFiles() {
        synchronized (Locker.lockerEarth) {
            Random randomSymbol = new Random();
            char randomChar = (char) (randomSymbol.nextInt(25) + 'a');
            try (FileWriter fileWriter = new FileWriter(nameClass, true)) {
                fileWriter.write(randomChar);
                System.out.print(randomChar + " ");
                fileWriter.flush();
                Locker.lockerEarth.notify();
            } catch (IOException ioException) {
                System.out.println("Не удалось записать файл");
            }
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                fillingFiles();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

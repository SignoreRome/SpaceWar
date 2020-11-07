package MainGame.Planets;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class MarsPlanet extends SpacePlanets implements Runnable {

    private static String nameClass = "E:\\JavaProjects\\SpaceWar\\" + MarsPlanet.class.getSimpleName() + ".txt";

    private static MarsPlanet marsPlanet;

    static {
        try {
            marsPlanet = new MarsPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MarsPlanet() throws IOException {
        createFile();
    }

    public static String getNameClass() {
        return nameClass;
    }

    public static MarsPlanet getMarsPlanet() throws IOException {
        if (marsPlanet == null)
            marsPlanet = new MarsPlanet();
        return marsPlanet;
    }

    @Override
    public void createFile() throws IOException {
        if (Files.isRegularFile(Path.of(nameClass))) {
            System.out.println("Файл планеты Марс уже был создан");
        } else {
            Files.createFile(Path.of(nameClass));
            System.out.println("Файл планеты Марс был создан");
        }
    }

    @Override
    public void fillingFiles() throws IOException {
        synchronized (Locker.LOCKER_MARS) {
            Random randomSymbol = new Random();
            char randomChar = (char) (randomSymbol.nextInt(25) + 'a');
            try (FileWriter fileWriter = new FileWriter(nameClass, true)) {
                fileWriter.write(randomChar);
                System.out.print(randomChar + " ");
                fileWriter.flush();
                Locker.LOCKER_MARS.notify();
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
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

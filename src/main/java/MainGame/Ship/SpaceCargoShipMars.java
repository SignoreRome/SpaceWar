package MainGame.Ship;

import Engine.Tranzit;
import MainGame.Planets.EarthPlanet;
import MainGame.Planets.Locker;
import MainGame.Planets.MarsPlanet;
import MainGame.Planets.OrbitalPlanet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SpaceCargoShipMars extends SpaceShip implements Runnable, Tranzit {
    long skipper = 0;
    private String nameClass = "E:\\JavaProjects\\SpaceWar\\" + SpaceCargoShipMars.class.getSimpleName() + ".txt";

    public SpaceCargoShipMars() throws IOException {
        createFile();
    }

    @Override
    public void createFile() throws IOException {
        if (Files.isRegularFile(Path.of(nameClass))) {
            System.out.println("Файл космического корабля Марса уже был создан");
        } else {
            Files.createFile(Path.of(nameClass));
            System.out.println("Файл космического корабля Марса был создан");
        }
    }

    @Override
    public void fillingFiles() throws IOException {
        synchronized (Locker.lockerMars) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MarsPlanet.getMarsPlanet().getNameClass()));
                 FileWriter fileWriter = new FileWriter(nameClass)
            ) {
                int c;
                if (bufferedReader.ready()) {
                    bufferedReader.skip(skipper);
                    for (int i = 0; i < 5; i++) {
                        c = bufferedReader.read();
                        skipper += c;
                        fileWriter.write((char) c);
                        System.out.print((char) c + " ");
                        fileWriter.flush();
                        Thread.sleep(2000);
                        Locker.lockerMars.wait();
                    }
                    System.out.println("Корабль Марса заполнен и начал движение в сторону Орбитальной станции");
                }
            } catch (FileNotFoundException | InterruptedException fileNotFoundException) {
                System.out.println("Файл не найден");
            }
        }
    }

    @Override
    public void tranzitFromOrbit() {
        synchronized (Locker.lockerOrbit) {
            try (BufferedReader bufferedReaderFileOrbit = new BufferedReader(new FileReader(OrbitalPlanet.getNameClass()));
                 BufferedReader bufferedReaderFileShip = new BufferedReader(new FileReader(nameClass));
                 FileWriter fileWriterOrbit = new FileWriter(OrbitalPlanet.getNameClass(), true);
            ) {
                String strFileOrbit = bufferedReaderFileOrbit.readLine();
                String strFileShip = bufferedReaderFileShip.readLine();
                if (strFileOrbit.contains("Mars")) {
                    try (FileWriter fileWriterShip = new FileWriter(nameClass)) {
                        fileWriterShip.write("Mars");
                        fileWriterOrbit.write("\nFrom Mars " + strFileShip);
                        fileWriterShip.flush();
                        fileWriterOrbit.flush();
                    }
                }
                System.out.println("Корабль Марса забрал Mars с Орбитальной станции и возвращается на родную планету");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void tranzitToPlanet() {
        synchronized (Locker.lockerMars) {
            try (BufferedReader bufferedReaderFileShip = new BufferedReader(new FileReader(nameClass));
                 FileWriter fileWriterMars = new FileWriter(MarsPlanet.getMarsPlanet().getNameClass(), true);
            ) {
                String strFileShip = bufferedReaderFileShip.readLine();
                System.out.println("корабль Марса вернулся с " + strFileShip);
                fileWriterMars.write("*****" + strFileShip + "*****" + "\n");
                fileWriterMars.flush();
                /*try (FileWriter fileWriterShip = new FileWriter(nameClass)) {
                }
                fileWriterShip.write("Empty");
                fileWriterShip.flush();*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                fillingFiles();
                Thread.sleep(5000);
                tranzitFromOrbit();
                Thread.sleep(5000);
                tranzitToPlanet();
//                Thread.currentThread().interrupt();
//                System.out.println("Поток корабль завершен");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

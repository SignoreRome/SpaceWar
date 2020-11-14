package MainGame.Planets;

import Engine.AddToFile;
import Exceptions.NotEnoughResourcesException;
import MainGame.Persons.Humanity;
import MainGame.Persons.Officer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public final class EarthPlanet extends SpacePlanets implements AddToFile {

    private Humanity earthCommandos = new Officer("Young Lenin", "Earth", 4);

    private static EarthPlanet earthPlanet;

    static {
        try {
            earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);
        } catch (NotEnoughResourcesException e) {
            e.printStackTrace();
        }
    }

    private EarthPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) throws NotEnoughResourcesException {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
        addToInitialFile();
    }

    public static EarthPlanet getEarthPlanet() throws NotEnoughResourcesException {
        if (earthPlanet == null)
            earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);
        return earthPlanet;
    }

    public Humanity getEarthCommandos() {
        return earthCommandos;
    }

    public void addToInitialFile() {
        try {
            Files.writeString(this.filePath, "\nCommandos\n" + earthCommandos.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

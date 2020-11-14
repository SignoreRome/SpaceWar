package MainGame.Planets;

import Engine.AddToFile;
import Exceptions.NotEnoughResourcesException;
import MainGame.Persons.Humanity;
import MainGame.Persons.Officer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public final class UranPlanet extends SpacePlanets implements AddToFile {
    private Humanity uranCommandos = new Officer("Capitan Vrungel", "Uran", 4);

    private static UranPlanet uranPlanet;

    static {
        try {
            uranPlanet = new UranPlanet(0, 0, 1, 1, 10, 100);
        } catch (NotEnoughResourcesException e) {
            e.printStackTrace();
        }
    }

    public UranPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) throws NotEnoughResourcesException {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
        addToInitialFile();
    }

    public static UranPlanet getUranPlanet() throws NotEnoughResourcesException {
        if (uranPlanet == null)
            new UranPlanet(0, 0, 1, 1, 10, 100);
        return uranPlanet;
    }

    public void addToInitialFile() {
        try {
            Files.writeString(this.filePath, "\nCommandos\n" + uranCommandos.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

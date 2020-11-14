package MainGame.Planets;

import Engine.AddToFile;
import Exceptions.NotEnoughResourcesException;
import MainGame.Persons.Humanity;
import MainGame.Persons.Officer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public final class MarsPlanet extends SpacePlanets implements AddToFile {
    private Humanity marsCommandos = new Officer("Naruto Uzumaki", "Mars", 4);

    private static MarsPlanet marsPlanet;

    static {
        try {
            marsPlanet = new MarsPlanet(0, 0, 1, 10, 1, 100);
        } catch (NotEnoughResourcesException e) {
            e.printStackTrace();
        }
    }

    private MarsPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) throws NotEnoughResourcesException {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
        addToInitialFile();
    }

    public static MarsPlanet getMarsPlanet() throws NotEnoughResourcesException {
        if (marsPlanet == null)
            return marsPlanet = new MarsPlanet(0, 0, 1, 10, 1, 100);
        return marsPlanet;
    }

    public void addToInitialFile() {
        try {
            Files.writeString(this.filePath, "\nCommandos\n" + marsCommandos.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

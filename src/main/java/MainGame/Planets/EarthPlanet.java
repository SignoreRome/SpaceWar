package MainGame.Planets;

import Engine.Interaction;

import java.util.List;

public class EarthPlanet extends SpacePlanets {
    //Для будущей реализации
    private int coordinateX;
    private int coordinateY;

    private static EarthPlanet earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);

    private EarthPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static EarthPlanet getEarthPlanet() {
        if (earthPlanet == null)
            earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);
        return earthPlanet;
    }

    //Для будущей реализации
    public int getCoordinateX() {
        return coordinateX;
    }

    //Для будущей реализации
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    //Для будущей реализации
    public int getCoordinateY() {
        return coordinateY;
    }

    //Для будущей реализации
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}

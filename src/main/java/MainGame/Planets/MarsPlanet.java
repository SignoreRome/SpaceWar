package MainGame.Planets;

import Engine.Interaction;

public class MarsPlanet extends SpacePlanets {
    private int coordinateX;
    private int coordinateY;

    private static MarsPlanet marsPlanet = new MarsPlanet(0, 0, 1, 10, 1, 100);

    public MarsPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static MarsPlanet getMarsPlanet() {
        if (marsPlanet == null)
            return marsPlanet = new MarsPlanet(0, 0, 1, 10, 1, 100);
        return marsPlanet;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}

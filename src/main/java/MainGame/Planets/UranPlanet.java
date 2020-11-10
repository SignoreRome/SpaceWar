package MainGame.Planets;

public final class UranPlanet extends SpacePlanets {
    private static final UranPlanet uranPlanet = new UranPlanet(0, 0, 1, 1, 10, 100);
    private int coordinateX;
    private int coordinateY;

    public UranPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static UranPlanet getUranPlanet() {
        if (uranPlanet == null)
            new UranPlanet(0, 0, 1, 1, 10, 100);
        return uranPlanet;
    }
}

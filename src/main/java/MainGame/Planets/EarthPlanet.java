package MainGame.Planets;

public final class EarthPlanet extends SpacePlanets {
    private static EarthPlanet earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);
    //Для будущей реализации
    private int coordinateX;
    private int coordinateY;

    private EarthPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static EarthPlanet getEarthPlanet() {
        if (earthPlanet == null)
            earthPlanet = new EarthPlanet(0, 0, 10, 1, 1, 100);
        return earthPlanet;
    }
}

package MainGame.Planets;

public final class StationOne extends SpacePlanets {
    private int coordinateX;
    private int coordinateY;

    private static final StationOne stationOne = new StationOne(0, 0, 0, 0, 0, 10000);

    public StationOne(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static StationOne getStationOne() {
        if (stationOne == null)
            return new StationOne(0, 0, 0, 0, 0, 10000);
        return stationOne;
    }
}

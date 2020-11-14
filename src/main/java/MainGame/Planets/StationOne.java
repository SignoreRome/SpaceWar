package MainGame.Planets;

import Exceptions.NotEnoughResourcesException;

public final class StationOne extends SpacePlanets {
    private static StationOne stationOne;

    static {
        try {
            stationOne = new StationOne(0, 0, 0, 0, 0, 10000);
        } catch (NotEnoughResourcesException e) {
            e.printStackTrace();
        }
    }

    public StationOne(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) throws NotEnoughResourcesException {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static StationOne getStationOne() throws NotEnoughResourcesException {
        if (stationOne == null)
            return new StationOne(0, 0, 0, 0, 0, 10000);
        return stationOne;
    }
}

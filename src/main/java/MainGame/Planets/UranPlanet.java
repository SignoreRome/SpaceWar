package MainGame.Planets;

public class UranPlanet extends SpacePlanets{
    private int coordinateX;
    private int coordinateY;

    private static UranPlanet uranPlanet = new UranPlanet(0,0,1,1,10,100);

    public UranPlanet(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        super(START_COORDINATE_X, START_COORDINATE_Y, START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
    }

    public static UranPlanet getUranPlanet() {
        if (uranPlanet == null)
            new UranPlanet(0,0,1,1,10,100);
        return uranPlanet;
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

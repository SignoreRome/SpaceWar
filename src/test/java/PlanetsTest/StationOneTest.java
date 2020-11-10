package PlanetsTest;

import MainGame.Planets.StationOne;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StationOneTest {
    private static StationOne stationOne;

    @BeforeClass
    public static void createPlanetObject() {
        stationOne = StationOne.getStationOne();
    }

    @Test
    public void createPlanetWithNecessaryDate() {
        Assert.assertEquals(0, stationOne.getCoordinateX());
        Assert.assertEquals(0, stationOne.getCoordinateY());
        Assert.assertEquals(0, stationOne.getWaterStorage().size());
        Assert.assertEquals(0, stationOne.getIronStorage().size());
        Assert.assertEquals(0, stationOne.getUranStorage().size());
        Assert.assertEquals(10000, stationOne.getGoldStorage().size());
    }
}

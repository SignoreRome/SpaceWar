package PlanetsTest;

import Exceptions.NotEnoughResourcesException;
import MainGame.Planets.UranPlanet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UranPlanetTest {
    private static UranPlanet uranPlanet;

    @BeforeClass
    public static void createPlanetObject() throws NotEnoughResourcesException {
        uranPlanet = UranPlanet.getUranPlanet();
    }

    @Test
    public void createPlanetWithNecessaryDate() {
        Assert.assertEquals(0, uranPlanet.getCoordinateX());
        Assert.assertEquals(0, uranPlanet.getCoordinateY());
        Assert.assertEquals(1, uranPlanet.getWaterStorage().size());
        Assert.assertEquals(1, uranPlanet.getIronStorage().size());
        Assert.assertEquals(10, uranPlanet.getUranStorage().size());
        Assert.assertEquals(100, uranPlanet.getGoldStorage().size());
    }
}

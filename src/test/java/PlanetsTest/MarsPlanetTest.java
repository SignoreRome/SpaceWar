package PlanetsTest;

import Exceptions.NotEnoughResourcesException;
import MainGame.Planets.MarsPlanet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MarsPlanetTest {
    private static MarsPlanet marsPlanet;

    @BeforeClass
    public static void createPlanetObject() throws NotEnoughResourcesException {
        marsPlanet = MarsPlanet.getMarsPlanet();
    }

    @Test
    public void createPlanetWithNecessaryDate() {
        Assert.assertEquals(0, marsPlanet.getCoordinateX());
        Assert.assertEquals(0, marsPlanet.getCoordinateY());
        Assert.assertEquals(1, marsPlanet.getWaterStorage().size());
        Assert.assertEquals(10, marsPlanet.getIronStorage().size());
        Assert.assertEquals(1, marsPlanet.getUranStorage().size());
        Assert.assertEquals(100, marsPlanet.getGoldStorage().size());
    }
}

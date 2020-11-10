package PlanetsTest;

import MainGame.Planets.EarthPlanet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EarthPlanetTest {
    private static EarthPlanet earthPlanet;

    @BeforeClass
    public static void createPlanetObject() {
        earthPlanet = EarthPlanet.getEarthPlanet();
    }

    @Test
    public void createPlanetWithNecessaryDate() {
        Assert.assertEquals(0, earthPlanet.getCoordinateX());
        Assert.assertEquals(0, earthPlanet.getCoordinateY());
        Assert.assertEquals(10, earthPlanet.getWaterStorage().size());
        Assert.assertEquals(1, earthPlanet.getIronStorage().size());
        Assert.assertEquals(1, earthPlanet.getUranStorage().size());
        Assert.assertEquals(100, earthPlanet.getGoldStorage().size());
        System.out.println(earthPlanet.getInitialStateResourcesMap());
        System.out.println(earthPlanet.getStrFilePath());
    }
}

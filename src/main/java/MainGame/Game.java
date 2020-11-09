package MainGame;

import MainGame.Ship.SpaceCargoShipEarth;
import MainGame.Ship.SpaceCargoShipMars;

import java.io.IOException;

public class Game {
    public final static int GAME_SPEED = 1;

    public void StartGame() throws IOException, InterruptedException {
        SpacePlanetsFirstVer earth = EarthPlanetFirstVer.getEarthPlanet();
        SpacePlanetsFirstVer mars = MarsPlanetFirstVer.getMarsPlanet();
        SpacePlanetsFirstVer orbit = new OrbitalPlanetFirstVer();
        Thread threadEarth = new Thread((Runnable) earth);
        Thread threadMars = new Thread((Runnable) mars);
        Thread threadCargoShipEarth = new Thread(new SpaceCargoShipEarth());
        Thread threadCargoshipMars = new Thread(new SpaceCargoShipMars());
        threadMars.start();
        threadEarth.start();
        Thread.sleep(5000);
        threadCargoShipEarth.start();
        threadCargoshipMars.start();

    }
}

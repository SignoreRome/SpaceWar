package MainGame;

import MainGame.Planets.EarthPlanet;
import MainGame.Planets.MarsPlanet;
import MainGame.Planets.OrbitalPlanet;
import MainGame.Planets.SpacePlanets;
import MainGame.Ship.SpaceCargoShipEarth;
import MainGame.Ship.SpaceCargoShipMars;

import java.io.IOException;

public class Game {
    public void StartGame() throws IOException, InterruptedException {
        SpacePlanets earth = EarthPlanet.getEarthPlanet();
        SpacePlanets mars = MarsPlanet.getMarsPlanet();
        SpacePlanets orbit = new OrbitalPlanet();
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

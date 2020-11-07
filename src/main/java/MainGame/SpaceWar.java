package MainGame;

import MainGame.Planets.EarthPlanet;

import java.io.IOException;

public class SpaceWar {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game newGame = new Game();
        newGame.StartGame();
    }
}

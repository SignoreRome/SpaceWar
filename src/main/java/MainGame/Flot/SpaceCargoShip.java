package MainGame.Flot;

import Engine.InteractionWithResources;
import MainGame.Persons.Humanity;
import MainGame.Resources.GoldResource;
import MainGame.Resources.IronResource;
import MainGame.Resources.UranResource;
import MainGame.Resources.WaterResource;

import java.util.ArrayList;
import java.util.List;

public class SpaceCargoShip extends SpaceFleet implements Ships, InteractionWithResources {
    private static int countSpaceCargoShip;

    private String producerPlanet;

    private List<GoldResource> goldStorage = new ArrayList<>();
    private List<IronResource> ironStorage = new ArrayList<>();
    private List<UranResource> uranStorage = new ArrayList<>();
    private List<WaterResource> waterStorage = new ArrayList<>();

    public SpaceCargoShip(String producerPlanet, Humanity officer, Humanity worker1, Humanity worker2, Humanity worker3) {
        this.producerPlanet = producerPlanet;
        fillShipTeam(officer, worker1, worker2, worker3);
        countSpaceCargoShip++;
    }

    @Override
    public void fly() {

    }

    public List<GoldResource> getGoldStorage() {
        return goldStorage;
    }

    public List<IronResource> getIronStorage() {
        return ironStorage;
    }

    public List<UranResource> getUranStorage() {
        return uranStorage;
    }

    public List<WaterResource> getWaterStorage() {
        return waterStorage;
    }

    public static int getCountSpaceCargoShip() {
        return countSpaceCargoShip;
    }

    public String getProducerPlanet() {
        return producerPlanet;
    }
}

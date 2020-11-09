package MainGame.Planets;

import Engine.Interaction;
import Engine.Moving;
import MainGame.Resources.GoldResource;
import MainGame.Resources.IronResource;
import MainGame.Resources.UranResource;
import MainGame.Resources.WaterResource;

import java.util.ArrayList;
import java.util.List;

public abstract class SpacePlanets implements Moving, Interaction {
    //Для будущей реализации
    private int START_COORDINATE_X;
    private int START_COORDINATE_Y;
    //Для будущей реализации
    private final int START_COUNT_OF_WATER;
    private final int START_COUNT_OF_IRON;
    private final int START_COUNT_OF_URAN;
    private final int START_COUNT_OF_GOLD;

    private int coordinateX;
    private int coordinateY;

    public SpacePlanets(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        this.START_COORDINATE_X = START_COORDINATE_X;
        this.START_COORDINATE_Y = START_COORDINATE_Y;
        this.START_COUNT_OF_WATER = START_COUNT_OF_WATER;
        this.START_COUNT_OF_IRON = START_COUNT_OF_IRON;
        this.START_COUNT_OF_URAN = START_COUNT_OF_URAN;
        this.START_COUNT_OF_GOLD = START_COUNT_OF_GOLD;
    }
    //Хранилище ресурсов
    private List<GoldResource> goldStorage = new ArrayList<>();
    private List<IronResource> ironStorage = new ArrayList<>();
    private List<UranResource> uranStorage = new ArrayList<>();
    private List<WaterResource> waterStorage = new ArrayList<>();


}

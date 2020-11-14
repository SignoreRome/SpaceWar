package MainGame.Planets;

import Engine.InteractionWithResources;
import Engine.Moving;
import Engine.NameAndSurname;
import Exceptions.NotEnoughResourcesException;
import MainGame.Flot.SpaceCargoShip;
import MainGame.Flot.SpaceFleet;
import MainGame.Persons.Humanity;
import MainGame.Persons.Officer;
import MainGame.Persons.Worker;
import MainGame.Resources.GoldResource;
import MainGame.Resources.IronResource;
import MainGame.Resources.UranResource;
import MainGame.Resources.WaterResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class SpacePlanets implements Moving, InteractionWithResources {
    //кол-во рейдов совершенных с данной планеты
    private int countRaids;
    //Массив "Флот" содержит в себе корабли, созданные этой планетой
    private List<SpaceFleet> fleet = new ArrayList<>();

    //Добавляем грузовой корабль в флот планеты на старте
    {
        fleet.add(new SpaceCargoShip(this.getClass().getSimpleName(),
                new Officer(NameAndSurname.getFIO(), this.getClass().getSimpleName()),
                new Worker(NameAndSurname.getFIO(), this.getClass().getSimpleName()),
                new Worker(NameAndSurname.getFIO(), this.getClass().getSimpleName()),
                new Worker(NameAndSurname.getFIO(), this.getClass().getSimpleName())));
    }

    //Для создания файла, содержащего в себе первоначашльные данные по планете в папке gameFiles
    private String strFilePath = "gameFiles\\" + this.getClass().getSimpleName() + ".txt";
    Path filePath = Path.of(strFilePath).toAbsolutePath();
    //Для будущей реализации движения
    private int START_COORDINATE_X;
    private int START_COORDINATE_Y;
    private int coordinateX;
    private int coordinateY;

    //Хранилище ресурсов
    private List<GoldResource> goldStorage = new ArrayList<>();
    private List<IronResource> ironStorage = new ArrayList<>();
    private List<UranResource> uranStorage = new ArrayList<>();
    private List<WaterResource> waterStorage = new ArrayList<>();

    //для создания файлов колличества ресурсов в начале/конце игры
    private Map<String, Integer> initialStateResourcesMap = new LinkedHashMap<>();
    private Map<String, Integer> finalStateResourcesMap = new LinkedHashMap<>();

    //конструктор для создания планеты
    public SpacePlanets(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) throws NotEnoughResourcesException {
        this.START_COORDINATE_X = START_COORDINATE_X;
        this.START_COORDINATE_Y = START_COORDINATE_Y;
        fillWaterStorage(START_COUNT_OF_WATER);
        fillIronStorage(START_COUNT_OF_IRON);
        fillUranStorage(START_COUNT_OF_URAN);
        fillGoldStorage(START_COUNT_OF_GOLD);
        fillInitialStateResourcesMap(START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
        createAndFillFileStateInitialState();
    }

    //Создает файл, если не создан, добавляет стартовую информацию о планете
    private void createAndFillFileStateInitialState() {
        try {
            Files.writeString(filePath, "Resources \n", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> pair : initialStateResourcesMap.entrySet()) {
            try {
                Files.writeString(filePath, pair.getKey() + ": " + pair.getValue() + '\n', StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createFileState() {
        if (Files.isRegularFile(filePath)) {
            System.out.println("Файл " + this.getClass().getSimpleName() + " уже был создан");
        } else {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.out.println("Файл не найден");
            }
        }
    }

    //Создает грузовой корабль
    public void createSpaceCargoShip() throws NotEnoughResourcesException {
        if ((goldStorage.size() <= 3) && (ironStorage.size() <= 3) && (uranStorage.size() <= 3))
            throw new NotEnoughResourcesException("Недостаточно ресурсов");
        for (int i = 0; i < 3; i++) {
            goldStorage.remove(goldStorage.size() - 1);
            ironStorage.remove(ironStorage.size() - 1);
            uranStorage.remove(uranStorage.size() - 1);
        }
        fleet.add(new SpaceCargoShip(this.getClass().getSimpleName(), createOfficer(), createWorker(), createWorker(), createWorker()));
    }

    //Создает офицера
    public Humanity createOfficer() throws NotEnoughResourcesException {
        if (goldStorage.size() < Officer.getCostOfficer())
            throw new NotEnoughResourcesException("Недостаточно золота");
        for (int i = 0; i < Officer.getCostOfficer(); i++) {
            goldStorage.remove(goldStorage.size() - 1);
        }
        return new Officer(NameAndSurname.getFIO(), this.getClass().getSimpleName());
    }

    //Создает рабочего
    public Humanity createWorker() throws NotEnoughResourcesException {
        if (goldStorage.size() < Worker.getCostWorker())
            throw new NotEnoughResourcesException("Недостаточно золота");
        goldStorage.remove(goldStorage.size() - 1);
        return new Worker(NameAndSurname.getFIO(), this.getClass().getSimpleName());
    }

    //Для записи в начальный файл
    private void fillInitialStateResourcesMap(int water, int iron, int uran, int gold) {
        initialStateResourcesMap.put("Water", water);
        initialStateResourcesMap.put("Iron", iron);
        initialStateResourcesMap.put("Uran", uran);
        initialStateResourcesMap.put("Gold", gold);
    }

    //Заполняет стартовое хранилище золотом
    private void fillGoldStorage(int count) {
        for (int i = 0; i < count; i++) {
            goldStorage.add(new GoldResource());
        }
    }

    //Заполняет стартовое хранилище железом
    private void fillIronStorage(int count) {
        for (int i = 0; i < count; i++) {
            ironStorage.add(new IronResource());
        }
    }

    //Заполняет стартовое хранилище ураном
    private void fillUranStorage(int count) {
        for (int i = 0; i < count; i++) {
            uranStorage.add(new UranResource());
        }
    }

    //Заполняет стартовое хранилище водой
    private void fillWaterStorage(int count) {
        for (int i = 0; i < count; i++) {
            waterStorage.add(new WaterResource());
        }
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

    public Map<String, Integer> getInitialStateResourcesMap() {
        return initialStateResourcesMap;
    }

    public Map<String, Integer> getFinalStateResourcesMap() {
        return finalStateResourcesMap;
    }

    public String getStrFilePath() {
        return strFilePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public List<SpaceFleet> getFleet() {
        return fleet;
    }
}

package MainGame.Planets;

import Engine.Interaction;
import Engine.Moving;
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

public abstract class SpacePlanets implements Moving, Interaction {
    //Для создания файла, содержащего в себе первоначашльные данные по планете в папке gameFiles
    private String strFilePath = "gameFiles\\" + this.getClass().getSimpleName() + ".txt";
    private Path filePath = Path.of(strFilePath).toAbsolutePath();
    //Для будущей реализации движения
    private int START_COORDINATE_X;
    private int START_COORDINATE_Y;
    private int coordinateX;
    private int coordinateY;

    private final int START_COUNT_OF_WATER;
    private final int START_COUNT_OF_IRON;
    private final int START_COUNT_OF_URAN;
    private final int START_COUNT_OF_GOLD;

    //Хранилище ресурсов
    private List<GoldResource> goldStorage = new ArrayList<>();
    private List<IronResource> ironStorage = new ArrayList<>();
    private List<UranResource> uranStorage = new ArrayList<>();
    private List<WaterResource> waterStorage = new ArrayList<>();

    //для создания файлов колличества ресурсов в начале/конце игры
    private Map<String, Integer> initialStateResourcesMap = new LinkedHashMap<>();
    private Map<String, Integer> finalStateResourcesMap = new LinkedHashMap<>();

    public SpacePlanets(int START_COORDINATE_X, int START_COORDINATE_Y, int START_COUNT_OF_WATER, int START_COUNT_OF_IRON, int START_COUNT_OF_URAN, int START_COUNT_OF_GOLD) {
        this.START_COORDINATE_X = START_COORDINATE_X;
        this.START_COORDINATE_Y = START_COORDINATE_Y;
        this.START_COUNT_OF_WATER = START_COUNT_OF_WATER;
        this.START_COUNT_OF_IRON = START_COUNT_OF_IRON;
        this.START_COUNT_OF_URAN = START_COUNT_OF_URAN;
        this.START_COUNT_OF_GOLD = START_COUNT_OF_GOLD;
        fillWaterStorage(START_COUNT_OF_WATER);
        fillIronStorage(START_COUNT_OF_IRON);
        fillUranStorage(START_COUNT_OF_URAN);
        fillGoldStorage(START_COUNT_OF_GOLD);
        fillInitialStateResourcesMap(START_COUNT_OF_WATER, START_COUNT_OF_IRON, START_COUNT_OF_URAN, START_COUNT_OF_GOLD);
        createAndFillFileStateInitialState();
    }

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

    private void fillInitialStateResourcesMap(int water, int iron, int uran, int gold) {
        initialStateResourcesMap.put("Water", water);
        initialStateResourcesMap.put("Iron", iron);
        initialStateResourcesMap.put("Uran", uran);
        initialStateResourcesMap.put("Gold", gold);
    }

    private void fillGoldStorage(int count) {
        for (int i = 0; i < count; i++) {
            goldStorage.add(new GoldResource());
        }
    }

    private void fillIronStorage(int count) {
        for (int i = 0; i < count; i++) {
            ironStorage.add(new IronResource());
        }
    }

    private void fillUranStorage(int count) {
        for (int i = 0; i < count; i++) {
            uranStorage.add(new UranResource());
        }
    }

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
}

package MainGame.Resources;

public class ResourceFactory {
    private static int countGoldResource;
    private static int countIronResource;
    private static int countUranResource;
    private static int countWaterResource;


    public Resource getResource(ResourceTypes type){
        switch (type){
            case GOLD -> new GoldResource();
            case IRON -> new IronResource();
            case URAN -> new UranResource();
            case WATER -> new WaterResource();
            default -> throw new IllegalArgumentException("Wrong resource type:" + type);
        }
        return null;
    }

    public static int getCountGoldResource() {
        return countGoldResource;
    }

    public static int getCountIronResource() {
        return countIronResource;
    }

    public static int getCountUranResource() {
        return countUranResource;
    }

    public static int getCountWaterResource() {
        return countWaterResource;
    }
}

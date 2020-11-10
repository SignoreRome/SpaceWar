package MainGame.Resources;

public final class WaterResource extends Resources implements Resource {
    private static final int COST_OF_WATER_IN_GOLD = 50;
    private static int countWaterResource;

    public WaterResource() {
        countWaterResource++;
    }

    public static int getCountWaterResource() {
        return countWaterResource;
    }

    public static int getCOST_OF_WATER_IN_GOLD() {
        return COST_OF_WATER_IN_GOLD;
    }
}

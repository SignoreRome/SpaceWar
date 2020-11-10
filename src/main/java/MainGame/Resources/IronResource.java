package MainGame.Resources;

public final class IronResource extends Resources implements Resource {
    private static final int COST_OF_IRON_IN_GOLD = 100;
    private static int countIronResource;

    public IronResource() {
        countIronResource++;
    }

    public static int getCountIronResource() {
        return countIronResource;
    }

    public static int getCOST_OF_IRON_IN_GOLD() {
        return COST_OF_IRON_IN_GOLD;
    }
}

package MainGame.Resources;

public final class UranResource extends Resources implements Resource {
    private static final int COST_OF_URAN_IN_GOLD = 200;
    private static int countUranResource;

    public UranResource() {
        countUranResource++;
    }

    public static int getCountUranResource() {
        return countUranResource;
    }

    public static int getCOST_OF_URAN_IN_GOLD() {
        return COST_OF_URAN_IN_GOLD;
    }
}

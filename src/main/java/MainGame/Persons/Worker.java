package MainGame.Persons;

public class Worker extends Humanity {
    private static int countWorker;
    private static final int COST_WORKER = 1;
    public Worker(String name, String nationality) {
        super(name, nationality);
        countWorker++;
    }

    public static int getCostWorker() {
        return COST_WORKER;
    }
}

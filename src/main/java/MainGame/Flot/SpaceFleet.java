package MainGame.Flot;

import MainGame.Persons.Humanity;

import java.util.ArrayList;
import java.util.List;

public class SpaceFleet {
    //кол-во рейдов совершенных кораблем
    private int countSpaceShipRaids;

    private List<Humanity> shipTeam = new ArrayList<>();

    public void fillShipTeam(Humanity officer, Humanity worker1, Humanity worker2, Humanity worker3) {
        shipTeam.add(officer);
        shipTeam.add(worker1);
        shipTeam.add(worker2);
        shipTeam.add(worker3);
    }

    @Override
    public String toString() {
        String str = null;
        for (int i = 0; i < shipTeam.size(); i++) {
            str += shipTeam.get(i).toString() + " ";
        }
        return str.trim();
    }

    public int getCountSpaceCargoShipRaids() {
        return countSpaceShipRaids;
    }
}

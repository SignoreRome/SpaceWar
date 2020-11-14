package MainGame.Persons;

public class Officer extends Humanity {
    private static int countOfficer;
    public static final int EXP_TO_LVL_UP = 5;
    private static final int COST_OFFICER = 2;
    private int experience;
    private int rang;
    private int countRaid;

    public Officer(String name, String nationality) {
        super(name, nationality);
        rang = 1;
        countRaid = 0;
        countOfficer++;
    }

    public Officer(String name, String nationality, int rang) {
        super(name, nationality);
        this.rang = rang;
        countRaid = 0;
        countOfficer++;
    }

    //Для увеличения кол-ва рейдов
    @Override
    public void increaseCountRaid() {
        countRaid++;
    }

    //Для увеличения кол-ва опыта (1 рейд = 2 очка опыта)
    public void increaseExperience() {
        experience += 2;
    }

    //Для поднятия ранга у офицера (1 стоит 5 очков опыта)
    public void rangUp() {
        if (experience % EXP_TO_LVL_UP == 0)
            rang++;
    }

    public int getExperience() {
        return experience;
    }

    public int getRang() {
        return rang;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nNationality: " + getNationality() + "\nRang: " + getRang();
    }

    public static int getCostOfficer() {
        return COST_OFFICER;
    }

    public static int getCountOfficer() {
        return countOfficer;
    }

    @Override
    public int getCountRaid() {
        return countRaid;
    }

}

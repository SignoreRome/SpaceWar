package MainGame.Persons;

public abstract class Humanity {
    public static int salary;
    private String name;
    private String nationality;
    public int countRaid;

    public Humanity(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public void increaseCountRaid() {
        countRaid++;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getCountRaid() {
        return countRaid;
    }

    public static int getSalary() {
        return salary;
    }

    public static void setSalary(int salary) {
        Humanity.salary = salary;
    }

    @Override
    public String toString() {
        return getName()+" "+getNationality();
    }
}

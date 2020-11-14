package Engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class NameAndSurname {
    private static String strNamesPath = "gameFiles\\Names.txt";
    private static Path namesPath = Path.of(strNamesPath).toAbsolutePath();

    private static String strSurnamesPath = "gameFiles\\Surnames.txt";
    private static Path surnamesPath = Path.of(strSurnamesPath).toAbsolutePath();

    public static List<String> listNames;
    public static List<String> listSurnames;

    static {
        if (Files.exists(namesPath) && Files.exists(surnamesPath)) {
            try {
                listNames = Files.readAllLines(namesPath);
                listSurnames = Files.readAllLines(surnamesPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            listNames = listNames.stream().sorted().collect(Collectors.toList());
            listSurnames = listSurnames.stream().sorted().collect(Collectors.toList());
        }
    }

    public static String getFIO() {
        Random random = new Random();
        int randomIndexName = random.nextInt(listNames.size());
        int randomIndexSurname = random.nextInt(listSurnames.size());
        return listNames.get(randomIndexName) + " " + listSurnames.get(randomIndexSurname);
    }
}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <language country>");
            System.exit(1);
        }
        String language = args[0];
        String country = args[1];

        Locale locale = new Locale(language, country);
        Locale.setDefault(locale);

        ResourceBundle messages = ResourceBundle.getBundle("messages");

        ConstructionBureau bureau = new ConstructionBureau();

        TechnicalTask task1 = new TechnicalTask("Design a multi-story house", 10000);
        TechnicalTask task2 = new TechnicalTask("Design a commercial building", 150000);

        ConstructionTeam team1 = new ConstructionTeam("Construction Team A", 10);
        ConstructionTeam team2 = new ConstructionTeam("Construction Team B", 15);

        DateFormat dateFormat = new SimpleDateFormat(messages.getString("date.format"));
        DateFormat dateFormatShort = new SimpleDateFormat(messages.getString("date.format.short"));
        System.out.println(messages.getString("technicalTask.created") + " " + dateFormat.format(task1.getCreationDate()));
        System.out.println(messages.getString("technicalTask.created") + " " + dateFormatShort.format(task2.getCreationDate()));
        System.out.println(messages.getString("constructionTeam.created") + " " + dateFormat.format(team1.getCreationDate()));
        System.out.println(messages.getString("constructionTeam.created") + " " + dateFormatShort.format(team2.getCreationDate()));

        bureau.registerTechnicalTask(task1);
        bureau.registerTechnicalTask(task2);

        bureau.createConstructionTeam(team1);
        bureau.createConstructionTeam(team2);

        bureau.saveToFile("construction_data.ser");

        // Чтение данных из файла
        bureau.loadFromFile("construction_data.ser");

        for (TechnicalTask task : bureau.getTechnicalTasks()) {
            System.out.println(task);
        }

        for (ConstructionTeam team : bureau.getConstructionTeams()) {
            System.out.println(team);
        }
    }
}

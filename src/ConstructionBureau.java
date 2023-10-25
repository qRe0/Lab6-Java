import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ConstructionBureau {
    private List<TechnicalTask> technicalTasks;
    private List<ConstructionTeam> constructionTeams;
    private Date creationDate;

    public ConstructionBureau() {
        this.technicalTasks = new ArrayList<>();
        this.constructionTeams = new ArrayList<>();
        this.creationDate = new Date();
    }

    // Метод для регистрации ТЗ
    public void registerTechnicalTask(TechnicalTask task) {
        technicalTasks.add(task);
    }

    // Метод для создания бригады
    public void createConstructionTeam(ConstructionTeam team) {
        constructionTeams.add(team);
    }

    public List<TechnicalTask> getTechnicalTasks() {
        return technicalTasks;
    }

    public List<ConstructionTeam> getConstructionTeams() {
        return constructionTeams;
    }

    // Метод для сохранения объектов в файл
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(technicalTasks);
            oos.writeObject(constructionTeams);
            oos.writeObject(creationDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки объектов из файла
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            technicalTasks = (List<TechnicalTask>) ois.readObject();
            constructionTeams = (List<ConstructionTeam>) ois.readObject();
            creationDate = (Date) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Ошибка: Не удалось найти класс для десериализации.");
        }
    }

    // Геттер для получения даты создания бюро
    public Date getCreationDate() {
        return creationDate;
    }
}

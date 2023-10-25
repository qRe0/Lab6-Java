import java.io.Serializable;
import java.util.Date;

public class TechnicalTask implements Serializable {
    private static final long serialVersionUID = 1L;
    private String description;
    private double cost;
    private Date creationDate;

    public TechnicalTask(String description, double cost) {
        this.description = description;
        this.cost = cost;
        this.creationDate = new Date();
    }

    // Геттеры и сеттеры
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "TechnicalTask{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                ", creationDate=" + creationDate +
                '}';
    }
}

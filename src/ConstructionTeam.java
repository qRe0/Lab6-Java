import java.io.Serializable;
import java.util.Date;

public class ConstructionTeam implements Serializable {
    private static final long serialVersionUID = 2L;
    private String teamName;
    private int numberOfMembers;
    private Date creationDate;

    public ConstructionTeam(String teamName, int numberOfMembers) {
        this.teamName = teamName;
        this.numberOfMembers = numberOfMembers;
        this.creationDate = new Date();
    }

    // Геттеры и сеттеры
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ConstructionTeam{" +
                "teamName='" + teamName + '\'' +
                ", numberOfMembers=" + numberOfMembers +
                ", creationDate=" + creationDate +
                '}';
    }
}

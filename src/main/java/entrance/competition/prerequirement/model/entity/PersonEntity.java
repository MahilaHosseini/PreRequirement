package entrance.competition.prerequirement.model.entity;

import jakarta.persistence.*;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Version
    private Integer version;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package entrance.competition.prerequirement.model.dao;

import entrance.competition.prerequirement.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<PersonEntity,Integer> {
    Object findByName(String name);
}

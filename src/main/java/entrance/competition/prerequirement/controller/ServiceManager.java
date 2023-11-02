package entrance.competition.prerequirement.controller;

import entrance.competition.prerequirement.PreRequirementApplication;
import entrance.competition.prerequirement.exception.NameException;
import entrance.competition.prerequirement.model.dao.PersonDao;
import entrance.competition.prerequirement.model.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ServiceManager {
    private static Logger logger = LoggerFactory.getLogger(PreRequirementApplication.class);
    private PersonDao personDao;

    public ServiceManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    public String greeting(String name) throws Exception {

        if (Objects.isNull(name)) {
            logger.info("anonymous person greeted!");
            return "welcome Stranger!!!";
        } else {
            if (name.length() < 3) {
                throw new NameException("that is not a name!");
            }
            try {
                if (Objects.isNull(personDao.findByName(name))) {
                    PersonEntity person = new PersonEntity();
                    person.setName(name);
                    personDao.save(person);
                    logger.info("new person greeted and added!");
                    return " welcome " + name.toUpperCase() + " we are happy that you have visited us :)";
                }
            } catch (Exception e) {
                logger.error("database has a problem" + e.getMessage());
                throw new Exception("Something went wrong! please try again later.");
            }

            logger.info("previously seen person greeted!");
            return "welcome back " + name.toUpperCase() + "! what is new?";

        }
    }
}

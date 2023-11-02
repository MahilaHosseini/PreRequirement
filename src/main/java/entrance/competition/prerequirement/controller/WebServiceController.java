package entrance.competition.prerequirement.controller;

import entrance.competition.prerequirement.PreRequirementApplication;
import entrance.competition.prerequirement.dto.ResponseDto;
import entrance.competition.prerequirement.dto.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebServiceController implements EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(PreRequirementApplication.class);
    private Environment environment;
    private ServiceManager service;
    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    public WebServiceController(ServiceManager service) {
        this.service = service;
    }

    @RequestMapping(value = "/pws/helloworld", method = RequestMethod.GET)
    public ResponseDto<String> helloWorld() {
        logger.info("helloworld web service is running!");
        return new ResponseDto(ResponseStatus.Ok, "Hello, World!", environment.getProperty("universal.ok.System.success"), null);
    }

    @RequestMapping(value = "/pws/greeting", method = RequestMethod.GET)
    public ResponseDto<String> greeting(@RequestParam (required=false) String name) throws Exception {
        logger.info("greeting web service is running!");
        String output = service.greeting(name);
        return new ResponseDto(ResponseStatus.Ok, output, environment.getProperty("universal.ok.System.success"), null);
    }


}

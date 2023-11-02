package entrance.competition.prerequirement.controller;

import entrance.competition.prerequirement.dto.ResponseDto;
import entrance.competition.prerequirement.dto.ResponseException;
import entrance.competition.prerequirement.dto.ResponseStatus;
import entrance.competition.prerequirement.exception.NameException;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController implements EnvironmentAware {
    private Environment environment;
    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ResponseDto> generalHandler(Throwable t) {
        String error;
        if (t instanceof HttpMessageNotReadableException)
            error = environment.getProperty("universal.exception.parser.json");
        else if (t instanceof NameException)
            error = environment.getProperty("universal.exceptoin.incorrect.name") + t.getMessage();
        else
            error = environment.getProperty("universal.exception.general.error") + t.getMessage();

        ResponseDto responseObject = new ResponseDto(ResponseStatus.Error, null, null, new ResponseException(error));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);

    }
}

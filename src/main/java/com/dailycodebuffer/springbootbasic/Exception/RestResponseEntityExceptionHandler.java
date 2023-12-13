package com.dailycodebuffer.springbootbasic.Exception;

import com.dailycodebuffer.springbootbasic.model.ErrorMessageAndStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageAndStatusCode employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException){
        return new ErrorMessageAndStatusCode(HttpStatus.NOT_FOUND, employeeNotFoundException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageAndStatusCode genericException(Exception exception){
        return new ErrorMessageAndStatusCode(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}

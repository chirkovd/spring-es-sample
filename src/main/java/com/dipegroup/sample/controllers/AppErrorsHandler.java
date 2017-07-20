package com.dipegroup.sample.controllers;

import com.dipegroup.exceptions.services.exceptions.ErrorsHandler;
import com.dipegroup.exceptions.services.exceptions.ExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 7/20/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@ControllerAdvice
public class AppErrorsHandler extends ErrorsHandler {

    @Autowired
    public AppErrorsHandler(ExceptionMapper exceptionMapper) {
        super(exceptionMapper);
    }
}

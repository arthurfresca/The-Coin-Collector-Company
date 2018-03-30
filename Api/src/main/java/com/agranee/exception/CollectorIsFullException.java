package com.agranee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Collector is full ...")
public class CollectorIsFullException extends Exception {

    static final long serialVersionUID = -3387516993224229948L;

    public CollectorIsFullException(String message)
    {
        super(message);
    }

}

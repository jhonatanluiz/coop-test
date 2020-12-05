package com.jj.coop.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class BrasilApiException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public BrasilApiException(String message, Status status) {
        super(ErrorConstants.BRASIL_API_ERROR, message, status);
    }
}

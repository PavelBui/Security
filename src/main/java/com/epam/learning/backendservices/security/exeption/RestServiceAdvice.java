package com.epam.learning.backendservices.security.exeption;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class RestServiceAdvice {

    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    EntityModel<PersonNotFoundException> personNotFoundHandler(PersonNotFoundException ex) {
        return EntityModel.of(ex);
    }

    @ResponseBody
    @ExceptionHandler(SubscriptionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    EntityModel<SubscriptionNotFoundException> subscriptionNotFoundHandler(SubscriptionNotFoundException ex) {
        return EntityModel.of(ex);
    }
}

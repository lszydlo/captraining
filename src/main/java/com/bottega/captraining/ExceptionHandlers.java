package com.bottega.captraining;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({DomainException.class})
    ResponseEntity<MyError> koza123(DomainException e, WebRequest request){
        System.out.println("EXC");
        UUID uuid = UUID.randomUUID();
        // log.error(e,uuid);
        MyError myError = new MyError(request.getContextPath(), e.getLocalizedMessage(), "500", "localhost", uuid);

        return ResponseEntity.status(e.statusCode).cacheControl(CacheControl.noCache()).body(myError);
    }

}

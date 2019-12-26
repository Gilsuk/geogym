package com.geogym.common.adviser;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class LocalDateAdviser {

    @InitBinder
    public void initBinder( WebDataBinder binder )
    {
        binder.registerCustomEditor( LocalDate.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText( String text ) throws IllegalArgumentException
            {
            	LocalDate date;
            	try {
            		date = LocalDate.parse(text);
            	} catch (DateTimeParseException e) {
            		date = LocalDate.MIN;
            	}
                setValue(date);
            }
            
            public String getAsText() {
            	LocalDate date = (LocalDate)getValue();
            	return date.toString();
            };
        } );

        binder.registerCustomEditor( LocalTime.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText( String text ) throws IllegalArgumentException
            {
            	LocalTime date;
            	try {
            		date = LocalTime.parse(text);
            	} catch (DateTimeParseException e) {
            		date = LocalTime.MIN;
            	}
                setValue(date);
            }
            
            public String getAsText() {
            	LocalTime date = (LocalTime)getValue();
            	return date.toString();
            };
        } );

        binder.registerCustomEditor( LocalDateTime.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText( String text ) throws IllegalArgumentException
            {
            	LocalDateTime date;
            	try {
            		date = LocalDateTime.parse(text);
            	} catch (DateTimeParseException e) {
            		date = LocalDateTime.MIN;
            	}
                setValue(date);
            }
            
            public String getAsText() {
            	LocalDateTime date = (LocalDateTime)getValue();
            	return date.toString();
            };
        } );
    }
}

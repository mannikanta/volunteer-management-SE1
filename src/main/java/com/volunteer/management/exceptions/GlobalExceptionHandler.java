package com.volunteer.management.exceptions;

import com.volunteer.management.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    ResponseDto responseDto;

    @ExceptionHandler(Exception.class)
    public ModelAndView displayExceptionMessage(Exception e, Model model){
        responseDto.setResponse_Message(e.getMessage());
        model.addAttribute("status", responseDto);
        return new ModelAndView("Response");
    }
}

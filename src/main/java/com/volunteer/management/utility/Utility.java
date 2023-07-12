package com.volunteer.management.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class Utility {

    public LocalDate getDate(){
       return java.time.LocalDate.now();
    }
}

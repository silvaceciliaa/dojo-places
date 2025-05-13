package br.com.alura.dojoplaces.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public String formatterDate(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(date != null){
            return date.format(formatter);
        }

        return "";
    }

    public String formatterDaysSince(LocalDateTime dateTime){

        if(dateTime == null){
            return "";
        }

        Duration duration = Duration.between(dateTime, LocalDateTime.now());
        long days = duration.toDays();


        return days == 0 ? "Hoje" : days + (days == 1 ? " dia atrás" : " dias atrás");
    }


}

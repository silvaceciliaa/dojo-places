package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.Utils.Formatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class FormatterTests {

    @Test
    void shouldReturnFormattedDate(){
        LocalDateTime dateTime = LocalDateTime.of(2025, 2, 6, 12, 30, 0);
        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDate(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("06/02/2025");

    }

    @Test
    void shouldReturnEmptyDateFormatter(){
        LocalDateTime dateTime = null;

        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDate(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("");

    }

    @Test
    void shouldReturnToday(){
        LocalDateTime dateTime = LocalDateTime.now();
        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDaysSince(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("Hoje");
    }

    @Test
    void shouldReturnOneDayAgo(){
        LocalDateTime dateTime = LocalDateTime.now().minusMinutes(1440);
        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDaysSince(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("1 dia atrás");
    }

    @Test
    void shouldReturnDaysAgo(){
        LocalDateTime dateTime = LocalDateTime.now().minusMinutes(2880);
        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDaysSince(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("2 dias atrás");
    }

    @Test
    void shouldReturnEmptyDaysFormatter(){
        LocalDateTime dateTime = null;

        Formatter formatter = new Formatter();

        String dateFormatted = formatter.formatterDaysSince(dateTime);

        Assertions.assertThat(dateFormatted).isEqualTo("");
    }
}

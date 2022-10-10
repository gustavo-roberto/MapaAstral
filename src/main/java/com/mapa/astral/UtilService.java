package com.mapa.astral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class UtilService {
    public static int getAgeInYears(ZonedDateTime birthDatePlace) {
      return Period.between(birthDatePlace.toLocalDate(), LocalDate.now()).getYears();
    }

    public static LocalDateTime formatStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.parse(dateString)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static String verifyLeapYear(ZonedDateTime birthDatePlace) {
        if (Year.isLeap(birthDatePlace.getYear())) {
            return "nasceu";
        }
        else
        {
            return "não nasceu";
        }
    }

    public static String getZoneOffSet(ZonedDateTime birthDatePlace) {
        return birthDatePlace.getOffset().toString();
    }

    public static String getFormattedDate(ZonedDateTime birthDatePlace) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return birthDatePlace.toLocalDateTime().format(format);
    }

    public static String getZoneId(String stringZoneId) {
        stringZoneId = stringZoneId.replace(" ", "_").toLowerCase();
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            if (zoneId.toLowerCase().contains(stringZoneId)) {
                return zoneId;
            }
        }

        return null;
    }

    public static String printfFormattedZoneId(ZoneId zoneId) {
        StringBuilder builder = new StringBuilder();
        String zoneIdString = zoneId.toString();

        if (zoneIdString.contains("/")) {
            String[] locals = zoneId.toString().split("/");
            String continent = locals[0];
            String city = locals[1];

            builder.append(continent + " continent, ");
            builder.append(city.replace("_"," ") + " city");
        }
        else {
            builder.append(zoneIdString.replace("_", " "));
        }

        return builder.toString();
    }
}

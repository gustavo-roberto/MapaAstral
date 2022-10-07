package com.mapa.astral;

import java.time.LocalTime;
import java.time.ZonedDateTime;

public class LunarSignService {
    public static String getLunarSign(ZonedDateTime birthDatePlace, String city) {
        LocalTime birthTime = birthDatePlace.toLocalTime();

        if ("Recife".equalsIgnoreCase(city) && birthTime.isAfter(LocalTime.NOON))
            return "Casimiro";

        if ("Cuiaba".equalsIgnoreCase(city) && birthTime.isBefore(LocalTime.NOON))
            return "Odin";

        if ("Sao Paulo".equalsIgnoreCase(city))
            return "Gandalf";

        return "Dinossauro";
    }
}

package com.mapa.astral;


import java.time.MonthDay;
import java.time.ZonedDateTime;
import java.util.Arrays;

public enum EnumSignos {
    ARIES(MonthDay.of(3, 21), MonthDay.of(4, 20)),
    TOURO(MonthDay.of(4, 21), MonthDay.of(5, 20)),
    GEMEOS(MonthDay.of(5, 21), MonthDay.of(6, 20)),
    CANCER(MonthDay.of(6, 21), MonthDay.of(7, 22)),
    LEAO(MonthDay.of(7, 23), MonthDay.of(8, 22)),
    VIRGEM(MonthDay.of(8, 23), MonthDay.of(9, 22)),
    LIBRA(MonthDay.of(9, 23), MonthDay.of(10, 22)),
    ESCORPIAO(MonthDay.of(10, 23), MonthDay.of(11, 21)),
    SAGITARIO(MonthDay.of(11, 22), MonthDay.of(12, 21)),
    CAPRICORNIO(MonthDay.of(12, 22), MonthDay.of(1, 19)),
    AQUARIO(MonthDay.of(1, 20), MonthDay.of(2, 18)),
    PEIXES(MonthDay.of(2, 19), MonthDay.of(3, 20));

    private final MonthDay inicialSignDate;
    private final MonthDay lastSignDate;
    EnumSignos(MonthDay inicialSignDate, MonthDay lastSignDate)
    {
        this.inicialSignDate = inicialSignDate;
        this.lastSignDate = lastSignDate;
    }

    public static EnumSignos getSign(ZonedDateTime birthDatePlace) {
        var birthDate = MonthDay.of(birthDatePlace.getMonth(), birthDatePlace.getDayOfMonth());
        return Arrays.stream(EnumSignos.values())
                .filter(sign -> {
                    if (sign.equals(EnumSignos.CAPRICORNIO)) {
                        return (birthDate.isAfter(sign.inicialSignDate)) || (birthDate.isBefore(sign.lastSignDate));
                    }
                    else {
                        return (birthDate.isAfter(sign.inicialSignDate)) && (birthDate.isBefore(sign.lastSignDate));
                    }
                }).findFirst().orElseThrow(RuntimeException::new);
    }
}

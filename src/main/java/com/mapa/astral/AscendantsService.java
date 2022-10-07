package com.mapa.astral;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AscendantsService {
    private static final Map<String, List<LocalTime>> ascendantsHashMap;

    static {
        ascendantsHashMap = new HashMap<>();
        ascendantsHashMap.put("ARIES", List.of(LocalTime.of(0, 0), LocalTime.of(1, 59)));
        ascendantsHashMap.put("TOURO", List.of(LocalTime.of(2, 0), LocalTime.of(3, 59)));
        ascendantsHashMap.put("GEMEOS", List.of(LocalTime.of(4, 0), LocalTime.of(5, 59)));
        ascendantsHashMap.put("CANCER", List.of(LocalTime.of(6, 0), LocalTime.of(7, 59)));
        ascendantsHashMap.put("LEAO", List.of(LocalTime.of(8, 0), LocalTime.of(9, 59)));
        ascendantsHashMap.put("VIRGEM", List.of(LocalTime.of(10, 0), LocalTime.of(11, 59)));
        ascendantsHashMap.put("LIBRA", List.of(LocalTime.of(12, 0), LocalTime.of(13, 59)));
        ascendantsHashMap.put("ESCORPIAO", List.of(LocalTime.of(14, 0), LocalTime.of(15, 59)));
        ascendantsHashMap.put("SAGITÁRIO", List.of(LocalTime.of(16, 0), LocalTime.of(17, 59)));
        ascendantsHashMap.put("CAPRICÓRNIO", List.of(LocalTime.of(18, 0), LocalTime.of(19, 59)));
        ascendantsHashMap.put("AQUÁRIO", List.of(LocalTime.of(20, 0), LocalTime.of(21, 59)));
        ascendantsHashMap.put("PEIXES", List.of(LocalTime.of(22, 0), LocalTime.of(23, 59)));
    }

    public static String getAscendant(ZonedDateTime birthDatePlace) {
        for (String ascendant: ascendantsHashMap.keySet()) {
            if (isAscendant(birthDatePlace.toLocalTime(), ascendant)) {
                return ascendant;
            }
        }

        return "Seu ascendente não foi encontrado. Verifique a data";
    }
    private static boolean isAscendant(LocalTime birthTime, String ascendant) {
        List<LocalTime> hours = ascendantsHashMap.get(ascendant);
        return isTimeBetween(hours.get(0), hours.get(1), birthTime);
    }

    private static boolean isTimeBetween(LocalTime initAscendantHour, LocalTime lastAscendantHour, LocalTime birthTime) {
        return (birthTime.isAfter(initAscendantHour) && birthTime.isBefore(lastAscendantHour))
                || (birthTime.equals(initAscendantHour) || birthTime.equals(lastAscendantHour));
    }

}

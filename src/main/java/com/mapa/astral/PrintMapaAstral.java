package com.mapa.astral;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PrintMapaAstral {
    public static void run() {
        Scanner scan = new Scanner(System.in);

        System.out.println("BEM VINDO AO SISTEMA DE SIGNOS\n");

        System.out.println("Qual é o seu nome? ");
        String name = scan.nextLine();

        System.out.println(name + ", em que ano e hora você nasceu? Digite no formato dd/MM/yyyy HH:mm");
        LocalDateTime birthDate;
        try
        {
            birthDate = UtilService.formatStringToDate(scan.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException("A data foi digitada de maneira errônea. Reinicie a aplicação");
        }

        System.out.println("Como você nasceu em São Paulo (você não tem opção, por enquanto), então:");
        ZoneId birthPlaceZoneId = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime birthDatePlace = ZonedDateTime.of(birthDate, birthPlaceZoneId);

        System.out.println("Sua idade é: " + UtilService.getAgeInYears(birthDatePlace));
        System.out.println("Você " + UtilService.verifyLeapYear(birthDatePlace) + " em ano bissexto" );

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data de nascimento formatada: " + UtilService.getFormattedDate(birthDatePlace));
        System.out.println("ZoneOffSet do local de nascimento: " + birthDatePlace.getOffset().toString());
        System.out.println("Seu signo é: " + EnumSignos.getSign(birthDatePlace));
        System.out.println("Seu ascendente é: " + AscendantsService.getAscendant(birthDatePlace));
        System.out.println("Seu signo lunar é: " + LunarSignService.getLunarSign(birthDatePlace, "Sao Paulo"));

    }
}

package com.mapa.astral;

import java.text.ParseException;
import java.time.*;
import java.time.zone.ZoneRulesException;
import java.util.Scanner;

public class PrintMapaAstral {
    public static void run() {
        Scanner scan = new Scanner(System.in);

        System.out.println("BEM VINDO AO SISTEMA DE SIGNOS\n");

        System.out.println("Qual é o seu nome? ");
        String name = scan.nextLine();

        System.out.println(name + ", em que ano e hora você nasceu? Digite no formato dd/MM/yyyy HH:mm");
        LocalDateTime birthDate = null;
        try
        {
            birthDate = UtilService.formatStringToDate(scan.nextLine());
        } catch (ParseException e) {
            System.out.println("A data foi digitada de maneira errônea. Reinicie o programa");
            System.exit(1);
        }

        System.out.println("Digite um ZoneId válido (Por exemplo, 'America/Sao_Paulo'):");
        ZoneId birthPlaceZoneId = null;
        try {
            birthPlaceZoneId = ZoneId.of(UtilService.getZoneId(scan.nextLine()));
        } catch(ZoneRulesException ex) {
            System.out.println("Você digitou um zoneId inválido. Reinicie o programa.");
            System.exit(1);
        }

        ZonedDateTime birthDatePlace = ZonedDateTime.of(birthDate, birthPlaceZoneId);

        System.out.println("Sua idade é: " + UtilService.getAgeInYears(birthDatePlace));
        System.out.println("Seu local de nascimento:  " + UtilService.printfFormattedZoneId(birthPlaceZoneId));
        System.out.println("Você " + UtilService.verifyLeapYear(birthDatePlace) + " em ano bissexto" );

        System.out.println("Data de nascimento formatada: " + UtilService.getFormattedDate(birthDatePlace));
        System.out.println("ZoneOffSet do local de nascimento: " + UtilService.getZoneOffSet(birthDatePlace));
        System.out.println("Seu signo é: " + EnumSignos.getSign(birthDatePlace));
        System.out.println("Seu ascendente é: " + AscendantsService.getAscendant(birthDatePlace));
        System.out.println("Seu signo lunar é: " + LunarSignService.getLunarSign(birthDatePlace, "Sao Paulo"));
    }
}

package app.service.helpers;

import app.domain.enums.SelectPreferencesEnum;

import java.util.Scanner;

public class SetUserPreferences {

    static Scanner sc = new Scanner(System.in);

    //Metodo helper para manejar la logica de la variable preferences
    public static String setPreferencesUser(){
        System.out.println("Seleccione: 1. VIP\n2. General\n3. Preferencial\n4. Balcon");
        int option = sc.nextInt();
        String preferences = null;
        switch (option){
            case 1:
                preferences = SelectPreferencesEnum.VIP.getPreference();
                break;
            case 2:
                preferences = SelectPreferencesEnum.GENERAL.getPreference();
                break;
            case 3:
                preferences = SelectPreferencesEnum.PREFERENCIAL.getPreference();
                break;
            default:
                System.out.println("Opción no valida");
        }
        return preferences;
    }

}

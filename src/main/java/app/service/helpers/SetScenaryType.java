package app.service.helpers;

import app.domain.enums.ScenaryTypeEnum;
import app.domain.enums.SelectPreferencesEnum;

import java.util.Scanner;

public class SetScenaryType {

    static Scanner sc = new Scanner(System.in);

    public static String setScenaryType(){
        System.out.println("Seleccione: 1. VIP\n2. General\n3. Preferencial\n4. Balcon");
        int option = sc.nextInt();
        String preferences = null;
        switch (option){
            case 1:
                preferences = ScenaryTypeEnum.TEATRO.getScenary();
                break;
            case 2:
                preferences = ScenaryTypeEnum.SALON.getScenary();
                break;
            case 3:
                preferences = ScenaryTypeEnum.ARENA.getScenary();
                break;
            default:
                System.out.println("Opción no valida");
        }
        return preferences;
    }
}

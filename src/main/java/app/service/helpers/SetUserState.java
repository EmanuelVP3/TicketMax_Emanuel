package app.service.helpers;

import app.domain.enums.SelectStateEnum;

import app.service.validators.DataTypeValidator;

public class SetUserState {

    //Metodo helper para manejar la logica de la variable state
    public static String getUserState(){
        while (true) {
            int option = DataTypeValidator.validateInt("Seleccione: 1. Activo\n2. Inactivo\n3. Bloqueado");
            switch (option){
            case 1:
                return SelectStateEnum.ACTIVE.getState();
            case 2:
                return SelectStateEnum.INACTIVE.getState();
            case 3:
                return SelectStateEnum.BLOCKED.getState();
            default:
                System.out.println("Opción no valida");
            }
        }
    }

}

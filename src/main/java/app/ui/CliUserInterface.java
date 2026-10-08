package app.ui;

import app.service.validators.DataTypeValidator;
import app.view.SeatView;
import app.view.UserView;
//import app.view.UserView;

public class CliUserInterface {



    private final UserView userView;
    //21. Se inyecta la dependencia de la vista en la interface
    private final SeatView seatView;

    //22 se actualizan los parametros del constructor para inyectar la dependencia de la vista
    // y el 23 sigue en la clase Config
    public CliUserInterface(UserView userView, SeatView seatView) {
        this.seatView = seatView;
        this.userView = userView;
    }

    public void applicationInit(){

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación");


        while(init != 0){

            int option = DataTypeValidator.validateInt("1. Registro " +
                    "2. Login" +
                    "3. Salir");

            switch (option){
                case 1:
                    userView.createUser();
                    break;
                case 2:
                    System.out.println("Login");
                    userMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación");
                    init = 0;
                    break;
                default:
                    System.out.println("Seleccione una opción valida");
                    break;
            }
        }
    }


    public void userMenu(){

        int option = DataTypeValidator.validateInt("Seleccione 1. registrar usuario\n" +
                "2. Consultar Usuario por id\n" +
                "3. Consultar todos los usuarios\n" +
                "4. Actualizar usuario");

        switch (option){
            case 1:
                System.out.println("Registrar Usuario");
                userView.createUser();
                break;
            case 2:
                System.out.println("Consultar usuario por id");
                int id = DataTypeValidator.validateInt("Ingrese el id del usuario a consultar");
                userView.selectById(id);
                break;
            case 3:
                System.out.println("Consultar todos los usuarios");
                userView.selectUsers();
                break;
            case 4:
                userView.update();
                break;
            default:
                System.out.println("Ingrese una opción valida");
        }
    }
}

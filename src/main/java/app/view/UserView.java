package app.view;

import app.domain.User;
import app.domain.enums.SelectPreferencesEnum;
import app.service.helpers.SetUserState;
import app.service.inputPorts.UserService;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class UserView {


    private final UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }

    public void createUser() {


        int id = DataTypeValidator.validateInt("Ingrese el id del usuario: ");
        if (userService.selectUserById(id) != null) {
            System.out.println("Ya existe un usuario con ese id");
            return;
        }
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        System.out.println("Ingrese el estado del usuario: ");
        String state = SetUserState.getUserState();
        System.out.println();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        System.out.println("Ingrese las preferencias del usuario: ");
        String preferences = setUserPreferences();

        User createdUser = userService.create(id, name , lastName , email , phone , password , state, city, preferences);
        if (createdUser == null) {
            System.out.println("No se pudo registrar el usuario: revise el id");
        } else {
            System.out.println("Usuario registrado correctamente");
        }

    }


    public void selectById(int id) {
        userService.selectById(id);
    }


    public void selectUsers(){

        List<User> users = userService.selectUsers();
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }
        System.out.println("ID | Nombre | Apellido | Correo | Telefono | Estado | Ciudad | Preferencia");
        for (User user : users) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getLastName()
                    + " | " + user.getEmail() + " | " + user.getPhone() + " | " + user.isState()
                    + " | " + user.getCity() + " | " + user.getPreferences());
        }

    }


    public void update() {
        int id = DataTypeValidator.validateInt("Ingrese el id del usuario a actualizar: ");
        if (userService.selectUserById(id) == null) {
            System.out.println("No se encontró un usuario con ese id");
            return;
        }
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        String state = SetUserState.getUserState();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        String preferences = setUserPreferences();
        User updatedUser = new User(id, name, lastName, email, phone, password, state, city, preferences);
        if (userService.updateUser(updatedUser) == null) {
            System.out.println("No se pudo actualizar el usuario");
        } else {
            System.out.println("Usuario actualizado correctamente");
        }
    }


    public void delete(int id) {
        if (userService.deleteUser(id)) {
            System.out.println("Usuario eliminado correctamente");
        } else {
            System.out.println("No se encontró un usuario con ese id");
        }
    }

    public void countUsers() {
        System.out.println("Numero de usuarios: " + userService.countUsers());
    }

    // métodos Helper




    public String setUserPreferences(){


        while (true) {
            int option = DataTypeValidator.validateInt("Seleccione 1. VIP 2. General 3. Preferencial");
            switch (option){
            case 1:
                return SelectPreferencesEnum.VIP.getPreference();
            case 2:
                return SelectPreferencesEnum.GENERAL.getPreference();
            case 3:
                return SelectPreferencesEnum.PREFERENCIAL.getPreference();
            default:
                System.out.println("Opción no valida");
            }
        }
    }








}

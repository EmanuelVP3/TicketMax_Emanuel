package app.view;

import java.util.Scanner;

public class userView {

    Scanner sc = new Scanner(System.in);

    public void create() {
        System.out.println("Ingrese la identificación del usuario: ");
        int id = sc.nextInt();
        sc.nextLine(); //reseteo de buffer
        System.out.println("Ingrese el nombre del usuario: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el apellido del usuario: ");
        String lastName = sc.nextLine();
        System.out.println("Ingrese el correo del usuario: ");
        String email = sc.nextLine();
        System.out.println("Ingrese el telefono del usuario: ");
        String phone = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario: ");
        String password = sc.nextLine();

    }

    public void selectById(int id) {}

    public void update() {}
}

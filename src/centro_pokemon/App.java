package centro_pokemon;

import java.util.Scanner;

/**
 * @name App.java
 * @purpose main
 * @author https://www.squash.io/how-to-connect-java-with-mysql/
 * @version 1.0
 */

public class App {

	public static void menuPrincipal() {

		System.out.println("-------- Bienvenido al centro Pokemon ------------");

		Scanner sc = new Scanner(System.in);

		Crud crud = null;

		int selectMenu = 0;
		while (selectMenu != 7) {
			System.out.println("\nMenu principal: \n1.- Conectar a bbdd\n" + "2.- Configurar bbdd\n" + "3.- CREATE\n"
					+ "4.- READ\n" + "5.- UPDATE\n" + "6.- DELETE\n" + "7.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				crud = new Crud();
				break;
			case 2:
				Conn.configuraConn();
				break;
			case 3:
				System.out.println("INSERT");
				crud.Insert("enfermera");
				break;
			case 4:
				System.out.println("READ");
				crud.Select("centro");
				break;
			case 5:
				System.out.println("UPDATE");
				break;
			case 6:
				System.out.println("DELETE");
				break;
			case 7:
				System.out.println("Hasta luego Lucas!");
				if (sc != null)
					sc.close();
				break;
			default:
				System.out.println("Número no reconocido");
				continue;
			}
		}
	}

	public static void main(String[] args) {

		menuPrincipal();

	}

}

package centro_pokemon;

import java.util.Scanner;

/**
 * @name App.java
 * @purpose main
 * @author Group 4
 * @version 1.0
 */

public class App {

	public static void menuPrincipal() {

		System.out.println("-------- Bienvenido al centro Pokemon --------");

		Scanner sc = new Scanner(System.in);

		Crud crud = null;

		int selectMenu = 0;
		while (selectMenu != 7) {
			System.out.println("\nMENU PRINCIPAL \n1.- Conectar a bbdd\n" + "2.- Configurar bbdd\n" + "3.- CREATE\n"
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
                menuInsert(crud);
				break;
			case 4:
				menuSelect(crud);
				break;
			case 5:
				menuUpdate(crud);
				break;
			case 6:
				menuDelete(crud);
				break;
			case 7:
				System.out.println("¡Hasta luego Lucas!");
				if (sc != null)
					sc.close();
				break;
			default:
				System.out.println("Numero no reconocido");
				continue;
			}
		}
	}
	
	public static void menuInsert(Crud crud) {
	
		Scanner sc = crud.getSc();

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\\n-------- INSERT --------");
			System.out.println("\n1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n"
					+ "4.- Pokemon\n" + "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				Centro nuevoCentro = new Centro();
                System.out.println("Inserte nombre del centro");
                String nuevoNombre = sc.next();
                nuevoCentro.setNombre(nuevoNombre);

                System.out.println("Inserte localidad");
                String nuevaLocalidad = sc.next();
                nuevoCentro.setLocalidad(nuevaLocalidad);

                System.out.println("Inserte presupuesto");
                Double nuevoPresupuesto = sc.nextDouble() ;
                nuevoCentro.setPresupuesto(nuevoPresupuesto);

                System.out.println("Introduce ID de trabajador");
                int nuevoTrabajador = sc.nextInt() ;

                nuevoCentro.setTrabajador(nuevoTrabajador);

                crud.Insert(nuevoCentro);            
				break;
			case 2:
				crud.Insert(nuevaEnfermera);
				break;
			case 3:
				//crud.Insert(nuevoEntrenador);            
				break;
			case 4:
				//crud.Insert(nuevoPokemon); 
				break;
			case 5: 
				//crud.Insert(nuevoTratamiento); 
				break;
			case 6:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Numero no reconocido");
				continue;
			}
		}
	}
	
	public static void menuSelect(Crud crud) {
		
		Scanner sc = crud.getSc();

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\\n-------- SELECT --------");
			System.out.println("\n1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n"
					+ "4.- Pokemon\n" + "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				try {
					crud.Select("centro");

				} catch (Exception e) {
					System.out.println("Error al leer la base de datos");
				}
				break;
			case 2:
				crud.Select("enfermera");
				break;
			case 3:
				crud.Select("entrenador");            
				break;
			case 4:
				try {
					crud.Select("pokemon");

				} catch (Exception e) {
					System.out.println("Error al leer la base de datos");
				}  
				break;
			case 5:
				//crud.Select("tratamiento");
				break;
			case 6:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Numero no reconocido");
				continue;
			}
		}
	}
	
	public static void menuUpdate(Crud crud) {
		
		Scanner sc = crud.getSc();

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- UPDATE --------");
			System.out.println("\n1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n"
					+ "4.- Pokemon\n" + "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				System.out.println("Elige tupla a modificar");
				crud.Select("centro");
                System.out.println("Inserte id del centro");
                int centroID = sc.nextInt();
                crud.SelectId("centro", centroID);

                /*
                System.out.println("Inserte localidad");
                String nuevaLocalidad = sc.next();
                nuevoCentro.setLocalidad(nuevaLocalidad);

                System.out.println("Inserte presupuesto");
                Double nuevoPresupuesto = sc.nextDouble() ;
                nuevoCentro.setPresupuesto(nuevoPresupuesto);

                System.out.println("Introduce ID de trabajador");
                int nuevoTrabajador = sc.nextInt() ;

                nuevoCentro.setTrabajador(nuevoTrabajador);

                crud.Update("centro",centroID);
                */            
				break;
			case 2:
				//crud.Update("enfermera",centroID);
				break;
			case 3:
				//crud.Update("entrenador",centroID);            
				break;
			case 4:
				//crud.Update("pokemon",centroID);  
				break;
			case 5: 
				//crud.Update("tratamiento",centroID);  
				break;
			case 6:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Numero no reconocido");
				continue;
			}
		}
	}
	
	public static void menuDelete(Crud crud) {
		
		Scanner sc = crud.getSc();

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- DELETE --------");
			System.out.println("\n1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n"
					+ "4.- Pokemon\n" + "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				//crud.Delete("centro",centroID);            
				break;
			case 2:
				//crud.Delete("enfermera,centroID); 
				break;
			case 3:
				//crud.Delete("entrenador",centroID);            
				break;
			case 4:
				//crud.Delete("pokemon",centroID); 
				break;
			case 5: 
				//crud.Delete("tratamiento",centroID); 
				break;
			case 6:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Numero no reconocido");
				continue;
			}
		}
	}

	public static void main(String[] args) {

		menuPrincipal();

	}

}

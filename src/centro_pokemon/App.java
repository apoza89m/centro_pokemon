package centro_pokemon;

import java.util.Scanner;

/**
 * @name App.java
 * @purpose main
 * @author Group 4
 * @version 1.0
 */

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void menuPrincipal() {

		System.out.println("-------- Bienvenido al centro Pokemon --------");

		Crud crud = null;

		int selectMenu = 0;

		while (selectMenu != 8) {
			String opcion_1 = (crud == null) ? "Conectar a bbdd" : "Conectado";

			System.out.println("\nMENU PRINCIPAL \n1.- " + opcion_1 + "\n" + "2.- Configurar bbdd\n" + "3.- CREATE\n"
					+ "4.- READ\n" + "5.- UPDATE\n" + "6.- DELETE\n" + "7.- Curar pokemon\n" + "8.- Salir\n");

			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				if (crud != null)
					System.out.println("Ya estas conectado a la base de datos");
				else
					crud = new Crud();
				break;

			case 2:
				Conn.configuraConn();
				break;

			case 3:
				try {
					menuInsert(crud);
				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 4:
				try {
					menuSelect(crud);
				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 5:
				try {
					menuUpdate(crud);
				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 6:
				try {
					menuDelete(crud);
				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 7:
				try {
					System.out.println("Inserte id del centro");
					int id_centro = sc.nextInt();

					System.out.println("Inserte id de entrenador");
					int id_entrenador = sc.nextInt();

					crud.muestraPokemon(id_entrenador);
					System.out.println("Inserte id de pokemon");
					int id_pokemon = sc.nextInt();

					crud.curarPokemon(id_centro, id_entrenador, id_pokemon);

				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 8:
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

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- INSERT --------");
			System.out.println("1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n" + "4.- Pokemon\n"
					+ "5.- Tratamiento\n" + "6.- Salir\n");
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
				Double nuevoPresupuesto = sc.nextDouble();
				nuevoCentro.setPresupuesto(nuevoPresupuesto);

				System.out.println("Introduce ID de trabajador");
				int nuevoTrabajador = sc.nextInt();
				nuevoCentro.setTrabajador(nuevoTrabajador);

				crud.insertCentro(nuevoCentro);
				break;

			case 2:
				Enfermera nuevaEnfermera = new Enfermera();

				System.out.println("Inserte id de la enfermera");
				nuevaEnfermera.setId(sc.nextInt());

				System.out.println("Inserte nombre de la enfermera");
				nuevaEnfermera.setNombre(sc.next());

				System.out.println("Inserte genero(h/m)");
				nuevaEnfermera.setGenero(sc.next());

				nuevaEnfermera.setNumPokemonTratados(0);

				crud.insertEnfermera(nuevaEnfermera);
				break;

			case 3:
				Entrenador nuevoEntrenador = new Entrenador();

				System.out.println("Inserte id del entrenador");
				nuevoEntrenador.setId(sc.nextInt());

				System.out.println("Inserte nombre del entrenador");
				nuevoEntrenador.setNombre(sc.next());

				System.out.println("Inserte genero(h/m)");
				nuevoEntrenador.setGenero(sc.next());

				nuevoEntrenador.setNumMedallas(0);

				System.out.println("Inserte saldo");
				nuevoEntrenador.setSaldo(sc.nextDouble());

				crud.insertEntrenador(nuevoEntrenador);
				break;

			case 4:
				// crud.insertPokemon(nuevoPokemon);
				break;

			case 5:
				Tratamiento nuevoTratamiento = new Tratamiento();
				// PEPE
				/*
				 * System.out.println("Inserte nombre del centro"); String nuevoNombre =
				 * sc.next(); nuevoCentro.setNombre(nuevoNombre);
				 * 
				 * System.out.println("Inserte localidad"); String nuevaLocalidad = sc.next();
				 * nuevoCentro.setLocalidad(nuevaLocalidad);
				 * 
				 * System.out.println("Inserte presupuesto"); Double nuevoPresupuesto =
				 * sc.nextDouble() ; nuevoCentro.setPresupuesto(nuevoPresupuesto);
				 * 
				 * System.out.println("Introduce ID de trabajador"); int nuevoTrabajador =
				 * sc.nextInt() ;
				 * 
				 * nuevoCentro.setTrabajador(nuevoTrabajador);
				 */

				crud.insertTratamiento(nuevoTratamiento);
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

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- SELECT --------");
			System.out.println("1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n" + "4.- Pokemon\n"
					+ "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				try {
					crud.select("centro");

				} catch (Exception e) {
					System.out.println("Error al leer la base de datos");
				}
				break;
			case 2:
				crud.select("enfermera");
				break;
			case 3:
				crud.select("entrenador");
				break;
			case 4:
				try {
					crud.select("pokemon");

				} catch (Exception e) {
					System.out.println("Error al leer la base de datos");
				}
				break;
			case 5:
				crud.select("tratamiento");
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

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- UPDATE --------");
			System.out.println("1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n" + "4.- Pokemon\n"
					+ "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {

			case 1:
				// CODIGO JESUS//
		/*		
				crud.select("centro");
				System.out.println("Elige id a modificar: ");
				int centroID = sc.nextInt();

				if (crud.selectId("entrenador", entrenadorID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- genero\n" + "3.- num_medallas\n" + "4.- saldo\n");
					int opcionEntrenador = sc.nextInt();
					switch (opcionEntrenador) {
					case 1:
						crud.updateEntrenador(entrenadorID, "nombre");
						break;
					case 2:
						crud.updateEntrenador(entrenadorID, "genero");
						break;
					case 3:
						crud.updateEntrenador(entrenadorID, "num_medallas");
						break;
					case 4:
						crud.updateEntrenador(entrenadorID, "saldo");
						break;
					default:
						System.out.println("Saliendo...");
						break;
					}
				} else
					System.out.println("Esa ID no existe");
				break;*/ 
			case 2:
				crud.select("enfermera");
				System.out.println("Elige id a modificar: ");
				int enfermeraID = sc.nextInt();

				if (crud.selectId("enfermera", enfermeraID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- genero\n" + "3.- num_pokemon_tratados\n");
					int opcionEnfermera = sc.nextInt();

					switch (opcionEnfermera) {
					case 1:
						crud.updateEnfermera(enfermeraID, "nombre");
						break;
					case 2:
						crud.updateEnfermera(enfermeraID, "genero");
						break;
					case 3:
						crud.updateEnfermera(enfermeraID, "num_pokemon_tratados");
						break;
					default:
						System.out.println("Saliendo...");
						break;
					}
				} else
					System.out.println("Esa ID no existe");
				break;
			case 3:
				crud.select("entrenador");
				System.out.println("Elige id a modificar: ");
				int entrenadorID = sc.nextInt();

				if (crud.selectId("entrenador", entrenadorID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- genero\n" + "3.- num_medallas\n" + "4.- saldo\n");
					int opcionEntrenador = sc.nextInt();
					switch (opcionEntrenador) {
					case 1:
						crud.updateEntrenador(entrenadorID, "nombre");
						break;

					case 2:
						crud.updateEntrenador(entrenadorID, "genero");
						break;

					case 3:
						crud.updateEntrenador(entrenadorID, "num_medallas");
						break;

					case 4:
						crud.updateEntrenador(entrenadorID, "saldo");
						break;

					default:
						System.out.println("Saliendo...");
						break;
					}
				} else
					System.out.println("Esa ID no existe");
				break;
			case 4:
				// CODIGO MAR
				break;
			case 5:
				// CODIGO PEPE
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

		int selectMenu = 0;
		while (selectMenu != 6) {
			System.out.println("\n-------- DELETE --------");
			System.out.println("1.- Centro\n" + "2.- Enfermera\n" + "3.- Entrenador\n" + "4.- Pokemon\n"
					+ "5.- Tratamiento\n" + "6.- Salir\n");
			selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				// crud.Delete("centro",centroID);
				break;

			case 2:
				crud.select("enfermera");
				System.out.println("Elige id a eliminar: ");
				int enfermeraID = sc.nextInt();

				if (crud.selectId("enfermera", enfermeraID) != null)
					crud.deleteEnfermera(enfermeraID);
				else
					System.out.println("Esa ID no existe");
				break;

			case 3:
				crud.select("entrenador");
				System.out.println("Elige id a eliminar: ");
				int entrenadorID = sc.nextInt();

				if (crud.selectId("entrenador", entrenadorID) != null)
					crud.deleteEntrenador(entrenadorID);
				else
					System.out.println("Esa ID no existe");
				break;

			case 4:
				// crud.Delete("pokemon",centroID);
				break;

			case 5:
				// crud.Delete("tratamiento",centroID);
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

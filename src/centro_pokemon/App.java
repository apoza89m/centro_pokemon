package centro_pokemon;

import java.sql.Date;
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
			sc.nextLine();
			switch (selectMenu) {

			case 1:
				if (crud != null)
					System.out.println("Ya estas conectado a la base de datos");
				else
					crud = new Crud();
				break;

			case 2:
				if (crud != null)
					System.out.println("Ya estas conectado a la base de datos");
				else
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
					crud.select("centro");
					int id_centro = sc.nextInt();
					sc.nextLine();

					System.out.println("Inserte id de entrenador");
					crud.select("entrenador");
					int id_entrenador = sc.nextInt();
					sc.nextLine();

					System.out.println("Inserte id de pokemon");
					crud.muestraPokemon(id_entrenador);
					int id_pokemon = sc.nextInt();
					sc.nextLine();

					crud.curarPokemon(id_centro, id_entrenador, id_pokemon);

				} catch (Exception e) {
					System.out.println("Conecta a la base de datos primero.");
				}
				break;

			case 8:
				System.out.println("Saliendo...");
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
			sc.nextLine();
			switch (selectMenu) {
			case 1:
				Centro nuevoCentro = new Centro();
				System.out.println("Inserte nombre del centro");
				String nuevoNombre = sc.nextLine();
				nuevoCentro.setNombre(nuevoNombre);

				System.out.println("Inserte localidad");
				String nuevaLocalidad = sc.nextLine();
				nuevoCentro.setLocalidad(nuevaLocalidad);

				System.out.println("Inserte presupuesto");
				Double nuevoPresupuesto = sc.nextDouble();
				sc.nextLine();
				nuevoCentro.setPresupuesto(nuevoPresupuesto);

				System.out.println("Introduce ID de trabajador");
				int nuevoTrabajador = sc.nextInt();
				sc.nextLine();
				nuevoCentro.setTrabajador(nuevoTrabajador);

				crud.insertCentro(nuevoCentro);
				break;

			case 2:
				Enfermera nuevaEnfermera = new Enfermera();

				System.out.println("Inserte id de la enfermera");
				nuevaEnfermera.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Inserte nombre de la enfermera");
				nuevaEnfermera.setNombre(sc.nextLine());

				System.out.println("Inserte genero(h/m)");
				nuevaEnfermera.setGenero(sc.next());
				sc.nextLine();
				nuevaEnfermera.setNumPokemonTratados(0);

				crud.insertEnfermera(nuevaEnfermera);
				break;

			case 3:
				Entrenador nuevoEntrenador = new Entrenador();

				System.out.println("Inserte id del entrenador");
				nuevoEntrenador.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Inserte nombre del entrenador");
				nuevoEntrenador.setNombre(sc.nextLine());

				System.out.println("Inserte genero(h/m)");
				nuevoEntrenador.setGenero(sc.next());
				sc.nextLine();
				nuevoEntrenador.setNumMedallas(0);

				System.out.println("Inserte saldo");
				nuevoEntrenador.setSaldo(sc.nextDouble());
				sc.nextLine();
				crud.insertEntrenador(nuevoEntrenador);
				break;

			case 4:
				// crud.insertPokemon(nuevoPokemon);
				break;

			case 5:
				Tratamiento nuevoTratamiento = new Tratamiento();

				System.out.println("Inserte nombre de diagnostico");
				nuevoTratamiento.setDiagnostico(sc.nextLine());

				System.out.println("Inserte fecha de alta (YYYY-MM-DD) ");
				nuevoTratamiento.setFechaAlta(Date.valueOf(sc.next()));
				sc.nextLine();
				System.out.println("Inserte fecha de baja (YYYY-MM-DD)");
				nuevoTratamiento.setFechaBaja(Date.valueOf(sc.next()));
				sc.nextLine();
				System.out.println("Inserte costo");
				nuevoTratamiento.setCosto(sc.nextDouble());
				sc.nextLine();
				System.out.println("Inserte id de pokemon a tratar");
				nuevoTratamiento.setIdPokemon(sc.nextInt());
				sc.nextLine();
				System.out.println("Inserte id de enfermera responsable");
				nuevoTratamiento.setIdEnfermera(sc.nextInt());
				sc.nextLine();
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
			sc.nextLine();
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
			sc.nextLine();
			switch (selectMenu) {

			case 1:
				crud.select("centro");
				System.out.println("Elige id a modificar: ");
				int centroID = sc.nextInt();
				sc.nextLine();
				if (crud.selectId("centro", centroID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- localidad\n" + "3.- presupuesto\n" + "4.- trabajador\n");
					int opcionCentro = sc.nextInt();
					sc.nextLine();
					switch (opcionCentro) {
					case 1:
						crud.updateCentro(centroID, "nombre");
						break;
					case 2:
						crud.updateCentro(centroID, "localidad");
						break;
					case 3:
						crud.updateCentro(centroID, "presupuesto");
						break;
					case 4:
						crud.updateCentro(centroID, "trabajador");
						break;
					default:
						System.out.println("Saliendo...");
						break;
					}
				} else
					System.out.println("Esa ID no existe");
				break;

			case 2:
				crud.select("enfermera");
				System.out.println("Elige id a modificar: ");
				int enfermeraID = sc.nextInt();

				if (crud.selectId("enfermera", enfermeraID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- genero\n" + "3.- num_pokemon_tratados\n");
					int opcionEnfermera = sc.nextInt();
					sc.nextLine();
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
				sc.nextLine();
				if (crud.selectId("entrenador", entrenadorID) != null) {
					System.out.println("Elige campo a modificar: ");
					System.out.println("1.- nombre\n" + "2.- genero\n" + "3.- num_medallas\n" + "4.- saldo\n");
					int opcionEntrenador = sc.nextInt();
					sc.nextLine();
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
				crud.select("tratamiento");
				System.out.println("Elige el ID del tratamiento a modificar: ");
				int tratamientoID = sc.nextInt();
				sc.nextLine();
				// Verificar si el ID del tratamiento existe en la base de datos
				if (crud.selectId("tratamiento", tratamientoID) != null) {
					System.out.println("Elige el campo a modificar: ");
					System.out.println("1.- Diagnóstico\n" + "2.- Fecha de alta\n" + "3.- Fecha de baja\n"
							+ "4.- Costo\n" + "5.- ID del Pokemon\n" + "6.- ID de la Enfermera\n");
					int opcionTratamiento = sc.nextInt();
					sc.nextLine();
					switch (opcionTratamiento) {
					case 1:
						crud.updateTratamiento(tratamientoID, "id_tratamiento");
						break;
					case 2:
						crud.updateTratamiento(tratamientoID, "fecha_alta");
						break;
					case 3:
						crud.updateTratamiento(tratamientoID, "fecha_baja");
						break;
					case 4:
						crud.updateTratamiento(tratamientoID, "costo");
						break;
					case 5:
						crud.updateTratamiento(tratamientoID, "id_poke");
						break;
					case 6:
						crud.updateTratamiento(tratamientoID, "id_enfermera");
						break;
					default:
						System.out.println("Opción inválida. Saliendo...");
						break;
					}
				} else {
					System.out.println("Ese ID de tratamiento no existe");
				}
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
			sc.nextLine();
			switch (selectMenu) {
			case 1:
				crud.select("centro");
				System.out.println("Elige id a eliminar: ");
				int centroID = sc.nextInt();
				sc.nextLine();
				if (crud.selectId("centro", centroID) != null)
					crud.deleteCentro(centroID);
				else
					System.out.println("Esa ID no existe");
				break;

			case 2:
				crud.select("enfermera");
				System.out.println("Elige id a eliminar: ");
				int enfermeraID = sc.nextInt();
				sc.nextLine();
				if (crud.selectId("enfermera", enfermeraID) != null)
					crud.deleteEnfermera(enfermeraID);
				else
					System.out.println("Esa ID no existe");
				break;

			case 3:
				crud.select("entrenador");
				System.out.println("Elige id a eliminar: ");
				int entrenadorID = sc.nextInt();
				sc.nextLine();
				if (crud.selectId("entrenador", entrenadorID) != null)
					crud.deleteEntrenador(entrenadorID);
				else
					System.out.println("Esa ID no existe");
				break;

			case 4:
				// crud.Delete("pokemon",centroID);
				break;

			case 5:
				crud.select("tratamiento");
				System.out.println("Elige el ID del tratamiento a eliminar: ");
				int tratamientoID = sc.nextInt();
				sc.nextLine();
				// Verificar si el ID del tratamiento existe en la base de datos
				if (crud.selectId("tratamiento", tratamientoID) != null) {
					crud.deleteTratamiento(tratamientoID);
				} else {
					System.out.println("Ese ID de tratamiento no existe");
				}
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

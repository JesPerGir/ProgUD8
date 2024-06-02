package tuCine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestionCines {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/gestioncine", user="root", password = "";
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("||||||||||    BIENVENIDO A LA HERRAMIENTA DE GESIÓN DE CINES ''TU CINE''    ||||||||||' ");
		
		do {
			menu(sc, connection);
		}while(seguir(sc)!=2);
		sc.close();
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public static void menu(Scanner sc, Connection connection) {
	int opcionUsuario=0;
	System.out.println(	"\n ¿Qué gestión deseas realizar? \n" + 
				" 1) Insertar datos  \n" +
				" 2) Modificar datos \n" +
				" 3) Eliminar datos  \n" +
				" 4) Visualizar datos  \n");
	opcionUsuario=sc.nextInt();
	try {
		operacion(opcionUsuario, sc, connection);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static int seguir(Scanner sc) {
	System.out.println("\n ¿Deseas hacer alguna operación más? \n" +
			"1) Sí \n" +
			"2) No \n");
	return sc.nextInt();
}

public static void insert(int opcionUsuario, Connection connection, Scanner sc) throws SQLException{
	if(opcionUsuario==1) {
		int identificador=0;
		String nombreCine="", direccion="";
		System.out.println("Introduce el identificador de 8 dígitos del cine: ");
		identificador=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el nombre del cine: ");
		nombreCine=sc.nextLine();
		System.out.println("Introduce la dirección del cine: ");
		direccion=sc.nextLine();
		String sqlString = "INSERT INTO cines VALUES ( ' " + identificador + " ' , ' " + nombreCine + " ' , ' " + direccion +" ' )";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==2) {
		int identificador=0, capacidad=0, metrosCuadrados=0;
		System.out.println("Introduce el identificador de 8 dígitos de la sala: ");
		identificador=sc.nextInt();
		System.out.println("Introduce la capacidad de la sala : ");
		capacidad=sc.nextInt();
		System.out.println("Introduce los metros cuadrados de la sala: ");
		metrosCuadrados=sc.nextInt();
		String sqlString = "INSERT INTO salas VALUES ( ' " + identificador + " ' , ' " + capacidad + " ' , ' " + metrosCuadrados +" ' )";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==3) {
		int identificador=0, duracionMinutos=0, clasificacionPorEdad=0, precio=0;
		String titulo, genero, director;
		System.out.println("Introduce el identificador de 8 dígitos de la película: ");
		identificador=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el título de la película: ");
		titulo=sc.nextLine();
		System.out.println("Introduce la duración en minutos de la película: ");
		duracionMinutos=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el género de la película : ");
		genero=sc.nextLine();
		System.out.println("Introduce el nombre del director de la película : ");
		director=sc.nextLine();
		System.out.println("Introduce la clasificación de edad de la película: ");
		clasificacionPorEdad=sc.nextInt();
		System.out.println("Introduce el precio de la película: ");
		precio=sc.nextInt();
		String sqlString = "INSERT INTO peliculas VALUES ( ' " + identificador + " ' , ' " + titulo + " ' , ' " + duracionMinutos + " ' , ' " + genero + " ' , ' " + director + " ' , ' " + clasificacionPorEdad + " ' , ' "  + precio + " ' )";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}
}

public static void update(int opcionUsuario, Connection connection, Scanner sc) throws SQLException{
	if(opcionUsuario==1) {
		int anteriorIdentificador=0, identificador=0;
		String nombreCine="", direccion="";
		System.out.println("Introduce el actual identificador de 8 dígitos del cine que deseas modificar: ");
		anteriorIdentificador=sc.nextInt();
		System.out.println("Introduce el nuevo identificador de 8 dígitos): ");
		identificador=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el nuevo nombre del cine: ");
		nombreCine=sc.nextLine();
		System.out.println("Introduce la nueva dirección del cine: ");
		direccion=sc.nextLine();
		String sqlString = "UPDATE cines SET identificador='" + identificador + "', nombreCine='" + nombreCine + "', direccion='" + direccion + "' WHERE identificador='" + anteriorIdentificador + "'";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==2) {
		int anteriorIdentificador=0, identificador=0, capacidadSala=0, metrosCuadrados=0;
		System.out.println("Introduce el actual identificador de 8 dígitos de la sala que deseas modificar: ");
		anteriorIdentificador=sc.nextInt();
		System.out.println("Introduce el nuevo identificador de 8 dígitos): ");
		identificador=sc.nextInt();
		System.out.println("Introduce la nueva capacidad de la sala: ");
		capacidadSala=sc.nextInt();
		System.out.println("Introduce la nueva superficie de la sala en metros cuadrados: ");
		metrosCuadrados=sc.nextInt();
		String sqlString = "UPDATE salas SET identificador='" + identificador + "', capacidadSala='" + capacidadSala + "', metrosCuadrados='" + metrosCuadrados + "' WHERE identificador='" + anteriorIdentificador + "'";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==3) {
		int anteriorIdentificador=0, identificador=0, duracionMinutos=0, clasificacionPorEdad=0, precio=0;
		String titulo, genero, director;
		System.out.println("Introduce el actual identificador de 8 dígitos de la película que deseas modificar: ");
		anteriorIdentificador=sc.nextInt();
		System.out.println("Introduce el nuevo identificador de 8 dígitos de la película: ");
		identificador=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el nuevo título de la película: ");
		titulo=sc.nextLine();
		System.out.println("Introduce la nueva duración en minutos de la película: ");
		duracionMinutos=sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el nuevo género de la película : ");
		genero=sc.nextLine();
		System.out.println("Introduce el nuevo nombre del director de la película : ");
		director=sc.nextLine();
		System.out.println("Introduce la nueva clasificación de edad de la película: ");
		clasificacionPorEdad=sc.nextInt();
		System.out.println("Introduce el nuevo precio de la película: ");
		precio=sc.nextInt();
		String sqlString = "UPDATE peliculas SET identificador='" + identificador + "', titulo='" + titulo + "', duracionMinutos='" + duracionMinutos + "', genero='" + genero + "', director= '" + director + "', clasificacionPorEdad='" + clasificacionPorEdad + "', precio='" + precio + "' WHERE identificador='" + anteriorIdentificador + "'";
		 Statement statement = connection.createStatement();
		 statement.executeUpdate(sqlString);
		 statement.close(); 
	}
}

public static void delete(int opcionUsuario, Connection connection, Scanner sc) throws SQLException{
	if(opcionUsuario==1) {
		int identificador=0;
		System.out.println("Introduce el identificador del cine a eliminar: ");
		identificador=sc.nextInt();
		String sqlString = "DELETE FROM cines  WHERE identificador = ( ' " + identificador + " ' )";
		 Statement statement = connection.createStatement();
		 statement.execute(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==2) {
		int identificador=0;
		System.out.println("Introduce el identificador de la sala a eliminar: ");
		identificador=sc.nextInt();
		String sqlString = "DELETE FROM salas  WHERE identificador = ( ' " + identificador + " ' )";
		 Statement statement = connection.createStatement();
		 statement.execute(sqlString);
		 statement.close(); 
	}else if(opcionUsuario==3) {
		int identificador=0;
		System.out.println("Introduce el identificador de la película a eliminar: ");
		identificador=sc.nextInt();
		String sqlString = "DELETE FROM peliculas  WHERE identificador = ( ' " + identificador + " ' )";
		 Statement statement = connection.createStatement();
		 statement.execute(sqlString);
		 statement.close(); 
	}
}

public static void result(int opcionUsuario, Connection connection) throws SQLException{
	if(opcionUsuario==1) {
		String sqlString = "SELECT * FROM cines";
		 Statement statement = connection.createStatement();
		 ResultSet rs = statement.executeQuery(sqlString);
		 while (rs.next()) {
			 System.out.println("\n" + "Identificador: " + rs.getInt("identificador") + "\nNombre Cine: " + rs.getString("nombreCine") +"\nDirección: " + rs.getString("direccion"));
			 } 
		 statement.close(); 
	}else if(opcionUsuario==2) {
		String sqlString = "SELECT * FROM salas";
		 Statement statement = connection.createStatement();
		 ResultSet rs = statement.executeQuery(sqlString);
		 while (rs.next()) {
			 System.out.println("\n" + "Identificador: " + rs.getInt("identificador") + "\nCapacidad: " + rs.getInt("capacidad") + "\nSuperficie m2: " + rs.getInt("metrosCuadrados"));
			 } 
		 statement.close(); 
	}else if(opcionUsuario==3) {
		String sqlString = "SELECT * FROM peliculas";
		 Statement statement = connection.createStatement();
		 ResultSet rs = statement.executeQuery(sqlString);
		 while (rs.next()) {
			 System.out.println("\n" + "Identificador: " + rs.getInt("identificador") + "\nTítulo: " + rs.getString("titulo") + "\nDuración minutos: " + rs.getInt("duracionMinutos") + "\nGénero: " + rs.getString("genero") + "\nDirector: " + rs.getString("director") + "\nClasificación  edad: " + rs.getInt("clasificacionPorEdad") + "\nPrecio: " +rs.getInt("precio"));
			 } 
		 statement.close(); 
	}
}


public static void operacion(int opcionUsuario, Scanner sc, Connection connection) throws SQLException {
	switch(opcionUsuario) {
	case 1:
		System.out.println("\n Escoge una opción: \n" +
			 "1) Introducir un cine \n" +
			 "2) Introducir una sala \n" + 
			 "3) Introducir una película \n");
		opcionUsuario=sc.nextInt();
			insert(opcionUsuario, connection, sc);
			break;
	case 2:
		System.out.println("\n Escoge una opción: \n" +
				 "1) Modificar un cine \n" +
				 "2) Modificar una sala \n" + 
				 "3) Modificar una película \n");
			opcionUsuario=sc.nextInt();
				update(opcionUsuario, connection, sc);
				break;
	case 3:
		System.out.println("\n Escoge una opción: \n" +
				 "1) Eliminar un cine \n" +
				 "2) Eliminar una sala \n" + 
				 "3) Eliminar una película \n");
		opcionUsuario=sc.nextInt();
		delete(opcionUsuario, connection, sc);
		break;
	case 4:
		System.out.println("\n Escoge una opción: \n" +
				 "1) Visualizar tabla cines \n" +
				 "2) Visualizar tabla salas \n" + 
				 "3) Visualizar tabla películas \n");
		opcionUsuario=sc.nextInt();
		result(opcionUsuario, connection);
		break;
	}
}

}

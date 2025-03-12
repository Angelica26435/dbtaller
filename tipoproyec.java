import java.sql.*;
import java.util.Scanner;

// Clase para la conexion a la base de datos dbtaller
class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/dbtaller";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    // Clase para INSERT
    static class insert {
        public void insertar(String nombre_tipo) {
            String sql = "INSERT INTO tipoproyec (nombre_tipo) VALUES (?)";
            try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre_tipo);
                stmt.executeUpdate();
                System.out.println("Nombre de tipo de proyecto insertado con exito.");
            } catch (SQLException e) {
                System.out.println("Error al insertar: " + e.getMessage());
            }
        }
    }

    // Clase READ
    static class read {
        public void leer() {
            String sql = "SELECT * FROM tipoproyec";
            try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("CLAVE: " + rs.getInt("clave_tipo") + ", Nombre: " + rs.getString("nombre_tipo"));
                }
            } catch (SQLException e) {
                System.out.println("Error al leer: " + e.getMessage());
            }
        }
    }

    // Clase UPDATE
    static class update {
        public void actualizar(int clave_linea, String nombre_tipo) {
            String sql = "UPDATE tipoproyec SET nombre_tipo = ? WHERE clave_tipo = ?";
            try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre_tipo);
                stmt.setInt(2, clave_linea);
                int filas = stmt.executeUpdate();
                if (filas > 0) {
                    System.out.println(" Tipo de proyecto actualizada con exito");
                } else {
                    System.out.println("No se encontro la clave" + clave_linea);
                }
            } catch (SQLException e) {
                System.out.println("Error al actualizar: " + e.getMessage());
            }
        }
    }

    // Clase DELETE
    static class delete {
        public void eliminar(int clave_tipo) {
            String sql = "DELETE FROM tipoproyec WHERE clave_tipo = ?";
            try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, clave_tipo);
                int filas = stmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("Tipo de proyecto eliminada con exito.");
                } else {
                    System.out.println("No se encontro la clave  " + clave_tipo);
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar: " + e.getMessage());
            }
        }
    }

    // METODO MAIN PARA CASE EN CONSOLA AKI :)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        insert insertar = new insert();
        read leer = new read();
        update actualizar = new update();
        delete eliminar = new delete();

        // Menu para seleccionar la operacion
        while (true) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Insertar tipo de proyecto");
            System.out.println("2. Leer todos los tipos de proyectos");
            System.out.println("3. Actualizar tipos de proyectos");
            System.out.println("4. Eliminar tipo de proyecto");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Insertar
                    System.out.print("Ingrese el nombre del tipo de proyecto: ");
                    String nombre_tipo = scanner.nextLine();
                    insertar.insertar(nombre_tipo);
                    break;

                case 2:
                    // Leer
                    leer.leer();
                    break;

                case 3:
                    // Actualizar
                    System.out.print("Ingrese la clave a actualizar ");
                    int clave_actualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de linea
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    actualizar.actualizar(clave_actualizar, nuevoNombre);
                    break;

                case 4:
                    // Eliminar
                    System.out.print("Ingrese la clave a eliminar: ");
                    int clave_eliminar = scanner.nextInt();
                    eliminar.eliminar(clave_eliminar);
                    break;

                case 5:
                    // Salir
                    System.out.println(" GUD BAY");
                    scanner.close();
                    return;

                default:
                    System.out.println("OPCION NO VALIDA");
            }
        }
    }
}

 HEAD
- Crear la base de datos dbtaller y la tabla tipoproyec

Modificar las credenciales en la clase Conexion si es necesario.
private static final String URL = "jdbc:mysql://localhost:3306/dbtaller";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
EN EL MENU MUESTRA LAS OPCIONES QUE TIENE DENTRO DEL CODIGO
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

            EN DONDE SE PUDE SELECCCIONAR DE ACUERDO A LAS NECESIDADES DEL USUARIO 
            Y AUTOMATICAMENTE SE VERAN REFLEJADOS DICHOS CAMBIOS DENTRO DE MYSQL 
       
PROFESOR
TABLA
SE COLOCA LAS CONEXIONES DENTRO DE LA CLASE
CONEXION
- MENU MUESTRA OPCIONES PARA SU SELECCION DEL USUARIO
- CONFIGURA O AGREGA AL MYSQL 
CONECTION
13de627 (SUBIENDO PROFESOR.JAVA Y README)

package DAOs;

import java.sql.*;



public class ConexionSQLServer {



    // URL de conexión con credenciales, cifrado SSL y confianza en el certificado

    private String url;



    // Constructor para inicializar la URL de la base de datos

    public ConexionSQLServer(String host, int puerto, String dbName, String usuario, String contrasena) {

        this.url = "jdbc:sqlserver://" + host + ":" + puerto + ";databaseName=" + dbName +

                ";encrypt=true;trustServerCertificate=true;user=" + usuario + ";password=" + contrasena;

    }



    // Método para conectar a la base de datos

    private Connection conectar() throws SQLException {

        try {

            // Cargar el driver JDBC (no necesario en las versiones más recientes de Java, si está configurado en pom.xml)

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Error al cargar el driver JDBC.");

            e.printStackTrace();

            return null;

        }

        // Establecer la conexión

        return DriverManager.getConnection(url);

    }



    // Método para realizar una consulta SELECT

    public ResultSet obtenerDatos(String query) {

        Connection conn = null;

        Statement stmt = null;

        ResultSet rs = null;

        try {

            conn = conectar();

            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

        } catch (SQLException e) {

            System.out.println("Error al ejecutar la consulta SELECT.");

            e.printStackTrace();

        }

        return rs; // El ResultSet debe ser procesado por el llamador

    }



    // Método para insertar datos

    public int insertarDatos(String query) {

        Connection conn = null;

        Statement stmt = null;

        int filasAfectadas = 0;

        try {

            conn = conectar();

            stmt = conn.createStatement();

            filasAfectadas = stmt.executeUpdate(query);  // Devuelve el número de filas afectadas

        } catch (SQLException e) {

            System.out.println("Error al insertar datos.");

            e.printStackTrace();

        }

        return filasAfectadas;  // Devuelve el número de filas insertadas

    }



    // Método para modificar datos (UPDATE)

    public int modificarDatos(String query) {

        Connection conn = null;

        Statement stmt = null;

        int filasAfectadas = 0;

        try {

            conn = conectar();

            stmt = conn.createStatement();

            filasAfectadas = stmt.executeUpdate(query);  // Devuelve el número de filas afectadas

        } catch (SQLException e) {

            System.out.println("Error al modificar datos.");

            e.printStackTrace();

        }

        return filasAfectadas;  // Devuelve el número de filas modificadas

    }



    // Método para eliminar datos (DELETE)

    public int eliminarDatos(String query) {

        Connection conn = null;

        Statement stmt = null;

        int filasAfectadas = 0;

        try {

            conn = conectar();

            stmt = conn.createStatement();

            filasAfectadas = stmt.executeUpdate(query);  // Devuelve el número de filas afectadas

        } catch (SQLException e) {

            System.out.println("Error al eliminar datos.");

            e.printStackTrace();

        }

        return filasAfectadas;  // Devuelve el número de filas eliminadas

    }

}


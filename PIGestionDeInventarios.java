
package pigestiondeinventarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PIGestionDeInventarios {
    Connection conexion;
    private String nombreUsuario;
    
    public PIGestionDeInventarios() {
        conectar(); // Llama al método conectar al crear una instancia de la clase
    }

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/piGestion_inventary", "root", "beacosta");
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException e) {
            throw new RuntimeException("Error al establecer conexión: " + e.getMessage(), e);
        }
    }

    public void autenticarUsuario(String usuario, String contraseña) {
        String query = "SELECT rol FROM Usuarios WHERE usuario = ? AND contraseña = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String rol = rs.getString("rol");
                nombreUsuario = usuario; // Guarda el nombre del usuario autenticado
                if (rol.equals("usuario")) {
                    abrirFrameUsuario();
                } else if (rol.equals("administrador")) {
                    abrirFrameAdministrador();
                }
            } else {
                mostrarMensajeError();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al autenticar usuario: " + e.getMessage(), e);
        }
    }

    private void abrirFrameUsuario() {
        FrameUsuario frameUsuario = new FrameUsuario();
        frameUsuario.setNombreUsuario(nombreUsuario);
        frameUsuario.setVisible(true);
    }

    private void abrirFrameAdministrador() {
        FrameAdministrador frameAdmin = new FrameAdministrador();
        frameAdmin.setVisible(true);
    }

    private void mostrarMensajeError() {
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
    }
    // Método para establecer el nombre del usuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}

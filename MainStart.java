
package pigestiondeinventarios;

public class MainStart extends PIGestionDeInventarios {
    public static void main(String[] args) {
        // Crear una instancia de LogIn para iniciar la interfaz de inicio de sesión
        LogIn login = new LogIn();
        login.setVisible(true);
    }
}





/*package pigestiondeinventarios;

import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainStart extends PIGestionDeInventarios {
    public static void main(String[] args) {
        // Crear una instancia de LogIn para iniciar la interfaz de inicio de sesión
        LogIn login = new LogIn();
        login.setVisible(true);

        // Iniciar la comunicación con Arduino
        try {
            ComunicacionArduinoJava comunicacionArduino = new ComunicacionArduinoJava();
        } catch (PortInUseException | UnsupportedCommOperationException | IOException ex) {
            Logger.getLogger(MainStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
*/
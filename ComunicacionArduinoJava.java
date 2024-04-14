package pigestiondeinventarios;

import ConexionSerial.ConexionSerialJrIng;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;

public class ComunicacionArduinoJava {

    private UidRFID interfaz;   
    
    ConexionSerialJrIng Serial;

     
     
    public ComunicacionArduinoJava() throws PortInUseException, UnsupportedCommOperationException, IOException {
        Serial = new ConexionSerialJrIng(9600, "COM5");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String Mensaje = "";
                while (true) {
                    Mensaje = Serial.SerialRead();
                    if (!Mensaje.isEmpty()) {
                        System.out.println(Mensaje);
                        if (interfaz != null) {
                            interfaz.actualizarLabel(Mensaje);
                        }
                        Mensaje = "";
                    }
                }
            }
        }).start();

    }
    
    
    public void setInterfaz(UidRFID interfaz) {
        this.interfaz = interfaz;
    }
    
    /*public static void main(String[] args) {
        try {
            // Crear una instancia de la clase ComunicacionArduinoJava
            ComunicacionArduinoJava comunicacion = new ComunicacionArduinoJava();
            
            // Mantener el programa en ejecución para recibir datos continuamente
            // Esto puede ser un bucle infinito o puedes definir alguna lógica de salida
            while (true) {
                // Esto mantendrá el programa en ejecución para recibir datos
            }
            
        } catch (PortInUseException | UnsupportedCommOperationException | IOException e) {
            e.printStackTrace();
            System.out.println("Error al iniciar la comunicación con Arduino.");
        }
    }*/
}


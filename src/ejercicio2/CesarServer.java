package ejercicio2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CesarServer {
    public static void main(String[] args) {
        try {
            // Inicia el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Crea una instancia del servicio
            CesarService cesarService = new CesarServiceImpl();

            // Vincula la instancia al registro RMI
            Naming.rebind("CesarService", cesarService);

            System.out.println("Servidor RMI Cesar listo.");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
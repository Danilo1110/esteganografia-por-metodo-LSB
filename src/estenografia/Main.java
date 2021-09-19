/*

 */
package estenografia;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author jchierro
 */
public class Main {

    /**
     * MAIN DEL PROYECTO
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Main x = new Main(); int opc;
        
        do {
            opc = x.menu();
            
            switch (opc) {
                case 1:
                    x.introducirMensaje();
                    break;
                case 2:
                    x.leerMensaje();
                    break;
                case 3:
                    break;
            }
        } while (opc != 3);
          
    }
    
    public int menu() {
        System.out.println("\n CODIGO DE ESTENOGRAFIA POR METODO LSB BY DAN");
        System.out.println("▶▶▶▶▶ MENU DE OPCIONES ◀◀◀◀◀");
        System.out.println("● 1. INGRESAR MESANJE DE TEXTO OCULTO EN UNA IMAGEN PORTADOR...");
        System.out.println("● 2. LEER MENSAJE OCULTO EN LA IMAGEN PORTADORA...");
        System.out.println("● 3. SALIR... \n");
        System.out.print("INGRESE EL NUMERO DE OCPION DEL MENU DE OPCIONES: ");
        
        return Entrada.entero();
    }

    public void introducirMensaje() throws IOException {
        System.out.println("\nOPCIÓN 1: INGRESAR MESANJE DE TEXTO OCULTO EN UNA IMAGEN PORTADOR... ");
        System.out.print("INGRESE LA RUTA COMPLETA DE LA IMAGEN PORTADORA: ");
        String nombre = Entrada.cadena();
        System.out.print("INGRESE EL MENSAJE DE TEXTO QUE SE OCULTARÁ EN LA IMAGEN PORTADORA: ");
        String mensaje = Entrada.cadena();
        
        EsteganografíaLSB x = new EsteganografíaLSB(ImageIO.read(new File(nombre)));
        x.introducirMensaje(mensaje);
        System.out.println("EL MENSAJE DE TEXTO SE HA OCULTADO CON EXITO EN LA IMAGEN PORTADORA \n");
    }
    
    public void leerMensaje() throws IOException {
        System.out.println("\nOPCIÓN 2: LEER MENSAJE OCULTO EN LA IMAGEN PORTADORA... ");
        System.out.print("INGRESE LA RUTA COMPLETA DE LA IMAGEN EN DONDE SE HA OCULTADO EL MENSAJE: ");
        String nombre = Entrada.cadena();
        //System.out.println("Introduzca el mensaje para introducir en la imagen (Ejemplo: hola mundo!).");
        //String mensaje = Entrada.cadena();
        
        EsteganografíaLSB x = new EsteganografíaLSB(ImageIO.read(new File(nombre)));
        System.out.print("EL MENSAJE OCULTO EN LA IMAGEN PORTADORA ES: " + x.leerMensaje() + "\n");
    }
}

package codigo;
import java.io.*;

public class Clave {


    public static void writeArchivoClave(int clave, String rutaArchivo) {

        //File crea un objeto de tipo archivo. CON ESTO NO SE CREA UN ARCHIVO TODADVIA

        File archivoClave = new File(rutaArchivo+"\\"+"claveDesplazamiento.txt");
        try {
            //crea el archivo
            PrintWriter salidaC = new PrintWriter(archivoClave);
            salidaC.println(clave);
            salidaC.close();
            System.out.println("Se creo y se escribio la clave de desplazamiento en el claveDesplazamiento.txt");
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
            System.out.println("No se creo el archivo, ni se inserto el texto en claro");
        }


    }


    public static  void readArchivoClave(String rutaArchivo){
        File archivoClave= new File(rutaArchivo+"\\"+"claveDesplazamiento.txt");

        try (FileReader lectorArchivo = new FileReader(archivoClave);

            BufferedReader lectorAlmacenado = new BufferedReader(lectorArchivo)) {
            String line1;
            while ((line1 = lectorAlmacenado.readLine()) != null) {
                int k = Integer.parseInt(line1);
                //System.out.println("Esto es k "+k);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}



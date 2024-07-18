package codigo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArchivoDesencriptado {
    public static void writeArchivoDesencriptado(String frase3, String rutaArchivo) {

        //File crea un objeto de tipo archivo. CON ESTO NO SE CREA UN ARCHIVO TODADVIA
        File archivoDesencriptado = new File(rutaArchivo+"\\"+"archivoDesencriptado.txt");

        try {
            //crea el archivo
            PrintWriter salidaD= new PrintWriter(archivoDesencriptado);
            salidaD.println(frase3);
            salidaD.close();
            System.out.println("Se creo y se escribio el mensaje desencriptado en el archivoDesencriptado.txt "+ frase3);
        }

        catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
            System.out.println("No se creo el archivo, ni se inserto el texto en claro");
        }

    }
}

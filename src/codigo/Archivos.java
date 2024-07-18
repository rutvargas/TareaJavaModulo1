package codigo;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Archivos {

        //Metodo Escribir Archivo
        public static void writeArchivo(String rutaArchivo, String nombreArchivo, String textoEnClaro) {
        //File crea un objeto de tipo archivo. CON ESTO NO SE CREA UN ARCHIVO TODADVIA
        File archivo = new File(rutaArchivo+"\\"+nombreArchivo);

        try {
            //crea el archivo
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(textoEnClaro);
            salida.close();
            System.out.println("Se creo y se escribio el texto en claro en el archivo correctamente: "+nombreArchivo);
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
            System.out.println("No se creo el archivo, ni se inserto el texto en claro");
        }

    }

    //Metodo Leer Archivo
    public  static void readArchivo(String rutaArchivo, String nombreArchivo){
        //creando un objeto de clase File
        File archivo = new File(rutaArchivo+"\\"+nombreArchivo);

        try (FileReader fileReader = new FileReader(archivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println("Esto es el texto en claro leido "+line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
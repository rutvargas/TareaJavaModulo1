package codigo;
import java.util.Scanner;//importando la clase Scanner
import static codigo.Archivos.*;
import static codigo.Cesar.frase2;
import static codigo.Clave.writeArchivoClave;
import static codigo.Clave.readArchivoClave;
import static codigo.ArchivoDesencriptado.writeArchivoDesencriptado;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);

        // Paso 1: Pedir al usuario que ingrese un texto en claro
        System.out.println("Ingrese un texto en claro:");
        String textoEnClaro = scanner.nextLine();
        //System.out.println(textoEnClaro);


        //System.out.println(textoEnClaro);
        // Paso 2: Pedir al usuario la dirección del archivo
        System.out.println("Especifique la dirección del archivo donde se guardará el texto en claro:");
        String rutaArchivo = scanner.nextLine();
        //System.out.println(rutaArchivo);



        // Paso 3: Pedir al usuario el nombre del archivo
        System.out.println("Especifique el nombre del archivo donde se guardará el texto en claro:");
        String nombreArchivo = scanner.nextLine();



        // Paso 4: Pedir clave
        System.out.println("Ingresa clave de desplazamiento: ");
        int clave=scanner.nextInt();
        //System.out.println(clave);


        //Llamando a los metodos de las otras clases
        writeArchivo(rutaArchivo,nombreArchivo,textoEnClaro);
        writeArchivoClave(clave,rutaArchivo);
        readArchivo(rutaArchivo,nombreArchivo);
        readArchivoClave(rutaArchivo);


        //Metodos de escribir en los archivos Desencriptado y Encripotado
        writeArchivoDesencriptado(textoEnClaro,rutaArchivo);


        System.out.println("Texto en claro: "+textoEnClaro);

        //Llamando a los metodos Encriptar y desencriptar
        Cesar cesar = new Cesar();
        cesar.encriptar(textoEnClaro, clave);
        cesar.desencriptar(clave);
        cesar.writeArchivoEncriptado(frase2,rutaArchivo);

        System.out.println(frase2);
    }



}
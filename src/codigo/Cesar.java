package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Cesar {

    // ALFABETO EN minusculas
    private static char[] ALPHABETMIN = {
            'a', 'á', 'â', 'ã', 'à',
            'b', 'c', 'd', 'e', 'é', 'ê',
            'f', 'g', 'h', 'i', 'í', 'î',
            'j', 'k', 'l', 'm', 'n', 'ñ',
            'o', 'ó', 'ô', 'õ', 'ò',
            'p', 'q', 'r', 's', 't',
            'u', 'ú', 'û', 'v', 'w', 'x', 'y', 'z',
            'ç', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ';', ' ', '$', '-', '_', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // ALFABETO EN mayusculas
    private static char[] ALPHABETMAY = {
            'A', 'Á', 'Â', 'Ã', 'À',
            'B', 'C', 'D', 'E', 'É', 'Ê',
            'F', 'G', 'H', 'I', 'Í', 'Î',
            'J', 'K', 'L', 'M', 'N', 'Ñ',
            'O', 'Ó', 'Ô', 'Õ', 'Ò',
            'P', 'Q', 'R', 'S', 'T',
            'U', 'Ú', 'Û', 'V', 'W', 'X', 'Y', 'Z',
            'Ç', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ';', ' ', '$', '-', '_', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // Variable de instancia para almacenar el mensaje encriptado
    public static String frase2;

    public void encriptar(String line, int k) {
        frase2 = "";

        // Cantidad de longitud de variables
        int m = line.length();
        int a = ALPHABETMIN.length;

        k = ((k % a) + a) % a;
        System.out.println("La clave positiva es: " + k);

        // Recorrer texto en claro
        for (int i = 0; i < m; i++) {
            char charTextoClaro = line.charAt(i);

            // Comparar cada char de texto en claro con cada char de ALPHABET
            for (int j = 0; j < a; j++) {
                if (charTextoClaro == ALPHABETMIN[j]) {
                    frase2 += ALPHABETMIN[(j + k) % a];
                } else if (charTextoClaro == ALPHABETMAY[j]) {
                    frase2 += ALPHABETMAY[(j + k) % a];
                }
            }
        }
    }

    public void desencriptar(int k) {
        // Declarar la variable que almacenará el mensaje desencriptado
        String frase3 = "";


        int m = frase2.length();
        int a = ALPHABETMIN.length;

        //System.out.println("La cantidad de caracteres de Texto en claro es: " + m);
        System.out.println("La cantidad de caracteres del abecedario es: " + a);

        k = ((k % a) + a) % a;
        System.out.println("La clave positiva es: " + k);

        // Recorrer texto encriptado
        for (int i = 0; i < m; i++) {
            char charTextoEncriptado = frase2.charAt(i);

            // Comparar cada char de texto encriptado con cada char de ALPHABET
            for (int j = 0; j < a; j++) {
                if (charTextoEncriptado == ALPHABETMIN[j]) {
                    frase3 += ALPHABETMIN[(j - k + a) % a];
                } else if (charTextoEncriptado == ALPHABETMAY[j]) {
                    frase3 += ALPHABETMAY[(j - k + a) % a];
                }
            }
        }
        System.out.println("Texto encriptado: "+ frase2);
        System.out.println("Texto desencriptado: " + frase3);
    }

    public static void writeArchivoEncriptado(String frase4, String rutaArchivo) {

        //File crea un objeto de tipo archivo. CON ESTO NO SE CREA UN ARCHIVO TODADVIA
        File archivoEncriptado = new File(rutaArchivo+"\\"+"archivoEncriptado.txt");
    try {
            //crea el archivo
            PrintWriter salidaC= new PrintWriter(archivoEncriptado);
            salidaC.println(frase2);
            salidaC.close();

    }
    catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
            System.out.println("No se creo el archivo, ni se inserto el texto en claro"); }
    }


}
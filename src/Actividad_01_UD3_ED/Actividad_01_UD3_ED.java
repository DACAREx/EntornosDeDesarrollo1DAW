package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Programa que lee el contenido de un archivo de texto/binario
 * utilizando FileInputStream y BufferedInputStream
 * Demuestra el funcionamiento de lectura por bloques usando un búfer (memoria intermedia)
 * @author ana
 */

public class Actividad_01_UD3_ED 
{
    // Aquí guardamos temporalmente lo que se va leyendo del archivo, mediante un array.
    private static byte[] intermedio = new byte[1000];

    // Nombre del archivo que se va a leer.
    private static String NombreArchivo = "fichero.dat";
    
    // Flujo para leer el archivo directamente.
    private static FileInputStream FlujoDeEntrada = null;
   
    // Flujo que guarda varios datos de golpe para que leer del archivo sea más rápido.
    private static BufferedInputStream IntermedioEntrada = null;
    
    /**
         * Abre el archivo y prepara los objetos necesarios para leerlo.
     */
    public static void IniciarFicheros() throws FileNotFoundException
    {
        FlujoDeEntrada = new FileInputStream(NombreArchivo);
        IntermedioEntrada = new BufferedInputStream(FlujoDeEntrada);
    }
    /**
         * Lee el archivo poco a poco y lo muestra por pantalla.
         * Devuelve cuántos bytes se han leído en total.
         */
    public static int MostrarTextoFichero() throws IOException
    {
        int total = 0; // Para saber cuántos bytes hemos leído al final.
        int numLeer = 0; // Lo que leemos en cada vuelta del bucle.
        
        // Mientras queden cosas por leer…
        while((numLeer = FlujoDeEntrada.read(intermedio)) != -1) 
        {
            // Mostramos solo lo que se ha leído esta vez.
            System.out.println(new String(intermedio));        
            // Sumamos lo leído a la cuenta final.
            total += numLeer;
        }
        
        return total;
    }
    public static void main(String[] args) 
    {        
        try 
        { 
             // Abrimos el archivo.
            IniciarFicheros();
            
            // Mostramos el contenido y contamos los bytes.
            int total = MostrarTextoFichero();           

            // Mostramos cuántos bytes se han leído en total.
            System.out.println("\nLeidos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            // Si algo sale mal al leer, mostramos el error.
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            { 
                // Cerramos los flujos si siguen abiertos.
                if( IntermedioEntrada != null && FlujoDeEntrada != null )
                {
                    FlujoDeEntrada.close();
                    IntermedioEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                // Si falla el cierre del archivo, también lo avisamos.
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}

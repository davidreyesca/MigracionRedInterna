package Controlador;

import Vista.IndexarDocumentos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LecturaEscritura
{
    static String[] URLsCopias;
    static String[] URLsServidor;
    static String[] NombresArchivosServidor;
    static int numeroCopias=0;
    static int NoExpe;
    static String direccion;    
    static final Logger LOGGER = Logger.getAnonymousLogger(); 
    
    public static void setDireccion(String direccion)
    {
        LecturaEscritura.direccion=direccion;
    }
    
    public static void Obtenerdatos(String[]URLs) throws Exception
    {
        NoExpe = BDdocumentos.getNoExpediente();
        URLsCopias = URLs;
        int tamañoArreglo = URLsCopias.length;
        URLsServidor = new String[tamañoArreglo];
        NombresArchivosServidor = new String[tamañoArreglo];
        for (int i = 0; i < tamañoArreglo; i++) 
        {           
            URLsServidor[i]= ValoresInicialesPrograma.getCarpetaArchivosServidor() + NoExpe + "//";
        }
        for (int i = 0; i < tamañoArreglo; i++) 
        {   
            File fichero = new File(URLsCopias[i]);
            String nombreArchivoNuevo = fichero.getName();
            NombresArchivosServidor[i]=nombreArchivoNuevo;
            URLsServidor[i]=URLsServidor[i]+nombreArchivoNuevo;
        }
        for (int i = 0; i < tamañoArreglo; i++) 
        {
            PasarDatosFichero(URLsCopias[i]);
            numeroCopias++;
        }
        BDdocumentos.setCarpetaServidor(URLsServidor);
        BDdocumentos.setNombresArchivos(NombresArchivosServidor);
        BDdocumentos.continuarOperacion();
    }

    static public void PasarDatosFichero(String OrigenArchivo)
    {
        File fichero = new File(OrigenArchivo);
        String nombreOrigenArchivo = fichero.getName();
        System.out.println("Origen: " + OrigenArchivo);
        System.out.println("Destino: " + direccion + nombreOrigenArchivo);
        IndexarDocumentos.jInformacionActual.setText("Copiando archivo(s)...");
        copiarArchivo(OrigenArchivo, direccion + nombreOrigenArchivo);
    }
    
    public static void copiarArchivo(String origenArchivo, String destinoArchivo) 
    {
        try 
        {
            Path origenPath = Paths.get(origenArchivo);
            Path destinoPath = Paths.get(destinoArchivo);
            //sobreescribir el fichero de destino si existe y lo copia
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);      
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Hubo un problema al tratar de copiar los archivos");
            BDdocumentos.cerrarOperacion();
            EliminarContenidoCarpetas.iniciar(ValoresInicialesPrograma.getCarpetaArchivosLocalLectura());
        } catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, "Hubo un problema al tratar de copiar los archivos");
            BDdocumentos.cerrarOperacion();
            EliminarContenidoCarpetas.iniciar(ValoresInicialesPrograma.getCarpetaArchivosLocalLectura());
        }
        File af = new File(destinoArchivo);
            if(af.exists())
            {
                System.out.println("¡Se ha copiado el archivo exitosamente el archivo en el destino: " + destinoArchivo +"!" );
            }else
            {
                System.out.println("Hubo un problema al copiar el archivo");
            }
    }
}

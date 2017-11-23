package Controlador;

import java.io.File;
/**
 * Clase encargada de verificar que las rutas necesarias para el funcionamiento del sistema existan, y si no se encarga de crearlas.
 * @author David Reyes
 */

public class ValoresInicialesPrograma 
{
//    final static private String CarpetaArchivosFinal = "C:\\wamp\\www";
//    final static private String CarpetaArchivosFinal = "C:\\xampp\\htdocs";
    final static private String CarpetaArchivosFinal = "I:\\";
//    final static private String CarpetaArchivosLocalCompresos = "C:\\EBPConsultores\\Enviar";
    final static private String CarpetaArchivosLocalLectura = "C:\\EBPConsultores\\Lectura";
    final static File folderLocal = new File(CarpetaArchivosFinal);
//    final static File folderLocalCompresos = new File(CarpetaArchivosLocalCompresos);
    final static File folderLocalLectura = new File(CarpetaArchivosLocalLectura);
//    final static String FicheroZipLocal= CarpetaArchivosLocalCompresos + "\\compreso.zip";
    final static String CarpetaCopiaTemporalArchivos= CarpetaArchivosFinal;
    
//    final static int PuertoSalidaArchivosCompresos= 9999;
//    final static int PuertoEntradaInformacionServidor= 9090;
    
//    final static String IPServidor="localhost";
//    final static String CarpetaArchivosServidor = "http://localhost//";
    
//    //Este es el chido
    final static String IPServidor="192.168.1.10";
    final static String CarpetaArchivosServidor = "http://192.168.1.10//";
    
//    final static String IPServidor="192.168.1.81";
//    final static String CarpetaArchivosServidor = "http://192.168.1.81//";
    


    /**
     * Getters publicos del sistema.
     * @return CarpetaArchivosServidor
     */    
//    public static int getPuertoSalidaArchivosCompresos() {
//        return PuertoSalidaArchivosCompresos;
//    }

    public static String getIPServidor() {
        return IPServidor;
    }
//    public static int getPuertoEntradaInformacionServidor() {
//        return PuertoEntradaInformacionServidor;
//    }
    public static String getCarpetaArchivosServidor() 
    {
        return CarpetaArchivosServidor;
    }
    public static File getfolderLocal() 
    {
        return folderLocal;
    }
    public static File getfolderLocalLectura() 
    {
        return folderLocalLectura;
    }
    public static String getCarpetaArchivosLocalLectura() 
    {
        return CarpetaArchivosLocalLectura;
    }
    public static String getCarpetaArchivosFinal() 
    {
        return CarpetaArchivosFinal;
    }
    public static String getCarpetaCopiaTemporalArchivos() 
    {
        return CarpetaCopiaTemporalArchivos;
    }
//    public static String getFicheroZipLocal() 
//    {
//        return FicheroZipLocal;
//    }
    
    /**
     * Metodo encargado de verificar que existan los directorios, o crearlos.
     */
    public static void ValidandoCreacionCarpetas() 
    {
        boolean validacion = false;
        if (folderLocal.isDirectory()) 
        {
            System.out.println("Todo bien, puede continuar, su folder local existe");
        }
        else
        {
            folderLocal.mkdirs();
            validacion = true;
        }
        if (folderLocalLectura.isDirectory()) 
        {
            System.out.println("Todo bien, puede continuar, su folder lectura existe");
        }
        else
        {
             folderLocalLectura.mkdirs();
        }
    }
    
    public static void LimpiandoArea() 
    {
        EliminarContenidoCarpetas.iniciar(CarpetaArchivosLocalLectura + "\\");
    }
}

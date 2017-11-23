
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class CopiarServidorArchivo 
{
    static public void CopiarNuevoArchivo(String URL, int NoExpediente) throws IOException
    {
       String origenArchivo= URL;
       File fichero = new File(URL);
       String NombreArchivo = fichero.getName();
       String destinoArchivo= ValoresInicialesPrograma.getCarpetaArchivosFinal() + "\\" + String.valueOf(NoExpediente) + "\\" + NombreArchivo;
       if(copyFile(origenArchivo, destinoArchivo)==true)
       {
           JOptionPane.showMessageDialog(null, "Se han copiado al servidor exitosamente los archivos");
       }else
       {
           JOptionPane.showMessageDialog(null, "Hubo un error al copiar los archivos");
       }
    }
    
    static public boolean copyFile(String fromFile, String toFile) throws FileNotFoundException, IOException {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            InputStream in = new FileInputStream(origin);
            OutputStream out = new FileOutputStream(destination);
            // We use a buffer for the copy (Usamos un buffer para la copia).
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            return true;
        } else {
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class EliminarExpedienteCompleto 
{
    static int NoExpediente=0;
    public static void Iniciar(int NoExpediente)
    {
        EliminarExpedienteCompleto.NoExpediente = NoExpediente;
        String CarpetaEliminar = ValoresInicialesPrograma.getCarpetaArchivosFinal() + "\\" + String.valueOf(NoExpediente);
        funcionEliminarCarpeta (new File (CarpetaEliminar));
        JOptionPane.showMessageDialog(null, "Se he eliminado satisfactoriamente el Expediente " + String.valueOf(NoExpediente));
    }
    
    private static void funcionEliminarCarpeta(File pArchivo) 
    {
        if (!pArchivo.exists()) 
        {     
            return; 
        }
        if (pArchivo.isDirectory()) 
        {
            for (File f : pArchivo.listFiles()) 
            {
                funcionEliminarCarpeta(f);  
            }
        }
        pArchivo.delete();
    }
}

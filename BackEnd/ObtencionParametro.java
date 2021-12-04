
package BackEnd;

import Dato.Parametro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ObtencionParametro {
    public static void obtenerParametro(List<Parametro> tabla)
            throws Exception{
        FileReader fr = null;
        BufferedReader br = null;
        Parametro parametro = null;
        
        int id;
        
        JFileChooser ventanaArchivo = new JFileChooser();
        ventanaArchivo.setFileSelectionMode(
                JFileChooser.FILES_ONLY
        );
        int resultado = ventanaArchivo.showOpenDialog(
                            new JPanel()
                        );
        
        if(resultado == JFileChooser.APPROVE_OPTION){
            File archivo = ventanaArchivo.getSelectedFile();
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea=br.readLine()) != null){
                String[] campos = linea.split(",");
                
                id = campos[0].equals("") ?
                        0 :
                        Integer.parseInt(campos[0]);
                
                parametro = new Parametro(
                        id,
                        campos[1],
                        campos[2]
                );
                tabla.add(parametro);
            }
        }
        try{
            br.close();
            fr.close();
        }
        catch(IOException ex){
            
        }
    }
}

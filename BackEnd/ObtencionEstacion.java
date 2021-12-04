
package BackEnd;

import Dato.Estacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ObtencionEstacion {
    public static void obtenerEstacion(List<Estacion> tabla)
            throws Exception{
        FileReader fr = null;
        BufferedReader br = null;
        Estacion estacion = null;
        
        double longitud,
               latitud;
        int altitud;
        long id;
        
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

                longitud = campos[2].equals("") ? 
                                0 : 
                                Double.parseDouble(campos[2]);
                latitud = campos[3].equals("") ? 
                                0 : 
                                Double.parseDouble(campos[3]);
                altitud = campos[4].equals("") ? 
                                0 : 
                                Integer.parseInt(campos[4]);
                id = campos[6].equals("") ? 
                                0 : 
                                Long.parseLong(campos[6]);

                estacion = new Estacion(
                        campos[0],
                        campos[1],
                        longitud,
                        latitud,
                        altitud,
                        campos[5],
                        id
                );
                tabla.add(estacion);
            }
            try{
                br.close();
                fr.close();
            } catch (IOException ex) {
                
            }
        }
    }
}

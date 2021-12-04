
package BackEnd;

import Dato.Estacion;
import Dato.Parametro;
import Dato.Unidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TransformacionContaminantes {
    public static void transformarContaminantes(
            List<Estacion> estaciones,
            List<Parametro> parametros, List<Unidad> unidades)
            throws Exception{
        FileReader fr = null;
        BufferedReader br = null;
        String linea,
               campos[],
               tiempo[],
               fecha[],
               horas[];
        
        int id = 1,
            anio,
            mes,
            dia,
            hora,
            minuto;
        String estacion,
               parametro,
               unidad;
        float valor;
        
        JFileChooser ventanaArchivo = new JFileChooser();
        ventanaArchivo.setFileSelectionMode(
                JFileChooser.FILES_ONLY
        );
        ventanaArchivo.setMultiSelectionEnabled(true);
        int resultado = ventanaArchivo.showOpenDialog(
                            new JPanel()
                        );
        
        if(resultado == JFileChooser.APPROVE_OPTION){
            PrintWriter write = new PrintWriter("./Contaminantes.csv","UTF-8");
            write.println(
                    "ID,"+
                    "Anio,"+
                    "Mes,"+
                    "Dia,"+
                    "Hora,"+
                    "Minuto,"+
                    "Estacion,"+
                    "Parametro,"+
                    "Valor,"+
                    "Unidad"
            );
            
            File[] archivos = ventanaArchivo.getSelectedFiles();
            for(int i=0; i<archivos.length; i++){
                fr = new FileReader(archivos[i]);
                br = new BufferedReader(fr);
            
                while((linea=br.readLine()) != null){
                    campos = linea.split(",");
                    
                    if(!campos[3].equals("")){
                        tiempo = campos[0].split(" ");
                        fecha = tiempo[0].split("/");
                        horas = tiempo[1].split(":");
                        dia = Integer.parseInt(fecha[0]);
                        mes = Integer.parseInt(fecha[1]);
                        anio = Integer.parseInt(fecha[2]);
                        hora = Integer.parseInt(horas[0]);
                        minuto = Integer.parseInt(horas[1]);
                        estacion = buscarEstacion(
                                        estaciones, campos[1]
                                   );
                        parametro = buscarParametro(
                                        parametros,campos[2]
                                    );
                        valor = Float.parseFloat(campos[3]);
                        unidad = buscarUnidad(
                                    unidades,
                                    Integer.parseInt(
                                        campos[4]
                                    )
                                 );
                        write.println(
                                (id++)+","+
                                anio+","+
                                mes+","+
                                dia+","+
                                hora+","+
                                minuto+","+
                                estacion+","+
                                parametro+","+
                                valor+","+
                                unidad+","
                        );
                    }
                }
                try{
                    fr.close();
                    br.close();
                } catch(IOException ex){
                    
                }
            }
            write.close();
        }
    }
    
    public static String buscarEstacion(List<Estacion> tabla,
            String cve){
        for(int i=0; i<tabla.size(); i++)
            if(tabla.get(i).getCVE().equals(cve))
                return tabla.get(i).getNombre();
        return "";
    }
    
    public static String buscarParametro(List<Parametro> tabla,
            String cve){
        for(int i=0; i<tabla.size(); i++)
            if(tabla.get(i).getCVE().equals(cve))
                return tabla.get(i).getNombre();
        return "";
    }
    
    public static String buscarUnidad(List<Unidad> tabla,
            int id){
        for(int i=0; i<tabla.size(); i++)
            if(tabla.get(i).getID() == id)
                return tabla.get(i).getClave();
        return "";
    }
}

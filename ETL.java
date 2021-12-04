
import BackEnd.ObtencionEstacion;
import BackEnd.ObtencionParametro;
import BackEnd.ObtencionUnidades;
import BackEnd.TransformacionContaminantes;
import Dato.Estacion;
import Dato.Parametro;
import Dato.Unidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ETL {

    public static void main(String[] args) {
        List<Estacion> estaciones = new ArrayList<Estacion>();
        List<Parametro> parametros = new ArrayList<Parametro>();
        List<Unidad> unidades = new ArrayList<Unidad>();
        
        
        
        try{
            JOptionPane.showMessageDialog(
                    null, "Ingrese su archivo de estaciones", 
                    "Estaciones", JOptionPane.INFORMATION_MESSAGE
            );
            
            ObtencionEstacion.obtenerEstacion(estaciones);
            
            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese su archivo de parametros",
                    "Parametros",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            ObtencionParametro.obtenerParametro(parametros);
            
            JOptionPane.showMessageDialog(
                    null, "Ingrese su archivo de unidades",
                    "Unidades", JOptionPane.INFORMATION_MESSAGE
            );
            
            ObtencionUnidades.obtenerUnidad(unidades);
            
            JOptionPane.showMessageDialog(
                    null, "Ingrese su archivo de registros",
                    "Registros", JOptionPane.INFORMATION_MESSAGE
            );
            
            TransformacionContaminantes
                    .transformarContaminantes(
                            estaciones,
                            parametros,
                            unidades
                    );
            
            JOptionPane.showMessageDialog(
                    null,
                    "Los datos se han exportado correctamente",
                    "Exportación completa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null, "No se pudo leer el archivo",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
}

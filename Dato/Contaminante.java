package Dato;


public class Contaminante {
    private int id,
                anio,
                mes,
                dia,
                hora,
                minuto;
    private String estacion,
                   parametro,
                   unidad;
    private float valor;
    
    public Contaminante(int id, int anio, int mes, int dia,
            int hora, int minuto, String estacion,
            String parametro, float valor, String unidad){
        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.estacion = estacion;
        this.parametro = parametro;
        this.valor = valor;
        this.unidad = unidad;
    }
    
    public Contaminante(Contaminante copia){
        this.id = copia.id;
        this.anio = copia.anio;
        this.mes = copia.mes;
        this.dia = copia.dia;
        this.hora = copia.hora;
        this.minuto = copia.minuto;
        this.estacion = copia.estacion;
        this.parametro = copia.parametro;
        this.valor = copia.valor;
        this.unidad = copia.unidad;
    }
    
    public int getID(){
        return id;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getHora(){
        return hora;
    }
    
    public int getMinuto(){
        return minuto;
    }
    
    public String getEstacion(){
        return estacion;
    }
    
    public String getParametro(){
        return parametro;
    }
    
    public float getValor(){
        return valor;
    }
    
    public String getUnidad(){
        return unidad;
    }
}

package Dato;


public class Estacion {
    private String cve,
                   nombre,
                   obs;
    private double longitud,
                   latitud;
    private int altitud;
    private long id;
    
    public Estacion(String cve, String nombre, double longitud,
            double latitud, int altitud, String obs, long id){
        this.cve = cve;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.altitud = altitud;
        this.obs = obs;
        this.id = id;
    }
    
    public Estacion(Estacion copia){
        this.cve = copia.cve;
        this.nombre = copia.nombre;
        this.longitud = copia.longitud;
        this.latitud = copia.latitud;
        this.altitud = copia.altitud;
        this.obs = copia.obs;
        this.id = copia.id;
    }
    
    public String getCVE(){
        return cve;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getLongitud(){
        return longitud;
    }
    
    public double getLatitud(){
        return latitud;
    }
    
    public int getAltitud(){
        return altitud;
    }
    
    public String getObs(){
        return obs;
    }
    
    public long getID(){
        return id;
    }
}

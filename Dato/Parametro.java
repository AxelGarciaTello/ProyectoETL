package Dato;

public class Parametro {
    private int id;
    private String cve,
                   nombre;
    
    public Parametro(int id, String cve, String nombre){
        this.id = id;
        this.cve = cve;
        this.nombre = nombre;
    }
    
    public Parametro(Parametro copia){
        this.id = copia.id;
        this.cve = copia.cve;
        this.nombre = copia.nombre;
    }
    
    public int getID(){
        return id;
    }
    
    public String getCVE(){
        return cve;
    }
    
    public String getNombre(){
        return nombre;
    }
}

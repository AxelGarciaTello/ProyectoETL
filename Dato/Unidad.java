package Dato;


public class Unidad {
    private int id;
    private String clave,
                   nombre;
    
    public Unidad(int id, String clave, String nombre){
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
    }
    
    public Unidad(Unidad copia){
        this.id = copia.id;
        this.clave = copia.clave;
        this.nombre = copia.nombre;
    }
    
    public int getID(){
        return id;
    }
    
    public String getClave(){
        return clave;
    }
    
    public String getNombre(){
        return nombre;
    }
}

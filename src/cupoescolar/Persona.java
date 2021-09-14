package cupoescolar;

public class Persona 
{
    protected String id, nombre, dir;
    protected int edad;

    public Persona(String id, String nombre, String dir, int edad) 
    {
        this.id = id;
        this.nombre = nombre;
        this.dir = dir;
        this.edad = edad;
    }

    public Persona() 
    {
    }   
}


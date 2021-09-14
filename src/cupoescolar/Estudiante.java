package cupoescolar;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class Estudiante extends Persona
{
    private String loc, fecha, op;
    private int curso, numloc, numloc1, opcion, a=0, c;
    private Boolean estado, estado1;
    private String ver;
    
    public void Archivo()
    { 
        File fil = new File("Estudiante.csv");
            try 
            {
                FileReader fr = new FileReader(fil);
                BufferedReader br = new BufferedReader(fr);
                
                while((ver = br.readLine()) != null)
                   {
                       StringTokenizer token = new StringTokenizer(ver,";");
                       while(token.hasMoreTokens())
                       {
                           id = token.nextToken();
                           nombre = token.nextToken();
                           fecha = token.nextToken();
                           edad = Integer.parseInt(token.nextToken());
                           dir = token.nextToken();
                           numloc = Integer.parseInt(token.nextToken());
                           curso = Integer.parseInt(token.nextToken());
                           estado = Boolean.parseBoolean(token.nextToken());
                           Escritura();
                       }
                       
                     
                    }
                JOptionPane.showMessageDialog(null,"El archivo se ha convertido exitosamente", "Conversión", JOptionPane.INFORMATION_MESSAGE);
                } 
            catch (IOException error) 
            {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
            finally
                    {
                        try 
                            {
                                FileReader fr = new FileReader(fil);
                                fr.close();
                            } 
                            catch (IOException error) 
                            {
                                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
    }
    
    
    public void Escritura()
    {
        FileOutputStream  fos = null;
        DataOutputStream dos = null;
        try
            {
            fos = new FileOutputStream("Estudiantes.dat",true);
            dos = new DataOutputStream(fos);
                dos.writeUTF(id);
                dos.writeUTF(nombre);
                dos.writeUTF(fecha);
                dos.writeInt(edad);
                dos.writeUTF(dir);
                dos.writeInt(numloc);
                dos.writeInt(curso);
                dos.writeBoolean(estado);
            }
        
        catch(FileNotFoundException Error2)
        {
            JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
        }
        catch(IOException Error1)
        {
            JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
        }
        catch(Exception Error3)
        {
            JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
        }
        finally{
            try{
                if(dos!=null){
                dos.close();
                }
                if(fos!=null){
                    fos.close();
                }

            }
            catch(IOException Error1){
                JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }
        }
    }
     
    public int Validacion(){
        String id2;
        int b=0;
        FileInputStream  fos = null;
        DataInputStream dos = null;
        
        try{
            fos = new FileInputStream("Estudiantes.dat");
            dos = new DataInputStream(fos);
            
            while(true)
            {
                id2 = dos.readUTF();
                nombre = dos.readUTF();
                fecha = dos.readUTF();
                edad = dos.readInt();
                dir = dos.readUTF();
                numloc = dos.readInt();
                curso = dos.readInt();
                estado = dos.readBoolean();
                if (id2.equals(id))
                {
                    JOptionPane.showMessageDialog(null, "El estudiante ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    b=1;
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
           
        } 
        catch (IOException ex) 
        {
            
        }
        finally{
            try{
                if(dos!=null){
                dos.close();
                }
                if(fos!=null){
                    fos.close();
                }

            }
            catch(IOException Error1){
                JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }
        }
        return b;
    }
            
            
    public void numLocalidad()
    {
        String[] op1 = { "1.Usaquén", "2.Chapinero", "3.Santa Fe", "4.San Cristóbal", "5.Usme", "6.Tunjuelito", "7.Bosa", "8.Kennedy", "9.Fontibón", "10.Engativá", "11.Suba", "12.Barrios Unidos", "13.Teusaquillo", "14.Los Mártires", "15.Antonio Nariño", "16.Puente Aranda", "17.La Candelaria", "18.Rafael Uribe Uribe", "19.Ciudad Bolívar", "20.Sumapaz"};
        op = (String) JOptionPane.showInputDialog(null,"Seleccione la localidad del estudiante", "Elegir",JOptionPane.QUESTION_MESSAGE,null,op1, op1[0]);
        if(op.equals("1.Usaquén"))
        {
            numloc = 1;
        }
        if(op.equals("2.Chapinero"))
        {
            numloc = 2;
        }
        if(op.equals("3.Santa Fe"))
        {
            numloc = 3;
        }
        if(op.equals("4.San Cristóbal"))
        {
            numloc = 4;
        }
        if(op.equals("5.Usme"))
        {
            numloc = 5;
        }
        if(op.equals("6.Tunjuelito"))
        {
            numloc = 6;
        }
        if(op.equals("7.Bosa"))
        {
            numloc = 7;
        }
        if(op.equals("8.Kennedy"))
        {
            numloc = 8;
        }
        if(op.equals("9.Fontibón"))
        {
            numloc = 9;
        }
        if(op.equals("10.Engativá"))
        {
            numloc = 10;
        }
        if(op.equals("11.Suba"))
        {
            numloc = 11;
        }
        if(op.equals("12.Barrios Unidos"))
        {
            numloc = 12;
        }
        if(op.equals("13.Teusaquillo"))
        {
            numloc = 13;
        }
        if(op.equals("14.Los Mártires"))
        {
            numloc = 14;
        }
        if(op.equals("15.Antonio Nariño"))
        {
            numloc = 15;
        }
        if(op.equals("16.Puente Aranda"))
        {
            numloc = 16;
        }
        if(op.equals("17.La Candelaria"))
        {
            numloc = 17;
        }
        if(op.equals("18.Rafael Uribe Uribe"))
        {
            numloc = 18;
        }
        if(op.equals("19.Ciudad Bolívar"))
        {
            numloc = 19;
        }
        if(op.equals("20.Sumapaz"))
        {
            numloc = 20;
        }


    }
            
    public void Registro()
    {
        JOptionPane.showMessageDialog(null, "A continuación se pedirá la \ninformación del estudiante \npara el registro", "Registro", JOptionPane.INFORMATION_MESSAGE);
        
        id = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE);
        c = Validacion();
        if(c == 1)
        {
            return;
        }
        nombre = JOptionPane.showInputDialog(null, "Ingrese los nombres del estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE);
        fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento del estudiante (dd/mm/aa)", "Registro", JOptionPane.INFORMATION_MESSAGE);
        dir = JOptionPane.showInputDialog(null, "Ingrese la dirección del estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE);
        numLocalidad();
        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE));
        curso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el curso al que aspira el estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE));
        
        while((11 < curso)||(curso < 1))
        {
            JOptionPane.showMessageDialog(null, "El curso ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
            curso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el curso al que aspira el estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE));
        }
        
        estado = false;

        Escritura();
    }
    
    
    public void Buscar1()
    {
        
        String id3 = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante que desea buscar", "Busquéda", JOptionPane.INFORMATION_MESSAGE);

        Localidad loca= new Localidad();
        FileInputStream  fis = null;
        DataInputStream dis = null;
        
        try
        {
            fis = new FileInputStream("Estudiantes.dat");
            dis = new DataInputStream(fis);
            
            while(true)
            {
                id = dis.readUTF();
                nombre = dis.readUTF();
                fecha = dis.readUTF();
                edad = dis.readInt();
                dir = dis.readUTF();
                numloc = dis.readInt();
                loc = loca.nombre(numloc);
                curso = dis.readInt();
                estado = dis.readBoolean();
                if(id3.equals(id))
                {
                    JOptionPane.showMessageDialog(null, "Codigo: "+id+" \nNombre: "+nombre+" \nFecha de nacimiento: "+fecha+" \nEdad: "+edad+" \nDirección: "+dir+" \nLocalidad: "+loc+" \nCurso: "+curso+" \nEstado de cupo: "+estado);  
                    a=1;
                }
            }
        } 
        catch (EOFException e) 
        {
            if(a == 0)
            {
                JOptionPane.showMessageDialog(null, "El estudiante no está registrado", "Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
             JOptionPane.showMessageDialog(null, "Fin del archivo", "Fin", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e) 
        {
             JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try
             {
                 if(dis != null)
                 {
                     dis.close();
                 }
                 if(fis != null)
                 {
                     fis.close();
                 }
             } 
             catch (IOException e) 
             {
                 JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
    }

    
    
    public void Buscar2()
    {
        numLocalidad();
        
        FileInputStream  fis = null;
        DataInputStream dis = null;
        
        String lista = "";
        int cont = 0;
        try
        {
            fis = new FileInputStream("Estudiantes.dat");
            dis = new DataInputStream(fis);
            
            while(true)
            {
                id = dis.readUTF();
                nombre = dis.readUTF();
                fecha = dis.readUTF();
                edad = dis.readInt();
                dir = dis.readUTF();
                numloc1 = dis.readInt();
                curso = dis.readInt();
                estado = dis.readBoolean();
                
                if(numloc==numloc1)
                 {
                    cont++;
                    lista = lista + " | " + id + " | " + nombre + " | " + fecha + " | " + edad + " | " + dir + " | " + numloc + " | " + curso  + " | " + estado + "\n";
                 }
                 if(cont == 20)
                 {
                     JOptionPane.showMessageDialog(null, lista);
                     cont = 0;
                     lista = "";
                 }
   
            }
        } 
        catch (EOFException e) 
        {
             if(cont != 0)
             {
                 JOptionPane.showMessageDialog(null, lista);
             }
             JOptionPane.showMessageDialog(null, "Fin del archivo", "Fin", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e) 
        {
             JOptionPane.showMessageDialog(null, "Error123", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try
             {
                 if(dis != null)
                 {
                     dis.close();
                 }
                 if(fis != null)
                 {
                     fis.close();
                 }
             } 
             catch (IOException e) 
             {
                 JOptionPane.showMessageDialog(null, "Error2", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
    }
    
    
    public void Buscar4()
    {
        String[] opc = {"Aprobado", "Pendiente"};
        opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion para continuar", "Cupos escolares", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
            switch(opcion)
            {
                case 0:
                    estado1 = true;
                break;
                    
                case 1:
                    estado1 = false;
                break;
            }
        
        FileInputStream  fis = null;
        DataInputStream dis = null;
        
        String lista = "";
        int cont = 0;
        try
        {
            fis = new FileInputStream("Estudiantes.dat");
            dis = new DataInputStream(fis);
            
            while(true)
            {
                id = dis.readUTF();
                nombre = dis.readUTF();
                fecha = dis.readUTF();
                edad = dis.readInt();
                dir = dis.readUTF();
                numloc1 = dis.readInt();
                curso = dis.readInt();
                estado = dis.readBoolean();
                 
                if(Objects.equals(estado1, estado))
                {
                    cont++;
                    lista = lista + " | " + id + " | " + nombre + " | " + fecha + " | " + edad + " | " + dir + " | " + numloc + " | " + curso  + " | " + estado + "\n";
                }

                if(cont == 20)
                {
                    JOptionPane.showMessageDialog(null, lista);
                    cont = 0;
                    lista = "";
                }
           
            }
        } 
        catch (EOFException e) 
        {
            if(cont != 0)
             {
                 JOptionPane.showMessageDialog(null, lista);
             }
             JOptionPane.showMessageDialog(null, "Fin del archivo", "Fin", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e) 
        {
             JOptionPane.showMessageDialog(null, "Error1", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try
             {
                 if(dis != null)
                 {
                     dis.close();
                 }
                 if(fis != null)
                 {
                     fis.close();
                 }
             } 
             catch (IOException e) 
             {
                 JOptionPane.showMessageDialog(null, "Error2", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
    }

    
    public void consultar() 
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        String lista = "";
        int cont = 0;
        try
        {
            fis = new FileInputStream("Estudiantes.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 id = dis.readUTF();
                 nombre = dis.readUTF();
                 fecha = dis.readUTF();
                 edad = dis.readInt();
                 dir = dis.readUTF();
                 numloc = dis.readInt();
                 curso = dis.readInt();
                 estado = dis.readBoolean();
                 cont++;
                 lista = lista + " | " + id + " | " + nombre + " | " + fecha + " | " + edad + " | " + dir + " | " + numloc + " | " + curso  + " | " + estado + "\n";
                 if(cont == 20)
                 {
                     JOptionPane.showMessageDialog(null, lista);
                     cont = 0;
                     lista = "";
                 }
            }
            
        }
        catch (EOFException e) 
        {
             if(cont != 0)
             {
                 JOptionPane.showMessageDialog(null, lista);
             }
             JOptionPane.showMessageDialog(null, "Fin del archivo", "Fin", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e) 
        {
             JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try
             {
                 if(dis != null)
                 {
                     dis.close();
                 }
                 if(fis != null)
                 {
                     fis.close();
                 }
             } 
             catch (IOException e) 
             {
                 JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
    }
    
    
    public void cupos()
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        int cont=0, c;
        
        c = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el curso, para saber el numero\n de solicitudes de cupos", "Busqueda", JOptionPane.INFORMATION_MESSAGE));
        try
        {
            fis = new FileInputStream("Estudiantes.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 id = dis.readUTF();
                 nombre = dis.readUTF();
                 fecha = dis.readUTF();
                 edad = dis.readInt();
                 dir = dis.readUTF();
                 numloc = dis.readInt();
                 curso = dis.readInt();
                 estado = dis.readBoolean();
                 
                 if(c == curso)
                 {
                     if(estado == false)
                    {
                        cont++;
                    }
                 }
            }
            
        }
        catch (EOFException e) 
        {
             JOptionPane.showMessageDialog(null, "El numero de solicitudes de cupos es de:  " + cont, "Busqueda", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException e) 
        {
             JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try
             {
                 if(dis != null)
                 {
                     dis.close();
                 }
                 if(fis != null)
                 {
                     fis.close();
                 }
             } 
             catch (IOException e) 
             {
                 JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
    }
    
}

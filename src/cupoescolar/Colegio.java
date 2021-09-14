package cupoescolar;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Colegio 
{
    private String id, nombre, dir, loc, op;
    private int numloc, numloc1, a=0;
    private String ver;
    
    public void Archivo()
    { 
        File fil = new File("Colegio.csv");
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
                           dir = token.nextToken();
                           numloc = Integer.parseInt(token.nextToken());
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
            fos = new FileOutputStream("Colegios.dat",true);
            dos = new DataOutputStream(fos);
                dos.writeUTF(id);
                dos.writeUTF(nombre);
                dos.writeUTF(dir);
                dos.writeInt(numloc);
            }
        
        catch(FileNotFoundException Error2){
            JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
        }
        catch(IOException Error1){
            JOptionPane.showMessageDialog(null, "Hay un error en el archivo", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
        }
        catch(Exception Error3){
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
    
    
    public void numLocalidad()
    {
        String[] op1 = { "1.Usaquén", "2.Chapinero", "3.Santa Fe", "4.San Cristóbal", "5.Usme", "6.Tunjuelito", "7.Bosa", "8.Kennedy", "9.Fontibón", "10.Engativá", "11.Suba", "12.Barrios Unidos", "13.Teusaquillo", "14.Los Mártires", "15.Antonio Nariño", "16.Puente Aranda", "17.La Candelaria", "18.Rafael Uribe Uribe", "19.Ciudad Bolívar", "20.Sumapaz"};
        op = (String) JOptionPane.showInputDialog(null,"Seleccione la localidad del colegio", "Elegir",JOptionPane.QUESTION_MESSAGE,null,op1, op1[0]);
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
        JOptionPane.showMessageDialog(null, "A continuación se pedirá la \ninformación del colegio \npara el registro", "Registro", JOptionPane.INFORMATION_MESSAGE);
        
        id = JOptionPane.showInputDialog(null, "Ingrese la identificación del colegio", "Registro", JOptionPane.INFORMATION_MESSAGE);
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del colegio", "Registro", JOptionPane.INFORMATION_MESSAGE);
        dir = JOptionPane.showInputDialog(null, "Ingrese la dirección del colegio", "Registro", JOptionPane.INFORMATION_MESSAGE);
        numLocalidad();
        Escritura();
    }
    
    public void Buscar5()
    {
        
        String id3 = JOptionPane.showInputDialog(null, "Ingrese la identificación del colegio que desea buscar", "Busquéda", JOptionPane.INFORMATION_MESSAGE);
        
        Localidad loca = new Localidad();
        FileInputStream  fis = null;
        DataInputStream dis = null;
        
        try
        {
            fis = new FileInputStream("Colegios.dat");
            dis = new DataInputStream(fis);
            
            while(true)
            {
                id = dis.readUTF();
                nombre = dis.readUTF();
                dir = dis.readUTF();
                numloc = dis.readInt();
                loc = loca.nombre(numloc);
                if(id3.equals(id))
                {
                    JOptionPane.showMessageDialog(null, "Codigo: "+id+" \nNombre: "+nombre+" \nDirección: "+dir+" \nLocalidad: "+loc);  
                    a=1;
                }
            }
        } 
        catch (EOFException e) 
        {
            if(a == 0)
            {
                JOptionPane.showMessageDialog(null, "El colegio no está registrado", "Búsqueda", JOptionPane.ERROR_MESSAGE);
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
    
    
    public void Buscar6()
    {
        numLocalidad();
        
        FileInputStream  fis = null;
        DataInputStream dis = null;
        
        String lista = "";
        int cont = 0;
        try
        {
            fis = new FileInputStream("Colegios.dat");
            dis = new DataInputStream(fis);
            
            while(true)
            {
                id = dis.readUTF();
                nombre = dis.readUTF();
                dir = dis.readUTF();
                numloc1 = dis.readInt();
                 if(numloc==numloc1)
                {
                    cont++;
                    lista = lista + " | " + id + " | " + nombre + " | " + dir + " | " + numloc + "\n";
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
            fis = new FileInputStream("Colegios.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 id = dis.readUTF();
                 nombre = dis.readUTF();
                 dir = dis.readUTF();
                 numloc = dis.readInt();
                 cont++;
                 lista = lista + " | " + id + " | " + nombre + " | " + dir + " | " + numloc + " | " + "\n";
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
}

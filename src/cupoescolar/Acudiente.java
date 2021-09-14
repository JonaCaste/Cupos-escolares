package cupoescolar;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class Acudiente extends Persona
{
    private String tipo, ocupacion, num, op;
    private String ver;
    
    public void Archivo()
    { 
        File fil = new File("Acudiente.csv");
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
                           edad = Integer.parseInt(token.nextToken());
                           tipo = token.nextToken();
                           num = token.nextToken();
                           dir = token.nextToken();
                           ocupacion = token.nextToken();
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
            fos = new FileOutputStream("Acudientes.dat",true);
            dos = new DataOutputStream(fos);
                dos.writeUTF(id);
                dos.writeUTF(nombre);
                dos.writeInt(edad);
                dos.writeUTF(tipo);
                dos.writeUTF(num);
                dos.writeUTF(dir);
                dos.writeUTF(ocupacion);
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
     
    
    public void Registro()
    {
        JOptionPane.showMessageDialog(null, "A continuación se pedirá la \ninformación del acudiente \npara el registro", "Registro", JOptionPane.INFORMATION_MESSAGE);
        
        id = JOptionPane.showInputDialog(null, "Ingrese la identificación del acudiente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        nombre = JOptionPane.showInputDialog(null, "Ingrese los nombres del acudiente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        edad = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese la edad del acudiente)", "Registro", JOptionPane.INFORMATION_MESSAGE));
             
        String[] op1 = { "1. Madre", "2. Padre", "3. Otro"};
        op = (String) JOptionPane.showInputDialog(null,"Ingrese el parentesco del acudiente", "Registro",JOptionPane.QUESTION_MESSAGE,null,op1, op1[0]);
        if(op.equals("1. Madre"))
        {
            tipo = "Madre";
        }
        if(op.equals("2. Padre"))
        {
            tipo = "Padre";
        }
        if(op.equals("3. Otro"))
        {
            tipo = JOptionPane.showInputDialog(null, "Ingrese el parentesco del acudiente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        num = JOptionPane.showInputDialog(null, "Ingrese un número del acudiente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        dir = JOptionPane.showInputDialog(null, "Ingrese la dirección del estudiante", "Registro", JOptionPane.INFORMATION_MESSAGE);
        
        String[] op2 = { "1. Empleado", "2. Independiente", "3. Pensionado", "4. Desempleado"};
        op = (String) JOptionPane.showInputDialog(null,"Ingrese la ocupación del acudiente", "Registro",JOptionPane.QUESTION_MESSAGE,null,op2, op2[0]);
        if(op.equals("1. Empleado"))
        {
            ocupacion = "Empleado";
        }
        if(op.equals("2. Independiente"))
        {
            ocupacion = "Independiente";
        }
        if(op.equals("3. Pensionado"))
        {
            ocupacion = "Pensionado";
        }
        if(op.equals("4. Desempleado"))
        {
            ocupacion = "Desempleado";
        }
        
        Escritura();
    }
    
    
    public void consultar() 
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        String lista = "";
        int cont = 0;
        try
        {
            fis = new FileInputStream("Acudientes.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 id = dis.readUTF();
                 nombre = dis.readUTF();
                 edad = dis.readInt();
                 tipo = dis.readUTF();
                 num = dis.readUTF();
                 dir = dis.readUTF();
                 ocupacion = dis.readUTF();
                 cont++;
                 lista = lista + " | " + id + " | " + nombre + " | " + " | " + edad + " | " + tipo + " | " + num + " | " + dir  + " | " + ocupacion + "\n";
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

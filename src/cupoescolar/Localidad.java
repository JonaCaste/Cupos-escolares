package cupoescolar;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;



public class Localidad 
{
    private String ver, loc;
    private int numloc;
    
    public void Archivo()
    { 
        File fil = new File("localidad.txt");
            try 
            {
                FileReader fr = new FileReader(fil);
                BufferedReader br = new BufferedReader(fr);
                
                while((ver = br.readLine()) != null)
                   {
                       StringTokenizer token = new StringTokenizer(ver,",");
                       while(token.hasMoreTokens())
                       {
                           numloc = Integer.parseInt(token.nextToken());
                           loc = token.nextToken();
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
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try
            {
            fos = new FileOutputStream("localidades.dat",true);
            dos = new DataOutputStream(fos);
                dos.writeInt(numloc);
                dos.writeUTF(loc);
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
    
    public String nombre(int numloc1)
    {
        
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        String loc1="";
        try
        {
            fis = new FileInputStream("localidades.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 numloc = dis.readInt();
                 loc = dis.readUTF();
                 if(numloc1 == numloc)
                 {
                    loc1 = numloc + "." + loc;
                    
                 }
            }
            
        }
        catch (EOFException e) 
        {
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
        return loc1;
    }
    
}

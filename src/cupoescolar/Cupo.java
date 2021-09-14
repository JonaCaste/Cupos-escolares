package cupoescolar;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Cupo 
{
    private String idcol, ver;
    private int curso, numcupos;
    
    public void Archivo()
    { 
        File fil = new File("Cupo.csv");
            try 
            {
                FileReader fr = new FileReader(fil);
                BufferedReader br = new BufferedReader(fr);
                
                while((ver = br.readLine()) != null)
                   {
                       StringTokenizer token = new StringTokenizer(ver,";");
                       while(token.hasMoreTokens())
                       {
                           idcol = token.nextToken();
                           curso = Integer.parseInt(token.nextToken());
                           numcupos = Integer.parseInt(token.nextToken());
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
            fos = new FileOutputStream("Cupos.dat",true);
            dos = new DataOutputStream(fos);
                dos.writeUTF(idcol);
                dos.writeInt(curso);
                dos.writeInt(numcupos);
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
    
    public void disp()
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        String lista = "Identificacion colegio || Cupos disponibles\n", idcol2="";
        int cont = 0, a=1;
        try
        {
            fis = new FileInputStream("cupos.dat");
            dis = new DataInputStream(fis);
            while(true)
            {
                 idcol = dis.readUTF();
                 curso = dis.readInt();
                 numcupos = dis.readInt();
                 if(a==1)
                 {
                     idcol2 = "" + idcol;
                     a = 2;
                 }
                 if(idcol.equals(idcol2))
                 {
                     cont = cont + numcupos;
                 }
                 else
                 {
                     lista = lista + idcol + "             ||             " + cont + "\n";
                     cont = 0;
                 }
                 idcol2 = "" + idcol;
            }
            
        }
        catch (EOFException e) 
        {
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
        JOptionPane.showMessageDialog(null, lista);
    }

}

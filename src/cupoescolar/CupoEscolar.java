package cupoescolar;

import javax.swing.JOptionPane;

public class CupoEscolar
{
    
    public static void main(String[] args)
    {
        String opcion1;
        int a=1, opcion;
        do
        {
            String[] opc = {"Consultar", "Registrar", "Buscar", "Convertir", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion para continuar", "Cupos escolares", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
            Estudiante est = new Estudiante();
            Colegio col = new Colegio();
            Acudiente acu = new Acudiente();
            Cupo cup = new Cupo();
            Localidad loc = new Localidad();
            
            switch(opcion)
            {
                case 0:
                    
                    String[] opc8 = {"Consultar lista de colegios", "Consultar lista de estudiantes", "Consultar lista de acudientes"};
                    opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion para continuar", "Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc8, opc8[0]);

                    switch (opcion)
                    {
                        case 0:
                            col.consultar();;
                            break;

                        case 1:
                            est.consultar();
                            break;
                            
                        case 2:
                            acu.consultar();
                            break;
                    }
                    
                    break;

                case 1:

                    String[] opc2 = {"Registrar colegio", "Registrar estudiante", "Registrar acudiente"};
                    opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion para continuar", "Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc2, opc2[0]);

                    switch (opcion)
                    {
                        case 0:
                            col.Registro();
                            break;

                        case 1:
                            est.Registro();
                            break;
                            
                        case 2:
                            acu.Registro();
                            break;
                    }

                    break;
                    
                case 2:
                    String[] opc4 = {"Estudiante por identificación", "Estudiante por localidad", "Solicitud de cupos por grado", "Estudiantes por estado de la solicitud", "Colegio por identificación", "Colegios por localidad", "Cupos disponibles por colegios"};
                    opcion1 = (String) JOptionPane.showInputDialog(null,"Seleccione la busqueda que desea realizar", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opc4, opc4[0]);

                    if(opcion1.equals("Estudiante por identificación"))
                    {
                        opcion = 0;
                    }
                    if(opcion1.equals("Estudiante por localidad"))
                    {
                        opcion = 1;
                    }
                    if(opcion1.equals("Solicitud de cupos por grado"))
                    {
                        opcion = 2;
                    }
                    if(opcion1.equals("Estudiantes por estado de la solicitud"))
                    {
                        opcion = 3;
                    }
                    if(opcion1.equals("Colegio por identificación"))
                    {
                        opcion = 4;
                    }
                    if(opcion1.equals("Colegios por localidad"))
                    {
                        opcion = 5;
                    }
                    if(opcion1.equals("Cupos disponibles por colegios"))
                    {
                        opcion = 6;
                    }

                    switch (opcion)
                    {
                        case 0:
                            est.Buscar1();
                            break;
                            
                        case 1:
                            est.Buscar2();
                            break;
                            
                        case 2:
                            est.cupos();
                            break;
                                
                        case 3:
                            est.Buscar4();
                            break;
                                    
                        case 4:
                            col.Buscar5();
                            break;
                        
                        case 5:
                            col.Buscar6();
                            break;
                            
                        case 6:
                            cup.disp();
                            break;
                    }

                    break;
                    
                case 3:
                        String[] opc3 = {"Estudiante", "Colegio", "Acudiente", "Localidad", "Cupos"};
                        opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion para convertir", "Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc3, opc3[0]);
                        
                        switch (opcion)
                        {
                            case 0:
                                est.Archivo();
                                break;
                            
                            case 1:
                                col.Archivo();
                                break;
                            
                            case 2:
                                acu.Archivo();
                                break;
                                
                            case 3:
                                loc.Archivo();
                                break;
                                
                            case 4:
                                cup.Archivo();
                                break;
                                
                        }
                        
                    break;
                
                case 4:
                    System.exit(0);
                    break;
            }
        }
        while(a==1);
    }
    
}
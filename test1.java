import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;


class accion{
    //OBJETO Principal
JFrame Ventana = new JFrame("Nueva Ventana");

//parte superior: Menu
JMenuBar Menu = new JMenuBar();

//Opcion Main First
JMenu M1 = new JMenu("Color");
JMenuItem M11 = new JMenuItem("Amarillo");
JMenuItem M12 = new JMenuItem("Rojo");
JMenuItem M13 = new JMenuItem("Azul");
JMenuItem M14 = new JMenuItem("Negro");

//Opcion Main Second 
JMenu M2 = new JMenu("Imagen");
JMenuItem M22 = new JMenuItem("Abrir");
JMenuItem M23 = new JMenuItem("Ejemplo");

//Parte Central 
JLabel Contenido = new JLabel();
JPanel panel = new JPanel();
JFileChooser dialog = new JFileChooser();

//parte inferior
JPanel Panel = new JPanel();
JLabel Etiqueta = new JLabel("¿Que deseas hacer?");
JButton exit = new JButton("Salir");
JButton reset = new JButton("Reiniciar");

    


    public void GUI(){
        Ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Ventana.setUndecorated(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.getContentPane().add(BorderLayout.NORTH, Menu);
        Ventana.getContentPane().add(BorderLayout.SOUTH, panel);
        Ventana.setVisible(true);
    }

    public void PanelSuperior(){
        Menu.add(M1);
        M1.add(M11);
        M1.add(M12);
        M1.add(M13);
        M1.add(M14);
        
    
        Menu.add(M2);
        M2.add(M22);
        M2.add(M23);
            
        Ventana.getContentPane().add(BorderLayout.NORTH, Menu);
            
        
    }


    public void EventosM1(){
        M11.addActionListener(e->{  
              Ventana.getContentPane().setBackground(Color.yellow);
            });
            
        M12.addActionListener(e->{  
              Ventana.getContentPane().setBackground(Color.red);
            });
        M13.addActionListener(e->{  
              Ventana.getContentPane().setBackground(Color.blue);
            });
        M14.addActionListener(e->{  
              Ventana.getContentPane().setBackground(Color.black);
            });

    }

    public void EventosM2(){
        M22.addActionListener(e->{
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpeg", "jpg", "gif", "png");
            dialog.setFileFilter(filtro);
            int returnVal = dialog.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION){
                System.out.println("Has escogido: "+dialog.getSelectedFile().getAbsolutePath());
                Contenido.setIcon(new ImageIcon(dialog.getSelectedFile().getAbsolutePath()));
            }

            
        });

        M23.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "Vaya...");
        });
    }



    public void Eventos(){
        EventosM1();
        EventosM2();
    }
    
    public void Contenido(){
        Ventana.add(BorderLayout.CENTER, Contenido);

    }

    public void LayoutInferior(){
        JLabel Etiqueta = new JLabel("¿Que deseas hacer?");
        JButton exit = new JButton("Cerrar App");       
        JButton reset = new JButton("Reiniciar Panel"); 
        
        panel.add(Etiqueta);
        panel.add(exit);
        panel.add(reset);

        reset.addActionListener(e ->{
            Ventana.getContentPane().setBackground(null);
            Contenido.setIcon(null);
        });

        exit.addActionListener(e ->{
            Ventana.dispose();
            System.exit(0);
        });
    }
    

    accion(){
        GUI();
        PanelSuperior();
        Eventos();
        Contenido();
        LayoutInferior();
    }

    public static void main(String[] args) {
        new accion();
    } 
}
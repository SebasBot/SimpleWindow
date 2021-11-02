import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;

class Accion{
//main Frame
    JFrame VENTANA = new JFrame("Nueva ventana");
    //Layout Superior
    JMenuBar MENU= new JMenuBar();
    
    //Opcion Main First 
    JMenu M1 = new JMenu("Imagen");
    JMenuItem M11 = new JMenuItem("Abrir");
    JMenuItem M12 = new JMenuItem("Ejemplo");

    //Opcion Main Second
    JMenu M2 = new JMenu("Color");
    JMenuItem M21 = new JMenuItem("Amarillo");
    JMenuItem M22 = new JMenuItem("Rojo");
    JMenuItem M23 = new JMenuItem("Azul");
    JMenuItem M24 = new JMenuItem("Negro");
    
    //Mid
    JLabel CONTENIDO = new JLabel();
    JFileChooser DIALOGO = new JFileChooser();
    
    //Bottom
    JPanel PANEL = new JPanel();        
    JLabel BOTTOMTAG = new JLabel("¿Algo Mas?");
    JButton RESET = new JButton("Reiniciar");
    JButton EXIT = new JButton("Salir");
    
    
    public void baseView(){
    VENTANA.setExtendedState(JFrame.MAXIMIZED_BOTH);
    VENTANA.setUndecorated(true);
    VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    VENTANA.setVisible(true);
    
    }
    
    public void northLayout(){
        MENU.add(M1);
        M1.add(M11);
        M1.add(M12);
        
        MENU.add(M2);
        M2.add(M21);
        M2.add(M22);
        M2.add(M23);
        M2.add(M24);
           
        VENTANA.add(BorderLayout.NORTH, MENU); 

    }
    
    public void centerLayout(){
        VENTANA.add(BorderLayout.CENTER, CONTENIDO);
        
    }
    
    public void southLayout(){
        PANEL.add(BOTTOMTAG);
        PANEL.add(RESET);
        PANEL.add(EXIT);
                    VENTANA.add(BorderLayout.SOUTH, PANEL);
    }
    
    public void evento1(){
        M11.addActionListener(e->{
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpeg", "png", "jpg", "gif");
            DIALOGO.setFileFilter(filtro);
            int returnVal = DIALOGO.showOpenDialog(null);
            
            switch (returnVal){
                case JFileChooser.APPROVE_OPTION: 
                    System.out.println("Has escogido: "+DIALOGO.getSelectedFile().getAbsolutePath());
                    CONTENIDO.setIcon(new ImageIcon(DIALOGO.getSelectedFile().getAbsolutePath()));
                    break;
                case JFileChooser.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(VENTANA, "Has cancelado la eleccion de imagen", "Atencion", JOptionPane.ERROR_MESSAGE);
                    break;
                case JFileChooser.ERROR_OPTION:
                    JOptionPane.showMessageDialog(VENTANA, "Ha ocurrido un error", "Atencion", JOptionPane.ERROR_MESSAGE);
                    break;}
          });
        M12.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "Vaya...");
        });
        
    }
    
    public void evento2(){
        M21.addActionListener(e->{  
              VENTANA.getContentPane().setBackground(Color.yellow);
            });
            
        M22.addActionListener(e->{  
              VENTANA.getContentPane().setBackground(Color.red);
            });
        M23.addActionListener(e->{  
              VENTANA.getContentPane().setBackground(Color.blue);
            });
        M24.addActionListener(e->{  
              VENTANA.getContentPane().setBackground(Color.black);
            });
        
    }
    
    public void evento3(){
        RESET.addActionListener(e->{
            VENTANA.setBackground(null);
            CONTENIDO.setIcon(null);
        });
        
        
        EXIT.addActionListener(e->{
            VENTANA.dispose();
            System.exit(0);
            
        });
        
    }
    
    public void eventos(){
        evento1();
        evento2();
        evento3();
    }
    
    public void iniciarGUI(){
        System.out.println("GUI iniciado...");
        baseView();
        northLayout();
        centerLayout();
        southLayout();
        eventos();
        
        
    }
}
    public static void main(String[] args) {
        new iniciarGUI();
    } 
}


package proyecto_final;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login_2 extends JFrame{
    
    JPanel log_2 = new JPanel();//crear panel
    
    JTextField txtValor1 = new JTextField();
    JTextField txtValor2 = new JTextField();
    JPasswordField txtValor3 = new JPasswordField();
    JPasswordField txtValor4 = new JPasswordField();


    Usuario misUsuarios[] = new Usuario[11];
    
    public Login_2() {

        this.setVisible(true);//activar visibilidad de la ventana

      //  this.setDefaultCloseOperation(EXIT_ON_CLOSE);//cerrar ventana

        Componentes();//llamar iniciar componentes
    }
    
    public void Componentes() {
        
        iniciarComponentes();
        
        cuadrosDeTexto();
        
        etiquetas();
        
        botones();
    }
    
    public void iniciarComponentes() {

        log_2.setLayout(null); //desactivar la organizacion automatica de los componentes

        this.getContentPane().add(log_2); // agregar el panel al frame

        log_2.setBackground(Color.GRAY); // agregar color al fondo

    }

    
    
     public void cuadrosDeTexto() {

        txtValor1.setBounds(200, 150, 220, 30);
        log_2.add(txtValor1);

        txtValor2.setBounds(200, 190, 220, 30);
        log_2.add(txtValor2);
        
        
        

    }
     
     public void etiquetas() {
         
     }
     
     public void botones() {
         
     }

}

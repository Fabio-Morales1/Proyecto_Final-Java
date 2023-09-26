package proyecto_final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login_2 extends JFrame {

    JPanel log_2 = new JPanel();//crear panel

    JTextField txtValor1 = new JTextField();
    JTextField txtValor2 = new JTextField();
    JPasswordField txtValor3 = new JPasswordField();
    JPasswordField txtValor4 = new JPasswordField();

    // Areglo unidimensinal clase Global
    Usuario misUsuarios[] = new Usuario[11];

    //Metodo Constructor
    public Login_2() {

        this.setVisible(true);//activar visibilidad de la ventana

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

        txtValor1.setBounds(250, 150, 220, 30);
        log_2.add(txtValor1);

        txtValor2.setBounds(250, 200, 220, 30);
        log_2.add(txtValor2);

        txtValor3.setBounds(250, 250, 220, 30);
        log_2.add(txtValor3);

        txtValor4.setBounds(250, 300, 220, 30);
        log_2.add(txtValor4);

    }

    public void etiquetas() {

        JLabel Nuevo_Usuario = new JLabel("Ingrese El Usuario");
        Nuevo_Usuario.setBounds(40, 153, 350, 20);
        Nuevo_Usuario.setForeground(Color.WHITE);
        log_2.add(Nuevo_Usuario);

        JLabel Nuevo_Nombre = new JLabel("Ingrese El Nombre");
        Nuevo_Nombre.setBounds(40, 203, 350, 20);
        Nuevo_Nombre.setForeground(Color.WHITE);
        log_2.add(Nuevo_Nombre);

        JLabel Nueva_Contra = new JLabel("Ingrese La Contraseña");
        Nueva_Contra.setBounds(40, 253, 350, 20);
        Nueva_Contra.setForeground(Color.WHITE);
        log_2.add(Nueva_Contra);

        JLabel Confirmar_Contra = new JLabel("Confirmar Contraseña");
        Confirmar_Contra.setBounds(40, 303, 350, 20);
        Confirmar_Contra.setForeground(Color.WHITE);
        log_2.add(Confirmar_Contra);

    }

    public void botones() {

        //Boton de Registrarse
        JButton btnregistra = new JButton("Registarse");
        btnregistra.setBounds(50, 360, 150, 30);
        btnregistra.setBackground(Color.BLUE);
        btnregistra.setForeground(Color.WHITE);
        log_2.add(btnregistra);
        ActionListener nuevo_ini = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

            }

        };

        btnregistra.addActionListener(nuevo_ini);

        // Boton para Volver
        JButton btsVolve = new JButton("Volver");
        btsVolve.setBounds(250, 360, 150, 30);
        btsVolve.setBackground(Color.BLUE);
        btsVolve.setForeground(Color.WHITE);
        log_2.add(btsVolve);
        ActionListener Volver = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                botone();

            }

        };
        btsVolve.addActionListener(Volver);

    }

    public void botone() {

        this.dispose();

    }

    public void buscarUsuario(String usuario, String Nombre, String contra, String Confirmarcontra) {

        boolean encontrado = false;

        for (int i = 0; i <= 10; i++) {

            if (misUsuarios[i] != null) {
                
                
                if(misUsuarios[i].getContra().equals(contra) == misUsuarios[i].getConfirContra().equals(Confirmarcontra)){
                    
                }

             //   if (misUsuarios[i].getNombre_Usuario().equals(usuario) && misUsuarios[i].getContra().equals(contra)) {

              //      encontrado = true;

              //      JOptionPane.showMessageDialog(null, "bienvenido");

                    break;

             //   }

            }

        }

        if (encontrado) {

            JOptionPane.showMessageDialog(null, "bienve");

        } else {

            JOptionPane.showMessageDialog(null, "datos incorrectos");

        }

    }

}

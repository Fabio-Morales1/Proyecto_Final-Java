package proyecto_final;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login_1 extends JFrame {
public  Usuario misUsuarios[] = new Usuario[11];
    JPanel log_1 = new JPanel();//crear panel

    JTextField txtValor1 = new JTextField();
    JPasswordField txtValor2 = new JPasswordField();

   

    // Metodo constructor para la ventana
    public Login_1() {

        this.setVisible(true);//activar visibilidad de la ventana

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//cerrar ventana
       
        Componentes();//llamar iniciar componentes

        misUsuarios[0] = new Usuario("ADMIN", "2390"); //Usuario ya creado

    }

    public void Componentes() {

        iniciarComponentes(); // llamar a las etiquetas

        cuadrosDeTexto();

        etiquetas(); //Todas las Etiquetas

        botones();
        
    }

    public void iniciarComponentes() {

        log_1.setLayout(null); //desactivar la organizacion automatica de los componentes

        this.getContentPane().add(log_1); // agregar el panel al frame

        log_1.setBackground(Color.DARK_GRAY); // agregar color al fondo

    }

    public void cuadrosDeTexto() {

        txtValor1.setBounds(200, 150, 220, 30);
        log_1.add(txtValor1);

        txtValor2.setBounds(200, 190, 220, 30);
        //   txtValor2.setEnabled(false); //para Desactivar el panel 2 y que no escriban
        log_1.add(txtValor2);

    }

    public void etiquetas() {

        JLabel Usuario = new JLabel("Ingrese El Usuario");
        Usuario.setBounds(35, 152, 350, 20);
        Usuario.setForeground(Color.WHITE);
        log_1.add(Usuario);

        //Segunda Etiqueta
        JLabel Contra = new JLabel("Ingrese La Contraseña");
        Contra.setBounds(35, 192, 350, 20);
        Contra.setForeground(Color.WHITE);
        log_1.add(Contra);

        ImageIcon nuestroIcono = new ImageIcon("Usuarios.jpg");
        Image conver = nuestroIcono.getImage();
        Image tam = conver.getScaledInstance(150, 180, Image.SCALE_SMOOTH);
        ImageIcon fin = new ImageIcon(tam);
        JLabel Icon = new JLabel(fin);
        Icon.setBounds(140, 5, 165, 120);
        log_1.add(Icon);
        repaint();

    }

    public void botones() {

        // 
        JButton btniniciar = new JButton("Iniciar Sesion");
        btniniciar.setBounds(50, 290, 150, 30);
        btniniciar.setBackground(Color.BLUE);
        btniniciar.setForeground(Color.WHITE);
        log_1.add(btniniciar);
        ActionListener ini = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                String usuario = txtValor1.getText();
                String contra = txtValor2.getText();
                buscarUsuario(usuario, contra);

            }

        };

        btniniciar.addActionListener(ini);

        JButton btsregistra = new JButton("Nuevo Usuario");
        btsregistra.setBounds(250, 290, 150, 30);
        btsregistra.setBackground(Color.BLUE);
        btsregistra.setForeground(Color.WHITE);
        log_1.add(btsregistra);
        ActionListener regis = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Login_2 inicial = new Login_2();

                inicial.setBounds(490, 140, 550, 500);
                
                inicial.setTitle("Login_2");
                
            }

        };

        btsregistra.addActionListener(regis);
    }

    public void buscarUsuario(String usuario, String contra) {

        boolean encontrado = false;

        for (int i = 0; i <= 10; i++) {

            if (misUsuarios[i] != null) {

                if (misUsuarios[i].getNombre_Usuario().equals(usuario) && misUsuarios[i].getContra().equals(contra)) {

                    encontrado = true;

                    JOptionPane.showMessageDialog(null, "bienvenido");

                    break;

                }

            }

        }

        if (encontrado) {

            JOptionPane.showMessageDialog(null, "bienve");

        } else {

            JOptionPane.showMessageDialog(null, "datos incorrectos");

        }

    }
}

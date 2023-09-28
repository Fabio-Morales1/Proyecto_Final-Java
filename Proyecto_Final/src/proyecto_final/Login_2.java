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
    public  Usuario misUsuarios[] = new Usuario[11];
    // Areglo unidimensinal clase Global
    

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
                String Usuario_Nombre = txtValor1.getText();
                String Nombre = txtValor2.getText();
                String Contra = txtValor3.getText();
                String Confirmar_Contra = txtValor4.getText();

                if (guardarUsuarios(Usuario_Nombre, Nombre, Contra, Confirmar_Contra)) {
                    txtValor1.setText("");
                    txtValor2.setText("");
                    txtValor3.setText("");
                    txtValor4.setText("");

                }

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

    public boolean buscarUsuario(String contra, String Confirmarcontra) {

        boolean encontrado = false;

        for (int i = 0; i <= 10; i++) {

            if (misUsuarios[i] != null) {

                if (misUsuarios[i].getContra().equals(contra) == misUsuarios[i].getConfirContra().equals(Confirmarcontra)) {

                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "La Contra coincide");
                    //La Contra coincide

                } else {
                    encontrado = false;
                    JOptionPane.showMessageDialog(null, "La Contra no coincide");
                    //Contra no coincidente
                     break;
                }
            }

        }
        return encontrado;
    }

    public boolean guardarUsuarios(String Usuario, String Nombre, String Contra, String Confirmar_Contra) {

        boolean Guardado = false;
        if (Usuario.equals("") || Nombre.equals("") || Contra.equals("") || Confirmar_Contra.equals("")) {

            JOptionPane.showMessageDialog(null, "Dede Llenar Todos Los Campos Vacios");

        } else {
             //Codigo incompleto 
             //lo que hace es confirma la contra y no sigue verificando para guardar el usuario
            if(buscarUsuario(Contra, Confirmar_Contra)) {
                //  JOptionPane.showMessageDialog(null, "Contra No puesta");

             } else if( duplicadosDeUsuario(Nombre)) {
                    JOptionPane.showMessageDialog(null, "Ya Existe El Usuario");
                
            } else {

                boolean vacio = false;
                int posicion = -1;

                for (int i = 0; i <= 10; i++) {

                    if (misUsuarios[i] == null) {

                        vacio = true;
                        posicion = i;
                        break;
                    }

                }

                if (vacio) {

                    misUsuarios[posicion] = new Usuario(Usuario, Nombre, Contra, Confirmar_Contra);
                    JOptionPane.showMessageDialog(null, "Usuario Guardado");
                    Guardado = true;

                } else {

                    JOptionPane.showMessageDialog(null, "!!Ya No Se Pueden Guardar Mas Usuarios!!!");
                }
            }
        }

        return Guardado;
    }

    public boolean duplicadosDeUsuario(String nombre) {

        boolean duplicados = false;
        for (int i = 0; i <= 10; i++) {
            if (misUsuarios[i] != null) {

                if (misUsuarios[i].getNew_Nombre().equals(nombre)) {

                    duplicados = true;
                    break;

                }
            }
        }
        return duplicados;

    }
}

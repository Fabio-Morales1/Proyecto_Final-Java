package proyecto_final_4baco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Login_Todo extends JFrame{

//
    JPanel panelIniciodeSesion, Panelnuevousuario, PanelClientes,PanelGraficador;

    JTextField txtusuario;
    JPasswordField txtcontra;
    Usuario misUsuarios[] = new Usuario[11];
    Clientes misClientes[] = new Clientes[100];

    public Login_Todo() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        misUsuarios[0] = new Usuario("ADMIN", "123", "123");

        misClientes[0] = new Clientes("2232", "Pedro", "29", "M");
        misClientes[1] = new Clientes("2332", "Juan", "18", "M");
        misClientes[2] = new Clientes("2432", "Maria", "25", "F");
        misClientes[3] = new Clientes("2232", "Marco", "27", "M");
        misClientes[4] = new Clientes("2332", "Solfan", "19", "M");
        misClientes[5] = new Clientes("2432", "sofia", "35", "F");
        misClientes[6] = new Clientes("2232", "Jeremias", "40", "M");
        misClientes[7] = new Clientes("2332", "Andy", "41", "M");
        misClientes[8] = new Clientes("2432", "Jimena", "23", "F");
        misClientes[9] = new Clientes("2432", "Genesis", "24", "F");

    }

    // ---------------------> Componentes de inicializaciones de paneles
    public void iniciarComponentes() {

        //----------------- Panel De Inicio de Sesion 
        panelIniciodeSesion = new JPanel();
        panelIniciodeSesion.setBackground(Color.GRAY);
        panelIniciodeSesion.setLayout(null);
        this.getContentPane().add(panelIniciodeSesion);
        componentesIniciodeSesion();

        // ------------- Panel De Clientes
        PanelClientes = new JPanel();
        PanelClientes.setLayout(null);
        this.getContentPane().add(PanelClientes);
        PanelClientes.setVisible(false);

    }

    // ---------------------> Componentes Del primer Panel 
    public void componentesIniciodeSesion() {

        JLabel lblUsuario = new JLabel("Ingrese su usuario");
        lblUsuario.setBounds(50, 15, 150, 15);
        lblUsuario.setForeground(Color.WHITE);
        panelIniciodeSesion.add(lblUsuario);

        JLabel lblcontra = new JLabel("Ingrese su password");
        lblcontra.setBounds(50, 50, 150, 15);
        lblcontra.setForeground(Color.WHITE);
        panelIniciodeSesion.add(lblcontra);

        txtusuario = new JTextField();
        txtusuario.setBounds(210, 15, 150, 20);
        txtusuario.setForeground(Color.green);
        panelIniciodeSesion.add(txtusuario);

        txtcontra = new JPasswordField();
        txtcontra.setBounds(210, 50, 150, 20);
        txtcontra.setForeground(Color.green);
        panelIniciodeSesion.add(txtcontra);

        JButton btniniciar = new JButton("Ingresar");
        btniniciar.setBounds(100, 150, 100, 30);
        btniniciar.setBackground(Color.BLUE);
        btniniciar.setForeground(Color.WHITE);
        panelIniciodeSesion.add(btniniciar);

        ActionListener iniciarsesion = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String usuario = txtusuario.getText();
                String contra = txtcontra.getText();
                if (buscarUsuario(usuario, contra)) {
                    panelIniciodeSesion.setVisible(false);
                    PanelClientes.setVisible(true);
                    componentesClientes();
                }

            }

        };

        btniniciar.addActionListener(iniciarsesion);

        //
        // Boton Registrase
        JButton btnNuevoUsuario = new JButton("Registrar");
        btnNuevoUsuario.setBounds(220, 150, 100, 30);
        btnNuevoUsuario.setBackground(Color.BLUE);
        btnNuevoUsuario.setForeground(Color.WHITE);
        panelIniciodeSesion.add(btnNuevoUsuario);

        ActionListener nuevoUsuario = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                panelIniciodeSesion.setVisible(false);
                componentesNuevoUsuario();
            }

        };

// Boton nuevo usuario
        btnNuevoUsuario.addActionListener(nuevoUsuario);

        panelIniciodeSesion.repaint();

    }

    public boolean buscarUsuario(String usuario, String contra) {
        boolean encontrado = false;

        String nombre = "";
        if (usuario.equals("") || contra.equals("")) {

            JOptionPane.showMessageDialog(null, "Dede Llenar Todos Los Campos Vacios");

        } else {

            for (int i = 0; i <= 10; i++) {

                if (misUsuarios[i] != null) {

                    if (misUsuarios[i].getNombre_Usuarios().equals(usuario) && misUsuarios[i].getContra().equals(contra)) {

                        encontrado = true;
                        nombre = misUsuarios[i].getNombre_Usuarios();

                        break;

                    }

                }

            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO " + nombre);
            } else {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
        }
        return encontrado;
    }

// ---------------------> Componentes Del segunda Panel 
    public void componentesNuevoUsuario() {

        // -------------Etiquetas 2
        this.setTitle("Crear nueva cuenta");
        iniciarComponentesPanel2();

        Panelnuevousuario.setBackground(Color.GRAY); // agregar color al fondo
        JLabel Nuevo_Usuario = new JLabel("Ingrese El Usuario");
        Nuevo_Usuario.setBounds(40, 153, 350, 20);
        Nuevo_Usuario.setForeground(Color.WHITE);
        Panelnuevousuario.add(Nuevo_Usuario);

        JLabel Nuevo_Nombre = new JLabel("Ingrese El Nombre");
        Nuevo_Nombre.setBounds(40, 203, 350, 20);
        Nuevo_Nombre.setForeground(Color.WHITE);
        Panelnuevousuario.add(Nuevo_Nombre);

        JLabel Nueva_Contra = new JLabel("Ingrese La Contraseña");
        Nueva_Contra.setBounds(40, 253, 350, 20);
        Nueva_Contra.setForeground(Color.WHITE);
        Panelnuevousuario.add(Nueva_Contra);

        JLabel Confirmar_Contra = new JLabel("Confirmar Contraseña");
        Confirmar_Contra.setBounds(40, 303, 350, 20);
        Confirmar_Contra.setForeground(Color.WHITE);
        Panelnuevousuario.add(Confirmar_Contra);

        // -------------Cuadros de Texto del 2 
        JTextField txtValor1 = new JTextField();
        txtValor1.setBounds(250, 150, 190, 30);
        Panelnuevousuario.add(txtValor1);

        JTextField txtValor2 = new JTextField();
        txtValor2.setBounds(250, 200, 190, 30);
        Panelnuevousuario.add(txtValor2);

        JPasswordField txtValor3 = new JPasswordField();
        txtValor3.setBounds(250, 250, 190, 30);
        Panelnuevousuario.add(txtValor3);

        JPasswordField txtValor4 = new JPasswordField();
        txtValor4.setBounds(250, 300, 190, 30);
        Panelnuevousuario.add(txtValor4);

        // Boton volver
        //Boton de Registrarse
        JButton btnregistra = new JButton("Registarse");
        btnregistra.setBounds(50, 360, 150, 30);
        btnregistra.setBackground(Color.BLUE);
        btnregistra.setForeground(Color.WHITE);
        Panelnuevousuario.add(btnregistra);
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
        Panelnuevousuario.add(btsVolve);
        ActionListener Volver = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                panelIniciodeSesion.setVisible(true);
                Panelnuevousuario.setVisible(false);

            }

        };
        btsVolve.addActionListener(Volver);

    }

    public void iniciarComponentesPanel2() {
        Panelnuevousuario = new JPanel();
        Panelnuevousuario.setLayout(null);
        this.getContentPane().add(Panelnuevousuario);
    }

//
    public boolean buscarContraIgual(String contra, String Confirmarcontra) {

        boolean encontrado = true;

        for (int i = 0; i <= 10; i++) {

            if (misUsuarios[i] != null) {

                if (misUsuarios[i].getContra().equals(contra) != misUsuarios[i].getConfirmar_Contra().equals(Confirmarcontra)) {

                    encontrado = false;
                    JOptionPane.showMessageDialog(null, "Contra no coincidente");
                    //La Contra coincide

                } else {
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "La Contra coincide");
                    //Contra no coincidente

                }
            }

        }
        return encontrado;
    }

    //
    //
    // --------------------- Busqueda de Usuario del Panel 2  
    public boolean guardarUsuarios(String Usuario, String Nombre, String Contra, String Confirmar_Contra) {

        boolean Guardado = false;
        if (Usuario.equals("") || Nombre.equals("") || Contra.equals("") || Confirmar_Contra.equals("")) {

            JOptionPane.showMessageDialog(null, "Dede Llenar Todos Los Campos Vacios");

        } else {
            //Codigo incompleto 
            //lo que hace es confirma la contra y no sigue verificando para guardar el usuario

            if (buscarContraIgual(Contra, Confirmar_Contra)) {
                if (duplicadosDeUsuario(Usuario)) {
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

                        misUsuarios[posicion] = new Usuario(Usuario, Contra, Confirmar_Contra);
                        JOptionPane.showMessageDialog(null, "Usuario Guardado");
                        Guardado = true;

                    } else {

                        JOptionPane.showMessageDialog(null, "!!Ya No Se Pueden Guardar Mas Usuarios!!!");
                    }
                }
            }

        }
        return Guardado;
    }

    public boolean duplicadosDeUsuario(String usuario) {

        boolean duplicados = false;
        for (int i = 0; i <= 10; i++) {
            if (misUsuarios[i] != null) {

                if (misUsuarios[i].getNombre_Usuarios().equals(usuario)) {

                    duplicados = true;
                    break;

                }
            }
        }
        return duplicados;

    }

    //
    //   
    // ---------------------> Componentes Del Tercer Panel 
    public void componentesClientes() {

        this.setTitle("Ingresar Clienestes");//Customer control panel
       
        
        this.setSize(500, 500);
        PanelClientes.setBackground(Color.GRAY); // agregar color al fondo
        JLabel Nuevo_Cliente = new JLabel("Nombre");
        Nuevo_Cliente.setBounds(40, 153, 350, 20);
        Nuevo_Cliente.setForeground(Color.WHITE);
        PanelClientes.add(Nuevo_Cliente);

        JLabel Edad_Cliente = new JLabel("Edad");
        Edad_Cliente.setBounds(40, 203, 350, 20);
        Edad_Cliente.setForeground(Color.WHITE);
        PanelClientes.add(Edad_Cliente);

        JLabel Genero_Cliente = new JLabel("Genero");
        Genero_Cliente.setBounds(40, 253, 350, 20);
        Genero_Cliente.setForeground(Color.WHITE);
        PanelClientes.add(Genero_Cliente);

        JLabel Nit_Cliente = new JLabel("Nit");
        Nit_Cliente.setBounds(40, 303, 350, 20);
        Nit_Cliente.setForeground(Color.WHITE);
        PanelClientes.add(Nit_Cliente);

        // -------------Cuadros de Texto del 2 
        JTextField txtValor5 = new JTextField();
        txtValor5.setBounds(250, 150, 190, 30);
        PanelClientes.add(txtValor5);

        JTextField txtValor6 = new JTextField();
        txtValor6.setBounds(250, 200, 190, 30);
        PanelClientes.add(txtValor6);

        JPasswordField txtValor7 = new JPasswordField();
        txtValor7.setBounds(250, 250, 190, 30);
        PanelClientes.add(txtValor7);

        JPasswordField txtValor8 = new JPasswordField();
        txtValor8.setBounds(250, 300, 190, 30);
        PanelClientes.add(txtValor8);
        
        
        
        // Boton volver
        //Boton de Registrarse
        JButton btnregistra = new JButton("Registrar");
        btnregistra.setBounds(50, 360, 150, 30);
        btnregistra.setBackground(Color.BLUE);
        btnregistra.setForeground(Color.WHITE);
        PanelClientes.add(btnregistra);
        ActionListener nuevo_ini = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                String Nombre_Cliente = txtValor5.getText();
                String Edad_Cliente = txtValor6.getText();
                String Genero_Cliente = txtValor7.getText();
                String Nit_Cliente = txtValor8.getText();

                if (guardarClientes(Nombre_Cliente, Edad_Cliente, Genero_Cliente, Nit_Cliente)) {
                    txtValor5.setText("");
                    txtValor6.setText("");
                    txtValor7.setText("");
                    txtValor8.setText("");

                }

            }

        };

        btnregistra.addActionListener(nuevo_ini);

        // Boton para Volver
        JButton btsVolve = new JButton("Volver");
        btsVolve.setBounds(250, 360, 150, 30);
        btsVolve.setBackground(Color.BLUE);
        btsVolve.setForeground(Color.WHITE);
        PanelClientes.add(btsVolve);
        ActionListener Volver = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                panelIniciodeSesion.setVisible(true);
                PanelClientes.setVisible(false);

            }

        };
        btsVolve.addActionListener(Volver);
        
        
        // Boton    Graficar
        
        JButton btsGraficar = new JButton("Graficar");
        btsGraficar.setBounds(250, 400, 150, 30);
        btsGraficar.setBackground(Color.BLUE);
        btsGraficar.setForeground(Color.WHITE);
        PanelClientes.add(btsGraficar);
        ActionListener Grafi = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                
                PanelClientes.setVisible(false);         
                PanelGraficador.setVisible(true);

            }

        };
        btsGraficar.addActionListener(Grafi);
        
        
        
                
        

        
        
    }
    
     public void graficarClientes() {
         
         
     }
    
    
    
    
    
    
   public void DaTosclientes() {
        JLabel lblClientes = new JLabel("Stored clients");//clientes almacenados
        lblClientes.setBounds(10, 10, 150, 15);
        PanelClientes.add(lblClientes);
       
       
       
       // Para La Tabla
        DefaultTableModel info = new DefaultTableModel();
        info.addColumn("NIT");
        info.addColumn("NOMBRE");
        info.addColumn("EDAD");
        info.addColumn("GENERO");

        for (int i = 0; i < misClientes.length - 1; i++) {
            if (misClientes[i] != null) {

                String tempo[] = {misClientes[i].getNit(), misClientes[i].getNombre(), String.valueOf(misClientes[i].getEdad()), String.valueOf(misClientes[i].getGenero())};
                info.addRow(tempo);
            }
        }

        // Crear la Tabla
        JTable clientes_tabla = new JTable(info);
        
         //crollPane Para la tabla Clientes_Barra  
        JScrollPane Clientes_Barra = new JScrollPane(clientes_tabla);
        Clientes_Barra.setBounds(25, 35, 350, 250);
        PanelClientes.add(Clientes_Barra);
        
      //  Tabla De pastel
        
        DefaultPieDataset Grafico_Pastel_Edades = new DefaultPieDataset();
        Grafico_Pastel_Edades.setValue("Masculino",7);
        Grafico_Pastel_Edades.setValue("Femenino",10);
        
        JFreeChart Circulas_Grafico = ChartFactory.createPieChart("Genero",Grafico_Pastel_Edades,true,true,false);
        ChartPanel Panel_Circular = new ChartPanel(Circulas_Grafico);
        
        Panel_Circular.setBounds(400, 20, 300, 250);
        PanelClientes.add(Panel_Circular);
        
       
   }
    
    
    
    
    
    // --------------------------Guardar Clientes
    public boolean guardarClientes(String Nit, String Nombre, String Edad, String Genero) {

        boolean Guardado = false;
        if (Nit.equals("") || Nombre.equals("") || Edad.equals("") || Genero.equals("")) {
       
            JOptionPane.showMessageDialog(null, "Dede Llenar Todos Los Campos Vacios");

        } else {
            //Codigo incompleto 
            //lo que hace es confirma la contra y no sigue verificando para guardar el usuario

            
                if (duplicadosDeNit(Nit)) {
                    JOptionPane.showMessageDialog(null, "Ya Existe El numero de Nit");

                } else {
                    boolean vacio = false;
                    int posicion = -1;

                    for (int i = 0; i <= 10; i++) {

                        if (misClientes[i] == null) {

                            vacio = true;
                            posicion = i;
                            break;
                        }

                    }

                    if (vacio) {

                        misClientes[posicion] = new Clientes(Nit, Nombre, Edad,Genero);
                        JOptionPane.showMessageDialog(null, "Usuario Guardado");
                        Guardado = true;

                    } else {

                        JOptionPane.showMessageDialog(null, "!!Ya No Se Pueden Guardar Mas Usuarios!!!");
                    }
                }
            }

        
        return Guardado;
    }
    
    
    
    

    public boolean duplicadosDeNit(String Nit) {

        boolean duplicadosNit = false;
        for (int i = 0; i <= 10; i++) {
            if (misClientes[i] != null) {

                if (misClientes[i].getNit().equals(Nit)) {

                    duplicadosNit = true;
                    break;

                }
            }
        }
        return duplicadosNit;

    }

}

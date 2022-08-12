package Pack_User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;

public class JavaCrud extends JDialog{
    private JPanel MainPanel;
    private JTextField textNombre;
    private JTextField textPrecio;
    private JTextField textCiudad;
    private JButton createBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JTextField textId;
    private JTextField textCantidad;
    private JButton limpiarBtn;
    private JButton buscarBtn;
    public JavaCrud(JFrame parent) {
        Connect();

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create();
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete();
            }
        });
        limpiarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });
        MostrarVentana();
    }
    Connection con;
    PreparedStatement pst;

    public void MostrarVentana(){
        setTitle("Perfil");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(640,480));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setVisible(true);
    }

     public void Connect(){
         final String DB_URL= "jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
         final String USERNAME="root";
         final String PASSWORD="";

        try {
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stat = conn.createStatement();
            //System.out.println("Conexion exitosa");
        }
        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
     }

     public void Create(){
         String nombre, precio, ciudad, cantidad;
         nombre = textNombre.getText();
         precio = textPrecio.getText();
         ciudad = textCiudad.getText();
         cantidad = textCantidad.getText();

         final String DB_URL= "jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
         final String USERNAME="root";
         final String PASSWORD="";

         try {
             Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             String sql = "INSERT INTO productos(pnombre, pciudad, pprecio, pcantidad)VALUES(?,?,?,?)";
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, nombre);
             pst.setString(2, ciudad);
             pst.setString(3, precio);
             pst.setString(4, cantidad);
             //ResultSet resultSet = pst.executeQuery(); //select
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Producto agregado");
             stmt.close();
             conn.close();
         }
         catch (SQLException ex){
             ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Producto no agregado");
         }
     }

     public void Limpiar(){
         textNombre.setText("");
         textPrecio.setText("");
         textCiudad.setText("");
         textId.setText("");
         textCantidad.setText("");
     }

     public void Buscar(){
         String id="0";
         id=textId.getText();

         final String DB_URL= "jdbc:mysql://localhost/misproductos?serverTimezone=UTC"; // Error Nombre DATABASE
         final String USERNAME="root";
         final String PASSWORD="";

         try {
             Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             String sql = "SELECT * FROM productos where pid=?";
             PreparedStatement pst=conn.prepareStatement(sql);
             pst.setString(1,id);
             //System.out.println(sql);

             ResultSet rs = pst.executeQuery(); //select

             if (rs.next()==true){ //no esta vacio
                 String nombre, ciudad, precio,cantidad;
                 nombre=rs.getString(2); // 1 es el id
                 ciudad=rs.getString(3);
                 precio=rs.getString(4);
                 cantidad=rs.getString(5);

                 System.out.println();
                 textNombre.setText(nombre);
                 textCiudad.setText(ciudad);
                 textPrecio.setText(precio);
                 textCantidad.setText(cantidad);
             }
             else {
                 //textMensaje.setText("No se ha encontrado el producto");
                 JOptionPane.showMessageDialog(null, "No se ha encontrado el producto");
                 Limpiar();
             }

             stmt.close();
             conn.close();
         }
         catch (SQLException ex){
             ex.printStackTrace();
             System.out.println("SQL incorrecto");
         }
     }

     public void Update(){
         String id, nombre, precio, ciudad, cantidad;

         id=textId.getText();
         nombre=textNombre.getText();
         ciudad=textCiudad.getText();
         precio=textPrecio.getText();
         cantidad=textCantidad.getText();

         final String DB_URL= "jdbc:mysql://localhost/misproductos?serverTimezone=UTC"; // Error Nombre DATABASE
         final String USERNAME="root";
         final String PASSWORD="";

         try {
             Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             String sql = "UPDATE productos set pnombre=?, pciudad=?, pprecio=?, pcantidad=? WHERE pid=?";
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, nombre);
             pst.setString(2, ciudad);
             pst.setString(3, precio);
             pst.setString(4, cantidad);
             pst.setString(5, id);
             //ResultSet resultSet = pst.executeQuery(); //select
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro actualizado");
             stmt.close();
             conn.close();
         }
         catch (SQLException ex){
             ex.printStackTrace();
             System.out.println("SQL incorrecto");
         }

     }

     public void Delete(){
         String borrarId=textId.getText();

         final String DB_URL= "jdbc:mysql://localhost/misproductos?serverTimezone=UTC"; // Error Nombre DATABASE
         final String USERNAME="root";
         final String PASSWORD="";

         try {
             Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             String sql = "DELETE FROM productos WHERE pid=?";
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, borrarId);
             //ResultSet resultSet = pst.executeQuery(); //select
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro borrado");
             stmt.close();
             conn.close();
         }
         catch (SQLException ex){
             ex.printStackTrace();
             System.out.println("SQL incorrecto");
         }
     }
}

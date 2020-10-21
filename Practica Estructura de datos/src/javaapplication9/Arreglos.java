package javaapplication9;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Arreglos extends javax.swing.JFrame {
    ClassArreglos objArreglo;
    DefaultTableModel modelo;
    String[]cabecera={"N°","Codigo","Nombre","Apellido1","Apellido2","DNI","Telef.Casa","Celular"};
    String[][]data={};
    int num=0;

    
    public Arreglos() {
        initComponents();
        this.setLocationRelativeTo(this);
        modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(modelo);
        objArreglo=new ClassArreglos();
        cargarDatos();
        actualizarTabla();
        txtcodigo.requestFocus();

    }

    
    @SuppressWarnings("unchecked")

    public void cargarDatos(){
        try{
            FileInputStream fis=new FileInputStream("Registros.txt");
            ObjectInputStream in=new ObjectInputStream(fis);
            if(in!=null){
                objArreglo=(ClassArreglos)in.readObject();
                in.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al cargar el archivo..."+e);
        }
    }
    public void grabar(){
        try{
            FileOutputStream fos=new FileOutputStream("Registros.txt");
            ObjectOutputStream out=new ObjectOutputStream(fos);
            if(out!=null){
                out.writeObject(objArreglo);
                out.close();
            }
        }catch(IOException z){
            mensaje("Error en grabacion del archivo...."+z);
        }
    }
    public void vaciarTabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            modelo.removeRow(0);
    }
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(this, texto);
    }
    public void actualizarTabla(){
        vaciarTabla();
        int m=0;
        for(int i=0;i<m;i++){
            String cod=objArreglo.getCodigo();
            String nom=objArreglo.getNombre();
            String ape1=objArreglo.getApellido1();
            String ape2=objArreglo.getApellido2();
            int dni=objArreglo.getDNI();
            int ca=objArreglo.getCasa();
            int cel=objArreglo.getCelular();
            insertar(i+1,cod,nom,ape1,ape2,dni,ca,cel);
        }
    }

    public void modifica(){
        String cod=txtcodigo.getText().toUpperCase();
        String nom=txtnombre.getText().toUpperCase();
        String ape1=txtapellido1.getText().toUpperCase();
        String ape2=txtapellido2.getText().toUpperCase();
        int dni=Integer.parseInt(txtdni.getText());
        int ca=Integer.parseInt(txtcasa.getText());
        int cel=Integer.parseInt(txtcelular.getText());
        limpiarEntradas();
        grabar();
        actualizarTabla();
        txtcodigo.requestFocus();

    }
    public void eliminar(){
        consultar();
        int p=0;
        if(p!=-1){
           int r=JOptionPane.showConfirmDialog(this,"Esta seguro de eliminar este registro?","Responder",0);
           if(r==0){
               
               limpiarEntradas();
               grabar();
               actualizarTabla();
               txtcodigo.requestFocus();
           }
        }
    }
    public void consultar(){
        String cod=txtcodigo.getText().toUpperCase();
        int p=0;
        if(p==1){
            mensaje("Codigo no existe");
            limpiarEntradas();

        }
    }
    void limpiarEntradas(){
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtcodigo.requestFocus(true);
    }
    void insertar(int num,String codigo,String nombre,String apellido1,String apellido2,int DNI,int casa,int celular){
        
        
        Object[]fila={num,codigo,nombre,apellido1,apellido2,DNI,casa,celular};
        modelo.addRow(fila);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido1 = new javax.swing.JTextField();
        txtapellido2 = new javax.swing.JTextField();
        btngrabar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clase Arreglos");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 50, 50, 20);

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 80, 50, 20);

        jLabel3.setText("Apellido Paterno");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 110, 100, 20);

        jLabel4.setText("Apellido Materno");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 100, 20);
        jPanel1.add(txtcodigo);
        txtcodigo.setBounds(140, 50, 100, 20);
        jPanel1.add(txtnombre);
        txtnombre.setBounds(140, 80, 110, 20);
        jPanel1.add(txtapellido1);
        txtapellido1.setBounds(140, 110, 110, 20);
        jPanel1.add(txtapellido2);
        txtapellido2.setBounds(140, 140, 110, 20);

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        jPanel1.add(btngrabar);
        btngrabar.setBounds(20, 200, 90, 30);

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnconsultar);
        btnconsultar.setBounds(250, 200, 90, 30);

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar);
        btnmodificar.setBounds(130, 200, 90, 30);

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar);
        btneliminar.setBounds(370, 200, 90, 30);

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir);
        btnsalir.setBounds(480, 200, 90, 30);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Universiad Fidelitas");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 20, 210, 20);

        jLabel6.setText("DNI");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(340, 50, 40, 20);

        jLabel7.setText("Telef. Casa");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(340, 80, 70, 20);

        jLabel8.setText("Celular");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(340, 110, 60, 20);
        jPanel1.add(txtdni);
        txtdni.setBounds(430, 50, 100, 20);
        jPanel1.add(txtcasa);
        txtcasa.setBounds(430, 80, 100, 20);
        jPanel1.add(txtcelular);
        txtcelular.setBounds(430, 110, 100, 20);

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        String cod=txtcodigo.getText().toUpperCase();
        String nom=txtnombre.getText().toUpperCase();
        String ape1=txtapellido1.getText().toUpperCase();
        String ape2=txtapellido2.getText().toUpperCase();
        int dni=Integer.parseInt(txtdni.getText());
        int ca=Integer.parseInt(txtcasa.getText());
        int cel=Integer.parseInt(txtcelular.getText());
        insertar(0,cod,nom,ape1,ape2,dni,ca,cel);
        limpiarEntradas();
        grabar();
        
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arreglos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtapellido2;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}

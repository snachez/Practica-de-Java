package javaapplication9;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.awt.Font;

public class ListaCircular extends javax.swing.JInternalFrame {
    public class Nodo{
        String codigo;
        String nombre;
        String apellido1;
        String apellido2;
        int DNI;
        int casa;
        int celular;
        Nodo enlace;

        public Nodo(String cod,String nom,String ape1,String ape2,int dni,int ca,int cel){
            codigo=cod;
            nombre=nom;
            apellido1=ape1;
            apellido2=ape2;
            DNI=dni;
            casa=ca;
            celular=cel;
            enlace=this;
        }
    }

    DefaultTableModel Modelo;
    String [] cabecera={"N°","Codigo","Nombres","Ape. Paterno","Ape. Materno","Cedula","Telef.casa","Celular"};
    String [][] data={};
    public Nodo lc;
    public Nodo pFound;
    int num=0;

    
    public ListaCircular() {
        initComponents();
        lc=pFound=null;
        Modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(Modelo);


    }


    
    @SuppressWarnings("unchecked")

    Nodo buscar(Nodo lc,String cod){
        Nodo actual;
        boolean encontrado=false;
        actual=lc;
        while((actual.enlace!=lc) && (!encontrado)){
            encontrado=actual.enlace.codigo.equalsIgnoreCase(txtcodigo.getText().trim());
            if(!encontrado)
                actual=actual.enlace;
        }
           return actual.enlace;
    }

    Nodo inserta_final(Nodo lc,String cod,String nom,String ape1,String ape2,int dni,int ca,int cel){
        Nodo nuevo=new Nodo(cod,nom,ape1,ape2,dni,ca,cel);

        if(lc!=null){
         nuevo.enlace=lc.enlace;
         lc.enlace=nuevo;
        }
        lc=nuevo;
        return lc;
    }

    void habilitar(){
        btneliminar.setEnabled(true);
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);

    }

    void deshabilitar(){
        btneliminar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btnguardar.setEnabled(true);
    }

    void limpiar_entradas(){
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtcodigo.requestFocus();
    }

    void vaciar_tabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            Modelo.removeRow(0);
    }

    void ver_datos(){
        String cod,nom,ape1,ape2;
        int dni,ca,cel;
        vaciar_tabla();
        Nodo p;
        if(lc!=null){
            num=0;
            p=lc.enlace;
            do
            { cod=p.codigo;
              nom=p.nombre;
              ape1=p.apellido1;
              ape2=p.apellido2;
              dni=p.DNI;
              ca=p.casa;
              cel=p.celular;
              
                 num++;
                 Object[] fila={num,cod,nom,ape1,ape2,dni,ca,cel};
                 Modelo.addRow(fila);
                 p=p.enlace;
               }while(p!=lc.enlace);
        }
    }
   
    void eliminar(){
        Nodo actual;
        boolean encontrado = false;
        actual=lc;
        while((actual.enlace!=lc)&&(!encontrado)){
          encontrado=actual.enlace.codigo.equalsIgnoreCase(txtcodigo.getText().trim());
          if(!encontrado)
              actual=actual.enlace;
        }
        encontrado=actual.enlace.codigo.equalsIgnoreCase(txtcodigo.getText().trim());
        if(encontrado){
            Nodo p;
            p=actual.enlace;
            if(lc==lc.enlace) lc=null;
            else{
                if(p==lc)
                    lc=actual;
                actual.enlace=p.enlace;
            }
        }
        ver_datos();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido1 = new javax.swing.JTextField();
        txtapellido2 = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Circular");
        setPreferredSize(new java.awt.Dimension(650, 460));

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Reestaurar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Cedula");

        jLabel6.setText("Telef. Casa");

        jLabel7.setText("Celular");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Universidad Fidelitas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String cod=txtcodigo.getText();
      String nom=txtnombre.getText().toUpperCase();
      String ape1=txtapellido1.getText().toUpperCase();
      String ape2=txtapellido2.getText().toUpperCase();
      int dni=Integer.parseInt(txtdni.getText());
      int ca=Integer.parseInt(txtcasa.getText());
      int cel=Integer.parseInt(txtcelular.getText());
      lc=inserta_final(lc,cod,nom,ape1,ape2,dni,ca,cel);
      limpiar_entradas();
      ver_datos();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        pFound.codigo=txtcodigo.getText();
        pFound.nombre=txtnombre.getText();
        pFound.apellido1=txtapellido1.getText().toUpperCase();
        pFound.apellido2=txtapellido2.getText().toUpperCase();
        pFound.DNI=Integer.parseInt(txtdni.getText());
        pFound.casa=Integer.parseInt(txtcasa.getText());
        pFound.celular=Integer.parseInt(txtcelular.getText());
        limpiar_entradas();
        deshabilitar();
        ver_datos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
        limpiar_entradas();
        ver_datos();
        if(lc==null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        deshabilitar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
        limpiar_entradas();
        deshabilitar();
    }//GEN-LAST:event_btnreestaurarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String cod=txtcodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese en codigo por favor");
        }else {
            pFound=buscar(lc,cod);
            if(pFound!=null){
                txtnombre.setText(pFound.nombre);
                txtapellido1.setText(pFound.apellido1);
                txtapellido2.setText(pFound.apellido2);
                txtdni.setText(String.valueOf(pFound.DNI));
                txtcasa.setText(String.valueOf(pFound.casa));
                txtcelular.setText(String.valueOf(pFound.celular));
                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" , no esta en la lista..");
            }
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnreestaurar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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

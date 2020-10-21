package javaapplication9;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class ListaDoble extends javax.swing.JInternalFrame {
      public class Nodo{
        String nombre;
        String apellido1;
        String apellido2;
        int DNI;
        int casa;
        int celular;
        Nodo sig;
        Nodo ant;
        public Nodo(String nom,String ape1,String ape2,int dni,int ca,int cel){
            nombre=nom;
            apellido1=ape1;
            apellido2=ape2;
            DNI=dni;
            casa=ca;
            celular=cel;
            sig=ant=null;
        }
    }

    DefaultTableModel Modelo;
    String [] cabecera={"N°","Nombres","Ape. Paterno","Ape. Materno","Cedula","Telef.casa","Celular"};
    String [][] data={};
    public Nodo ini,fin;
    public Nodo pFound;
    int num=0;

   
    public ListaDoble() {
        initComponents();
        
        ini=fin=pFound=null;
        Modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(Modelo);
    }

   
    @SuppressWarnings("unchecked")

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
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtnombre.requestFocus();
    }

    void vaciar_tabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            Modelo.removeRow(0);
    }

    void ver_datos(int ind){
        String nom,ape1,ape2;
        int dni,ca,cel;

        switch(ind){
            case 1:{
                vaciar_tabla();
                Nodo aux=ini;
                num=0;
                while(aux!=null){
                    nom=aux.nombre;
                    ape1=aux.apellido1;
                    ape2=aux.apellido2;
                    dni=aux.DNI;
                    ca=aux.casa;
                    cel=aux.celular;

                    num++;
                    Object[] fila={num,nom,ape1,ape2,dni,ca,cel};
                    Modelo.addRow(fila);
                    aux=aux.sig;
               }
            }break;

           case 2:{
                vaciar_tabla();
                Nodo aux=fin;
                num=0;
                while(aux!=null){
                    nom=aux.nombre;
                    ape1=aux.apellido1;
                    ape2=aux.apellido2;
                    dni=aux.DNI;
                    ca=aux.casa;
                    cel=aux.celular;
                    
                    num++;
                    Object[] fila={num,nom,ape1,ape2,dni,ca,cel};
                    Modelo.addRow(fila);
                    aux=aux.ant;
                }
            }break;
        }
    }

    Nodo buscar(Nodo inicio,String cod){
        Nodo pos=inicio;
        while(pos!=null && !cod.equalsIgnoreCase(pos.nombre))
            pos=pos.sig;
        return pos;
    }

    Nodo inserta_final(Nodo inicio,String nom,String ape1,String ape2,int dni,int ca,int cel){
        Nodo nuevo=new Nodo(nom,ape1,ape2,dni,ca,cel);
        nuevo.sig=inicio;
        if(inicio==null){
          fin=nuevo;
          fin.sig=null;
        }
        if(inicio!=null)
          inicio.ant=nuevo;
          inicio=nuevo;
          return inicio;
    }

    void eliminar(){
        Nodo actual;
        boolean encontrado = false;
        actual=ini;
        while((actual!=null)&&(!encontrado)){
          encontrado=actual.nombre.equalsIgnoreCase(txtnombre.getText().trim());
          if(!encontrado)
              actual=actual.sig;
        }
        if(actual!=null){
            if(actual== ini){
                ini=actual.sig;
                if(actual.sig!=null)
                    actual.sig.ant=null;
            }else if(actual.sig!=null){
                actual.ant.sig=actual.sig;
                actual.sig.ant=actual.ant;
            }else {
                actual.ant.sig=null;
                fin=actual.ant;
            }actual=null;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtapellido2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Doble");
        setPreferredSize(new java.awt.Dimension(650, 460));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

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

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
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

        jLabel4.setText("Apellido Materno");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Universidad Fidelitas");

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Reestaurar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cedula");

        jLabel7.setText("Telef. Casa");

        jLabel8.setText("Celular");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnreestaurar)
                        .addGap(13, 13, 13)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String nom=txtnombre.getText().toUpperCase();
      String ape1=txtapellido1.getText().toUpperCase();
      String ape2=txtapellido2.getText().toUpperCase();
      int dni=Integer.parseInt(txtdni.getText());
      int ca=Integer.parseInt(txtcasa.getText());
      int cel=Integer.parseInt(txtcelular.getText());
      ini=inserta_final(ini,nom,ape1,ape2,dni,ca,cel);
      limpiar_entradas();
      ver_datos(1);

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
        limpiar_entradas();
        ver_datos(1);
        if(ini==null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        deshabilitar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String nom=txtnombre.getText();
        if(nom.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese en codigo por favor");
        }else {
            pFound=buscar(ini,nom);
            if(pFound!=null){
                txtnombre.setText(pFound.nombre);
                txtapellido1.setText(pFound.apellido1);
                txtapellido2.setText(pFound.apellido2);
                txtdni.setText(String.valueOf(pFound.DNI));
                txtcasa.setText(String.valueOf(pFound.casa));
                txtcelular.setText(String.valueOf(pFound.celular));
                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El codigo: "+nom+" , no esta en la lista..");
            }
        }

    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        pFound.nombre=txtnombre.getText();
        pFound.apellido1=txtapellido1.getText().toUpperCase();
        pFound.apellido2=txtapellido2.getText().toUpperCase();
        pFound.DNI=Integer.parseInt(txtdni.getText());
        pFound.casa=Integer.parseInt(txtcasa.getText());
        pFound.celular=Integer.parseInt(txtcelular.getText());
        limpiar_entradas();
        deshabilitar();
        ver_datos(1);

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
        limpiar_entradas();
        deshabilitar();
    }//GEN-LAST:event_btnreestaurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnreestaurar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}

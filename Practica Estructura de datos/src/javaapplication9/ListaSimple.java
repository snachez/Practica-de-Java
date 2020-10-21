package javaapplication9;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.awt.Font;

public class ListaSimple extends javax.swing.JInternalFrame {
    public class Nodo{
        String codigo;
        String nombre;
        String apellido1;
        String apellido2;
        int DNI;
        int casa;
        int celular;
        Nodo sig;
        public Nodo(String cod,String nom,String ape1,String ape2,int dni,int ca,int cel){
            codigo=cod;
            nombre=nom;
            apellido1=ape1;
            apellido2=ape2;
            DNI=dni;
            casa=ca;
            celular=cel;
        }
    }
    public Nodo ini,fin;
    public Nodo pFound;
    int num=0;

   
    public ListaSimple() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")

    void encabezado(){
        txaRegistro.setFont(new Font("Comic Sams MS", Font.BOLD,12));
        txaRegistro.setText("");
        txaRegistro.append("");
        txaRegistro.append("    N°  CODIGO      NOMBRE        A.Paterno       A.Materno          Cedula        Telf.casa       Celular\n");
        txaRegistro.append("---------------------------------------------------------------------------------------------------------\n");

    }
    void habilitar(){
        btnactualizar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnguardar.setEnabled(false);
    }
    void deshabilitar(){
       btnactualizar.setEnabled(false);
       btneliminar.setEnabled(false);
       btnguardar.setEnabled(true);
    }
    void limpiarentradas(){
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtcodigo.requestFocus();
    }
    void verdatos(){
        String cod,nom,ape1,ape2;
        int dni,ca,cel;
        Nodo aux=ini;
        num=0;
        encabezado();
        while(aux!=null){
            cod=aux.codigo;
            nom=aux.nombre;
            ape1=aux.apellido1;
            ape2=aux.apellido2;
            dni=aux.DNI;
            ca=aux.casa;
            cel=aux.celular;
            num++;
            String numera=String.valueOf(num);
            for(int i=String.valueOf(num).length();i<5;i++){
                numera=" "+numera;
            }
            for(int i=cod.length();i<15;i++){
                cod=cod+" ";
            }
            for(int i=nom.length();i<15;i++){
                nom=nom+" ";
            }
            for(int i=ape1.length();i<20;i++){
                ape1=ape1+" ";
            }
            for(int i=ape2.length();i<20;i++){
                ape2=ape2+" ";
            }
            for(int i=0;i>dni;i++){
                dni=i;
            }
            for(int i=0;i<=ca;i++){
                ca=ca+i;
            }
            for(int i=0;cel<8;i++){
                cel=8;
            }
            
            txaRegistro.append(numera+"   "+cod+nom+ape1+ape2+dni+ca+cel+"\n");
            aux=aux.sig;
        }
    }
    Nodo buscar(Nodo inicio,String cod){
        Nodo pos=inicio;
        while(pos!=null&&!cod.equalsIgnoreCase(pos.codigo))
            pos=pos.sig;
        return pos;
    }
    Nodo insertarinicio(Nodo inicio,String cod,String nom,String ape1,String ape2,int dni,int ca,int cel){
        Nodo nuevo=new Nodo(cod,nom,ape1,ape2,dni,ca,cel);
        nuevo.sig=inicio;
        inicio=nuevo;
        return inicio;
    }
    void eliminar(Nodo actual){
        Nodo anterior=ini;
        while(anterior.sig!=actual&&anterior.sig!=null){
            anterior=anterior.sig;
        }
        if(actual!=null){
            if(anterior==actual)ini=actual.sig;
            else anterior.sig=actual.sig;
        }
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
        btnconsultar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRegistro = new javax.swing.JTextArea();
        btnactualizar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
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
        setTitle("Lista Simple");
        setPreferredSize(new java.awt.Dimension(650, 460));
        setRequestFocusEnabled(false);

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

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        txaRegistro.setEditable(false);
        txaRegistro.setColumns(20);
        txaRegistro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txaRegistro.setRows(5);
        jScrollPane1.setViewportView(txaRegistro);

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
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
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
      ini=insertarinicio(ini,cod,nom,ape1,ape2,dni,ca,cel);
      limpiarentradas();
      verdatos();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        pFound.codigo=txtcodigo.getText();
        pFound.nombre=txtnombre.getText();
        pFound.apellido1=txtapellido1.getText().toUpperCase();
        pFound.apellido2=txtapellido2.getText().toUpperCase();
        pFound.DNI=Integer.parseInt(txtdni.getText());
        pFound.casa=Integer.parseInt(txtcasa.getText());
        pFound.celular=Integer.parseInt(txtcelular.getText());
        limpiarentradas();
        deshabilitar();
        verdatos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String cod=txtcodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese en codigo por favor");
        }else {
            pFound=buscar(ini,cod);
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

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar(pFound);
        limpiarentradas();
        verdatos();
        if(ini==null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        deshabilitar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
        limpiarentradas();
        deshabilitar();
    }//GEN-LAST:event_btnreestaurarActionPerformed

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
    private javax.swing.JTextArea txaRegistro;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtapellido2;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}

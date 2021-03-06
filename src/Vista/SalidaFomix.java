/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import Controlador.Gestion;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatan Lara
 */
public class SalidaFomix extends javax.swing.JDialog {
    JFileChooser seleccinado = new JFileChooser();
    File archivo;
    byte[] bytesImge;
    Gestion gestion = new Gestion();
    String url="\\\\192.168.1.64\\coesicydet\\System\\";
    Conexion con =  new Conexion();
    public SalidaFomix(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private boolean Validate(){
        boolean verificar;
        String num_oficio = txtNumeroOficio.getText();
        if (num_oficio.isEmpty()) {
           JOptionPane.showMessageDialog(null, "verifique el numero de folio");
           verificar = false;
        }else{
            verificar = true;
            
        }
        return verificar;
    } 
    public void setFile(){
     con.conectar();
      Connection reg = con.conctarDB();
      String sql;
      String Mensaje = "";
      sql = "INSERT INTO fomix(id,num_oficio,asunto,fecha,destinatario,descripcion,remitente,aneso,img) VALUES (NULL,?,?,?,?,?,?,?,?)";
      Mensaje = "Se han insertado de manera Exitosa";
        try {
            String fecha = txtFecha.getCalendar().get(Calendar.YEAR)+"/"
                    +(txtFecha.getCalendar().get(Calendar.MONTH)+1)+"/"
                    +txtFecha.getCalendar().get(Calendar.DATE);
            
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, txtNumeroOficio.getText());
            pst.setString(2, txtAsunto.getText());
            pst.setString(3, fecha);
            pst.setString(4, txtDestinatario.getText());
            pst.setString(5, txtDescripcion.getText());
            pst.setString(6, txtRemitente.getText());
            pst.setString(7, txtAneso.getText());
            pst.setString(8, url+generarNombre());
            
            int n = pst.executeUpdate();
             if (n>0) {
                JOptionPane.showMessageDialog(null, Mensaje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalidaDG.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
      
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroOficio = new javax.swing.JTextField();
        txtAsunto = new javax.swing.JTextField();
        txtDestinatario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtRemitente = new javax.swing.JTextField();
        txtAneso = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btCargarImagenSalidaFomix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel1.setText("Registro de Oficio de Salida Fomix");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel2.setText("N° de Oficio");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel3.setText("Asunto:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel4.setText("Fecha");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel5.setText("Destinatario:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel6.setText("Descripción:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel7.setText("Remitente");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel8.setText("Anexo");

        txtNumeroOficio.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        txtAsunto.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        txtDestinatario.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 13)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        txtRemitente.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        txtAneso.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAneso, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRemitente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroOficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAneso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btGuardar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel9.setText("Documento");

        btCargarImagenSalidaFomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btCargarImagenSalidaFomix.setText("Cargar Imagen");
        btCargarImagenSalidaFomix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarImagenSalidaFomixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btCargarImagenSalidaFomix)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btCargarImagenSalidaFomix))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        if (Validate()) {
            setFile();
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCargarImagenSalidaFomixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarImagenSalidaFomixActionPerformed
        if (seleccinado.showDialog(this, "Abrir archivo")==JFileChooser.APPROVE_OPTION) {
            archivo = seleccinado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")) {
                    bytesImge = gestion.AbrirAImagen(archivo);
                    System.out.println(archivo);
                    
                    
                    String respuesta = gestion.GuardarAImagen(new File(url+generarNombre()), bytesImge);
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione una imagen con el tipo de formato jpg o png");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Seleccione una imagen con el tipo de formato jpg o png");
                }
        }
    }//GEN-LAST:event_btCargarImagenSalidaFomixActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalidaFomix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalidaFomix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalidaFomix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalidaFomix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalidaFomix dialog = new SalidaFomix(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCargarImagenSalidaFomix;
    private javax.swing.JButton btGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAneso;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDestinatario;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNumeroOficio;
    private javax.swing.JTextField txtRemitente;
    // End of variables declaration//GEN-END:variables
    public String generarNombre(){
        String nom="";
        con.conectar();
        int next = 0;
            Statement st = con.getStatement();
            try {
                ResultSet rs = st.executeQuery("select * from fomix");
                rs.beforeFirst();
                while (rs.next()) {
                next= Integer.valueOf(rs.getString("id"));
            }
                rs.close();
                st.close();
                nom = "Fomix_"+(next+1)+"_2016.jpg";
            } catch (SQLException | HeadlessException e) {
                e.printStackTrace();
            }
        return nom;
    
    }
}

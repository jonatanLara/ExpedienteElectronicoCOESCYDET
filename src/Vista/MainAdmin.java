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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonatan Lara
 */
public class MainAdmin extends javax.swing.JFrame {

    private DefaultTableModel modeloEntradaFomix,modeloEntradaDG,modeloFomix,modeloDG;
    private Conexion conn;
    public MainAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = new Conexion();
        conn.conectar();
        tablaEntradaFomix();
        tablaEntradaDG();
        tablaFomix();
        tablaDG();
        ConsultaEntradaFomix();
        ConsultaEntradaDG();
        ConsultaFomix();
        ConsultaDG();
        setTitle("Sistema de Control de Oficios");
        next_N_Entrada.setText("Next N° "+NextNum("entrada"));
        next_N_Entrada1.setText("Next N° "+NextNum("entradadg"));
        next_N_Fomix.setText("Next N° "+NextNum("fomix"));
        next_N_DG.setText("Next N° "+NextNum("direciong"));
    }
    private int NextNum(String tabla){
        int next=0;
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery("select * from "+tabla);
            r.beforeFirst();
            while (r.next()) {
                next = r.getInt("id");
            }
            ///JOptionPane.showMessageDialog(null, info);

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return next+1;
    }
    public void tablaEntradaFomix() {
        String columnas[] = {"N°","N° Oficio", "Asunto", "Fecha", "Destinatario", "Descripcion", "Remitente"};
        String filas[][] = {};
        modeloEntradaFomix = new DefaultTableModel(filas, columnas);
        tablaEntrada.setModel(modeloEntradaFomix);
    }
    public void tablaEntradaDG() {
        String columnas[] = {"N°","N° Oficio", "Asunto", "Fecha", "Destinatario", "Descripcion", "Remitente"};
        String filas[][] = {};
        modeloEntradaDG = new DefaultTableModel(filas, columnas);
        tablaEntradaDG.setModel(modeloEntradaDG);
    }
    public void tablaFomix() {
        String columnas[] = {"N°","N° Oficio", "Asunto", "Fecha", "Destinatario", "Descripcion", "Remitente"};
        String filas[][] = {};
        modeloFomix = new DefaultTableModel(filas, columnas);
        tablaFomix.setModel(modeloFomix);
    }
    public void tablaDG() {
        String columnas[] = {"N°","N° Oficio", "Asunto", "Fecha", "Destinatario", "Descripcion", "Remitente"};
        String filas[][] = {};
        modeloDG = new DefaultTableModel(filas, columnas);
        tablaDG.setModel(modeloDG);
    }
     public void ConsultaEntradaFomix() {
        String info = "";
        Object Datos[];
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery("select * from entrada");
            r.beforeFirst();
            while (r.next()) {

                Datos = new Object[7];
                Datos[0] = r.getString("id");
                Datos[1] = r.getString("num_oficio");
                Datos[2] = r.getString("asunto");
                Datos[4] = r.getString("destinatario");
                Datos[5] = r.getString("descripcion");
                Datos[6] = r.getString("remitente");
                //Datos[5]=r.getString("fecha");
                String fecha = r.getString("fecha");
                fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4);
                Datos[3] = fecha;
                modeloEntradaFomix.addRow(Datos);
            }
            ///JOptionPane.showMessageDialog(null, info);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    public void ConsultaEntradaDG() {
        String info = "";
        Object Datos[];
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery("select * from entradadg");
            r.beforeFirst();
            while (r.next()) {

                Datos = new Object[7];
                Datos[0] = r.getString("id");
                Datos[1] = r.getString("num_oficio");
                Datos[2] = r.getString("asunto");
                Datos[4] = r.getString("destinatario");
                Datos[5] = r.getString("descripcion");
                Datos[6] = r.getString("remitente");
                //Datos[5]=r.getString("fecha");
                String fecha = r.getString("fecha");
                fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4);
                Datos[3] = fecha;
                modeloEntradaDG.addRow(Datos);
            }
            ///JOptionPane.showMessageDialog(null, info);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
     public void ConsultaFomix() {
        String info = "";
        Object Datos[];
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery("select * from fomix");
            r.beforeFirst();
            while (r.next()) {
                Datos = new Object[7];
                Datos[0] = r.getString("id");
                Datos[1] = r.getString("num_oficio");
                Datos[2] = r.getString("asunto");
                Datos[4] = r.getString("destinatario");
                Datos[5] = r.getString("descripcion");
                Datos[6] = r.getString("remitente");
                //Datos[5]=r.getString("fecha");
                String fecha = r.getString("fecha");
                fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4);
                Datos[2] = fecha;
                modeloFomix.addRow(Datos);
            }
            ///JOptionPane.showMessageDialog(null, info);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
     public void ConsultaDG() {
        String info = "";
        Object Datos[];
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery("select * from direciong");
            r.beforeFirst();
            while (r.next()) {

                Datos = new Object[7];
                Datos[0] = r.getString("id");
                Datos[1] = r.getString("num_oficio");
                Datos[2] = r.getString("asunto");
                Datos[4] = r.getString("destinatario");
                Datos[5] = r.getString("descripcion");
                Datos[6] = r.getString("remitente");
                //Datos[5]=r.getString("fecha");
                String fecha = r.getString("fecha");
                fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4);
                Datos[3] = fecha;
                modeloDG.addRow(Datos);
            }
            ///JOptionPane.showMessageDialog(null, info);

        } catch (Exception e) {
            System.out.println("" + e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btNuevo_Entrada = new javax.swing.JButton();
        btEditar_Entrada = new javax.swing.JButton();
        btEliminar_Entrada = new javax.swing.JButton();
        BuscarEntrada = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        next_N_Entrada = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btDescargaEF = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btNuevo_Entrada1 = new javax.swing.JButton();
        btEditar_Entrada1 = new javax.swing.JButton();
        btEliminar_Entrada1 = new javax.swing.JButton();
        BuscarEntrada1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaEntradaDG = new javax.swing.JTable();
        next_N_Entrada1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btDescargaEDG = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btNuevo_Fomix = new javax.swing.JButton();
        btEditar_Fomix = new javax.swing.JButton();
        btEliminar_Fomix = new javax.swing.JButton();
        buscarFomix = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaFomix = new javax.swing.JTable();
        next_N_Fomix = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btDescargaSF = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btNuevo_DG = new javax.swing.JButton();
        btEditarDG = new javax.swing.JButton();
        btEliminarDG = new javax.swing.JButton();
        BuscarDG = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDG = new javax.swing.JTable();
        next_N_DG = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btDescargaSDG = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btNuevo_Entrada.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btNuevo_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        btNuevo_Entrada.setText("Nuevo*");
        btNuevo_Entrada.setBorderPainted(false);
        btNuevo_Entrada.setContentAreaFilled(false);
        btNuevo_Entrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNuevo_Entrada.setFocusPainted(false);
        btNuevo_Entrada.setFocusable(false);
        btNuevo_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevo_EntradaActionPerformed(evt);
            }
        });

        btEditar_Entrada.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEditar_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btEditar_Entrada.setText("Editar");
        btEditar_Entrada.setBorderPainted(false);
        btEditar_Entrada.setContentAreaFilled(false);
        btEditar_Entrada.setFocusPainted(false);
        btEditar_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar_EntradaActionPerformed(evt);
            }
        });

        btEliminar_Entrada.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEliminar_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        btEliminar_Entrada.setText("Eliminar");
        btEliminar_Entrada.setBorderPainted(false);
        btEliminar_Entrada.setContentAreaFilled(false);
        btEliminar_Entrada.setFocusPainted(false);
        btEliminar_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminar_EntradaActionPerformed(evt);
            }
        });

        BuscarEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarEntradaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarEntradaKeyTyped(evt);
            }
        });

        tablaEntrada.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        tablaEntrada.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaEntrada);

        next_N_Entrada.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        next_N_Entrada.setText("Next N°");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fomix_logo.png"))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btDescargaEF.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btDescargaEF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computing-cloud (1).png"))); // NOI18N
        btDescargaEF.setText("Download");
        btDescargaEF.setBorderPainted(false);
        btDescargaEF.setContentAreaFilled(false);
        btDescargaEF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDescargaEF.setDefaultCapable(false);
        btDescargaEF.setFocusPainted(false);
        btDescargaEF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescargaEFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btNuevo_Entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar_Entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminar_Entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDescargaEF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(next_N_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(jLabel7)
                .addGap(133, 133, 133))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevo_Entrada)
                    .addComponent(btEditar_Entrada)
                    .addComponent(btEliminar_Entrada)
                    .addComponent(BuscarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_N_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDescargaEF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Entrada Fomix", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btNuevo_Entrada1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btNuevo_Entrada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        btNuevo_Entrada1.setText("Nuevo*");
        btNuevo_Entrada1.setBorderPainted(false);
        btNuevo_Entrada1.setContentAreaFilled(false);
        btNuevo_Entrada1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNuevo_Entrada1.setFocusPainted(false);
        btNuevo_Entrada1.setFocusable(false);
        btNuevo_Entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevo_Entrada1ActionPerformed(evt);
            }
        });

        btEditar_Entrada1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEditar_Entrada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btEditar_Entrada1.setText("Editar");
        btEditar_Entrada1.setBorderPainted(false);
        btEditar_Entrada1.setContentAreaFilled(false);
        btEditar_Entrada1.setFocusPainted(false);
        btEditar_Entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar_Entrada1ActionPerformed(evt);
            }
        });

        btEliminar_Entrada1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEliminar_Entrada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        btEliminar_Entrada1.setText("Eliminar");
        btEliminar_Entrada1.setBorderPainted(false);
        btEliminar_Entrada1.setContentAreaFilled(false);
        btEliminar_Entrada1.setFocusPainted(false);
        btEliminar_Entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminar_Entrada1ActionPerformed(evt);
            }
        });

        BuscarEntrada1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarEntrada1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarEntrada1KeyTyped(evt);
            }
        });

        tablaEntradaDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        tablaEntradaDG.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tablaEntradaDG);

        next_N_Entrada1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        next_N_Entrada1.setText("Next N°");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_coesicydet.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btDescargaEDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btDescargaEDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computing-cloud (1).png"))); // NOI18N
        btDescargaEDG.setText("Download");
        btDescargaEDG.setBorderPainted(false);
        btDescargaEDG.setContentAreaFilled(false);
        btDescargaEDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDescargaEDG.setDefaultCapable(false);
        btDescargaEDG.setFocusPainted(false);
        btDescargaEDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescargaEDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btNuevo_Entrada1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar_Entrada1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminar_Entrada1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDescargaEDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next_N_Entrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevo_Entrada1)
                    .addComponent(btEditar_Entrada1)
                    .addComponent(btEliminar_Entrada1)
                    .addComponent(BuscarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_N_Entrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDescargaEDG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Entrada Coesicydet", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btNuevo_Fomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btNuevo_Fomix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        btNuevo_Fomix.setText("Nuevo*");
        btNuevo_Fomix.setBorderPainted(false);
        btNuevo_Fomix.setContentAreaFilled(false);
        btNuevo_Fomix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNuevo_Fomix.setFocusPainted(false);
        btNuevo_Fomix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevo_FomixActionPerformed(evt);
            }
        });

        btEditar_Fomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEditar_Fomix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btEditar_Fomix.setText("Editar");
        btEditar_Fomix.setBorderPainted(false);
        btEditar_Fomix.setContentAreaFilled(false);
        btEditar_Fomix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar_Fomix.setFocusPainted(false);
        btEditar_Fomix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar_FomixActionPerformed(evt);
            }
        });

        btEliminar_Fomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEliminar_Fomix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        btEliminar_Fomix.setText("Eliminar");
        btEliminar_Fomix.setBorderPainted(false);
        btEliminar_Fomix.setContentAreaFilled(false);
        btEliminar_Fomix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminar_Fomix.setFocusPainted(false);
        btEliminar_Fomix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminar_FomixActionPerformed(evt);
            }
        });

        buscarFomix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarFomixKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarFomixKeyTyped(evt);
            }
        });

        tablaFomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        tablaFomix.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaFomix);

        next_N_Fomix.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        next_N_Fomix.setText("Next N°");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fomix_logo.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btDescargaSF.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btDescargaSF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computing-cloud (1).png"))); // NOI18N
        btDescargaSF.setText("Download");
        btDescargaSF.setBorderPainted(false);
        btDescargaSF.setContentAreaFilled(false);
        btDescargaSF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDescargaSF.setDefaultCapable(false);
        btDescargaSF.setFocusPainted(false);
        btDescargaSF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescargaSFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btNuevo_Fomix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar_Fomix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminar_Fomix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDescargaSF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next_N_Fomix, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarFomix, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevo_Fomix)
                    .addComponent(btEditar_Fomix)
                    .addComponent(btEliminar_Fomix)
                    .addComponent(buscarFomix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_N_Fomix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDescargaSF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Salida Fomix", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btNuevo_DG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btNuevo_DG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        btNuevo_DG.setText("Nuevo*");
        btNuevo_DG.setBorderPainted(false);
        btNuevo_DG.setContentAreaFilled(false);
        btNuevo_DG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNuevo_DG.setFocusPainted(false);
        btNuevo_DG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevo_DGActionPerformed(evt);
            }
        });

        btEditarDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEditarDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btEditarDG.setText("Editar");
        btEditarDG.setBorderPainted(false);
        btEditarDG.setContentAreaFilled(false);
        btEditarDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditarDG.setFocusPainted(false);
        btEditarDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarDGActionPerformed(evt);
            }
        });

        btEliminarDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btEliminarDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        btEliminarDG.setText("Eliminar");
        btEliminarDG.setBorderPainted(false);
        btEliminarDG.setContentAreaFilled(false);
        btEliminarDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminarDG.setFocusPainted(false);
        btEliminarDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarDGActionPerformed(evt);
            }
        });

        BuscarDG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarDGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarDGKeyTyped(evt);
            }
        });

        tablaDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        tablaDG.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaDG);

        next_N_DG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        next_N_DG.setText("Next N°");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_coesicydet.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btDescargaSDG.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        btDescargaSDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computing-cloud (1).png"))); // NOI18N
        btDescargaSDG.setText("Download");
        btDescargaSDG.setBorderPainted(false);
        btDescargaSDG.setContentAreaFilled(false);
        btDescargaSDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDescargaSDG.setDefaultCapable(false);
        btDescargaSDG.setFocusPainted(false);
        btDescargaSDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescargaSDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btNuevo_DG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditarDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminarDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDescargaSDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(next_N_DG, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarDG, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNuevo_DG)
                    .addComponent(btEditarDG)
                    .addComponent(btEliminarDG)
                    .addComponent(BuscarDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_N_DG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDescargaSDG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salida Coesicydet", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevo_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevo_EntradaActionPerformed
        Nuevo  nview = new Nuevo(this, true);
        nview.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNuevo_EntradaActionPerformed

    private void btNuevo_FomixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevo_FomixActionPerformed
        SalidaFomix sf = new SalidaFomix(this, true);
        sf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNuevo_FomixActionPerformed

    private void btNuevo_DGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevo_DGActionPerformed
        SalidaDG dg = new SalidaDG(this, true);
        dg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNuevo_DGActionPerformed

    private void btEliminar_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminar_EntradaActionPerformed
       
        int filaselect;
        String id;
        int respuesta;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaEntrada.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "confirma si realmente lo quieres eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
                    id = (String) modeloEntradaFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("delete * from fomix where id ='" + id + "'");
                    /*actutalizar*/
                    ConsultaEntradaFomix();
                }
            }
        } catch (HeadlessException | SQLException e) {

        }

    
    }//GEN-LAST:event_btEliminar_EntradaActionPerformed

    private void btEliminar_FomixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminar_FomixActionPerformed
        int filaselect;
        String id;
        int respuesta;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaFomix.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "confirma si realmente lo quieres eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloFomix = (DefaultTableModel) tablaFomix.getModel();
                    id = (String) modeloFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("delete * from fomix where id ='" + id + "'");
                    /*actutalizar*/
                    ConsultaFomix();
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btEliminar_FomixActionPerformed

    private void btEliminarDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarDGActionPerformed
        int filaselect;
        String id;
        int respuesta;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaDG.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "confirma si realmente lo quieres eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloDG = (DefaultTableModel) tablaDG.getModel();
                    id = (String) modeloDG.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("delete * from direciong where id ='" + id + "'");
                    /*actutalizar*/
                    ConsultaEntradaFomix();
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btEliminarDGActionPerformed

    private void btEditar_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar_EntradaActionPerformed
        int fsel;
        String id, num_oficio, asunto, fecha, destinatario, descripcion,remitente,aneso;
        fsel = tablaEntrada.getSelectedRow();
        
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un dato de la tabla");
        } else {
            modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
            id = (String) modeloEntradaFomix.getValueAt(fsel, 0); //aqui extraigo los datos del jtable para meyterlos en variables cambia los nombres de los variables
            num_oficio = (String) modeloEntradaFomix.getValueAt(fsel, 1);
            asunto = (String) modeloEntradaFomix.getValueAt(fsel, 2);
            fecha = (String) modeloEntradaFomix.getValueAt(fsel, 3);
            destinatario = (String) modeloEntradaFomix.getValueAt(fsel, 4);
            descripcion = (String) modeloEntradaFomix.getValueAt(fsel, 5);
            remitente = (String) modeloEntradaFomix.getValueAt(fsel, 6);
            Editar edit= new Editar(this, true,"entrada", id, "Registro de Oficio de Entrada",num_oficio, asunto, fecha, destinatario, descripcion, remitente, "");
            edit.setVisible(true);
            edit.setLocationRelativeTo(null);
            tablaEntradaFomix();
            ConsultaEntradaFomix();
        }
    }//GEN-LAST:event_btEditar_EntradaActionPerformed

    private void btEditar_FomixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar_FomixActionPerformed
        int fsel;
        String id, num_oficio, asunto, fecha, destinatario, descripcion,remitente,aneso;
        fsel = tablaFomix.getSelectedRow();
        
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un dato de la tabla");
        } else {
            modeloFomix = (DefaultTableModel) tablaFomix.getModel();
            id = (String) modeloFomix.getValueAt(fsel, 0); //aqui extraigo los datos del jtable para meyterlos en variables cambia los nombres de los variables
            num_oficio = (String) modeloFomix.getValueAt(fsel, 1);
            asunto = (String) modeloFomix.getValueAt(fsel, 2);
            fecha = (String) modeloFomix.getValueAt(fsel, 3);
            destinatario = (String) modeloFomix.getValueAt(fsel, 4);
            descripcion = (String) modeloFomix.getValueAt(fsel, 5);
            remitente = (String) modeloFomix.getValueAt(fsel, 6);
            Editar edit= new Editar(this, true,"fomix", id, "Registro de Oficio de Salida Fomix",num_oficio, asunto, fecha, destinatario, descripcion, remitente, "");
            edit.setVisible(true);
            edit.setLocationRelativeTo(null);
            tablaFomix();
            ConsultaFomix();
        }
    }//GEN-LAST:event_btEditar_FomixActionPerformed

    private void btEditarDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarDGActionPerformed
      int fsel;
        String id, num_oficio, asunto, fecha, destinatario, descripcion,remitente,aneso;
        fsel = tablaDG.getSelectedRow();
        
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un dato de la tabla");
        } else {
            modeloDG = (DefaultTableModel) tablaDG.getModel();
            id = (String) modeloDG.getValueAt(fsel, 0); //aqui extraigo los datos del jtable para meyterlos en variables cambia los nombres de los variables
            num_oficio = (String) modeloDG.getValueAt(fsel, 1);
            asunto = (String) modeloDG.getValueAt(fsel, 2);
            fecha = (String) modeloDG.getValueAt(fsel, 3);
            destinatario = (String) modeloDG.getValueAt(fsel, 4);
            descripcion = (String) modeloDG.getValueAt(fsel, 5);
            remitente = (String) modeloDG.getValueAt(fsel, 6);
            Editar edit= new Editar(this, true,"direciong", id,"Registro de Oficio de Salida Direcion General", num_oficio, asunto, fecha, destinatario, descripcion, remitente, "");
            edit.setVisible(true);
            tablaDG();
            ConsultaDG();
        }  
    }//GEN-LAST:event_btEditarDGActionPerformed

    private void BuscarEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarEntradaKeyReleased
        buscar(BuscarEntrada, "entrada", modeloEntradaFomix);
    }//GEN-LAST:event_BuscarEntradaKeyReleased

    private void BuscarEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarEntradaKeyTyped
       tablaEntradaFomix();
    }//GEN-LAST:event_BuscarEntradaKeyTyped

    private void buscarFomixKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFomixKeyReleased
        buscar(buscarFomix, "fomix", modeloFomix);
    }//GEN-LAST:event_buscarFomixKeyReleased

    private void buscarFomixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFomixKeyTyped
        tablaFomix();
    }//GEN-LAST:event_buscarFomixKeyTyped

    private void BuscarDGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarDGKeyReleased
         buscar(BuscarDG,"direciong", modeloDG);
    }//GEN-LAST:event_BuscarDGKeyReleased

    private void BuscarDGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarDGKeyTyped
        // TODO add your handling code here:
        tablaDG();
    }//GEN-LAST:event_BuscarDGKeyTyped

    private void btNuevo_Entrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevo_Entrada1ActionPerformed
       Nuevodg  nview = new Nuevodg(this, true);
       nview.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btNuevo_Entrada1ActionPerformed

    private void btEditar_Entrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar_Entrada1ActionPerformed
        int fsel;
        String id, num_oficio, asunto, fecha, destinatario, descripcion,remitente,aneso;
        fsel = tablaDG.getSelectedRow();
        
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un dato de la tabla");
        } else {
            modeloDG = (DefaultTableModel) tablaDG.getModel();
            id = (String) modeloDG.getValueAt(fsel, 0); //aqui extraigo los datos del jtable para meyterlos en variables cambia los nombres de los variables
            num_oficio = (String) modeloDG.getValueAt(fsel, 1);
            asunto = (String) modeloDG.getValueAt(fsel, 2);
            fecha = (String) modeloDG.getValueAt(fsel, 3);
            destinatario = (String) modeloDG.getValueAt(fsel, 4);
            descripcion = (String) modeloDG.getValueAt(fsel, 5);
            remitente = (String) modeloDG.getValueAt(fsel, 6);
            Editar edit= new Editar(this, true,"entradadg", id,"Registro de Oficio de Entrada Direcion General", num_oficio, asunto, fecha, destinatario, descripcion, remitente, "");
            edit.setVisible(true);
            tablaDG();
            ConsultaDG();
        }  
    }//GEN-LAST:event_btEditar_Entrada1ActionPerformed

    private void btEliminar_Entrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminar_Entrada1ActionPerformed
        int filaselect;
        String id;
        int respuesta;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaDG.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "confirma si realmente lo quieres eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloDG = (DefaultTableModel) tablaDG.getModel();
                    id = (String) modeloDG.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("delete * from entradadg where id ='" + id + "'");
                    /*actutalizar*/
                    ConsultaEntradaFomix();
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btEliminar_Entrada1ActionPerformed

    private void BuscarEntrada1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarEntrada1KeyReleased
        buscar(BuscarEntrada1, "entradadg", modeloEntradaDG);// TODO add your handling code here:
    }//GEN-LAST:event_BuscarEntrada1KeyReleased

    private void BuscarEntrada1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarEntrada1KeyTyped
        tablaEntradaDG();
    }//GEN-LAST:event_BuscarEntrada1KeyTyped

    private void btDescargaEFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescargaEFActionPerformed
        Gestion gestion = new Gestion();
        JFileChooser seleccionado = new JFileChooser();
        File archivo;
        int filaselect;
        String id;
        int respuesta;
        String qr="";
        byte[] bytesImge;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaEntrada.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Confirma si realmente quieres descargar la imagen", "Descargar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
                    id = (String) modeloEntradaFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("select * from entrada where id ='" + id + "'");
                    r.beforeFirst();
                    while (r.next()) {
                        qr = r.getString("img");
                        
                    }
                    archivo = new File(qr);
                        if (archivo.canRead()) {
                             bytesImge = gestion.AbrirAImagen(archivo);
                             System.out.println(archivo);
                             if (seleccionado.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                 seleccionado.setName("archivo.jpg");
                                 archivo = seleccionado.getSelectedFile();
                                 
                                 System.out.println(archivo+":");
                                 String res = gestion.GuardarAImagen(archivo, bytesImge);
                                 System.out.println(res);
                             }
                             
                        }
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btDescargaEFActionPerformed

    private void btDescargaEDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescargaEDGActionPerformed
       Gestion gestion = new Gestion();
        JFileChooser seleccionado = new JFileChooser();
        File archivo;
        int filaselect;
        String id;
        int respuesta;
        String qr="";
        byte[] bytesImge;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaEntrada.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Confirma si realmente quieres descargar la imagen", "Descargar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
                    id = (String) modeloEntradaFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("select * from entradadg where id ='" + id + "'");
                    r.beforeFirst();
                    while (r.next()) {
                        qr = r.getString("img");
                        
                    }
                    archivo = new File(qr);
                        if (archivo.canRead()) {
                             bytesImge = gestion.AbrirAImagen(archivo);
                             System.out.println(archivo);
                             if (seleccionado.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                 seleccionado.setName("archivo.jpg");
                                 archivo = seleccionado.getSelectedFile();
                                 
                                 System.out.println(archivo+":");
                                 String res = gestion.GuardarAImagen(archivo, bytesImge);
                                 System.out.println(res);
                             }
                             
                        }
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btDescargaEDGActionPerformed

    private void btDescargaSFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescargaSFActionPerformed
        Gestion gestion = new Gestion();
        JFileChooser seleccionado = new JFileChooser();
        File archivo;
        int filaselect;
        String id;
        int respuesta;
        String qr="";
        byte[] bytesImge;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaEntrada.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Confirma si realmente quieres descargar la imagen", "Descargar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
                    id = (String) modeloEntradaFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("select * from fomix where id ='" + id + "'");
                    r.beforeFirst();
                    while (r.next()) {
                        qr = r.getString("img");
                        
                    }
                    archivo = new File(qr);
                        if (archivo.canRead()) {
                             bytesImge = gestion.AbrirAImagen(archivo);
                             System.out.println(archivo);
                             if (seleccionado.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                 seleccionado.setName("archivo.jpg");
                                 archivo = seleccionado.getSelectedFile();
                                 
                                 System.out.println(archivo+":");
                                 String res = gestion.GuardarAImagen(archivo, bytesImge);
                                 System.out.println(res);
                             }
                             
                        }
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btDescargaSFActionPerformed

    private void btDescargaSDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescargaSDGActionPerformed
        Gestion gestion = new Gestion();
        JFileChooser seleccionado = new JFileChooser();
        File archivo;
        int filaselect;
        String id;
        int respuesta;
        String qr="";
        byte[] bytesImge;
        Statement sentencia = conn.getStatement();
        try {
            filaselect = tablaEntrada.getSelectedRow();
            if (filaselect == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un dato");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "Confirma si realmente quieres descargar la imagen", "Descargar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    modeloEntradaFomix = (DefaultTableModel) tablaEntrada.getModel();
                    id = (String) modeloEntradaFomix.getValueAt(filaselect, 0);
                    /*modelo.removeRow(filaselect);*/
                    ResultSet r = sentencia.executeQuery("select * from direciong where id ='" + id + "'");
                    r.beforeFirst();
                    while (r.next()) {
                        qr = r.getString("img");
                        
                    }
                    archivo = new File(qr);
                        if (archivo.canRead()) {
                             bytesImge = gestion.AbrirAImagen(archivo);
                             System.out.println(archivo);
                             if (seleccionado.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                 seleccionado.setName("archivo.jpg");
                                 archivo = seleccionado.getSelectedFile();
                                 
                                 System.out.println(archivo+":");
                                 String res = gestion.GuardarAImagen(archivo, bytesImge);
                                 System.out.println(res);
                             }
                             
                        }
                }
            }
        } catch (HeadlessException | SQLException e) {

        }
    }//GEN-LAST:event_btDescargaSDGActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarDG;
    private javax.swing.JTextField BuscarEntrada;
    private javax.swing.JTextField BuscarEntrada1;
    private javax.swing.JButton btDescargaEDG;
    private javax.swing.JButton btDescargaEF;
    private javax.swing.JButton btDescargaSDG;
    private javax.swing.JButton btDescargaSF;
    private javax.swing.JButton btEditarDG;
    private javax.swing.JButton btEditar_Entrada;
    private javax.swing.JButton btEditar_Entrada1;
    private javax.swing.JButton btEditar_Fomix;
    private javax.swing.JButton btEliminarDG;
    private javax.swing.JButton btEliminar_Entrada;
    private javax.swing.JButton btEliminar_Entrada1;
    private javax.swing.JButton btEliminar_Fomix;
    private javax.swing.JButton btNuevo_DG;
    private javax.swing.JButton btNuevo_Entrada;
    private javax.swing.JButton btNuevo_Entrada1;
    private javax.swing.JButton btNuevo_Fomix;
    private javax.swing.JTextField buscarFomix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel next_N_DG;
    private javax.swing.JLabel next_N_Entrada;
    private javax.swing.JLabel next_N_Entrada1;
    private javax.swing.JLabel next_N_Fomix;
    private javax.swing.JTable tablaDG;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTable tablaEntradaDG;
    private javax.swing.JTable tablaFomix;
    // End of variables declaration//GEN-END:variables
    
    private void buscar(JTextField txtBusqueda, String tabla, DefaultTableModel modelo){
        String textoNombre = txtBusqueda.getText();
        String sql = "SELECT * FROM "+tabla+" WHERE asunto LIKE "+"'%"+textoNombre+"%'";
        String info = "";
        Object Datos[];
        Statement sentencia = conn.getStatement();
        try {

            ResultSet r = sentencia.executeQuery(sql);
            r.beforeFirst();
            while (r.next()) {

                Datos = new Object[7];
                Datos[0] = r.getString("id");
                Datos[1] = r.getString("num_oficio");
                Datos[2] = r.getString("asunto");
                Datos[4] = r.getString("destinatario");
                Datos[5] = r.getString("descripcion");
                Datos[6] = r.getString("remitente");
                //Datos[5]=r.getString("fecha");
                String fecha = r.getString("fecha");
                fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4);
                Datos[3] = fecha;
                
                modelo.addRow(Datos);
                
                //Consulta();
            }
        }
        catch (Exception e) {
            System.out.println("" + e);
        }
    
    }
}

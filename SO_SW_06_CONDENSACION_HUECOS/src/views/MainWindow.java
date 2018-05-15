package views;

import controller.Actions;
import controller.Controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import logic.Process;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.Partition;
import static views.GUIUtils.APP_TITLE;

/**
 * Esta clase representa la GUI principal sobre la cual el usuario realizará la
 * mayoría de las operaciones, podrá visualizar los procesos creados, iniciar la
 * ejecución de los procesos y visualizar las tablas de Procesos E/S, Estados y
 * transiciones
 *
 * @author Gabriel Huertas y Cesar Cardozo
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener {

    //---------------------- Attributes -------------------------------
    /**
     * Modelo de tabla utilizado para manipular la tabla
     */
    private DefaultTableModel processesTableModel;
    private DefaultTableModel partitionsTableModel;
    private DefaultTableModel processesPerPartitionsPassedTableModel;
    private DefaultTableModel processesPerPartitionsExecTableModel;
    private DefaultTableModel processesPerPartitionsOutTableModel;
    private DefaultTableModel unprocessedProcessesTableModel;
    private DefaultTableModel orderFinishingPartitionsTableModel;

    private Controller controller;

    //---------------------- Constructores -------------------------
    /**
     * Crea una nueva instancia de MainWindow
     *
     * @param controller referencia al controlador que manejará los eventos
     */
    public MainWindow(Controller controller) {

        this.controller = controller;

        processesTableModel = new DefaultTableModel(GUIUtils.ADD_PROCESSES_TABLE_HEADERS, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        partitionsTableModel = new DefaultTableModel(GUIUtils.ADD_PARTITIONS_TABLE_HEADERS, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsPassedTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        unprocessedProcessesTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        orderFinishingPartitionsTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsPassedTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsOutTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsExecTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.setTitle(APP_TITLE);
        this.setUndecorated(true);
        initComponents();
        orderFinishingPanel.setVisible(false);
        setActions(controller);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        showOptions(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //-------------------------- Métodos ---------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partitionsPopupMenu = new javax.swing.JPopupMenu();
        editPartitionjmi = new javax.swing.JMenuItem();
        deletePartitionjmi = new javax.swing.JMenuItem();
        processesPopupMenu = new javax.swing.JPopupMenu();
        editProcessjmi = new javax.swing.JMenuItem();
        deleteProcessjmi = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        createProcessbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        startbtn = new javax.swing.JButton();
        createPartitionbtn = new javax.swing.JButton();
        partitionsandProcessesbtn = new javax.swing.JButton();
        partitionsReportbtn1 = new javax.swing.JButton();
        partitionsReportbtn2 = new javax.swing.JButton();
        menulbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        processesandPartitionsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partitionsTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        processesTable = new javax.swing.JTable();
        tableHeaderPartitionslbl = new javax.swing.JLabel();
        tableHeaderProcesseslbl = new javax.swing.JLabel();
        processesPerPartitionsPanel = new javax.swing.JPanel();
        tableHeaderPartitionslbl2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        processesPerPartitionOutTable = new javax.swing.JTable();
        unprocessedProcessesPanel = new javax.swing.JPanel();
        unprocessedProcessesTablelbl = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        unprocessedProcessesTable = new javax.swing.JTable();
        orderFinishingPanel = new javax.swing.JPanel();
        orderFinishingTablelbl = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        orderFinishingTable = new javax.swing.JTable();
        processesPerPartitionsReadyExecOutPanel = new javax.swing.JPanel();
        unprocessedProcessesTablelbl1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        processesPerPartitionsOutTable = new javax.swing.JTable();
        unprocessedProcessesTablelbl2 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        processesPerPartitionsExecTable = new javax.swing.JTable();
        unprocessedProcessesTablelbl3 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        processesPerPartitionsExecTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        defineQuantumjmi = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        checkManualjmi = new javax.swing.JMenuItem();

        editPartitionjmi.setText("Editar");
        partitionsPopupMenu.add(editPartitionjmi);

        deletePartitionjmi.setText("Eliminar");
        partitionsPopupMenu.add(deletePartitionjmi);

        editProcessjmi.setText("Editar"
        );
        processesPopupMenu.add(editProcessjmi);

        deleteProcessjmi.setText("Eliminar"
        );
        processesPopupMenu.add(deleteProcessjmi);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(209, 700));

        createProcessbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        createProcessbtn.setText("Crear Proceso");

        exitbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        exitbtn.setText("Salir");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        startbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        startbtn.setText("Iniciar");

        createPartitionbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        createPartitionbtn.setText("Crear Partición");

        partitionsandProcessesbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsandProcessesbtn.setText("Reporte General");

        partitionsReportbtn1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsReportbtn1.setText("Reporte Particiones 1");

        partitionsReportbtn2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsReportbtn2.setText("Reporte Particiones 2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createPartitionbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createProcessbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partitionsandProcessesbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partitionsReportbtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(partitionsReportbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(createPartitionbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createProcessbtn)
                .addGap(10, 10, 10)
                .addComponent(partitionsandProcessesbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partitionsReportbtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(partitionsReportbtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitbtn)
                .addContainerGap())
        );

        menulbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menulbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menulbl.setText("Menú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menulbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(menulbl)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 2060, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        partitionsTable.setModel(partitionsTableModel);
        jScrollPane2.setViewportView(partitionsTable);

        processesTable.setModel(processesTableModel);
        processesTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(processesTable);

        tableHeaderPartitionslbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl.setText("Particiones");

        tableHeaderProcesseslbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderProcesseslbl.setText("Procesos");

        javax.swing.GroupLayout processesandPartitionsPanelLayout = new javax.swing.GroupLayout(processesandPartitionsPanel);
        processesandPartitionsPanel.setLayout(processesandPartitionsPanelLayout);
        processesandPartitionsPanelLayout.setHorizontalGroup(
            processesandPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesandPartitionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesandPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(processesandPartitionsPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(processesandPartitionsPanelLayout.createSequentialGroup()
                        .addComponent(tableHeaderPartitionslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableHeaderProcesseslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(354, 354, 354))))
        );
        processesandPartitionsPanelLayout.setVerticalGroup(
            processesandPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, processesandPartitionsPanelLayout.createSequentialGroup()
                .addGroup(processesandPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableHeaderPartitionslbl)
                    .addComponent(tableHeaderProcesseslbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(processesandPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableHeaderPartitionslbl2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl2.setText("Lista paso de procesos por particiones");

        processesPerPartitionOutTable.setModel(processesPerPartitionsPassedTableModel);
        jScrollPane5.setViewportView(processesPerPartitionOutTable);

        javax.swing.GroupLayout processesPerPartitionsPanelLayout = new javax.swing.GroupLayout(processesPerPartitionsPanel);
        processesPerPartitionsPanel.setLayout(processesPerPartitionsPanelLayout);
        processesPerPartitionsPanelLayout.setHorizontalGroup(
            processesPerPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesPerPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(processesPerPartitionsPanelLayout.createSequentialGroup()
                        .addComponent(tableHeaderPartitionslbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        processesPerPartitionsPanelLayout.setVerticalGroup(
            processesPerPartitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanelLayout.createSequentialGroup()
                .addComponent(tableHeaderPartitionslbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        unprocessedProcessesTablelbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        unprocessedProcessesTablelbl.setText("Lista procesos no procesados");

        unprocessedProcessesTable.setModel(unprocessedProcessesTableModel);
        jScrollPane6.setViewportView(unprocessedProcessesTable);

        javax.swing.GroupLayout unprocessedProcessesPanelLayout = new javax.swing.GroupLayout(unprocessedProcessesPanel);
        unprocessedProcessesPanel.setLayout(unprocessedProcessesPanelLayout);
        unprocessedProcessesPanelLayout.setHorizontalGroup(
            unprocessedProcessesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unprocessedProcessesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unprocessedProcessesTablelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
            .addGroup(unprocessedProcessesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(unprocessedProcessesPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        unprocessedProcessesPanelLayout.setVerticalGroup(
            unprocessedProcessesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unprocessedProcessesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unprocessedProcessesTablelbl)
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(unprocessedProcessesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(unprocessedProcessesPanelLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        orderFinishingTablelbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        orderFinishingTablelbl.setText("Orden de terminación de Particiones");

        orderFinishingTable.setModel(orderFinishingPartitionsTableModel);
        jScrollPane8.setViewportView(orderFinishingTable);

        javax.swing.GroupLayout orderFinishingPanelLayout = new javax.swing.GroupLayout(orderFinishingPanel);
        orderFinishingPanel.setLayout(orderFinishingPanelLayout);
        orderFinishingPanelLayout.setHorizontalGroup(
            orderFinishingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderFinishingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderFinishingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(orderFinishingPanelLayout.createSequentialGroup()
                        .addComponent(orderFinishingTablelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        orderFinishingPanelLayout.setVerticalGroup(
            orderFinishingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderFinishingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderFinishingTablelbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        unprocessedProcessesTablelbl1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        unprocessedProcessesTablelbl1.setText("Lista Salida Procesos por Particiones");

        processesPerPartitionsOutTable.setModel(processesPerPartitionsOutTableModel);
        jScrollPane7.setViewportView(processesPerPartitionsOutTable);

        unprocessedProcessesTablelbl2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        unprocessedProcessesTablelbl2.setText("Lista Ejecución Procesos por Particiones");

        processesPerPartitionsExecTable.setModel(processesPerPartitionsExecTableModel);
        jScrollPane9.setViewportView(processesPerPartitionsExecTable);

        unprocessedProcessesTablelbl3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        unprocessedProcessesTablelbl3.setText("Lista Procesos Listos por Particiones");

        processesPerPartitionsExecTable1.setModel(processesPerPartitionsExecTableModel);
        jScrollPane10.setViewportView(processesPerPartitionsExecTable1);

        javax.swing.GroupLayout processesPerPartitionsReadyExecOutPanelLayout = new javax.swing.GroupLayout(processesPerPartitionsReadyExecOutPanel);
        processesPerPartitionsReadyExecOutPanel.setLayout(processesPerPartitionsReadyExecOutPanelLayout);
        processesPerPartitionsReadyExecOutPanelLayout.setHorizontalGroup(
            processesPerPartitionsReadyExecOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsReadyExecOutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesPerPartitionsReadyExecOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(processesPerPartitionsReadyExecOutPanelLayout.createSequentialGroup()
                        .addGroup(processesPerPartitionsReadyExecOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unprocessedProcessesTablelbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unprocessedProcessesTablelbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unprocessedProcessesTablelbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                .addContainerGap())
        );
        processesPerPartitionsReadyExecOutPanelLayout.setVerticalGroup(
            processesPerPartitionsReadyExecOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsReadyExecOutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unprocessedProcessesTablelbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unprocessedProcessesTablelbl2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(unprocessedProcessesTablelbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Configuración");

        defineQuantumjmi.setText("Definir Quantum");
        jMenu1.add(defineQuantumjmi);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        checkManualjmi.setText("Ver Manual");
        checkManualjmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkManualjmiActionPerformed(evt);
            }
        });
        jMenu2.add(checkManualjmi);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processesandPartitionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesPerPartitionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unprocessedProcessesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderFinishingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesPerPartitionsReadyExecOutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(processesandPartitionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderFinishingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processesPerPartitionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(unprocessedProcessesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processesPerPartitionsReadyExecOutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 39, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Define el comando de acción para cada botón utilizado y agrega como
     * escuchador de eventos a la referencia de la clase Controller
     *
     * @param controller Referencia al manejador de eventos
     */
    private void setActions(Controller controller) {
        createProcessbtn.setActionCommand(Actions.OPEN_CREATE_PROCESS.name());
        createProcessbtn.addActionListener(controller);
        createPartitionbtn.setActionCommand(Actions.OPEN_CREATE_PARTITION.name());
        createPartitionbtn.addActionListener(controller);
        startbtn.setActionCommand(Actions.START.name());
        startbtn.addActionListener(controller);
        defineQuantumjmi.setActionCommand(Actions.OPEN_DEFINE_QUANTUM.name());
        defineQuantumjmi.addActionListener(controller);
        partitionsandProcessesbtn.setActionCommand(Actions.SHOW_PARTITIONS_AND_PROCESSES_TWO.name());
        partitionsandProcessesbtn.addActionListener(controller);
        //     generalReportbtn.setActionCommand(Actions.SHOW_GENERAL_REPORT.name());
        //   generalReportbtn.addActionListener(controller);
        partitionsReportbtn1.setActionCommand(Actions.SHOW_PARTITIONS_REPORT_1.name());
        partitionsReportbtn1.addActionListener(controller);
        partitionsReportbtn2.setActionCommand(Actions.SHOW_PARTITIONS_REPORT_2.name());
        partitionsReportbtn2.addActionListener(controller);

        //---------------OPCIONES JPOPUPMENUS
        editPartitionjmi.addActionListener(this);
        deletePartitionjmi.addActionListener(this);
        editProcessjmi.addActionListener(this);
        deleteProcessjmi.addActionListener(this);

    }

    /**
     * Elimina todos los valores de la tabla sin sus encabezados
     */
    private void clearTable() {
        processesTableModel.getDataVector().removeAllElements();
    }

    /**
     * Agrega un nuevo proceso a la tabla
     *
     * @param p El proceso a agregar a la tabla
     */
    public void addProcess(Process p) {
        //Define el número de filas como el número de filas actual + 1, esto para
        //Dar espacio para agregar el proceso
        processesTableModel.setRowCount(processesTableModel.getRowCount() + 1);
        //Agrega los datos del proceso en las columnas correspondientes
        processesTableModel.setValueAt(p.getName(), processesTableModel.getRowCount() - 1, 0);
        processesTableModel.setValueAt(p.getOldExecutionTime(), processesTableModel.getRowCount() - 1, 1);
        processesTableModel.setValueAt(p.getProcessSize(), processesTableModel.getRowCount() - 1, 2);
        this.repaint();
    }

    /**
     * Agrega un nuevo proceso a la tabla
     *
     * @param p El proceso a agregar a la tabla
     */
    public void addPartition(Partition p) {
        //Define el número de filas como el número de filas actual + 1, esto para
        //Dar espacio para agregar el proceso
        partitionsTableModel.setRowCount(partitionsTableModel.getRowCount() + 1);
        //Agrega los datos del proceso en las columnas correspondientes
        partitionsTableModel.setValueAt(p.getPartitionName(), partitionsTableModel.getRowCount() - 1, 0);
        partitionsTableModel.setValueAt(p.getPartitionSize(), partitionsTableModel.getRowCount() - 1, 1);

        this.repaint();
    }

    private void checkManualjmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkManualjmiActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("./Manual_de_Usuario.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el PDF desde la aplicación. Lo puede encontrar en la" + ""
                        + " \n carpeta SO_SW_05_MULTIPROGRAMACIÓN_REUBICACION ",
                        APP_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_checkManualjmiActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    /**
     * Muestra las opciones en el menú de acuerdo a
     *
     * @param isInitial Bandera que indica si la ventana se muestra con opciones
     * iniciales o con las opciones disponibles después de iniciar la ejecución
     * de los procesos
     */
    public void showOptions(boolean isInitial) {
        createProcessbtn.setVisible(isInitial);
        createPartitionbtn.setVisible(isInitial);
        startbtn.setVisible(isInitial);
        partitionsandProcessesbtn.setVisible(!isInitial);
        partitionsReportbtn1.setVisible(!isInitial);
        partitionsReportbtn2.setVisible(!isInitial);
        partitionsTable.setComponentPopupMenu((isInitial) ? partitionsPopupMenu : null);
        processesTable.setComponentPopupMenu((isInitial) ? processesPopupMenu : null);
        processesPerPartitionsPanel.setVisible(!isInitial);
        unprocessedProcessesPanel.setVisible(!isInitial);
        processesPerPartitionsReadyExecOutPanel.setVisible(!isInitial);
        orderFinishingPanel.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem checkManualjmi;
    private javax.swing.JButton createPartitionbtn;
    private javax.swing.JButton createProcessbtn;
    private javax.swing.JMenuItem defineQuantumjmi;
    private javax.swing.JMenuItem deletePartitionjmi;
    private javax.swing.JMenuItem deleteProcessjmi;
    private javax.swing.JMenuItem editPartitionjmi;
    private javax.swing.JMenuItem editProcessjmi;
    private javax.swing.JButton exitbtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel menulbl;
    private javax.swing.JPanel orderFinishingPanel;
    private javax.swing.JTable orderFinishingTable;
    private javax.swing.JLabel orderFinishingTablelbl;
    private javax.swing.JPopupMenu partitionsPopupMenu;
    private javax.swing.JButton partitionsReportbtn1;
    private javax.swing.JButton partitionsReportbtn2;
    private javax.swing.JTable partitionsTable;
    private javax.swing.JButton partitionsandProcessesbtn;
    private javax.swing.JTable processesPerPartitionOutTable;
    private javax.swing.JTable processesPerPartitionsExecTable;
    private javax.swing.JTable processesPerPartitionsExecTable1;
    private javax.swing.JTable processesPerPartitionsOutTable;
    private javax.swing.JPanel processesPerPartitionsPanel;
    private javax.swing.JPanel processesPerPartitionsReadyExecOutPanel;
    private javax.swing.JPopupMenu processesPopupMenu;
    private javax.swing.JTable processesTable;
    private javax.swing.JPanel processesandPartitionsPanel;
    private javax.swing.JButton startbtn;
    private javax.swing.JLabel tableHeaderPartitionslbl;
    private javax.swing.JLabel tableHeaderPartitionslbl2;
    private javax.swing.JLabel tableHeaderProcesseslbl;
    private javax.swing.JPanel unprocessedProcessesPanel;
    private javax.swing.JTable unprocessedProcessesTable;
    private javax.swing.JLabel unprocessedProcessesTablelbl;
    private javax.swing.JLabel unprocessedProcessesTablelbl1;
    private javax.swing.JLabel unprocessedProcessesTablelbl2;
    private javax.swing.JLabel unprocessedProcessesTablelbl3;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param partitionsList
     * @param input_ProcessList
     */
    public void showPartitionsandProcesses(ArrayList<Partition> partitionsList, ArrayList<Process> input_ProcessList) {
        clearTable();
        partitionsTableModel.getDataVector().removeAllElements();
        processesandPartitionsPanel.setVisible(true);
        processesPerPartitionsPanel.setVisible(false);
        unprocessedProcessesPanel.setVisible(false);
        orderFinishingPanel.setVisible(false);
        processesPerPartitionsReadyExecOutPanel.setVisible(false);
        
        tableHeaderProcesseslbl.setText(GUIUtils.ADD_PROCESSES_LABEL_HEADER);
        processesTableModel.setColumnIdentifiers(GUIUtils.ADD_PROCESSES_TABLE_HEADERS);
        for (Partition partition : partitionsList) {
            addPartition(partition);
        }
        for (Process process : input_ProcessList) {
            addProcess(process);
        }
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        if (menuItem == editPartitionjmi) {
            int row = partitionsTable.getSelectedRow();
            String value = partitionsTable.getModel().getValueAt(row, 0).toString();
            controller.editPartition(value);
        } else if (menuItem == deletePartitionjmi) {
            int row = partitionsTable.getSelectedRow();
            String value = partitionsTable.getModel().getValueAt(row, 0).toString();
            controller.deletePartition(value);
        } else if (menuItem == editProcessjmi) {
            int row = processesTable.getSelectedRow();
            String value = processesTable.getModel().getValueAt(row, 0).toString();
            controller.editProcess(value);
        } else if (menuItem == deleteProcessjmi) {
            int row = processesTable.getSelectedRow();
            String value = processesTable.getModel().getValueAt(row, 0).toString();
            controller.deleteProcess(value);
        }
//        System.out.println("salio");  
    }

    public void showUnprocessedProcesses(ArrayList<Process> unprocessedProcessesList) {
        processesandPartitionsPanel.setVisible(false);
        orderFinishingPanel.setVisible(false);
        processesPerPartitionsPanel.setVisible(true);
        unprocessedProcessesPanel.setVisible(true);
        processesPerPartitionsReadyExecOutPanel.setVisible(false);
        
        unprocessedProcessesTableModel.getDataVector().removeAllElements();
        unprocessedProcessesTableModel.setRowCount(unprocessedProcessesList.size());
        for (int i = 0; i < unprocessedProcessesList.size(); i++) {
            unprocessedProcessesTableModel.setValueAt(unprocessedProcessesList.get(i).getName(), i, 0);
            unprocessedProcessesTableModel.setValueAt(unprocessedProcessesList.get(i).getProcessSize(), i, 1);
            unprocessedProcessesTableModel.setValueAt(unprocessedProcessesList.get(i).getOldExecutionTime(), i, 2);
            unprocessedProcessesTableModel.setValueAt("No existe partición que tenga un tamaño de " + unprocessedProcessesList.get(i).getProcessSize(), i, 3);

        }
    }

    public void showProcessesPerPartitionsThatPassed(Object[] partitionTableHeaders, ArrayList<Partition> partitionsList) {

        processesPerPartitionsPanel.setVisible(true);
        processesandPartitionsPanel.setVisible(false);
        orderFinishingPanel.setVisible(false);
        processesPerPartitionsReadyExecOutPanel.setVisible(false);

        //SETEA LOS HEADERS DE LAS TABLAS Y LAS LIMPIA
        processesPerPartitionsPassedTableModel.getDataVector().removeAllElements();
        unprocessedProcessesTableModel.getDataVector().removeAllElements();

        processesPerPartitionsPassedTableModel.setColumnIdentifiers(partitionTableHeaders);
        unprocessedProcessesTableModel.setColumnIdentifiers(GUIUtils.UNPROCESSED_PROCESSES_TABLE_HEADERS);

        ArrayList<Integer> sizesInput = new ArrayList<>();

        for (Partition partition : partitionsList) {
            sizesInput.add(partition.getInputProcesses().size());
        }

        int maxSizeOut = Collections.max(sizesInput);

        processesPerPartitionsPassedTableModel.setRowCount(maxSizeOut);
        //processesPerPartitionsUnpTableModel.setRowCount(maxSizeUnp);
        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getInputProcesses().size(); j++) {
                processesPerPartitionsPassedTableModel.setValueAt(partitionsList.get(i).getInputProcesses().get(j).getName(), j, i);
            }
        }
    }

    public void showOrderFinishingPartitions(ArrayList<Partition> output_PartitionsList) {
        orderFinishingPanel.setVisible(true);
        orderFinishingPartitionsTableModel.setColumnIdentifiers(GUIUtils.ORDER_FINISHING_PARTITIONS_TABLE_HEADERS);
        orderFinishingPartitionsTableModel.setRowCount(output_PartitionsList.size());
        for (int i = 0; i < output_PartitionsList.size(); i++) {
            orderFinishingPartitionsTableModel.setValueAt(output_PartitionsList.get(i).getPartitionName(), i, 0);
            orderFinishingPartitionsTableModel.setValueAt(output_PartitionsList.get(i).getTotalExecutionTime(), i, 1);
        }

    }

    public void showProcessesPerPartitionsReadyExecOut(Object[] partitionTableHeaders, ArrayList<Partition> partitionsList) {
        processesPerPartitionsPanel.setVisible(false);
        processesandPartitionsPanel.setVisible(false);
        unprocessedProcessesPanel.setVisible(false);
        orderFinishingPanel.setVisible(false);
        processesPerPartitionsReadyExecOutPanel.setVisible(true);

        processesPerPartitionsExecTableModel.getDataVector().removeAllElements();
        processesPerPartitionsOutTableModel.getDataVector().removeAllElements();
        processesPerPartitionsExecTableModel.setColumnIdentifiers(partitionTableHeaders);
        processesPerPartitionsOutTableModel.setColumnIdentifiers(partitionTableHeaders);

        ArrayList<Integer> sizesExec = new ArrayList<>();
        ArrayList<Integer> sizesOut = new ArrayList<>();

        for (Partition partition : partitionsList) {
            sizesExec.add(partition.getExecutionProcesses().size());
            sizesOut.add(partition.getOutputListProcesses().size());
        }

        int maxSizeExec = Collections.max(sizesExec);
        int maxSizeOut = Collections.max(sizesOut);

        processesPerPartitionsExecTableModel.setRowCount(maxSizeExec);
        processesPerPartitionsOutTableModel.setRowCount(maxSizeOut);

        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getExecutionProcesses().size(); j++) {
                processesPerPartitionsExecTableModel.setValueAt(partitionsList.get(i).getExecutionProcesses().get(j).getName(), j, i);
            }
        }
        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getOutputListProcesses().size(); j++) {
                processesPerPartitionsOutTableModel.setValueAt(partitionsList.get(i).getOutputListProcesses().get(j).getName(), j, i);
            }
        }

    }
}

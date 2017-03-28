/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.view;

import code.hotel.victoria.model.beans.BEmpleado;
import code.hotel.victoria.model.dao.DAOEmpleado;
import code.hotel.victoria.model.interfaces.IEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PSantana
 */
public class MntColaboradores extends javax.swing.JInternalFrame implements ActionListener{
    private int opcion; // 1 = Registrar 2=Actualzar
    private DefaultTableModel tblemp= new DefaultTableModel(setTitle(), 0);
    private DefaultTableModel tblusu= new DefaultTableModel(setTitle(), 0);
    private IEmpleado empleado= new DAOEmpleado();
    SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
    public MntColaboradores() {
        initComponents();        
        insertDependencies();
        setToolTip();
        isControlActive(false);
        dcFechaI.setDateFormat(df);
        dcFechaN.setDateFormat(df);
        
    }
    //METODOS DE REGISTRO EMPLEADO O COLABORADOR
    private boolean validar(){
        String n=txtNombre.getText().trim();
        String p=txtPaterno.getText().trim();
        String m=txtMaterno.getText().trim();
        String t=txtTelf.getText().trim();
        String d=txtDni.getText().trim();
        int dep=cmbDepartamento.getSelectedIndex();
        int dis=cmbDistrito.getSelectedIndex();
        int es =cmbEstado.getSelectedIndex();
        int tip=cmbTipo.getSelectedIndex();
        if(n.isEmpty()||p.isEmpty()||m.isEmpty()||t.isEmpty()||d.isEmpty()){
            JOptionPane.showMessageDialog(this, "Rellene los campos");
            return false;
        }
        if(dep<=0||dis<=0||es<=0||tip<=0){
            JOptionPane.showMessageDialog(this, "Elija correctamente las opciones");
            return false;
        }
        return true;
    }
    private void setToolTip(){
        btnActualizarE.setToolTipText("Actualizar");
        btnGuardarE.setToolTipText("Guardar");
        btnNuevoE.setToolTipText("Nuevo");
    }
    private  String []  setTitle (){
        String [] titulo={"ID","Nombre","Apellido P.","Apellido M.","Dni","Telf",
            "Distrito","Fecha I.","Estado","Tipo","Fecha N.","Departamento","Usuario"};
        return titulo;
    }
    private void insertDependencies(){
        txtID.setVisible(false);
        btnActualizarE.addActionListener(this);
        btnGuardarE.addActionListener(this);
        btnCancelarE.addActionListener(this);
        btnNuevoE.addActionListener(this);
        
        tblEmpleados.setModel(tblemp);
        
        empleado.getEstado(cmbEstado);
        empleado.getDepartamento(cmbDepartamento);
        empleado.getTipo(cmbTipo);
        
        cmbDistrito.removeAllItems();cmbDistrito.addItem("(Distrito)");
        
        getDistrito();
        
        empleado.setTable(tblemp);
    }
    
    private String cutIDs(JComboBox cmb,int index){
        String text=cmb.getSelectedItem().toString();
        String cut=text.substring(text.length()-index);
        return cut;
    }
    private BEmpleado setParametersInsert(){ //establece los parametros requeridos para actualizar o registrar
        BEmpleado empleado=new BEmpleado(txtNombre.getText().trim(), txtPaterno.getText().trim(), 
                txtMaterno.getText().trim(), txtDni.getText().trim(), txtTelf.getText().trim(), 
                cutIDs(cmbDistrito, 4).trim(),dcFechaI.getText().trim(),
                cutIDs(cmbEstado, 3).trim(), cutIDs(cmbTipo, 2).trim(),
                dcFechaN.getText().trim(), cutIDs(cmbDepartamento, 4).trim());
//                System.out.println("Nombre :"+txtNombre.getText());
//                System.out.println("paterno :"+txtPaterno.getText());
//                System.out.println("materno :"+txtMaterno.getText());
//                System.out.println("dni :"+txtDni.getText());
//                System.out.println("telf :"+txtTelf.getText());
//                System.out.println("Distrito :"+cutIDs(cmbDistrito, 3)+"/");
//                System.out.println("FechaI :"+dcFechaI.getText()+"/");
//                System.out.println("Estado :"+cutIDs(cmbEstado, 3)+"/");
//                System.out.println("Tipo :"+cutIDs(cmbTipo, 2)+"/");
//                System.out.println("FechaN :"+dcFechaN.getText()+"/");
//                System.out.println("Departamento :"+cutIDs(cmbDepartamento, 4)+"/");
                
//        BEmpleado empleado= new BEmpleado("Juan", "Peres", "Roman", 
//                "45812465", "326545", "L29","10-10-1991",
//                "EM1", "E1", "10-10-1985", "PE15");
        return empleado;
    }
    
    private BEmpleado setParametersUpd(){ //establece los parametros requeridos para actualizar o registrar
        BEmpleado empleados=new BEmpleado(Integer.parseInt(txtID.getText()),txtNombre.getText().trim(),
                txtPaterno.getText().trim(), txtMaterno.getText().trim(), txtDni.getText().trim(), 
                txtTelf.getText().trim(), cutIDs(cmbDistrito, 4).trim(),dcFechaI.getText().trim(),
                cutIDs(cmbEstado, 3).trim(), cutIDs(cmbTipo, 2).trim(),
                dcFechaN.getText().trim(), cutIDs(cmbDepartamento, 4).trim());

        return empleados;
    }
    
    private void visibleButton(boolean isOn,boolean cancel){
        if(cancel){
            btnActualizarE.setVisible(true);
            btnNuevoE.setVisible(true);
            btnGuardarE.setVisible(true);
        }else{
            btnGuardarE.setVisible(isOn);
            btnNuevoE.setVisible(!isOn);
            btnActualizarE.setVisible(!isOn);             
        }
    }
    
    private void isControlActive(boolean on){
        txtNombre.setEditable(on);
        txtDni.setEditable(on);
        txtMaterno.setEditable(on);
        txtPaterno.setEditable(on);
        txtTelf.setEditable(on);
        dcFechaI.setEnabled(on);
        dcFechaN.setEnabled(on);
    }
    private void clean(){
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtTelf.setText("");
        txtDni.setText("");
        cmbDepartamento.setSelectedIndex(0);
        cmbDistrito.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        cmbTipo.setSelectedIndex(0);
    }

    private void getDistrito(){
    cmbDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empleado.getDistrito(cmbDistrito, cmbDepartamento);
            }
        });
    }
    //FINALIZA LOS METODOS DE EMPLEADO O COLABORADOR
    //eventos 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnActualizarE){ 
            boolean isExistDni=false;
            opcion=2;           
            int fila=0;
            String dni=JOptionPane.showInputDialog(this, "Ingrese el Nª de Dni para editar");
            if(dni==null){
                return;
            }
            while(dni.trim().isEmpty())    {
                JOptionPane.showMessageDialog(this, "Debe completar el campo");
                dni=JOptionPane.showInputDialog(this, "Ingrese el Nª de Dni para editar");
                if(dni==null){
                return;
                }
            }           
            for (int i = 0; i < tblemp.getRowCount(); i++) {
                if(tblemp.getValueAt(i, 4).equals(dni)){
                    isExistDni=true;
                    fila=i;
                    break;
                }  
            }
            if(isExistDni){
                visibleButton(true, false);  
                isControlActive(true);
                //
                String year=tblemp.getValueAt(fila, 10).toString().substring(0,4);
                String month=tblemp.getValueAt(fila, 10).toString().substring(5,7);
                String day=tblemp.getValueAt(fila, 10).toString().substring(8);
                int dia=Integer.parseInt(day);
                int mes=Integer.parseInt(month);
                int anio=Integer.parseInt(year);
                
                String years=tblemp.getValueAt(fila, 7).toString().substring(0,4);
                String months=tblemp.getValueAt(fila, 7).toString().substring(5,7);
                String days=tblemp.getValueAt(fila, 7).toString().substring(8);
                int dias=Integer.parseInt(days);
                int mess=Integer.parseInt(months);
                int anios=Integer.parseInt(years);
                //
                Calendar c = new GregorianCalendar(anio, mes-1, dia);
                System.out.println(c);
                Calendar c2= new GregorianCalendar(anios, mess-1, dias);
                
                txtID.setText(tblemp.getValueAt(fila, 0).toString());
                txtNombre.setText(tblemp.getValueAt(fila, 1).toString());
                txtPaterno.setText(tblemp.getValueAt(fila, 2).toString());
                txtMaterno.setText(tblemp.getValueAt(fila, 3).toString());
                txtDni.setText(tblemp.getValueAt(fila, 4).toString());
                txtTelf.setText(tblemp.getValueAt(fila, 5).toString()); 
                cmbDepartamento.setSelectedItem(tblemp.getValueAt(fila, 11).toString());
                cmbDistrito.setSelectedItem(tblemp.getValueAt(fila, 6).toString());               
                dcFechaI.setSelectedDate(c2);
                cmbEstado.setSelectedItem(tblemp.getValueAt(fila, 8).toString());
                cmbTipo.setSelectedItem(tblemp.getValueAt(fila, 9).toString());   
                dcFechaN.setSelectedDate(c);
                
            }else
                JOptionPane.showMessageDialog(this, "No existe el DNI ingresado");
        }
        if(e.getSource()==btnCancelarE){
            opcion=0;
            visibleButton(false, true);
            isControlActive(false);
            clean();
        }
        if(e.getSource()==btnGuardarE){
            boolean validar=validar();
            if(validar){
                if(opcion==1){//Registrar
                    empleado.insertEmpleado(setParametersInsert());
                    empleado.setTable(tblemp);
                    visibleButton(false, true);
                    JOptionPane.showMessageDialog(this, "Colaborador Registrado");
                    opcion=0;
                    isControlActive(false);
                    
                }
                if(opcion==2){//Actualizar
                    empleado.updateEmpleado(setParametersUpd(),Integer.parseInt(txtID.getText()));
                    empleado.setTable(tblemp);
                    visibleButton(false, true);
                    JOptionPane.showMessageDialog(this, "Datos Actualizados");
                    opcion=0;
                    isControlActive(false);
                }
            }
        }
        if(e.getSource()==btnNuevoE){
            opcion=1;
            clean();
            visibleButton(true, false);
            isControlActive(true);
            
        }
    }
    
    //fin eventos
    
    //inicia 
    private void setTabbedPane(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox();
        cmbEstado = new javax.swing.JComboBox();
        cmbTipo = new javax.swing.JComboBox();
        cmbDistrito = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        dcFechaN = new datechooser.beans.DateChooserCombo();
        dcFechaI = new datechooser.beans.DateChooserCombo();
        btnGuardarE = new javax.swing.JButton();
        btnActualizarE = new javax.swing.JButton();
        btnCancelarE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        txtTelf = new javax.swing.JTextField();
        btnNuevoE = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(2140, 2140));
        setPreferredSize(new java.awt.Dimension(1000, 610));

        jPanel1.setMaximumSize(new java.awt.Dimension(3276, 3276));
        jPanel1.setPreferredSize(new java.awt.Dimension(622, 605));

        jLabel1.setText("Nombre");

        jLabel3.setText("Apellido P.");

        jLabel9.setText("Distrito");

        jLabel10.setText("Apellido M.");

        jLabel11.setText("DNI");

        jLabel12.setText("Telefono");

        jLabel4.setText("Fecha Ingreso");

        jLabel5.setText("Estado");

        jLabel6.setText("Tipo");

        jLabel13.setText("Departamento");

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDistrito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Fecha N.");

        btnGuardarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/save.png"))); // NOI18N
        btnGuardarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardarE.setFocusable(false);
        btnGuardarE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/save copia.png"))); // NOI18N

        btnActualizarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/edit.png"))); // NOI18N
        btnActualizarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizarE.setFocusable(false);
        btnActualizarE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/edit copia.png"))); // NOI18N

        btnCancelarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/cancel.png"))); // NOI18N
        btnCancelarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelarE.setFocusable(false);
        btnCancelarE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/cancel copia.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmpleados);

        btnNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/new-user.png"))); // NOI18N
        btnNuevoE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtID.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtMaterno)
                    .addComponent(txtTelf)
                    .addComponent(txtDni)
                    .addComponent(dcFechaN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnActualizarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevoE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 264, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4)
                            .addComponent(txtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevoE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardarE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizarE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarE)
                                .addGap(14, 14, 14)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Registro C.", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jTabbedPane4.addTab("Registro U.", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarE;
    private javax.swing.JButton btnCancelarE;
    private javax.swing.JButton btnGuardarE;
    private javax.swing.JButton btnNuevoE;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbDistrito;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbTipo;
    private datechooser.beans.DateChooserCombo dcFechaI;
    private datechooser.beans.DateChooserCombo dcFechaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelf;
    // End of variables declaration//GEN-END:variables

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPS;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tanvir
 */
public class Metodos extends MainPS {

    static Connection conexion;

    public static void bdConexion() {

    }
    /**
     * Borra los datos de un panel
     * Es un metodo recursivo 
     * recibe un parametro
     * @param panel 
     * @param components 
     */
    public static void resetPanel(JPanel panel){
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof  JTextField) {
                ((JTextField) component).setText("");
            }else if (component instanceof JScrollPane) {
                //System.out.println(component.get);
            }else if(component instanceof JPanel){
                //Component[] com = 
                resetPanel((JPanel) component);
            }
        }
        
    }
    
    public static void tablaMovil(JTextField marca, JTextField modelo, JTextField imei1, JTextField imei2, JTextField precio, JTable tabla) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        String[] fila = new String[5];
        fila[0] = marca.getText();
        fila[1] = modelo.getText();
        fila[2] = imei1.getText();
        fila[3] = imei2.getText();
        fila[4] = precio.getText();
        modeloTabla.addRow(fila);
    }
    /**
     * 
     * @param marca
     * @param modelo
     * @param imei1
     * @param imei2
     * @param precio
     * @param tabla 
     */
    public static void modifyDataMovil(JTextField marca, JTextField modelo, JTextField imei1, JTextField imei2, JTextField precio, JTable tabla) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        int fila = tabla.getSelectedRow();
        marca.setText(modeloTabla.getValueAt(fila, 0).toString());
        modelo.setText(modeloTabla.getValueAt(fila, 1).toString());
        imei1.setText(modeloTabla.getValueAt(fila, 2).toString());
        imei2.setText(modeloTabla.getValueAt(fila, 3).toString());
        precio.setText(modeloTabla.getValueAt(fila, 4).toString());
        modeloTabla.removeRow(fila);
    }

    public static void borrarFilaTablaMovil(JTable tabla) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.removeRow(tabla.getSelectedRow());
    }
    public static void borrarAllDataTabla(JTable tabla) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);
    }
    /*metodos para vaciar campos*/
    //1campo
    public static void resetVentaMovil(JTextField campo1, JTextField campo2, JTextField campo3, JTextField campo4, JTextField campo5) {
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
        campo5.setText("");
    }

    public static void resetJustificanteMovil(JTextField campo) {
        campo.setText("");
    }

    /**
     * @param panel*************************
     */
    /*colores de los botones*/
    public static void btnSetHover(JPanel panel) {
        panel.setBackground(new Color(99, 77, 135));
    }

    public static void btnResetHover(JPanel panel) {
        panel.setBackground(new Color(54, 33, 89));
    }
    public static void btnSetBorder(JPanel panel) {
        panel.setBorder(BorderFactory.createLineBorder(new Color(54, 33, 89)));
    }
    public static void btnResetBorder(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder());
    }
    /*#####################*/

}

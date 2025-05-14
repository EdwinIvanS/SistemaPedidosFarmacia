package com.farmacia.pedidos.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.farmacia.pedidos.controller.PedidoController;
import com.farmacia.pedidos.model.Pedido;

/**
 * Ventana principal del sistema de pedidos de medicamentos.
 * <p>
 * Esta clase representa la interfaz gráfica donde los usuarios pueden ingresar
 * los detalles de un pedido, como el nombre del medicamento, tipo, cantidad,
 * distribuidor y sucursales. También proporciona botones para confirmar o borrar
 * la información ingresada.
 * </p>
 * 
 * @author EdwinIvanS
 * @version 1.0
 * @since 2025-05-07
 */

public class FormularioPedido extends JFrame {

	private JTextField txtNombreMedicamento;
    private JComboBox<String> cbTipoMedicamento;
    private JTextField txtCantidad;
    private JRadioButton rbCofarma, rbEmpsephar, rbCemefar;
    private JCheckBox cbPrincipal, cbSecundaria;
    private JButton btnBorrar, btnConfirmar;
    private ButtonGroup grupoDistribuidores;
    
    public FormularioPedido() {
    	setTitle("Formulario de Pedido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 530);
        setLocationRelativeTo(null);
        initComponents();
        new PedidoController(this);
    }
    
    private void initComponents() { 
    	txtNombreMedicamento = new JTextField(20);
        cbTipoMedicamento = new JComboBox<>(new String[]{"", "Analgésico", "Analéptico", "Anestésico", "Antiácido", "Antidepresivo", "Antibiótico"});
        txtCantidad = new JTextField(5);

        rbCofarma = new JRadioButton("Cofarma");
        rbEmpsephar = new JRadioButton("Empsephar");
        rbCemefar = new JRadioButton("Cemefar");
        grupoDistribuidores = new ButtonGroup();
        grupoDistribuidores.add(rbCofarma);
        grupoDistribuidores.add(rbEmpsephar);
        grupoDistribuidores.add(rbCemefar);

        cbPrincipal = new JCheckBox("Principal");
        cbSecundaria = new JCheckBox("Secundaria");

        btnConfirmar = new JButton("Confirmar");
        btnBorrar = new JButton("Borrar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        panel.add(new JLabel("Nombre del Medicamento:"));
        panel.add(txtNombreMedicamento);

        panel.add(new JLabel("Tipo de Medicamento:"));
        panel.add(cbTipoMedicamento);

        panel.add(new JLabel("Cantidad:"));
        panel.add(txtCantidad);

        panel.add(new JLabel("Distribuidor:"));
        panel.add(rbCofarma);
        panel.add(rbEmpsephar);
        panel.add(rbCemefar);

        panel.add(new JLabel("Sucursal:"));
        panel.add(cbPrincipal);
        panel.add(cbSecundaria);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelBotones.add(btnConfirmar);
        panelBotones.add(btnBorrar);
        panel.add(panelBotones);

        add(panel);
    }
    
    public JTextField getTxtNombreMedicamento() {
        return txtNombreMedicamento;
    }

    public JComboBox<String> getCbTipoMedicamento() {
        return cbTipoMedicamento;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JRadioButton getRbCofarma() {
        return rbCofarma;
    }

    public JRadioButton getRbEmpsephar() {
        return rbEmpsephar;
    }

    public JRadioButton getRbCemefar() {
        return rbCemefar;
    }

    public JCheckBox getCbPrincipal() {
        return cbPrincipal;
    }

    public JCheckBox getCbSecundaria() {
        return cbSecundaria;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }
    
    public ButtonGroup getGrupoDistribuidores() {
        return grupoDistribuidores;
    }
}

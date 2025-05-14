package com.farmacia.pedidos.controller;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.farmacia.pedidos.model.Pedido;
import com.farmacia.pedidos.view.FormularioPedido;
import com.farmacia.pedidos.view.ResumenPedido;

/**
 * Controlador que gestiona las acciones relacionadas con los pedidos.
 * <p>
 * Esta clase se encarga de manejar los eventos generados en el formulario de pedidos,
 * procesar la información, coordinar la creación y gestión de objetos de tipo Pedido.
 * </p>
 * 
 * @author EdwinIvanS
 * @version 1.0
 * @since 2025-05-07
 */

public class PedidoController {
	private FormularioPedido vista;

    public PedidoController(FormularioPedido vista) {
        this.vista = vista;
        initController();
    }

    private void initController() {
        vista.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarPedido();
            }
        });

        vista.getBtnBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarFormulario();
            }
        });
    }

    private void confirmarPedido() {
        String nombreMedicamento = vista.getTxtNombreMedicamento().getText().trim();
        String tipoMedicamento = (String) vista.getCbTipoMedicamento().getSelectedItem();
        String cantidadStr = vista.getTxtCantidad().getText().trim();
        String distribuidor = null;
        if (vista.getRbCofarma().isSelected()) {
            distribuidor = "Cofarma";
        } else if (vista.getRbEmpsephar().isSelected()) {
            distribuidor = "Empsephar";
        } else if (vista.getRbCemefar().isSelected()) {
            distribuidor = "Cemefar";
        }

        ArrayList<String> sucursales = new ArrayList<>();
        if (vista.getCbPrincipal().isSelected()) {
            sucursales.add("Principal");
        }
        if (vista.getCbSecundaria().isSelected()) {
            sucursales.add("Secundaria");
        }

        // Validaciones
        if (nombreMedicamento.isEmpty() || !nombreMedicamento.matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(vista, "Ingrese un nombre de medicamento válido.");
            return;
        }

        if (tipoMedicamento == null || tipoMedicamento.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Seleccione un tipo de medicamento.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero positivo.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cantidad válida.");
            return;
        }

        if (distribuidor == null) {
            JOptionPane.showMessageDialog(vista, "Seleccione un distribuidor.");
            return;
        }

        if (sucursales.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Seleccione al menos una sucursal.");
            return;
        }

        // Crear el pedido y mostrar el resumen
        Pedido pedido = new Pedido(nombreMedicamento, tipoMedicamento, cantidad, distribuidor, sucursales);
        ResumenPedido resumen = new ResumenPedido(pedido, this);
        resumen.setVisible(true);
    }

    public void borrarFormulario() {
        vista.getTxtNombreMedicamento().setText("");
        vista.getCbTipoMedicamento().setSelectedIndex(0);
        vista.getTxtCantidad().setText("");
        vista.getGrupoDistribuidores().clearSelection();
        vista.getCbPrincipal().setSelected(false);
        vista.getCbSecundaria().setSelected(false);
    }
}

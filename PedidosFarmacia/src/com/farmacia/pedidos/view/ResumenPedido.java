package com.farmacia.pedidos.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.farmacia.pedidos.controller.PedidoController;
import com.farmacia.pedidos.model.Pedido;

/**
 * Ventana que muestra el resumen de un pedido de medicamentos.
 * <p>
 * Esta clase representa una interfaz gráfica que presenta al usuario
 * los detalles del pedido realizado, incluyendo el nombre del medicamento,
 * tipo, cantidad, distribuidor y sucursales seleccionadas. Además, proporciona
 * opciones para confirmar o cancelar el envío del pedido.
 * </p>
 * 
 * @author EdwinIvanS
 * @version 1.0
 * @since 2025-05-07
 */

public class ResumenPedido extends JFrame{

	private PedidoController controlador;
	
	public ResumenPedido(Pedido pedido, PedidoController controlador) {
		this.controlador = controlador;
        setTitle("Pedido al distribuidor " + pedido.getDistribuidor());
        setSize(500, 180);
        setLocationRelativeTo(null);

        String medicamento = pedido.getCantidad() + " unidades del " + pedido.getTipoMedicamento() + " " + pedido.getNombreMedicamento();
        StringBuilder direccion = new StringBuilder("Para la farmacia situada en ");
        List<String> sucursales = pedido.getSucursales();
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).equals("Principal")) {
                direccion.append("Calle de la Rosa n. 28");
            } else if (sucursales.get(i).equals("Secundaria")) {
                direccion.append("Calle Alcazabilla n. 3");
            }
            if (i < sucursales.size() - 1) {
                direccion.append(" y ");
            }
        }

        JLabel lblMedicamento = new JLabel(medicamento);
        JLabel lblDireccion = new JLabel(direccion.toString());

        JButton btnEnviar = new JButton("Enviar");
        JButton btnCancelar = new JButton("Cancelar");

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pedido enviado");
            	JOptionPane.showMessageDialog(null,"Pedido enviado");
                controlador.borrarFormulario();
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
        panel.add(lblMedicamento);
        panel.add(lblDireccion);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelBotones.add(btnEnviar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones);
        
        add(panel);
    }
}

/**
 * 
 */
package com.farmacia.pedidos.model;

import java.util.List;

/**
 * Clase que representa un pedido realizado en la farmacia.
 * <p>
 * Esta clase encapsula la información relacionada con un pedido,
 * incluyendo el nombre y tipo del medicamento, la cantidad solicitada,
 * el distribuidor seleccionado y las sucursales a las que se debe enviar el pedido.
 * </p>
 * 
 * @author EdwinIvanS
 * @version 1.0
 * @since 2025-05-07
 */

public class Pedido {

	private String nombreMedicamento; 
	private String tipoMedicamento;
    private int cantidad;
    private String distribuidor;
    private List<String> sucursales;
    
    public Pedido(String nombreMedicamento, String tipoMedicamento, int cantidad, String distribuidor, List<String> sucursales) {
        this.nombreMedicamento = nombreMedicamento;
        this.tipoMedicamento = tipoMedicamento;
        this.cantidad = cantidad;
        this.distribuidor = distribuidor;
        this.sucursales = sucursales;
    }
    
    public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public List<String> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<String> sucursales) {
		this.sucursales = sucursales;
	}
    
}

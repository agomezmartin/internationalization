package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidosService {
	/*
	 *					==========
	 * 					 Objetos
	 *					==========
	 */
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	/*
	 *					==========
	 * 					 Métodos
	 *					==========
	 */
	
	// 1. Añadir pedido
	public boolean agregarPedido(String producto, String fechaPedido, double precio) {
		
		if(pedidos.stream().noneMatch(p->p.getProducto().equals(producto))){
			
			// parsear fecha
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fecha = LocalDate.parse(fechaPedido, dtf);

			fecha.format(dtf);

			// añadir pedido
			pedidos.add(new Pedido(producto, fecha, precio));
			return true;
		}
		
		return false;

}

	// 2. Mostrar pedidos más reciente
	public Pedido pedidoReciente() {
		
		return pedidos.stream()
		.max((a,b)->a.getFechapedido().compareTo(b.getFechapedido()))
		.orElse(null);
		
	}
	
	// 3. Mostrar pedidos inferiores al precio recibido
	public List<Pedido> mostrarPedidosInferiores(double preciosMax) {
		
		return pedidos.stream()
				.filter(p->p.getPrecio()<preciosMax)
				.toList();

	}

	// 4. Mostrar pedidos anteriores a una fecha
	public List<Pedido> mostrarPedidosAnteriores(int meses) {
		
		return pedidos.stream()
				.filter(p->p.getFechapedido().isBefore(LocalDate.now().minusMonths(meses)))
				.toList();

	}

}
package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import model.Pedido;

public class PedidosService {

	/*
	 *					==========
	 * 					 Objetos
	 *					==========
	 */

	static String dir = "c:\\Java_SE\\Ejercicios\\temp\\EE\\26_productos.txt";
	static Path path = Path.of(dir);

	/*
	 *					==========
	 * 					 Métodos
	 *					==========
	 */
	// método interno que recoge todos los pedidos del archivo
	private Stream<Pedido> getPedidos(){
		
		try {
			return Files.lines(path)
					.map(l -> new Pedido(l.split(";")[0],
							LocalDate.parse(l.split(";")[1]),
							Double.parseDouble(l.split(";")[2])));

		} catch (IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
		
	}
	
	// 1. Añadir pedido
	public boolean agregarPedido(String producto, String fechaPedido, double precio) {

		try {

			Stream<String> archivo = Files.lines(path);
			if(!archivo.anyMatch(p->p.equals(producto))){
	
				// parsear fecha
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fecha = LocalDate.parse(fechaPedido, dtf);
	
				fecha.format(dtf);

				// añadir pedido
				String pedido = producto + ";" + fecha + ";" + precio; 
				Files.writeString(path, pedido + System.lineSeparator(), StandardOpenOption.APPEND);
				return true;

			}
			
		} catch (IOException ex) {
			
				ex.printStackTrace();
				return false;
			}

		
		
		return false;

	}

	// 2. Mostrar pedidos más reciente
	public Pedido pedidoReciente() {

		return getPedidos()
				.max((a,b)->a.getFechapedido().compareTo(b.getFechapedido()))
					.orElse(null);

		}

	// 3. Mostrar pedidos inferiores al precio recibido
	public List<Pedido> mostrarPedidosInferiores(double preciosMax) {
		
		return getPedidos()
				.filter(p->p.getPrecio()<preciosMax)
				.toList();

	}

	// 4. Mostrar pedidos anteriores a una fecha
	public List<Pedido> mostrarPedidosAnteriores(int meses) {

		return getPedidos()
					.filter(p->p.getFechapedido().isBefore(LocalDate.now().minusMonths(meses)))
					.toList();

	}
}
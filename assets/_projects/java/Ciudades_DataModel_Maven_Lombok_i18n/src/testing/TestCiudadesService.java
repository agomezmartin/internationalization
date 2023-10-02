package testing;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.CiudadesService;

class TestCiudadesService {
	
	static CiudadesService service = new CiudadesService();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service.agregarCiudad("Madrid", 45687, "España");
		service.agregarCiudad("Barcelona", 3213, "España");
		service.agregarCiudad("Buenos Aires", 45687, "Argentina");
		service.agregarCiudad("New York", 545687, "U.S.A");
		service.agregarCiudad("Londres", 578687, "Reino Unido");
		service.agregarCiudad("París", 5687, "Francia");
	}

	@Test
	void testAgregarCiudad() {
		fail("Not yet implemented");
	}

	@Test
	void testCiudadPorPais() {
	}

	@Test
	void testEliminarCiudad() {
		fail("Not yet implemented");
	}

}

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import UD21.junit09.KarimTA21.Calculadora;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora cal;
	
	
	@BeforeEach
	void setUp() throws Exception {
		cal = new Calculadora();
	}

	/*Tests de los metodos propios del programa*/
	
	@Test
	public void testCalcular() {
		System.out.println("TestCalcular()");
		String result = cal.calcular("12+3");
		String predict = "12+3=15.0";
		assertEquals(predict, result);
	}
}

package edu.eci.cvds.tdd.aerodescuentos;

import static org.junit.Assert.assertEquals;

import org.junit.*;


public class TarifasTest{

	CalculadorDescuentos calcular;
	@Test 
	public void sinDescuento() {
	
		double tarifa = calcular.calculoTarifa(1000000, 5, 35);
		Assert.assertEquals(1000000, tarifa, 0.001);;
	}

	@Test
	public void mayorDeEdadSuperior20Dias() {
		double tarifa = calcular.calculoTarifa(1000000, 25, 35);
		
		Assert.assertEquals(850000,tarifa,0.001);
	}
	
	@Test
	public void menorDeEdadSuperior20Dias() {
		double tarifa = calcular.calculoTarifa(1000000, 21, 16);
		
		Assert.assertEquals(800000,tarifa,0.001);
	}

	@Test
	public void mayorDe65Superior20Dias() {
		double tarifa = calcular.calculoTarifa(1000000, 35, 67);
		
		Assert.assertEquals(770000,tarifa,0.001);
	}
	
	@Test
	public void menorDeEdadInferior20Dias() {
		double tarifa = calcular.calculoTarifa(1000000, 5, 15);
		
		Assert.assertEquals(950000,tarifa,0.001);
	}
	
	@Test
	public void mayorde65Inferior20Dias() {
		double tarifa = calcular.calculoTarifa(1000000, 10, 70);
		
		Assert.assertEquals(920000,tarifa,0.001);
	}
	
	/*@Test
	public void edadNegativa() {
		double tarifa = calcular.calculoTarifa(1000000, 10, -70);
		
		Assert.assertEquals(920000,tarifa,0.001);
	}*/
	
	
	
}
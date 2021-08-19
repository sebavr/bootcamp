package Rompecabezas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Rompecabezas {

	//----------EJERCICIO 1---------------------
	
	public void imprimirSuma() {
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		 ArrayList<Integer> arreglo2 = new ArrayList<Integer>();
		 arreglo.add(3);
		 arreglo.add(5);
		 arreglo.add(1);
		 arreglo.add(2);
		 arreglo.add(7);
		 arreglo.add(9);
		 arreglo.add(8);
		 arreglo.add(13);
		 arreglo.add(25);
		 arreglo.add(32);
		 
	
		
		int suma=0;

		for(int i = 0;i<arreglo.size();i++) {
			 suma+=arreglo.get(i);
			 
			 if(arreglo.get(i)>10) {
				 
				 arreglo2.add(arreglo.get(i));
			 }
			
			 
		
			}
		 System.out.println("Suma : "+suma);
		 System.out.println(arreglo2);
		
	}
	
	//------------EJERCICIO2-------------------------------
	/*Crear un arreglo con los siguientes valores: 
	Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. 
	Mezcle el arreglo e imprima el nombre de cada persona.
	Haga que el método también devuelva un arreglo con los
	nombres que tienes más de 5 caracteres*/
	
	public void arregloNombres() {
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<String> nombres2 = new ArrayList<String>();
		
		 nombres.add("Nancy");
		 nombres.add("Jinichi");
		 nombres.add("Fujibayashi");
		 nombres.add("Momochi");
		 nombres.add("Ishikawa");
	
		 Collections.shuffle(nombres);
		 System.out.println(nombres);
		 
		 for(int i = 0;i<nombres.size();i++) {
			
			 String s=nombres.get(i);
			 if (s.length()>5) {
				 nombres2.add(s);
			 }

			}
		 System.out.println("Nombres que tienen mas de 5 caracteres: "+nombres2);
	}
	
	
/*	//------------EJERCICIO3-------------------------------
 * 
 * Crear un arreglo que contiene las 26 letras del alfabeto (este arreglo 
debe tener 26 valores). Mezcle el arreglo y, después de mezclarlo, imprima 
la última letra del arreglo. También debe imprimir la primera letra del arreglo.
Si la primera letra del arreglo es una vocal, haga que muestre un mensaje.
Para mezclar una colección, puede utilizar el método shuffle de la clase 
Collections. Documentación de la Clase Collections.*/
	
	public void abecedario() {
		ArrayList<String> alfabeto = new ArrayList<String>();
		 
		alfabeto.add("a");
		alfabeto.add("b");
		alfabeto.add("c");
		alfabeto.add("d");
		alfabeto.add("e");
		alfabeto.add("f");
		alfabeto.add("g");
		alfabeto.add("h");
		alfabeto.add("i");
		alfabeto.add("j");
		alfabeto.add("k");
		alfabeto.add("l");
		alfabeto.add("m");
		alfabeto.add("n");
		alfabeto.add("o");
		alfabeto.add("p");
		alfabeto.add("q");
		alfabeto.add("r");
		alfabeto.add("s");
		alfabeto.add("t");
		alfabeto.add("u");
		alfabeto.add("v");
		alfabeto.add("w");
		alfabeto.add("x");
		alfabeto.add("y");
		alfabeto.add("z");

		Collections.shuffle(alfabeto);
		 System.out.println("La última letra del arreglo es: "+alfabeto.get(25));
		 System.out.println("La primera letra del arreglo es: "+alfabeto.get(0));
		 
		 if(alfabeto.get(0)=="a"||alfabeto.get(0)=="e"||alfabeto.get(0)=="i"||alfabeto.get(0)=="o"||alfabeto.get(0)=="u") {
			 System.out.println("Es increíble, es una vocal YUUUJUUUU");

		 }
}
	
/*//------------EJERCICIO 4-------------------------------
 * Generar y devolver un arreglo con 10 números aleatorios entre 55 - 100.
Para obtener un número entero aleatorio, puede utilizar el método nextInt
 de la clase Random. Documentación de la Clase Random.*/
	
	public void arregloAleatorio() {
		
		
		 Random r = new Random();
	        System.out.println(r.nextInt(45)+55); // Sin límites
	        
	}
	
	
	
/*//------------EJERCICIO 5-------------------------------
 * Generar y devolver un arreglo con 10 números aleatorios entre 55 - 100
 *  y hacer que estén ordenados (mostrar el número más pequeño en el principio 
 *  del arreglo). Imprimir todos los números del arreglo. Luego, Imprimir el 
 *  valor mínimo del arreglo, así como el valor máximo.*/	
	
	public void arregloAleatorio2() {
		ArrayList<Integer>  aleatorio= new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i=0;i<10;i++) {
			aleatorio.add(rand.nextInt(45)+55);
		}
		int max=aleatorio.get(0);
		int min=aleatorio.get(0);
		
		for(int i=0;i<10;i++) {
			if(aleatorio.get(i)>max) {
				max=aleatorio.get(i);
			}
			
			if(aleatorio.get(i)<min) {
				min=aleatorio.get(i);
			}
		}
		Collections.sort(aleatorio);
		System.out.println(aleatorio);
		System.out.println("El valor mínimo es :"+min);
		System.out.println("El valor máximo es :"+max);

		
		
}
	
	/*//------------EJERCICIO 6-------------------------------
	 * Crear una cadena aleatoria con 5 caracteres de longitud.
	 * */
	public void cadenaaleatoria() {
		ArrayList<Integer>  cad= new ArrayList<Integer>();
		Random c = new Random();
		for(int i=0;i<5;i++) {
			cad.add(c.nextInt(50));
		}
		System.out.println(cad);
	}
	
	
	
	//Generar un arreglo con 10 cadenas aleatorias y cada una con 5 caracteres de longitud.
	
	public void arreglo_cadena() {
		ArrayList<String>  arreglin= new ArrayList<String>();
		ArrayList<String> supercadena= new ArrayList<String>();
		ArrayList<String> llave= new ArrayList<String>();
		
		
		arreglin.add("a");
		arreglin.add("b");
		arreglin.add("c");
		arreglin.add("d");
		arreglin.add("e");
		arreglin.add("f");
		arreglin.add("g");
		arreglin.add("h");
		arreglin.add("i");
		arreglin.add("j");
		arreglin.add("k");
		arreglin.add("l");
		arreglin.add("m");
		arreglin.add("n");
		arreglin.add("o");
		arreglin.add("p");
		arreglin.add("q");
		arreglin.add("r");
		arreglin.add("s");
		arreglin.add("t");
		arreglin.add("u");
		arreglin.add("v");
		arreglin.add("w");
		arreglin.add("x");
		arreglin.add("y");
		arreglin.add("z");

		
		
		//int letra_aleatoria=ThreadLocalRandom.current().nextInt(0, arreglin.size());
		
		Random aleat = new Random();
		Random aleat2 = new Random();
		
		
		//generar la cadena aleatoria
		String a=arreglin.get(aleat.nextInt(arreglin.size()))+arreglin.get(aleat.nextInt(arreglin.size()))+arreglin.get(aleat.nextInt(arreglin.size()))+arreglin.get(aleat.nextInt(arreglin.size()))+arreglin.get(aleat.nextInt(arreglin.size()));

		for(int i=0;i<10;i++) {
			//del tamaño de la cadena de las letras toma uno aleatorio y consigue su posicion 
			supercadena.add(a);
			
		}
		System.out.println(supercadena);
		
		
		
		
	
	
	}}

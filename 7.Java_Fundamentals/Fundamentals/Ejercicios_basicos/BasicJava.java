package Core;

import java.util.ArrayList;

public class BasicJava {
	
	//------EJERCICIO1--------------
	public void imprimirHasta255() {
		
		for(int i=1;i<256;i++) {
			System.out.println(i);
		}
	}
	
	
	//-------EJERCICIO2-----------
	public void imprimirImpares() {
		
		for(int i=1;i<256;i++) {
			if(i%2!=0) {
			System.out.println(i);
			}
		}
	}
	
	
	//--------EJERCICIO3-------------
public void imprimirSuma() {
		int suma=0;
		for(int i=0;i<256;i++) {
			suma+=i;
			System.out.println("Nuevo número: "+i +" Suma: "+ suma);
		}
	}
//-----------EJERCICIO4-------------
	
public void recorrerArreglo() {
	ArrayList<Integer> arreglo = new ArrayList<Integer>();
	arreglo.add(1);
	arreglo.add(3);
	arreglo.add(5);
	arreglo.add(7);
	arreglo.add(9);
	arreglo.add(11);
	arreglo.add(13);

	for(Integer i:arreglo) {
		System.out.println(i);
	}
}

//-----------EJERCICIO5-------------	

int[] arreglo2={4, 8, 8, 5, 9};
public void arregloMaximo() {
	int max=arreglo2[0];
	for(int i=0;i<arreglo2.length;i++) {
		if(arreglo2[i]>=arreglo2[0]) {
			max=arreglo2[i];
		}
	}
	System.out.println("El número máximo del arreglo es: "+max);
}


//-----------EJERCICIO6-------------	

float[] arreglo3={1, 2, 3, 4, 5};
public void Promedio() {
	float x;
	float suma=0;
	int max=arreglo2[0];
	for(int i=0;i<arreglo3.length;i++) {
	
			suma+=arreglo3[i];
		
	}
	System.out.println("El promedio del arreglo es: "+suma/arreglo3.length);
}

//-----------EJERCICIO7-------------
public void arregloImpares() {
	ArrayList<Integer> arreg = new ArrayList<Integer>();
	for(int i=1;i<256;i++) {
		if(i%2!=0) {
		arreg.add(i);
		}
	}
	System.out.println(arreg);
}

//-----------EJERCICIO8-----------------
int[] arreglo4={1, 2, 3, 4, 5};
public void greaterY(int Y) {
    int count=0;
    for(int i=0;i<arreglo4.length;i++){
        if(arreglo4[i]>Y){
            count=count+1;
        }
    }
    System.out.println("La cantidad de numeros mayores a "+Y+" es : "+count);
}

//----------EJERCICIO9-------------------

public void squareVal() {
	ArrayList<Integer> arre = new ArrayList<Integer>();
	
	
	arre.add(1);
	arre.add(2);
	arre.add(3);
	arre.add(4);
	arre.add(5);
	arre.add(6);
	arre.add(7);

    for(int i=0;i<arre.size();i++){
    
    arre.set(i,i*i);
    }
    System.out.println(arre);
    
    
}

//----------EJERCICIO10-------------------


public void noNeg() {
ArrayList<Integer> arreglo5 = new ArrayList<Integer>();
	arreglo5.add(1);
	arreglo5.add(-23);
	arreglo5.add(3);
	arreglo5.add(4);
	arreglo5.add(-5);
	arreglo5.add(6);
	arreglo5.add(-7);
	

	
	for(int i=0;i<arreglo5.size();i++) {
		if(arreglo5.get(i)<0) {
			 arreglo5.set(i,0);
		}
	}
	
	System.out.println("los valores no negativos son: "+arreglo5);
}

//---------------------EJERCICIO11--------------------------

float[] arreglo6={1, 2, 3, 4, 5};
public void maxMinAvg() {
	float x;
	float suma=0;
	float maxx=arreglo6[0];
	float minn=arreglo6[0];
	for(int i=0;i<arreglo6.length;i++) {
			suma+=arreglo6[i];
			if(arreglo6[i]>=maxx) {
				maxx=arreglo6[i];
			}
			
			if(arreglo6[i]<minn) {
				minn=arreglo6[i];
			}
		
		
	}
	System.out.println("El maximo es: "+maxx+", el minimo es: "+minn+", el promedio es: "+suma/arreglo6.length);
}

//---------------------EJERCICIO12--------------------------

public void cambioValores() {
ArrayList<Integer> arreglo7 = new ArrayList<Integer>();
	arreglo7.add(1);
	arreglo7.add(5);
	arreglo7.add(10);
	arreglo7.add(7);
	arreglo7.add(-5);
	arreglo7.add(6);
	arreglo7.add(-7);
	
	System.out.println(arreglo7);
	
	for(int i=1;i<arreglo7.size();i++) {
	 //reemplaza cada valor por el anterior
	arreglo7.set(i-1, arreglo7.get(i));
	
	}
	//el ultimo valor
	arreglo7.set(arreglo7.size()-1, 0);
	System.out.println(arreglo7);
}
	
}
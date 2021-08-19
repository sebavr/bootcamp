package com.codingdojo_calculator;

import java.util.ArrayList;

public class calculator {
	
	
	
	private ArrayList<Double> numero= new ArrayList();
	private ArrayList<String> operador= new ArrayList();
	private double resultado=0;
	
	
	
	public calculator() {
		super();
		
	}
	
	//se debe empezar por un numero, luego operador, luego numero
	//van intercalados
	
	
	public void performOperation(double num) {
		
		numero.add(num);
		
	}
	
public void performOperation(String oper) {	
		
	//se guardara la primera operacion * o /
		double primera=0;
		
		//necesitamos señalar que "=" sera el ultimo operador, por lo que ser distinto a el
		//seria lo mas comun
		
		if(oper!="=") {
			this.operador.add(oper);
		}else {
			//aplicar orden de la multiplicacion y division
			// este int es 0 ya que se desea ocupar los mismos numeros
			int i=0;
			
			//mientras operador contenga * y / se entrara en esta condicion
			
			while(this.operador.contains("*")||this.operador.contains("/")) {
				
				// si el operador en i es *
				if(this.operador.get(i)=="*") {
					//multiplicar el numero i por el numero i+1
					primera=this.numero.get(i)*this.numero.get(i+1);
					
					// se reemplaza el numero por el resultado
					this.numero.set(i, primera);
					
					// de esta forma se saca el otro numero i+1 que se creo en la multiplicacion
					this.numero.remove(i+1);
					
					// y se saca el operador 
					this.operador.remove(i);
					
					i-=1; //con esto volvemos a 0 el i, para seguir ocupandolo, de lo contrario quedaria como 1 y no serviria 
					
				}else if(this.operador.get(i)=="/") {
					primera=this.numero.get(i)/this.numero.get(i+1);
					
					// se reemplaza el numero por el resultado
					this.numero.set(i, primera);
					
					// de esta forma se saca el otro numero i+1 que se creo en la multiplicacion
					this.numero.remove(i+1);
					
					// y se saca el operador
					this.operador.remove(i);
					
					i-=1;
					
				}
			
			i++;
		}
		
		// ahora se coloca el primer valor en el array
		this.resultado=this.numero.get(0);
		
		// ahora se añade la suma y resta
		
		for( i=0;i<this.operador.size();i++) {
			if(this.operador.get(i)=="+") {
				this.resultado+=this.numero.get(i+1);
			}
			else if(this.operador.get(i)=="-") {
				this.resultado-=this.numero.get(i+1);
			}
		}
		}	
}



	public void getResults() {
	
	System.out.println("Resultado:"+this.resultado);
	
	
	}
	
		
	}
	



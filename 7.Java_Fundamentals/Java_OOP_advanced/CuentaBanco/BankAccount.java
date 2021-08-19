package CuentaBanco;

import java.util.Random;

public class BankAccount {

	private String numeroCuenta;
	private double saldoCuentaCorriente;
	private double saldoCuentaAhorro;
	private static int numeroDeCuentas;
	
	
	
	public BankAccount() {
		super();
		this.numeroCuenta = numeroaleatorios();
		this.saldoCuentaCorriente = 0;
		this.saldoCuentaAhorro = 0;
		numeroDeCuentas++;
	}
	
	
	private String numeroaleatorios() {
		String number="";
		Random r = new Random();
		
		for(int i=0;i<10;i++) {
			
			// valueof transforma un int en string
			number+=String.valueOf(r.nextInt(9));
		}
		return number;
	}
	
	public void depositar(String tipoCuenta,double monto) {
		if(tipoCuenta=="ahorro") {
			this.saldoCuentaAhorro+=monto;
			System.out.println("Se ha depositado "+monto+" a su cuenta de ahorro");
			System.out.println("Ahora tiene ahorrado :"+this.getSaldoCuentaAhorro());
		}else if(tipoCuenta=="corriente"){
			this.saldoCuentaCorriente+=monto;
			System.out.println("Se ha depositado "+monto+" a su cuenta corriente");
			System.out.println("Ahora tiene ahorrado :"+this.getSaldoCuentaCorriente());
		}
		
	}
	
	public void retirar(String tipoCuenta,double monto) {
		if(tipoCuenta=="ahorro"&& this.saldoCuentaAhorro-monto>=0) {
			this.saldoCuentaAhorro-=monto;
			System.out.println("Se ha retirado "+monto+" de su cuenta de ahorro");
			System.out.println("Ahora tiene ahorrado :"+this.getSaldoCuentaAhorro());
		}else if(tipoCuenta=="corriente"&& this.saldoCuentaCorriente-monto>=0){
			this.saldoCuentaCorriente-=monto;
			System.out.println("Se ha retirado "+monto+" de su cuenta corriente");
			System.out.println("Ahora tiene ahorrado :"+this.getSaldoCuentaCorriente());
		}else {
			System.out.println("No hay suficiente saldo.");
		}
		
	}
	
	public void totalDinero() {
		System.out.println("El monto que tiene en su cuenta corriente es:"+this.saldoCuentaCorriente);
		System.out.println("El monto que tiene en su cuenta ahorro es:"+this.saldoCuentaAhorro);
	}
	

//GETTER nomas, ya que los usuarios no pueden modificar el SETTER
	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}


	public double getSaldoCuentaAhorro() {
		return saldoCuentaAhorro;
	}


	public static int getNumeroDeCuentas() {
		return numeroDeCuentas;
	}


	
	
	
}

package CuentaBanco;

public class BankAccountTest {

	public static void main(String[] args) {
	
		BankAccount b= new BankAccount();
		BankAccount b2= new BankAccount();
		System.out.println(b.getNumeroCuenta());
		System.out.println(b.getSaldoCuentaAhorro());
		System.out.println(b.getNumeroDeCuentas());
		b.depositar("ahorro", 1000);
		b2.depositar("corriente", 4000);
		b2.depositar("corriente", 4440);
		b.retirar("ahorro", 1100);
		b.retirar("ahorro", 800);
		b2.retirar("corriente", 80000);
		b2.retirar("corriente", 800);
		b.totalDinero();
		b2.totalDinero();
	}
	

}


public class StringManipulatorTesting {
	
	

	public static void main(String[] args) {
	
	StringManipulator manipulator = new StringManipulator();
	String texto3 = manipulator.trimAndConcat("    Hola    	 	","		Mundo	");
	System.out.println(texto3);
	
	
	StringManipulator manipulator2 = new StringManipulator();
	Integer salida = manipulator2.getIndexOrNull("adios mundo cruel",'a');
	Integer salida2 = manipulator2.getIndexOrNull("Ahora mismo, estoy sentado",'h');
	Integer salida3 = manipulator2.getIndexOrNull("Feliz navidad","navidad");
	System.out.println(salida);
	System.out.println(salida2);
	System.out.println(salida3);
	
	StringManipulator manipulator3 = new StringManipulator();
	String salida4 = manipulator3.concatSubstring("El auto rojo",4,10,"La casa es verde");
	System.out.println(salida4);
	
	


}
}
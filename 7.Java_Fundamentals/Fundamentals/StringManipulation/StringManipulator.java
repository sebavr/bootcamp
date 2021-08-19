
public class StringManipulator {
	
	public String trimAndConcat(String texto1,String texto2){
		
		String Resultado=texto1.trim()+texto2.trim();
		
		
		return Resultado.trim();
	}
	
	public Integer getIndexOrNull(String UnTexto, char letra){
		
		Integer valor=UnTexto.indexOf(letra);
		return valor;
	
	}
	
	// se utiliza la misma funcion pero se cambian los detalles de las entradas
	
	public Integer getIndexOrNull(String UnTexto2, String SubTexto){
		
		Integer valor=UnTexto2.indexOf(SubTexto);
		return valor;
	
	}
	
	public String concatSubstring(String UnTexto3, int posicion1, int posicion2, String UnTexto4) {
		
		String subString=UnTexto3.substring(posicion1, posicion2);
		String TextoFinal=subString+UnTexto4;
		return TextoFinal;
		
		
	}
	

}

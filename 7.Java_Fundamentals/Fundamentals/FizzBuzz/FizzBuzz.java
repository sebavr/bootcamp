public class FizzBuzz {
	
    public String fizzBuzz(int numero) {
    	
    	String retorno="";
    	
    	if(numero%3==0 && numero%5==0) {
    		System.out.println("FizzBuzz");
    	}else if(numero%5==0) {
    		System.out.println("Buzz");
    	}else if(numero%3==0) {
    		System.out.println("Fizz");
    		
    	}else {
    		retorno += numero;
    	}
    	
    	return retorno;
    	
    	
       
    }
}


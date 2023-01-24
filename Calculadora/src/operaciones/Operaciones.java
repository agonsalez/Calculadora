package operaciones;


/**
 * 
 * @author Aitor González
 * @version 1.1
 *
 */




public class Operaciones{
	
	/**
	 * 
	 * @param valor1 El primer valor de la suma
	 * @param valor2 El segundo valor de la suma
	 * @return Resultado de la suma
	 */
	
	
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1 El primer valor a restar
     * @param valor2 El segundo valor a restar
     * @return Resultado de la resta
     */
    
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1 El primer valor a multiplicar
     * @param valor2 El segundo valor a multiplicar
     * @return Resultado de la multiplicación
     */
    
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /**
     * @exception ArithmeticException Excepción
     * @param valor1 El primer valor a dividir
     * @param valor2 El segundo valor a dividir
     * @return Resultado del dividir
     * @throws ArithmeticException Saldrá si está el número 0 al dividir
     */
    
    public int dividir (int valor1, int valor2) throws ArithmeticException{
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1 El primer valor a dividir
     * @param valor2 El segundo valor a dividir
     * @return Resto
     */
    
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}
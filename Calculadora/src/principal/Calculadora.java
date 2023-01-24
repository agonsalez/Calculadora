package principal;
import menu.Menu;
import operaciones.Operaciones;

/**
 * 
 * @author Aitor González
 * @version 1.1
 *
 */

	
public class Calculadora{
	
	
	/**
	 * 
	 * @param args
	 */
	
    public static void main(String[] args) {   
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("/")){
            	
            	/**
            	 * Saldrá un mensaje cuando vaya a salir el error "ArithmeticException"
            	 */
            	
            	try {
            		resultado = operaciones.dividir(operandos[0], operandos[1]);
                    System.out.println ("Resultado: " + resultado);
            	}catch (ArithmeticException exception) {
            		System.out.println("Error Arimético" + exception.getMessage());
            	}
                
            } else if (operacion.equalsIgnoreCase("%")){		//Está amarillo porque no pasa por la última parte del código.
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else {
                System.out.println ("Operación no válida");		//El bucle no permite que el código pase por aquí.
            }
        }   while (menu.repetir());
    }
}
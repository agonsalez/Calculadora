package principal;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;

/**
 * 
 * @author Aitor González
 * @version 1.1
 *
 */

	
public class Calculadora{
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	
	
	/**
	 * 
	 * @param args
	 */
	
    public static void main(String[] args) {   
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
       
        Handler consoleHandler = null;
        Handler fileHandler  = null;
        
        try{
            //Crear consoleHandler y fileHandler
            consoleHandler = new ConsoleHandler();
            fileHandler  = new FileHandler("./operaciones.log");
             
            //Asignar handlers al objeto LOGGER
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
             
            LOGGER.setUseParentHandlers(false);
            //Establecer niveles a handlers y LOGGER
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
           
			
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Ocurrió un error en FileHandler.", exception);
        }
        
       

        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE, " funciona bien la suma");
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE, " funciona bien la resta");
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE, " funciona bien la multiplicacion");
            } else if (operacion.equalsIgnoreCase("/")){
            	
            	/**
            	 * Saldrá un mensaje cuando vaya a salir el error "ArithmeticException"
            	 */
            	
            	try {
            		resultado = operaciones.dividir(operandos[0], operandos[1]);
                    System.out.println ("Resultado: " + resultado);
                    LOGGER.log(Level.FINE, " funciona bien");
            	}catch (ArithmeticException exception) {
            		LOGGER.log(Level.WARNING, " Error Aritmético " + exception.getMessage());
            	}
                
            	 
            	
            } else if (operacion.equalsIgnoreCase("%")){		//Está amarillo porque no pasa por la última parte del código.
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE, " funciona bien");
            } else {
                System.out.println ("Operación no válida");		//El bucle no permite que el código pase por aquí.
            }
        }   while (menu.repetir());
        consoleHandler.close();
        fileHandler.close();
    }
    

}

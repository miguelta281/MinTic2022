/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.triangulo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.triangulo.mundo.Color;

/**
 * Clase usada para verificar que los m�todos de la clase Color est�n correctamente implementados.
 */
public class ColorTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Color usado para las pruebas.
     */
    private Color color;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo color e inicializa sus atributos.
     */
    private void setupEscenario1( )
    {
        color = new Color( 1, 1, 1 );
    }

    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo cambiarRojo. <b> M�todos a probar: </b> <br>
     * inicializar<br>
     * cambiarRojo<br>
     * darRojo<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente rojo del color.
     */
    @Test
    public void testCambiarRojo( )
    {
        setupEscenario1( );

        // Prueba el color Rojo
        assertEquals( "El rojo debe estar inicializado en 1", 1, color.darRojo( ) );
        color.cambiarRojo( 25 );
        assertEquals( "El rojo debe ser 25", 25, color.darRojo( ) );
    }

    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo cambiarVerde. <b> M�todos a probar: </b> <br>
     * inicializar<br>
     * cambiarVerde<br>
     * darVerde<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente verde del color.
     */
    @Test
    public void testVerde( )
    {
        setupEscenario1( );

        // Prueba el color Verde
        assertEquals( "El verde debe estar inicializado en 1", 1, color.darVerde( ) );
        color.cambiarVerde( 25 );
        assertEquals( "El verde debe ser 25", 25, color.darVerde( ) );
    }

    /**
     * Prueba 3: M�todo que se encarga de verificar el m�todo cambiarAzul. <b> M�todos a probar: </b> <br>
     * inicializar<br>
     * cambiarAzul<br>
     * darAzul<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente azul del color.
     */
    @Test
    public void testAzul( )
    {
        setupEscenario1( );

        // Prueba el color Azul
        assertEquals( "El azul debe estar inicializado en 1", 1, color.darAzul( ) );
        color.cambiarAzul( 25 );
        assertEquals( "El azul debe ser 25", 25, color.darAzul( ) );
    }

}

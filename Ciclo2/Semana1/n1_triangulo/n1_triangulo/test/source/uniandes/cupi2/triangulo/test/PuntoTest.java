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

import uniandes.cupi2.triangulo.mundo.Punto;

/**
 * Clase usada para verificar que los m�todos de la clase Punto est�n correctamente implementados.
 */
public class PuntoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Punto usado para las pruebas.
     */
    private Punto punto;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo Punto e inicializa sus atributos.
     */
    private void setupEscenario1( )
    {
        punto = new Punto( 1, 1 );
    }

    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo cambiarX. <b> M�todos a probar: </b> <br>
     * inicializar<br>
     * cambiarX<br>
     * darX<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia la coordenada x del punto.
     */
    @Test
    public void testCambiarX( )
    {
        setupEscenario1( );

        // Prueba el valor X
        assertEquals( "El valor X debe estar inicializado en 1", 1, punto.darX( ), 0 );
        punto.cambiarX( 25 );
        assertEquals( "El valor X debe ser 25", 25, punto.darX( ), 0 );
    }

    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo cambiarY. <b> M�todos a probar: </b> <br>
     * inicializar<br>
     * cambiarY<br>
     * darY<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia la coordenada y del punto.
     */
    @Test
    public void testValorY( )
    {
        setupEscenario1( );

        // Prueba el valor Y
        assertEquals( "El valor Y debe estar inicializado en 1", 1, punto.darY( ), 0 );
        punto.cambiarY( 25 );
        assertEquals( "El valor Y debe ser 25", 25, punto.darY( ), 0 );
    }

}

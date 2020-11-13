/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_transporte
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empresaTransporte.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.empresaTransporte.mundo.Camion;

/**
 * Clase usada para verificar que los m�todos de la clase Camion est�n correctamente implementados.
 */
public class CamionTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas
     */
    private Camion camion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un cami�n sin carga.
     */
    private void setupEscenario1( )
    {
        camion = new Camion( "ZZZ111", 25000, 2.58 );
    }

    /**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * Camion<br>
     * darMatricula<br>
     * darCargaActual<br>
     * darCapacidad<br>
     * darConsumo<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testCamion( )
    {
        setupEscenario1( );
        assertEquals( "La matr�cula no corresponde.", "ZZZ111", camion.darMatricula( ) );
        assertEquals( "La capacidad no coincide.", 25000, camion.darCapacidad( ) );
        assertEquals( "El consumo no corresponde.", 2.58, camion.darConsumo( ), 0.01 );
        assertEquals( "La carga actual no corresponde.", 0, camion.darCargaActual( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo cargar.<br>
     * <b> M�todos a probar: </b> <br>
     * cargar<br>
     * darCargaActual<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El cami�n se encontraba vac�o.<br>
     * 2. La carga supera la capacidad.
     */
    @Test
    public void testCargar( )
    {
        setupEscenario1( );
        assertTrue( "Deber�a realizarse la carga.", camion.cargar( 1000 ) );
        assertEquals( "La carga no coincide.", 1000, camion.darCargaActual( ) );

        assertFalse( "No deber�a realizarse la carga.", camion.cargar( 40000 ) );
    }

    /**
     * Prueba 3: Verifica el m�todo descargar.<br>
     * <b> M�todos a probar: </b> <br>
     * cargar<br>
     * descargar<br>
     * darCargaActual<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El cami�n ten�a carga..
     */
    @Test
    public void testDescargar( )
    {
        setupEscenario1( );
        camion.cargar( 5000 );
        camion.descargar( );
        assertEquals( "La carga no coincide.", 0, camion.darCargaActual( ) );
    }
}

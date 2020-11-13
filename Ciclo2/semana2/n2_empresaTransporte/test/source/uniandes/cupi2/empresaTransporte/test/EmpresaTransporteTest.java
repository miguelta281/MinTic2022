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

import org.junit.Test;

import junit.framework.TestCase;
import uniandes.cupi2.empresaTransporte.mundo.EmpresaTransporte;

/**
 * Clase usada para verificar que los m�todos de la clase EmpresaTransporte est�n correctamente implementados
 */
public class EmpresaTransporteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas
     */
    private EmpresaTransporte empresaTransporte;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva EmpresaTransporte con 4 camiones sin carga.
     */
    private void setupEscenario1( )
    {
        empresaTransporte = new EmpresaTransporte( );
    }

    /**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * EmpresaTransporte<br>
     * darCamion1<br>
     * darCamion2<br>
     * darCamion3<br>
     * darCamion4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testEmpresaTransporte( )
    {
        setupEscenario1( );

        assertNotNull( "El cami�n 1 deber�a existir.", empresaTransporte.darCamion1( ) );
        assertNotNull( "El cami�n 2 deber�a existir.", empresaTransporte.darCamion2( ) );
        assertNotNull( "El cami�n 3 deber�a existir.", empresaTransporte.darCamion3( ) );
        assertNotNull( "El cami�n 4 deber�a existir.", empresaTransporte.darCamion4( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo cargarCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * darCargaTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.
     */
    @Test
    public void testCargarCamion( )
    {
        setupEscenario1( );
        assertTrue( "Deber�a permitir cargar el cami�n.", empresaTransporte.cargarCamion( "BAC213", 100 ) );
    }

    /**
     * Prueba 3: Verifica el m�todo descargarCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * descargarCamion<br>
     * darCargaTotal<br>
     * darCamion1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Un cami�n tiene carga.
     */
    @Test
    public void testDescargarCamion( )
    {
        setupEscenario1( );
        empresaTransporte.cargarCamion( "BAC213", 100 );
        empresaTransporte.descargarCamion( "BAC213" );
        assertEquals( "Deber�a descargar el cami�n.", 0, empresaTransporte.darCamion1( ).darCargaActual( ) );
    }

    /**
     * Prueba 4: Verifica el m�todo darCapacidadTotal.<br>
     * <b> M�todos a probar: </b> <br>
     * darCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     */
    @Test
    public void testDarCapacidadTotal( )
    {
        setupEscenario1( );
        assertEquals( "La capacidad total no corresponde.", 835, empresaTransporte.darCapacidadTotal( ) );
    }

    /**
     * Prueba 5: Verifica el m�todo darCargaTotal.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * darCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testDarCargaTotal( )
    {
        setupEscenario1( );
        assertEquals( "La carga total no corresponde.", 0, empresaTransporte.darCargaTotal( ) );
        empresaTransporte.cargarCamion( "BAC213", 10 );
        empresaTransporte.cargarCamion( "CAP384", 20 );
        empresaTransporte.cargarCamion( "GER273", 30 );
        empresaTransporte.cargarCamion( "JKV232", 40 );
        assertEquals( "La carga total no corresponde.", 100, empresaTransporte.darCargaTotal( ) );
    }

    /**
     * Prueba 6: Verifica el m�todo calcularCargaPromedio.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * calcularCargaPromedio<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testCalcularCargaPromedio( )
    {
        setupEscenario1( );
        assertEquals( "El promedio est� mal calculado.", 0, empresaTransporte.calcularCargaPromedio( ), 0.01 );
        empresaTransporte.cargarCamion( "BAC213", 10 );
        empresaTransporte.cargarCamion( "CAP384", 20 );
        empresaTransporte.cargarCamion( "GER273", 30 );
        empresaTransporte.cargarCamion( "JKV232", 40 );
        assertEquals( "El promedio est� mal calculado.", 25, empresaTransporte.calcularCargaPromedio( ), 0.01 );
    }

    /**
     * Prueba 7: Verifica el m�todo darMejorCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * darMejorCamion<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testDarMejorCamion( )
    {
        setupEscenario1( );
        assertNull( "No deber�a sugerir ningun cami�n.", empresaTransporte.darMejorCamion( 2000 ) );
        assertNotNull( "Deber�a sugerir un cami�n.", empresaTransporte.darMejorCamion( 140 ) );
        assertEquals( "Deber�a sugerir un cami�n.", "CAP384", empresaTransporte.darMejorCamion( 140 ).darMatricula( ) );
    }

}
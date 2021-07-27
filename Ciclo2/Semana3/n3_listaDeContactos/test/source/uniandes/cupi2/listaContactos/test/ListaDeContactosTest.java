/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_listaDeContactos
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.listaContactos.test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import uniandes.cupi2.listaContactos.mundo.Contacto;
import uniandes.cupi2.listaContactos.mundo.ListaDeContactos;

/**
 * Clase de prueba de la lista de contactos
 */
public class ListaDeContactosTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Contacto1 para realizar pruebas
     */
    private Contacto contacto1;

    /**
     * Contacto2 para realizar pruebas
     */
    private Contacto contacto2;

    /**
     * Contacto3 para realizar pruebas
     */
    private Contacto contacto3;

    /**
     * Lista de contactos para realizar pruebas
     */
    private ListaDeContactos lista;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los elementos para las pruebas
     */
    public void setUpEscenario1( )
    {
        contacto1 = new Contacto( "Carolina", "Rodr�guez", "Trv 25 No. 43 - 45", "crodriguez@uniandes.edu.co" );
        contacto1.agregarTelefono( "6556850" );
        contacto1.agregarTelefono( "4859527" );
        contacto1.agregarPalabra( "Amigos" );
        contacto1.agregarPalabra( "Fiesta" );

        contacto2 = new Contacto( "Camila", "Borrero", "Cll 56 No. 67 - 76", "cborrero@uniandes.edu.co" );
        contacto2.agregarTelefono( "6456787" );
        contacto2.agregarTelefono( "5678765" );
        contacto2.agregarPalabra( "Amigas" );
        contacto2.agregarPalabra( "Fiesta" );

        contacto3 = new Contacto( "Mauricio", "S�nchez", "Av 24 No. 6 - 32", "msanchez@msanchez.com" );
        contacto3.agregarTelefono( "6785465" );
        contacto3.agregarPalabra( "Papa" );
        contacto3.agregarPalabra( "Familia" );

        lista = new ListaDeContactos( );
        lista.agregarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        lista.agregarContacto( contacto2.darNombre( ), contacto2.darApellido( ), contacto2.darDireccion( ), contacto2.darCorreo( ), contacto2.darTelefonos( ), contacto2.darPalabras( ) );
        lista.agregarContacto( contacto3.darNombre( ), contacto3.darApellido( ), contacto3.darDireccion( ), contacto3.darCorreo( ), contacto3.darTelefonos( ), contacto3.darPalabras( ) );
    }

    /**
     * Prueba el obtener todos los elementos
     */
    @Test
    public void testDarTodosLosContactos( )
    {
        setUpEscenario1( );
        ArrayList<String> contactos = lista.darTodosLosContactos( );
        String strCon1 = ( String )contactos.get( 0 );
        String strCon2 = ( String )contactos.get( 1 );
        String strCon3 = ( String )contactos.get( 2 );

        assertTrue( "La lista no se arm� correctamente", strCon1.equals( "Carolina Rodr�guez" ) && strCon2.equals( "Camila Borrero" ) && strCon3.equals( "Mauricio S�nchez" ) );

    }

    /**
     * Prueba la b�squeda de elementos por palabra
     */
    @Test
    public void testDarContactosPalabra( )
    {
        setUpEscenario1( );

        // b�squeda de m�s de 1 elemento
        ArrayList<String> contactos = lista.buscarContactosPalabraClave( "Fiesta" );
        String strCon1 = ( String )contactos.get( 0 );
        String strCon2 = ( String )contactos.get( 1 );

        assertTrue( "La lista no est� armada correctamente", strCon1.equals( "Carolina Rodr�guez" ) && strCon2.equals( "Camila Borrero" ) && contactos.size( ) == 2 );

        // b�squeda de un elemento
        contactos = lista.buscarContactosPalabraClave( "Familia" );
        strCon1 = ( String )contactos.get( 0 );

        assertTrue( "La lista no est� armada correctamente", strCon1.equals( "Mauricio S�nchez" ) && contactos.size( ) == 1 );

        // b�squeda por nombre
        contactos = lista.buscarContactosPalabraClave( "Camila" );
        strCon1 = ( String )contactos.get( 0 );

        assertTrue( "La lista no est� armada correctamente", strCon1.equals( "Camila Borrero" ) && contactos.size( ) == 1 );
    }

    /**
     * Prueba que los contactos se recuperen correctamente
     */
    @Test
    public void testBuscarContactoExistente( )
    {
        setUpEscenario1( );
        Contacto c = lista.buscarContacto( "Camila", "Borrero" );
        assertNotNull( c );
        assertEquals( "Camila", c.darNombre( ) );
        assertEquals( "Borrero", c.darApellido( ) );
        ArrayList<String> telefonos = c.darTelefonos( );
        assertEquals( 2, telefonos.size( ) );
        ArrayList<String> palabras = c.darPalabras( );
        assertEquals( 4, palabras.size( ) );
        assertEquals( "6456787", ( String )telefonos.get( 0 ) );
        assertEquals( "5678765", ( String )telefonos.get( 1 ) );
        assertEquals( "Amigas", ( String )palabras.get( 0 ) );
        assertEquals( "Fiesta", ( String )palabras.get( 1 ) );
    }

    /**
     * Prueba que que la b�squeda de un contacto que no existe retorne null
     */
    @Test
    public void testBuscarContactoInexistente( )
    {
        setUpEscenario1( );
        Contacto c = lista.buscarContacto( "Pedro", "P�rez" );
        assertNull( c );
    }

    /**
     * Prueba que no se agregue un usuario cuyo nombre y apellido ya existen en la lista
     */
    @Test
    public void testAgregarContacto( )
    {
        setUpEscenario1( );

        contacto1 = new Contacto( "Mauricio", "S�nchez", "Av 24 No. 6 - 34", "msanchez1@msanchez.com" );
        boolean accion = lista.agregarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        assertFalse( "No se puede agregar un contacto con el nombre y apellidos de uno ya existente", accion );

    }

    /**
     * Prueba la eliminaci�n de contactos
     */
    @Test
    public void testEliminarContacto( )
    {
        setUpEscenario1( );

        // prueba la eliminaci�n de un contacto no existente
        boolean accion = lista.eliminarContacto( "Diana", "Puentes" );
        assertTrue( "No se puede eliminar un contacto no existente", accion == false );

        // prueba la eliminaci�n de un contacto existente
        lista.eliminarContacto( "Mauricio", "S�nchez" );
        ArrayList<String> conts = lista.buscarContactosPalabraClave( "Familia" );
        assertTrue( "No se elimino correctamente el contacto", conts.size( ) == 0 );

    }

    /**
     * Prueba la modificaci�n de elementos
     */
    @Test
    public void testModificarContacto( )
    {
        setUpEscenario1( );

        // Modificaci�n de un elemento no existente
        contacto1 = new Contacto( "Pedro", "S�nchez", "Av 24 No. 6 - 34", "msanchez1@msanchez.com" );

        boolean accion = lista.modificarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        assertFalse( "No se puede modificar un contacto no existente", accion );

        // Modificaci�n de un elemento existente
        ArrayList<String> telefonos1 = new ArrayList<String>( );
        ArrayList<String> palabras1 = new ArrayList<String>( );

        lista.modificarContacto( "Mauricio", "S�nchez", "Av 24 No. 6 - 44", "msanchez1@msanchez.com", telefonos1, palabras1 );

        Contacto c = lista.buscarContacto( "Mauricio", "S�nchez" );
        assertEquals( "Av 24 No. 6 - 44", c.darDireccion( ) );
        assertEquals( "No se modifico el contacto correctamente (Las palabras clave no cambiaron)", 0, c.darPalabras( ).size( ) );
        assertEquals( "No se modifico el contacto correctamente (Las palabras clave no cambiaron)", 0, c.darTelefonos( ).size( ) );

    }

}

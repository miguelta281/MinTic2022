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
package uniandes.cupi2.listaContactos.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra la lista de contactos.
 */
@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante usada para indicar que se quieren ver todos los contactos.
     */
    private final static String TODOS = "TODOS";

    /**
     * Constante usada para indicar que se quieren ver los contactos que cumplan con alg�n criterio de b�squeda.
     */
    private final static String PALABRA = "PALABRA";

    /**
     * Constante usada para indicar que se quieren ver los datos de un contacto.
     */
    private final static String VER = "VER";

    /**
     * Constante usada para indicar que se quiere eliminar un contacto.
     */
    private final static String ELIMINAR = "ELIMINAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La ventana principal de la aplicaci�n.
     */
    private InterfazListaDeContactos principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de desplazamiento de la lista de contactos.
     */
    private JScrollPane panelLista;

    /**
     * Lista para los contactos.
     */
    private JList listaContactos;

    /**
     * Bot�n al que se le asignara la acci�n para mostrar los datos de un contacto.
     */
    private JButton btnVer;

    /**
     * Bot�n al que se le asignara la acci�n para eliminar un contacto.
     */
    private JButton btnEliminar;

    /**
     * Bot�n para la acci�n de ver todos los contactos.
     */
    private JButton btnTodos;

    /**
     * Bot�n para hacer b�squeda de contactos por palabras clave.
     */
    private JButton btnPalabra;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de visualizaci�n de la lista de contactos.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelLista( InterfazListaDeContactos pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Lista de Contactos" ) );

        // Inicializa la lista
        listaContactos = new JList( );
        panelLista = new JScrollPane( );
        panelLista.setViewportView( listaContactos );
        panelLista.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        panelLista.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

        listaContactos.setModel( new DefaultListModel( ) );

        // Inicializa los botones
        btnVer = new JButton( );
        btnVer.setText( "Ver" );
        btnVer.setActionCommand( VER );
        btnVer.addActionListener( this );

        btnEliminar = new JButton( );
        btnEliminar.setText( "Eliminar" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );

        btnTodos = new JButton( );
        btnTodos.setText( "Ver Todos los contactos" );
        btnTodos.setActionCommand( TODOS );
        btnTodos.addActionListener( this );

        btnPalabra = new JButton( );
        btnPalabra.setText( "Buscar por palabra clave" );
        btnPalabra.setActionCommand( PALABRA );
        btnPalabra.addActionListener( this );

        // Ubica los elementos inicializados anteriormente
        add( panelLista, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( );
        panelBotones.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        panelBotones.setLayout( new GridLayout( 4, 1, 5, 5 ) );
        panelBotones.add( btnTodos );
        panelBotones.add( btnPalabra );
        panelBotones.add( btnVer );
        panelBotones.add( btnEliminar );

        add( panelBotones, BorderLayout.EAST );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista con los elementos del arrayList.
     * @param pLista La nueva lista de nombres para mostrar.
     */
    public void actualizarLista( ArrayList pLista )
    {
        listaContactos.setListData( pLista.toArray( ) );
    }

    /**
     * Retorna el nombre del contacto seleccionado.
     * @return Nombre del contacto seleccionado. Si no hay un contacto seleccionado retorna null.
     */
    public String darNombreSeleccionado( )
    {
        String nombreCompleto = ( ( String )listaContactos.getSelectedValue( ) );
        if( nombreCompleto != null )
        {
            nombreCompleto = nombreCompleto.substring( 0, nombreCompleto.indexOf( " " ) );
        }

        return nombreCompleto;
    }

    /**
     * Retorna el apellido del contacto seleccionado.
     * @return Apellido del contacto seleccionado. Si no hay un contacto seleccionado retorna null.
     */
    public String darApellidoSeleccionado( )
    {
        String nombreCompleto = ( ( String )listaContactos.getSelectedValue( ) );
        if( nombreCompleto != null )
        {
            nombreCompleto = nombreCompleto.substring( nombreCompleto.indexOf( " " ) + 1, nombreCompleto.length( ) );
        }

        return nombreCompleto;
    }

    /**
     * Recibe los eventos realizados en los elementos de la interfaz y realiza acciones.
     * @param pEvento El evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( VER ) )
        {
            principal.visualizarContacto( );
        }
        else if( comando.equals( TODOS ) )
        {
            actualizarLista( principal.darContactos( ) );
        }
        else if( comando.equals( PALABRA ) )
        {
            principal.buscarContactosPalabra( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            principal.eliminarContacto( );
        }

    }

}

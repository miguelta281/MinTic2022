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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para los botones de extensi�n del ejercicio.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante OPCION_1, Usada para realizar la opci�n de la extensi�n 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante OPCION_2, Usada para realizar la opci�n de la extensi�n 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazListaDeContactos principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Para hacer la extensi�n 1.
     */
    private JButton opcion1;

    /**
     * Bot�n Para hacer la extensi�n 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel con los botones para realizar las extensiones.
     * @param pPrincipal La ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelOpciones( InterfazListaDeContactos pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Extensiones" ) );

        opcion1 = new JButton( );
        opcion1.setText( "Cerrar BD" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );

        opcion2 = new JButton( );
        opcion2.setText( "Cargar Registros" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );

        add( opcion1 );
        add( opcion2 );
    }

    /**
     * Realiza las acciones respectivas dependiendo del evento ocurrido. <br>
     * <b>post: </b> Se realiza alguno de los 2 puntos de extensi�n.
     * @param pEvento Evento generado. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( command.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}

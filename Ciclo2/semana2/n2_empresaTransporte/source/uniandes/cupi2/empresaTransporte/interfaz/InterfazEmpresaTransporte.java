/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_empresaTransporte
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empresaTransporte.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.empresaTransporte.mundo.Camion;
import uniandes.cupi2.empresaTransporte.mundo.EmpresaTransporte;

/**
 * Ventana principal de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class InterfazEmpresaTransporte extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private EmpresaTransporte empresaTransporte;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la informaci�n del cami�n 1.
     */
    private PanelCamion panelCamion1;

    /**
     * Panel con la informaci�n del cami�n 2.
     */
    private PanelCamion panelCamion2;

    /**
     * Panel con la informaci�n del cami�n 3.
     */
    private PanelCamion panelCamion3;

    /**
     * Panel con la informaci�n del cami�n 4.
     */
    private PanelCamion panelCamion4;

    /**
     * Panel con la informaci�n general.
     */
    private PanelInformacion panelInformaci�n;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la imagen de banner.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicaci�n. <br>
     * <b>post: </b> La venta fue creada con todos sus paneles.
     */
    public InterfazEmpresaTransporte( )
    {
        setTitle( "Empresa de transporte" );
        setSize( 750, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        empresaTransporte = new EmpresaTransporte( );

        setLayout( new BorderLayout( ) );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridLayout( 2, 2 ) );

        panelCamion1 = new PanelCamion( this );
        panelCentral.add( panelCamion1 );

        panelCamion2 = new PanelCamion( this );
        panelCentral.add( panelCamion2 );

        panelCamion3 = new PanelCamion( this );
        panelCentral.add( panelCamion3 );

        panelCamion4 = new PanelCamion( this );
        panelCentral.add( panelCamion4 );

        add( panelCentral, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        JPanel panelSuperior = new JPanel( );
        panelSuperior.setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        panelSuperior.add( panelImagen, BorderLayout.CENTER );

        panelInformaci�n = new PanelInformacion( );
        panelSuperior.add( panelInformaci�n, BorderLayout.SOUTH );

        add( panelSuperior, BorderLayout.NORTH );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n de todos los paneles.
     */
    public void actualizar( )
    {
        panelCamion1.actualizar( empresaTransporte.darCamion1( ) );
        panelCamion2.actualizar( empresaTransporte.darCamion2( ) );
        panelCamion3.actualizar( empresaTransporte.darCamion3( ) );
        panelCamion4.actualizar( empresaTransporte.darCamion4( ) );
        panelInformaci�n.actualizarInformacion( empresaTransporte.darCargaTotal( ), empresaTransporte.calcularCargaPromedio( ) );
    }

    /**
     * Carga un cami�n.
     * @param pMatricula Matr�cula del cami�n a descargar. pMatricula != null && pMatricula != "".
     */
    public void cargar( String pMatricula )
    {
        String ingresado = JOptionPane.showInputDialog( this, "Peso de la carga:", "Cargar cami�n", JOptionPane.DEFAULT_OPTION );
        if( ingresado != null )
        {
            try
            {
                int carga = Integer.parseInt( ingresado );
                if( carga > 0 )
                {
                    boolean cargo = empresaTransporte.cargarCamion( pMatricula, carga );
                    if( cargo == true )
                    {
                        actualizar( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El cami�n no tiene capacidad suficiente para esa carga.", "Cargar cami�n", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "El valor ingresado debe ser positivo.", "Cargar cami�n", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor num�rico.", "Cargar cami�n", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Descarga un cami�n.
     * @param pMatricula Matr�cula del cami�n a descargar. pMatricula != null && pMatricula != "".
     */
    public void descargar( String pMatricula )
    {
        empresaTransporte.descargarCamion( pMatricula );
        actualizar( );
    }

    /**
     * Busca y muestra el mejor cami�n para transportar una carga dada.
     */
    public void darMejorCamion( )
    {
        String valor = JOptionPane.showInputDialog( this, "Peso a transportar (en Kg.)", "Buscar mejor cami�n", JOptionPane.DEFAULT_OPTION );
        if( valor != null )
        {
            try
            {
                int cantidad = Integer.parseInt( valor );
                Camion resultado = empresaTransporte.darMejorCamion( cantidad );
                if( resultado != null )
                {
                    JOptionPane.showMessageDialog( this, "El mejor cami�n para transportar la carga tiene la matr�cula: " + resultado.darMatricula( ), "Mejor cami�n", JOptionPane.DEFAULT_OPTION );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Ning�n cami�n puede transportar la carga.", "Mejor cami�n", JOptionPane.DEFAULT_OPTION );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El peso ingresado debe ser un valor num�rico.", "Mejor cami�n", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Muestra la capacidad total de carga de los 4 camiones.
     */
    public void darTotalizarPeso( )
    {
        int peso = empresaTransporte.darCapacidadTotal( );
        JOptionPane.showMessageDialog( this, "La capacidad total de carga es " + peso + " kg.", "Peso Total", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresaTransporte.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresaTransporte.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazEmpresaTransporte interfaz = new InterfazEmpresaTransporte( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
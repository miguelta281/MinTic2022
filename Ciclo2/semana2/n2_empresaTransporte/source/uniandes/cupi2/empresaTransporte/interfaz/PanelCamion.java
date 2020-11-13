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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.empresaTransporte.mundo.Camion;

/**
 * Panel para mostrar la informaci�n de un cami�n.
 */
@SuppressWarnings("serial")
public class PanelCamion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el comando para descargar el cami�n.
     */
    private static final String DESCARGAR = "Descargar";

    /**
     * Representa el comando para cargar el cami�n.
     */
    private static final String CARGAR = "Cargar";

    /**
     * Ruta de la imagen a un cami�n que est� cargado.
     */
    private static final String CARGADO = "data/imagenes/camionCargado.png";

    /**
     * Ruta de la imagen a un cami�n que no est� cargado.
     */
    private static final String VACIO = "data/imagenes/camionVacio.png";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazEmpresaTransporte principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta para la imagen del cami�n.
     */
    private JLabel lblImagen;

    /**
     * Etiqueta Matr�cula.
     */
    private JLabel lblMatricula;

    /**
     * Etiqueta Capacidad.
     */
    private JLabel lblCapacidad;

    /**
     * Etiqueta Consumo.
     */
    private JLabel lblConsumo;

    /**
     * Etiqueta Carga actual.
     */
    private JLabel lblCargaActual;

    /**
     * Campo de texto para la matr�cula.
     */
    private JTextField txtMatricula;

    /**
     * Campo de texto para la capacidad.
     */
    private JTextField txtCapacidad;

    /**
     * Campo de texto para el consumo.
     */
    private JTextField txtConsumo;

    /**
     * Campo de texto para la carga actual.
     */
    private JTextField txtCargaActual;

    /**
     * Bot�n cargar.
     */
    private JButton btnCargar;

    /**
     * Bot�n descargar.
     */
    private JButton btnDescargar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param laPrincipal Ventana principal de la aplicaci�n. laPrincipal != null.
     */
    public PanelCamion( InterfazEmpresaTransporte laPrincipal )
    {
        principal = laPrincipal;
        setBorder( new TitledBorder( "" ) );
        setLayout( new BorderLayout( ) );

        ImageIcon icono = new ImageIcon( VACIO );
        lblImagen = new JLabel( "" );
        lblImagen.setIcon( icono );
        add( lblImagen, BorderLayout.WEST );

        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 4, 2, 5, 5 ) );

        lblMatricula = new JLabel( "Matr�cula:" );
        panelInfo.add( lblMatricula );
        txtMatricula = new JTextField( );
        txtMatricula.setEditable( false );
        panelInfo.add( txtMatricula );

        lblCapacidad = new JLabel( "Capacidad:" );
        panelInfo.add( lblCapacidad );
        txtCapacidad = new JTextField( );
        txtCapacidad.setEditable( false );
        panelInfo.add( txtCapacidad );

        lblConsumo = new JLabel( "Consumo:" );
        panelInfo.add( lblConsumo );
        txtConsumo = new JTextField( );
        txtConsumo.setEditable( false );
        panelInfo.add( txtConsumo );

        lblCargaActual = new JLabel( "Carga actual:" );
        panelInfo.add( lblCargaActual );
        txtCargaActual = new JTextField( );
        txtCargaActual.setEditable( false );
        panelInfo.add( txtCargaActual );

        add( panelInfo, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2, 5, 5 ) );

        btnCargar = new JButton( "Cargar" );
        btnCargar.setPreferredSize( new Dimension( 150, 25 ) );
        btnCargar.setActionCommand( CARGAR );
        btnCargar.addActionListener( this );
        panelBotones.add( btnCargar );

        btnDescargar = new JButton( "Descargar" );
        btnDescargar.setEnabled( false );
        btnDescargar.setPreferredSize( new Dimension( 150, 25 ) );
        btnDescargar.setActionCommand( DESCARGAR );
        btnDescargar.addActionListener( this );
        panelBotones.add( btnDescargar );

        add( panelBotones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n del cami�n con el cami�n dado por par�metro.
     * @param pCamion Cami�n con la informaci�n. pCamion != null.
     */
    public void actualizar( Camion pCamion )
    {
        ImageIcon icono = new ImageIcon( VACIO );
        btnCargar.setEnabled( true );
        btnDescargar.setEnabled( false );

        if( pCamion.darCargaActual( ) > 0 )
        {
            icono = new ImageIcon( CARGADO );
            btnCargar.setEnabled( false );
            btnDescargar.setEnabled( true );
        }

        lblImagen.setIcon( icono );

        txtMatricula.setText( pCamion.darMatricula( ) );
        txtCapacidad.setText( formatearValor( pCamion.darCapacidad( ) ) + " Kg" );
        txtConsumo.setText( formatearValor( pCamion.darConsumo( ) ) + " gal/Km" );
        txtCargaActual.setText( formatearValor( pCamion.darCargaActual( ) ) + " Kg" );

    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( DESCARGAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.descargar( txtMatricula.getText( ) );
        }
        else
        {
            principal.cargar( txtMatricula.getText( ) );
        }
    }

    /**
     * Formatea un valor num�rico.
     * @param pValor Valor num�rico a ser formateado.
     * @return Cadena con el valor formateado.
     */
    private String formatearValor( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 2 );
        return df.format( pValor );
    }

}
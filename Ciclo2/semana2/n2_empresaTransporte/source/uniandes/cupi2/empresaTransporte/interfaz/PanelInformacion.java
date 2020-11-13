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

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar la informaci�n general del barco.
 */
@SuppressWarnings("serial")
public class PanelInformacion extends JPanel
{

    // ------------------------------------------------------------
    // Atributos de interfaz
    // ------------------------------------------------------------

    /**
     * Etiqueta Total de carga.
     */
    private JLabel lblCargaTotal;

    /**
     * Etiqueta Promedio carga.
     */
    private JLabel lblPromedioCarga;

    /**
     * Campo de texto para el total de la carga.
     */
    private JTextField txtTotalCarga;

    /**
     * Campo de texto para el promedio de carga por cami�n.
     */
    private JTextField txtPromedioCarga;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    /**
     * Constructor del panel de informaci�n de la empresa de transporte.
     */
    public PanelInformacion( )
    {
        setLayout( new GridLayout( 2, 2, 2, 2 ) );

        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Informaci�n" ) ) );

        lblCargaTotal = new JLabel( "Carga total:" );
        add( lblCargaTotal );
        txtTotalCarga = new JTextField( );
        txtTotalCarga.setEditable( false );
        add( txtTotalCarga );

        lblPromedioCarga = new JLabel( "Carga promedio:" );
        add( lblPromedioCarga );
        txtPromedioCarga = new JTextField( );
        txtPromedioCarga.setEditable( false );
        add( txtPromedioCarga );
    }

    // ------------------------------------------------------------
    // M�todos
    // ------------------------------------------------------------

    /**
     * Actualiza el panel.
     * @param pCargaTotal Carga total de los 4 camiones. pCargaTotal >= 0.
     * @param pCargaPromedio Promedio de carga por cami�n. pCargaPromedio >= 0.
     */
    public void actualizarInformacion( int pCargaTotal, double pCargaPromedio )
    {
        txtTotalCarga.setText( pCargaTotal + " Kg." );
        txtPromedioCarga.setText( pCargaPromedio + " Kg." );
    }
}

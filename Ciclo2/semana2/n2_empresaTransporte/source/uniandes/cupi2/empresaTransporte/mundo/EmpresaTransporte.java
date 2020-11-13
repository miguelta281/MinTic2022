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
package uniandes.cupi2.empresaTransporte.mundo;

/**
 * Empresa de transporte.
 */
public class EmpresaTransporte
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cami�n 1 de la empresa.
     */
    private Camion camion1;

    /**
     * Cami�n 2 de la empresa.
     */
    private Camion camion2;

    /**
     * Cami�n 3 de la empresa.
     */
    private Camion camion3;

    /**
     * Cami�n 4 de la empresa.
     */
    private Camion camion4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva empresa de transporte con 4 camiones. <br>
     * <b>post: </b> Los camiones fueron creados con los siguientes valores: <br>
     * Cami�n 1: Matr�cula: BAC213, Capacidad (en Kgs): 150, Consumo: 85. <br>
     * Cami�n 2: Matr�cula: CAP384, Capacidad (en Kgs): 190, Consumo: 70. <br>
     * Cami�n 3: Matr�cula: GER273, Capacidad (en Kgs): 280, Consumo: 100. <br>
     * Cami�n 4: Matr�cula: JKV232, Capacidad (en Kgs): 215, Consumo: 110.
     */
    public EmpresaTransporte( )
    {
        camion1 = new Camion( "BAC213", 150, 85 );
        camion2 = new Camion( "CAP384", 190, 70 );
        camion3 = new Camion( "GER273", 280, 100 );
        camion4 = new Camion( "JKV232", 215, 110 );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el cami�n 1.
     * @return Cami�n 1.
     */
    public Camion darCamion1( )
    {
        return camion1;
    }

    /**
     * Retorna el cami�n 2.
     * @return Cami�n 2.
     */
    public Camion darCamion2( )
    {
        return camion2;
    }

    /**
     * Retorna el cami�n 3.
     * @return Cami�n 3.
     */
    public Camion darCamion3( )
    {
        return camion3;
    }

    /**
     * Retorna el cami�n 4.
     * @return Cami�n 4.
     */
    public Camion darCamion4( )
    {
        return camion4;
    }

    /**
     * Carga el cami�n con la matricula dada y carga dada por par�metro. <br>
     * <b>post: </b> El cami�n tiene la carga dada.
     * @param pMatricula Matr�cula del cami�n. pMatricula != null && pMatricula != "".
     * @param pPesoCarga Peso de la carga para cargar el cami�n. pPesoCarga > 0.
     * @return Retorna true si pudo realizar la carga, false en caso contrario.
     */
    public boolean cargarCamion( String pMatricula, int pPesoCarga )
    {
        boolean cargo = false;
        if( camion1.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion1.cargar( pPesoCarga );
        }
        else if( camion2.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion2.cargar( pPesoCarga );
        }
        else if( camion3.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion3.cargar( pPesoCarga );
        }
        else if( camion4.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion4.cargar( pPesoCarga );
        }
        return cargo;
        
    }

    /**
     * Descarga el cami�n con la matr�cula dada por par�metro. <br>
     * <b>post: </b> El cami�n no tiene carga.
     * @param pMatricula Matr�cula del cami�n. pMatricula != null && pMatricula != "".
     */
    public void descargarCamion( String pMatricula )
    {
        if( camion1.darMatricula( ).equals( pMatricula ) )
        {
            camion1.descargar( );
        }
        else if( camion2.darMatricula( ).equals( pMatricula ) )
        {
            camion2.descargar( );
        }
        else if( camion3.darMatricula( ).equals( pMatricula ) )
        {
            camion3.descargar( );
        }
        else if( camion4.darMatricula( ).equals( pMatricula ) )
        {
            camion4.descargar( );
        }
    }

    /**
     * Retorna la capacidad total de carga de los camiones.
     * @return Capacidad total de carga de los camiones.
     */
    public int darCapacidadTotal( )
    {
        return camion1.darCapacidad( ) + camion2.darCapacidad( ) + camion3.darCapacidad( ) + camion4.darCapacidad( );
    }

    /**
     * Retorna la carga total de los camiones.
     * @return Carga total de los camiones.
     */
    public int darCargaTotal( )
    {
        return camion1.darCargaActual( ) + camion2.darCargaActual( ) + camion3.darCargaActual( ) + camion4.darCargaActual( );
    }

    /**
     * Retorna la carga promedio por cami�n.
     * @return Carga promedio por cami�n.
     */
    public double calcularCargaPromedio( )
    {
        double promedio = ( double ) ( darCargaTotal( ) / 4 );
        return promedio;
    }

    /**
     * Retorna el mejor cami�n para transportar la carga especificada. <br>
     * El mejor cami�n es aquel que tiene la capacidad para cargar la carga dada y adem�s tiene un menor consumo de gasolina.
     * @param pPesoCarga Peso de la carga a transportar. pPesoCarga > 0.
     * @return Cami�n ideal para llevar la carga. Si ning�n cami�n es apto para la carga retorna null.
     */
    public Camion darMejorCamion( int pPesoCarga )
    {
        Camion mejor = null;
        double mejorConsumo = -1;
        if( camion1.darCapacidad( ) >= pPesoCarga && (mejorConsumo == -1  || camion1.darConsumo( ) < mejorConsumo) )
        {
            mejor = camion1;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion2.darCapacidad( ) >= pPesoCarga && (mejorConsumo == -1  || camion2.darConsumo( ) < mejorConsumo) )
        {
            mejor = camion2;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion3.darCapacidad( ) >= pPesoCarga && (mejorConsumo == -1  || camion3.darConsumo( ) < mejorConsumo) )
        {
            mejor = camion3;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion4.darCapacidad( ) >= pPesoCarga && (mejorConsumo == -1  || camion4.darConsumo( ) < mejorConsumo) )
        {
            mejor = camion4;
            mejorConsumo = mejor.darConsumo( );
        }
        return mejor;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}
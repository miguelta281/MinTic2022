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
 * Cami�n de la empresa de transporte.
 */
public class Camion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Matricula del cami�n.
     */
    private String matricula;

    /**
     * Capacidad del cami�n (en Kg).
     */
    private int capacidad;

    /**
     * Consumo de gasolina del cami�n (en galones de gasolina/kil�metro).
     */
    private double consumo;

    /**
     * Carga actual del cami�n (en Kg).
     */
    private int cargaActual;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo cami�n con los . <br>
     * <b>post: </b> La matr�cula, la capacidad y el consumo fueron inicializados con los valores dados por par�metro. <br>
     * La carga actual del cami�n fue inicializada en 0.
     * @param pMatricula Matricula del cami�n. pMatricula != null && pMatricula != "".
     * @param pCapacidad Capacidad (en Kg.) del cami�n. pCapacidad > 0.
     * @param pConsumo Consumo de gasolina (en gasolina/kil�metro). pConsumo > 0.
     */
    public Camion( String pMatricula, int pCapacidad, double pConsumo )
    {
        matricula = pMatricula;
        capacidad = pCapacidad;
        consumo = pConsumo;
        cargaActual = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la capacidad del cami�n.
     * @return Capacidad del cami�n.
     */
    public int darCapacidad( )
    {
        return capacidad;
    }

    /**
     * Retorna el consumo de gasolina del cami�n.
     * @return Consumo de gasolina del cami�n.
     */
    public double darConsumo( )
    {
        return consumo;
    }

    /**
     * Retorna la matricula del cami�n.
     * @return Matricula del cami�n.
     */
    public String darMatricula( )
    {
        return matricula;
    }

    /**
     * Retorna la carga actual del cami�n.
     * @return Carga actual del cami�n.
     */
    public int darCargaActual( )
    {
        return cargaActual;
    }

    /**
     * Carga el cami�n con la carga dada por par�metro. <br>
     * <b>post: </b> El cami�n fue cargado con el valor dado por par�metro.
     * @param pPesoCarga Peso a cargar (en Kg). pPesoCarga > 0.
     * @return Retorna true si logra cargar el cami�n, false de lo contrario.
     */
    public boolean cargar( int pPesoCarga )
    {
        boolean cargo = false;
        if( pPesoCarga <= capacidad )
        {
            cargo = true;
            cargaActual = pPesoCarga;
        }
        return cargo;
    }

    /**
     * Descarga el cami�n. <br>
     * <b>post: </b> La carga del cami�n es 0.
     */
    public void descargar( )
    {
        cargaActual = 0;
    }

}

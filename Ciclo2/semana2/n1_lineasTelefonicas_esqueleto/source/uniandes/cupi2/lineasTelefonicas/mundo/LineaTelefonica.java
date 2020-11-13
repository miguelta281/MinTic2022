/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa una línea telefónica.
 */
public class LineaTelefonica
{
	//-----------------------------------------------------------------
	// Constantes
	//-----------------------------------------------------------------
	public final static int costoLlamadaLocal = 35;
	public final static int costoLlamadaLarga = 380;
	public final static int costoLlamadaCelular = 999;
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Número de llamadas realizadas.
     */
    private int numeroLlamadas;

    /**
     * Número de minutos consumidos.
     */
    private int numeroMinutos;
    
    /**
     * Número de minutos consumidos por celular.
     */
    private int numeroMinutosCelular;

    /**
     * Costo total de las llamadas.
     */
    private double costoLlamadas;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa la línea telefónica. <br>
     * <b>post: </b> La línea se inicializó con valores en cero.
     */
    public LineaTelefonica( )
    {
    	numeroLlamadas = 0;
    	numeroMinutos = 0;
    	numeroMinutosCelular = 0;
    	costoLlamadas = 0;
    	
    	// TODO Parte2 PuntoA: Inicializar el número de llamadas, número de minutos y costo de llamadas en 0.
    }

    /**
     * Retorna el costo total de las llamadas realizadas.
     * @return Costo total de las llamadas realizadas.
     */
    public double darCostoLlamadas( )
    {
    	return costoLlamadas;
        // TODO Parte2 PuntoB: Completar el método según la documentación dada.
    }

    /**
     * Retorna el número de llamadas realizadas por esta línea.
     * @return Número de llamadas realizadas por esta línea.
     */
    public int darNumeroLlamadas( )
    {
    	return numeroLlamadas;
        // TODO Parte2 PuntoC: Completar el método según la documentación dada.
    }

    /**
     * Retorna el número de minutos consumidos.
     * @return Número de minutos consumidos.
     */
    public int darNumeroMinutos( )
    {
    	return numeroMinutos;
        // TODO Parte2 PuntoD: Completar el método según la documentación dada.
    }
    
    public int darNumeroMinutosCelular( )
    {
    	return numeroMinutosCelular;
        // TODO Parte2 PuntoE: Completar el método según la documentación dada.
    }

    /**
	 * Reinicia la línea telefónica, dejando todos sus valores en cero.<br>
	 * <b> post: </b> El número de llamadas, número de minutos y costo de llamadas son 0.
	 */
	public void reiniciar( )
	{
    	numeroLlamadas = 0;
    	numeroMinutos = 0;
    	numeroMinutosCelular = 0;
    	costoLlamadas = 0;
        // TODO Parte2 PuntoE: Reiniciar el número de llamadas, número de minutos y costo de llamadas en 0.
	}

	/**
     * Agrega una llamada local a la línea telefónica <br>
     * <b>post: </b> Se incrementó en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumentó en ( minutos * 35 ).
     * @param pMinutos Número de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaLocal( int pMinutos )
    {
        //Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + pMinutos;
        //
        //Suma el costo (costo por minuto: 35 pesos)
        costoLlamadas = costoLlamadas + ( pMinutos * costoLlamadaLocal );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica <br>
     * <b>post: </b> Se incrementó en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumentó en ( minutos * 380 )
     * @param pMinutos Número de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaLargaDistancia( int pMinutos )
    {
    	//Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + pMinutos;
        //
        //Suma el costo (costo por minuto: 380 pesos)
        costoLlamadas = costoLlamadas + ( pMinutos * costoLlamadaLarga );
    
    	// TODO Parte2 PuntoF: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada a celular a la línea telefónica <br>
     * <b>post: </b> Se incrementó en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumentó en ( minutos * 999 )
     * @param pMinutos Número de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaCelular( int pMinutos )
    {
    	//Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + pMinutos;
        //
        //Suma el costo (costo por minuto: 999 pesos)
        costoLlamadas = costoLlamadas + ( pMinutos * costoLlamadaCelular );
    
        numeroMinutosCelular = numeroMinutosCelular + pMinutos;
    	// TODO Parte2 PuntoG: Completar el método según la documentación dada.
    }

}
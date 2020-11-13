/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa.
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * L�nea telef�nica n�mero 1.
     */
    private LineaTelefonica linea1;

    /**
     * L�nea telef�nica n�mero 2.
     */
    private LineaTelefonica linea2;

    /**
     * L�nea telef�nica n�mero 3.
     */
    private LineaTelefonica linea3;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Inicializa las l�neas telef�nicas de la empresa. <br>
     * <b>post: </b> Se inicializaron las 3 l�neas telef�nicas.
     */
    public Empresa( )
    {
        linea1 = new LineaTelefonica( );
        linea2 = new LineaTelefonica( );
        linea3 = new LineaTelefonica( );
        // TODO Parte3 PuntoA: Construir linea2 y linea3.
    }

    /**
     * Retorna la l�nea 1.
     * @return L�nea 1.
     */
    public LineaTelefonica darLinea1( )
    {
    	return linea1;
        // TODO Parte3 PuntoB: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la l�nea 2.
     * @return L�nea 2.
     */
    public LineaTelefonica darLinea2( )
    {
    	return linea2;
        // TODO Parte3 PuntoC: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la l�nea 3.
     * @return L�nea 3.
     */
    public LineaTelefonica darLinea3( )
    {
    	return linea3;
        // TODO Parte3 PuntoD: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
	 * Retorna el n�mero total de llamadas realizadas.
	 * @return Total de llamadas de las tres l�neas.
	 */
	public int darTotalNumeroLlamadas( )
	{
		int resultado = linea1.darNumeroLlamadas()+ linea2.darNumeroLlamadas()+ linea3.darNumeroLlamadas();
        return resultado;
		// TODO Parte3 PuntoE: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el total de minutos consumidos.
	 * @return Total de minutos de las tres l�neas.
	 */
	public int darTotalMinutos( )
	{
		int resultado = linea1.darNumeroMinutos()+linea2.darNumeroMinutos()+linea3.darNumeroMinutos();
        return resultado;
		// TODO Parte3 PuntoF: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el costo total de las llamadas realizadas.
	 * @return Costo total de las tres l�neas.
	 */
	public double darTotalCostoLlamadas( )
	{        
		double resultado = linea1.darCostoLlamadas()+linea2.darCostoLlamadas()+linea3.darCostoLlamadas();
        return resultado;
		// TODO Parte3 PuntoG: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el costo promedio de un minuto, seg�n los minutos consumidos. <br>
	 * @return Costo promedio por minuto.
	 */
	public double darCostoPromedioMinuto( )
	{
		double resultado;
		if (darTotalMinutos() ==0)
		{	
			resultado = 0;
		}
		else
		{
			resultado = darTotalCostoLlamadas()/darTotalMinutos();
		}
		return resultado;
        // TODO Parte3 PuntoH: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
     * Agrega una llamada local a la l�nea telef�nica 1 <br>
     * <b>post: </b> Se agreg� la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int pMinutos )
    {
        linea1.agregarLlamadaLocal( pMinutos );
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agreg� la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaLocal(pMinutos);
        // TODO Parte3 PuntoI: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLocal(pMinutos);
        // TODO Parte3 PuntoJ: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 1. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaLargaDistancia( pMinutos );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaLargaDistancia(pMinutos);
        // TODO Parte3 PuntoK: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLargaDistancia(pMinutos);
        // TODO Parte3 PuntoL: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 1. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaCelular( pMinutos );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaCelular( pMinutos );
        // TODO Parte3 PuntoM: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaCelular( pMinutos );
        // TODO Parte3 PuntoN: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Reinicia todas las l�neas telef�nicas.
     * <b>post: </b> Se reinici� la llamada a la l�nea 1, 2 y 3.
     */
    public void reiniciar( )
    {
        linea1.reiniciar( );
        linea2.reiniciar();
        linea3.reiniciar();
        // TODO Parte3 PuntoB: Completar el m�todo para reiniciar las lineas 2 y 3.
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1. Mostremos el numero minutos a celular
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
    	int totalMinutosCelular = linea1.darNumeroMinutosCelular()+linea2.darNumeroMinutosCelular()+linea3.darNumeroMinutosCelular();
        String respuesta = String.format("%d",totalMinutosCelular);
    	return "La cantidad total de minutos a celular es: " + respuesta;
    }

    /**
     * M�todo para la extensi�n 2. Proporcion de minutos a celular!
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
    	int totalMinutosCelular = linea1.darNumeroMinutosCelular()+linea2.darNumeroMinutosCelular()+linea3.darNumeroMinutosCelular();
        double proporcion = totalMinutosCelular*100.0/darTotalMinutos();
        String respuesta = String.format("%.2f",proporcion);
    	return "La proporcion de minutos a celular es: " + respuesta +"%";
    }

}

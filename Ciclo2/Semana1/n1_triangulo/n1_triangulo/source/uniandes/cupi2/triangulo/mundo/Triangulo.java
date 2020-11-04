/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.triangulo.mundo;

/**
 * Clase que representa un tri�ngulo.
 */
public class Triangulo
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del tri�ngulo.
     */
    private Punto punto1;

    /**
     * Segundo punto del tri�ngulo.
     */
    private Punto punto2;

    /**
     * Tercer punto del tri�ngulo.
     */
    private Punto punto3;

    /**
     * Color de las l�neas.
     */
    private Color colorLineas;

    /**
     * Color del relleno.
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa el tri�ngulo. <br>
     * <b>post: </b> Se inicializaron los atributos con los siguientes valores: <br>
     * Punto 1: 200, 50 <br>
     * Punto 2: 300, 200 <br>
     * Punto 3: 100, 200 <br>
     * Color relleno: 50, 168, 56 <br>
     * Color l�neas: 0, 83, 24
     */
    public Triangulo( )
    {
        // Inicializa los puntos

        punto1 = new Punto( 200, 50 );
        punto2 = new Punto( 300, 200 );
        punto3 = new Punto( 100, 200 );

        // Inicializa los colores
        colorRelleno = new Color( 60, 168, 56 );
        colorLineas = new Color( 0, 83, 24 );
    }

    /**
     * Retorna el punto 1 del tri�ngulo.
     * @return Punto 1.
     */
    public Punto darPunto1( )
    {
        return punto1;
    }

    /**
     * Retorna el punto 2 del tri�ngulo.
     * @return Punto 2.
     */
    public Punto darPunto2( )
    {
        return punto2;
    }

    /**
     * Retorna el punto 3 del tri�ngulo.
     * @return Punto 3.
     */
    public Punto darPunto3( )
    {
        return punto3;
    }

    /**
     * Retorna el color de las l�neas del tri�ngulo.
     * @return Color de las l�neas.
     */
    public Color darColorLineas( )
    {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del tri�ngulo.
     * @return Color del relleno.
     */
    public Color darColorRelleno( )
    {
        return colorRelleno;
    }

    /**
     * Retorna el per�metro del tri�ngulo.
     * @return Per�metro del tri�ngulo.
     */
    public double darPerimetro( )
    {
        // Retorna la suma de todos los lados
        return calcularLado1( ) + calcularLado2( ) + calcularLado3( );
    }

    /**
     * Retorna el �rea del tri�ngulo, calculada utilizando la formula de Her�n. <br>
     * @return �rea del tri�ngulo.
     */
    public double darArea( )
    {
        // Calcula el valor S para la formula
        double perimetro = darPerimetro( );
        double s = perimetro / 2;

        // Calcula las restas para cada uno de los lados
        double valorLado1 = s - calcularLado1( );
        double valorLado2 = s - calcularLado2( );
        double valorLado3 = s - calcularLado3( );

        // Calcula y devuelve el �rea
        double area = Math.sqrt( s * valorLado1 * valorLado2 * valorLado3 );
        return area;
    }

    /**
     * Calcula la altura del tri�ngulo, teniendo en cuenta como base la l�nea entre el punto 1 y 2. <br>
     * Tenga en cuenta que �rea = (Base * Altura) / 2.
     * @return Altura del tri�ngulo.
     */
    public double darAltura( )
    {
        double area = darArea( );
        double base = calcularLado1( );
        double altura = ( area / base ) * 2;
        return altura;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private double calcularLado1( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto1.darX( ) - punto2.darX( ), 2 );
        double valorY = Math.pow( punto1.darY( ) - punto2.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private double calcularLado2( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto2.darX( ) - punto3.darX( ), 2 );
        double valorY = Math.pow( punto2.darY( ) - punto3.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private double calcularLado3( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto3.darX( ) - punto1.darX( ), 2 );
        double valorY = Math.pow( punto3.darY( ) - punto1.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula el �ngulo opuesto entre un v�rtice de referencia y los otros dos v�rtices de un tri�ngulo.
     * @param pX1 Coordenada X del v�rtice de referencia.
     * @param pY1 Coordenada Y del v�rtice de referencia.
     * @param pX2 Coordenada X del v�rtice opuesto 1.
     * @param pY2 Coordenada Y del v�rtice opuesto 1.
     * @param pX3 Coordenada X del v�rtice opuesto 2.
     * @param pY3 Coordenada Y del v�rtice opuesto 2.
     * @return �ngulo opuesto entre v�rtice de referencia y los otros dos v�rtices.
     */
    public double calcularAnguloOpuesto( double pX1, double pY1, double pX2, double pY2, double pX3, double pY3 )
    {
        // �ngulo 1
        double angulo1 = Math.atan2( pY2 - pY1, pX2 - pX1 );

        // �ngulo 2
        double angulo2 = Math.atan2( pY3 - pY1, pX3 - pX1 );

        // Garantiza que la diferencias de �ngulos sea la m�s peque�a.
        if( Math.abs( angulo1 - angulo2 ) > Math.PI )
        {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el �ngulo opuesto
        double anguloOpuesto = ( angulo1 + angulo2 ) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % ( 2.d * Math.PI );
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto1( double pX, double pY )
    {
        punto1.cambiarX( pX );
        punto1.cambiarY( pY );
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto2( double pX, double pY )
    {
        punto2.cambiarX( pX );
        punto2.cambiarY( pY );
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto3( double pX, double pY )
    {
        punto3.cambiarX( pX );
        punto3.cambiarY( pY );
    }

    /**
     * Cambia el color de relleno del tri�ngulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    public void cambiarColorRelleno( int pRojo, int pVerde, int pAzul )
    {
        colorRelleno.cambiarRojo( pRojo );
        colorRelleno.cambiarVerde( pVerde );
        colorRelleno.cambiarAzul( pAzul );
    }

    /**
     * Cambia el color de la l�neas del tri�ngulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    public void cambiarColorLineas( int pRojo, int pVerde, int pAzul )
    {
        colorLineas.cambiarRojo( pRojo );
        colorLineas.cambiarVerde( pVerde );
        colorLineas.cambiarAzul( pAzul );
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
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}

package ar.edu.unahur.obj2.impostoresPaises.cli

// builder
class paisBuilder{
    var pais  = Pais(this)

    private var nombre: String? = null
    private var codigoIso: String? = null
    private var poblacion: Int? = null
    private var superficie: Int? = null
    private var continente: String? = null
    private var paisesLimitrofes: List<Pais>? = null
    private var bloquesRegionales: List<String>? = null
    private var codigoMoneda: String? = null
    private var cotizacionDolar: Int? = null
    private var idiomas: List<String>? = null

    // apply cambia la variable y retorna el builder
    fun setNombre(nombre : String) = apply { pais.nombre = nombre }
    fun setCodigoIso(codigo : String) = apply { pais.codigoIso = codigo }
    fun setPoblacion(cantidad : Int) = apply { pais.poblacion = cantidad }
    fun setSuperficie(cantidad: Int) = apply { pais.superficie = cantidad }
    fun setContinente(continente: String) = apply { pais.continente = continente }
    fun setPaisesLimitrofes(paises : List<Pais>) = apply { pais.paisesLimitrofes = paises }
    fun setBloquesRegionales(bloques : List<String>) = apply { pais.bloquesRegionales = bloques }
    fun setCodigoMoneda(cod : String) = apply { pais.codigoMoneda = cod }
    fun setCotizacionDolar(num : Int) = apply { pais.cotizacionDolar = num }
    fun setIdiomas(idiomas : List<String>) = apply { pais.idiomas = idiomas }

    //Para terminar las llamadas al builder retornamos el objeto Pais
    fun build() = pais

    fun getNombre() = nombre
    fun getCodigoIso() = codigoIso
    fun getPoblacion() = poblacion
    fun getSuperficie() = superficie
    fun getContinente() = continente
    fun getPaisesLimitrofes() = paisesLimitrofes
    fun getBloquesRegionales() = bloquesRegionales
    fun getCodigoMoneda() = codigoMoneda
    fun getCotizacionDolar() = cotizacionDolar
    fun getIdiomas() = idiomas
}
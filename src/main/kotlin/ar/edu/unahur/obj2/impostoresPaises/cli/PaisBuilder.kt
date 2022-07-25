package ar.edu.unahur.obj2.impostoresPaises.cli

// builder
class PaisBuilder {

    var pais  = Pais()

    private var nombre: String = "Sin Dato"
    private var codigoIso: String = "Sin Dato"
    private var poblacion: Int = 0
    private var superficie: Int = 0
    private var continente: String = "Sin Dato"
    private var paisesLimitrofes: MutableList<Pais> = mutableListOf()
    private var bloquesRegionales: MutableList<String> = mutableListOf()
    private var codigoMoneda: String = "Sin Dato"
    private var cotizacionDolar: Int? = null
    private var idiomas: MutableList<String> = mutableListOf()

    // apply cambia la variable y retorna el builder
    fun setNombre(nombre : String) = apply { pais.nombre = nombre }
    fun setCodigoIso(codigo : String) = apply { pais.codigoIso = codigo }
    fun setPoblacion(cantidad : Int) = apply { pais.poblacion = cantidad }
    fun setSuperficie(cantidad: Int) = apply { pais.superficie = cantidad }
    fun setContinente(continente: String) = apply { pais.continente = continente }
    fun setPaisesLimitrofes(paises : MutableList<Pais>) = apply { pais.paisesLimitrofes = paises }
    fun setBloquesRegionales(bloques : MutableList<String>) = apply { pais.bloquesRegionales = bloques }
    fun setCodigoMoneda(cod : String) = apply { pais.codigoMoneda = cod }
    fun setCotizacionDolar(num : Int) = apply { pais.cotizacionDolar = num }
    fun setIdiomas(idiomas : MutableList<String>) = apply { pais.idiomas = idiomas }

    //Para terminar las llamadas al builder retornamos el objeto Pais
    fun build() = pais

}
package ar.edu.unahur.obj2.impostoresPaises.cli

// builder
class PaisBuilder {
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
    fun setNombre(nombre : String) = apply { this.nombre = nombre }
    fun setCodigoIso(codigo : String) = apply { this.codigoIso = codigo }
    fun setPoblacion(cantidad : Int) = apply { this.poblacion = cantidad }
    fun setSuperficie(cantidad: Int) = apply { this.superficie = cantidad }
    fun setContinente(continente: String) = apply { this.continente = continente }
    fun setPaisesLimitrofes(paises : MutableList<Pais>) = apply { this.paisesLimitrofes = paises }
    fun setBloquesRegionales(bloques : MutableList<String>) = apply { this.bloquesRegionales = bloques }
    fun setCodigoMoneda(cod : String) = apply { this.codigoMoneda = cod }
    fun setCotizacionDolar(num : Int) = apply { this.cotizacionDolar = num }
    fun setIdiomas(idiomas : MutableList<String>) = apply { this.idiomas = idiomas }

    //Para terminar las llamadas al builder retornamos el objeto Pais
    fun build() : Pais {
        val pais = Pais()
        pais.nombre = nombre
        pais.codigoIso = codigoIso
        pais.poblacion = poblacion
        pais.superficie = superficie
        pais.continente = continente
        pais.paisesLimitrofes = paisesLimitrofes
        pais.bloquesRegionales = bloquesRegionales
        pais.codigoMoneda = codigoMoneda
        pais.cotizacionDolar = cotizacionDolar
        pais.idiomas = idiomas
        return pais
    }

}
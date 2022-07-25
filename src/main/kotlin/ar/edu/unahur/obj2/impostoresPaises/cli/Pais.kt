package ar.edu.unahur.obj2.impostoresPaises.cli

// Utilizamos patron builder para la creacion del pais
class Pais (builder : paisBuilder) {

    var nombre: String? = null
    var codigoIso: String? = null
    var poblacion: Int? = null
    var superficie: Int? = null
    var continente: String? = null
    var paisesLimitrofes: List<Pais>? = null
    var bloquesRegionales: List<String>? = null
    var codigoMoneda: String? = null
    var cotizacionDolar: Int? = null
    var idiomas: List<String>? = null

    init {
        nombre = builder.getNombre()
        codigoIso = builder.getCodigoIso()
        poblacion = builder.getPoblacion()
        superficie = builder.getSuperficie()
        continente = builder.getContinente()
        paisesLimitrofes = builder.getPaisesLimitrofes()
        bloquesRegionales = builder.getBloquesRegionales()
        codigoMoneda = builder.getCodigoMoneda()
        cotizacionDolar = builder.getCotizacionDolar()
        idiomas = builder.getIdiomas()
    }
}



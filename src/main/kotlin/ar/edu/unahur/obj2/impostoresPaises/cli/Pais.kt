package ar.edu.unahur.obj2.impostoresPaises.cli
import kotlin.math.roundToInt

// Utilizamos patron builder para la creacion del pais
class Pais {

    var nombre: String = "Sin Dato"
    var codigoIso: String = "Sin Dato"
    var poblacion: Int = 0
    var superficie: Int = 0
    var continente: String = "Sin Dato"
    var paisesLimitrofes: MutableList<Pais> = mutableListOf()
    var bloquesRegionales: MutableList<String> = mutableListOf()
    var codigoMoneda: String = "Sin Dato"
    var cotizacionDolar: Int? = null
    var idiomas: MutableList<String> = mutableListOf()

    override fun toString() = this.nombre

    fun addVecino(pais: Pais) = paisesLimitrofes.add(pais)
    fun addMutuoVecino(pais: Pais) {
        this.addVecino(pais)
        pais.addVecino(this)
    }

    //ETAPA 1

    fun esPlurinacional() = idiomas.size > 1
    fun esUnaIsla() = paisesLimitrofes.isEmpty()
    fun densidadPoblacional() = (poblacion / superficie)
    fun vecinoMasPoblado() : Pais? = paisesLimitrofes.plus(this).maxByOrNull { p -> p.poblacion }

    fun esLimitrofeDe(pais: Pais) = paisesLimitrofes.contains(pais)
    fun necesitaTraductor(pais: Pais) = ! idiomas.any(pais.idiomas::contains)

    fun compartenBloqueRegional(pais: Pais) = bloquesRegionales.any(pais.bloquesRegionales::contains)
    fun potencialesAliados(pais: Pais) = ! this.necesitaTraductor(pais) && this.compartenBloqueRegional(pais)
    fun convieneIrDeCompras(pais: Pais) = cotizacionDolar!! < pais.cotizacionDolar!!
    fun valorLocalDeMoneda(pais: Pais, monto: Double) =  ((monto / cotizacionDolar!!)* pais.cotizacionDolar!!).roundToInt()

}



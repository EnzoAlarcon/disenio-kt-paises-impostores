package ar.edu.unahur.obj2.impostoresPaises.cli

// Singleton
//Object porque es una única instancia
object Observatorio {
    var paises = mutableSetOf<Pais>()

    fun retornarPais(nombre : String) : Pais? {
        return paises.find { it.nombre.equals(nombre, ignoreCase = true) }
    }

    fun reset() {
        paises = mutableSetOf()
    }

    fun sonLimitrofes(pais1 : String, pais2 : String) = retornarPais(pais1)!!.esLimitrofeDe(retornarPais(pais2)!!)
    fun necesitaTraduccion(pais1: String, pais2: String) = retornarPais(pais1)!!.necesitaTraductor(retornarPais(pais2)!!)
    fun sonPotencialesAliados(pais1: String, pais2: String) = retornarPais(pais1)!!.potencialesAliados(retornarPais(pais2)!!)
    fun convieneIrDeCompras(origen: String, destino: String) = retornarPais(origen)!!.convieneIrDeCompras(retornarPais(destino)!!)
    fun cuantoEquivaleLaMoneda(pais1: String, pais2: String, monto: Double) = retornarPais(pais1)!!.valorLocalDeMoneda(retornarPais(pais2)!!, monto)

    fun codigoISOMayorPoblacion(cant : Int) = paises.sortedByDescending { it.poblacion }.take(cant).map { it.codigoIso }
    fun continenteMasPlurinacional() = paises.filter { it.esPlurinacional() }.groupBy { it.continente }.maxByOrNull { it.value.size }?.key
    fun promedioPoblacionIslas() = paises.filter { it.esUnaIsla() }.map { it.poblacion }.average().toInt()
}
package ar.edu.unahur.obj2.impostoresPaises.cli

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class ObservatorioTest: DescribeSpec ({

    val argentina = PaisBuilder()
        .setNombre("Argentina")
        .setCodigoIso("ARG")
        .setPoblacion(47000000)
        .setSuperficie(3760000)
        .setContinente("America")
        .setCodigoMoneda("ARS")
        .setCotizacionDolar(130)
        .setBloquesRegionales(mutableListOf("UNASUR"))
        .setIdiomas(mutableListOf("Español"))
        .build()

    val brasil = PaisBuilder()
        .setNombre("Brasil")
        .setCodigoIso("BRA")
        .setPoblacion(210000000)
        .setSuperficie(8516000)
        .setContinente("America")
        .setCodigoMoneda("BRL")
        .setCotizacionDolar(6)
        .setBloquesRegionales(mutableListOf("UNASUR"))
        .setIdiomas(mutableListOf("Portugues"))
        .build()

    val uruguay = PaisBuilder()
        .setNombre("Uruguay")
        .setPoblacion(3000000)
        .setContinente("America")
        .setBloquesRegionales(mutableListOf("UNASUR"))
        .setIdiomas(mutableListOf("Español"))
        .build()

    argentina.addMutuoVecino(brasil)
    argentina.addMutuoVecino(uruguay)
    uruguay.addMutuoVecino(brasil)

    describe("Test de Paises conocidos") {
        Observatorio.borrarPaises()
        Observatorio.addPaises(mutableListOf(argentina, brasil, uruguay))
        it ("Comprobar paises conocidos por Observatorio") {
            Observatorio.paises.shouldContainExactly(argentina, brasil, uruguay)
        }
    }
    describe("Test de nombres de paises"){
        it("Comprobar que Argentina retorna el pais indicado") {
            Observatorio.borrarPaises()
            Observatorio.addPaises(mutableListOf(argentina, brasil, uruguay))
            println(Observatorio.paises)
            Observatorio.retornarPais("argentina").shouldBe(argentina)
            Observatorio.retornarPais("argentina").shouldBeTypeOf<Pais>()
        }
    }
    describe("Test Etapa 2") {
        Observatorio.borrarPaises()
        Observatorio.addPaises(mutableListOf(argentina, brasil, uruguay))
        it("Argentina y Brasil son limitrofes") {
            Observatorio.sonLimitrofes("argentina", "brasil").shouldBeTrue()
        }
        it("Argentina y Brasil necesitan traduccion") {
            Observatorio.necesitaTraduccion("argentina", "brasil").shouldBeTrue()
        }
        describe("Dos paises son potenciales aliados") {
            it("Argentina y Brasil no son potenciales aliados") {
                Observatorio.sonPotencialesAliados("argentina", "brasil").shouldBeFalse()
            }
            it("Argentina y Uruguay son potenciales aliados") {
                Observatorio.sonPotencialesAliados("argentina", "uruguay").shouldBeTrue()
            }
        }
        it("Conviene ir de compras desde Argentina a Brasil") {
            Observatorio.convieneIrDeCompras("argentina", "brasil").shouldBeFalse()
        }
        it("Calculo de un monto en moneda local") {
            Observatorio.cuantoEquivaleLaMoneda("brasil", "argentina", 100.0).shouldBe(2167)
        }
        it("Codigos ISO del pais de mayor poblacion") {
            Observatorio.codigoISOMayorPoblacion(1).shouldBe(listOf("BRA"))
        }
        it("El continente mas plurinacional es America") {

        }
    }
})
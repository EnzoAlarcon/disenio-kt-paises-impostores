package ar.edu.unahur.obj2.impostoresPaises.cli

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldNotBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
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

    val haiti = PaisBuilder()
        .setNombre("Haiti")
        .setCodigoIso("HTI")
        .setPoblacion(11325861)
        .setSuperficie(27755)
        .setContinente("America Central")
        .setCodigoMoneda("HTG")
        .setCotizacionDolar(117)
        .setBloquesRegionales(mutableListOf("ALBA"))
        .setIdiomas(mutableListOf("Haitiano", "Francés"))
        .build()

    val cuba = PaisBuilder()
        .setNombre("Cuba")
        .setCodigoIso("CU")
        .setPoblacion(11326616)
        .setSuperficie(109884)
        .setContinente("America Central")
        .setCodigoMoneda("CUB")
        .setCotizacionDolar(117)
        .setBloquesRegionales(mutableListOf("ALBA"))
        .setIdiomas(mutableListOf("Español"))
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
        it ("Comprobar paises conocidos por Observatorio") {
            Observatorio.paises.shouldContainExactly(argentina, brasil, uruguay)
        }
    }
    describe("Test de nombres de paises"){
        it("Comprobar que Argentina retorna el pais indicado") {
            Observatorio.retornarPais("argentina").shouldBe(argentina)
            Observatorio.retornarPais("argentina").shouldBeTypeOf<Pais>()
        }
    }
    describe("Test Etapa 2") {
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
            Observatorio.cuantoEquivaleLaMoneda("argentina", "brasil", 100.0).shouldBe(5)
        }
        it("Codigos ISO de los 5 paises de mayor poblacion") {
            Observatorio.codigoISOMayorPoblacion(5).shouldContain(listOf("ARG", "BR"))
        }
        it("Promedio de poblacion es paises insulares"){
            Observatorio.promedioPoblacionIslas().shouldBe(11326238)
        }
        it("El continente mas plurinacional es America Central"){
            Observatorio.continenteMasPlurinacional().shouldBe("America Central")
        }
    }
})
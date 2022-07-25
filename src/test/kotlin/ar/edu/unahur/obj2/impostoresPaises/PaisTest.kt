package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.cli.Pais
import ar.edu.unahur.obj2.impostoresPaises.cli.PaisBuilder
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class PaisTest : DescribeSpec ({

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

    describe("Test de Creacion") {

        it ("Comprobar nombre, codigoIso y poblacion") {
            argentina.nombre.shouldBe("Argentina")
            argentina.codigoIso.shouldBe("ARG")
            argentina.poblacion.shouldBe(47000000)
            argentina.shouldBeTypeOf<Pais>()
        }
    }
    describe("Test Etapa 1") {
        describe("Argentina") {
            it("No es plurinacional") {
                argentina.esPlurinacional().shouldBeFalse()
            }
            it("No es una isla") {
                argentina.esUnaIsla().shouldBeFalse()
            }
            it("Densidad poblacional") {
                argentina.densidadPoblacional().shouldBe(12)
            }
            it("Vecino mas poblado") {
                argentina.vecinoMasPoblado().shouldBe(brasil)
            }
            it("Es Limitrofe con brasil") {
                argentina.esLimitrofeDe(brasil).shouldBeTrue()
            }
            it("Arg y Br necesitan traductor") {
                argentina.necesitaTraductor(brasil).shouldBeTrue()
            }
            it("Potencial aliados") {
                argentina.potencialesAliados(brasil).shouldBeFalse()
                argentina.potencialesAliados(uruguay).shouldBeTrue()
            }
            it("Conviene comprar en brasil") {
                argentina.convieneIrDeCompras(brasil).shouldBeFalse()
            }
            it("valor peso") {
                argentina.valorLocalDeMoneda(brasil).shouldBe(21)
            }
        }
    }
})
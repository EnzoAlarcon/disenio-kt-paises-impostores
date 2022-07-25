package ar.edu.unahur.obj2.impostoresPaises

import ar.edu.unahur.obj2.impostoresPaises.cli.Pais
import ar.edu.unahur.obj2.impostoresPaises.cli.paisBuilder
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class PaisTest : DescribeSpec ({
    describe("Creacion de Argentina") {
        val argentina = paisBuilder()
            .setNombre("Argentina")
            .setCodigoIso("ARG")
            .setPoblacion(47000000)
            .setSuperficie(3760000)
            .setContinente("America")
            .setCodigoMoneda("ARS")
            .setCotizacionDolar(130)
            .setBloquesRegionales(listOf("UNASUR"))
            .setIdiomas(listOf("Español"))
            .build()

        it ("Comprobar nombre, codigoIso y poblacion") {
            argentina.nombre.shouldBe("Argentina")
            argentina.codigoIso.shouldBe("ARG")
            argentina.poblacion.shouldBe(47000000)
            argentina.paisesLimitrofes.shouldBeNull()
            argentina.shouldBeTypeOf<Pais>()
        }
    }

})
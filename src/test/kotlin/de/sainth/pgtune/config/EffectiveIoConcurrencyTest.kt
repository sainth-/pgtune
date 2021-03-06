package de.sainth.pgtune.config


import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class EffectiveIoConcurrencyTest : DescribeSpec() {

    init {
        describe("EffectiveIoConcurrencyTest") {
            val systemConfiguration = mockk<SystemConfiguration>(relaxed = true)
            forAll(
                    row(DataStorage.HDD, 2),
                    row(DataStorage.SSD, 200),
                    row(DataStorage.SAN, 300)
            ) { storage, expected ->
                every { systemConfiguration.dataStorage } returns storage
                EffectiveIoConcurrency(systemConfiguration).effectiveIoConcurrency shouldBe expected
            }
        }
    }

}
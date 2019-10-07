package de.sainth.pgtune

class EffectiveIoConcurrency(systemConfiguration: SystemConfiguration) : PgConfigurationParameter("effective_io_concurrency") {
    private val effectiveIoConcurrency: Int = when(systemConfiguration.dataStorage) {
        DataStorage.HDD -> 2
        DataStorage.SSD -> 200
        DataStorage.SAN -> 300
    }

    override fun getParameterString(): String {
        return "$effectiveIoConcurrency"
    }
}

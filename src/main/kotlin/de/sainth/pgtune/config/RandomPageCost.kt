package de.sainth.pgtune.config

class RandomPageCost(systemConfiguration: SystemConfiguration) : PgConfigurationParameter("random_page_cost") {
    val randomPageCost: Double = when (systemConfiguration.dataStorage) {
        DataStorage.HDD -> 4.0
        DataStorage.SSD -> 1.1
        DataStorage.SAN -> 1.1
    }

    override fun getParameterString(): String {
        return "$randomPageCost"
    }
}

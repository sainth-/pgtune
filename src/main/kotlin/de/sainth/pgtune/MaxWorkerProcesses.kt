package de.sainth.pgtune

import de.sainth.pgadjust.PostgresVersion
import de.sainth.pgadjust.SystemConfiguration
import java.lang.IllegalArgumentException

class MaxWorkerProcesses(systemConfiguration: SystemConfiguration) : PgConfigurationParameter("max_worker_processes") {
    private val maxWorkerProcesses: Int = systemConfiguration.cpus?.toInt() ?: 8

    init {
        if(systemConfiguration.dbVersion == PostgresVersion.V9_4) {
            throw IllegalArgumentException("$name is not supported by PostgreSQL version ${systemConfiguration.dbVersion.version}")
        }
    }

    override fun getParameterString(): String {
        return "$maxWorkerProcesses"
    }
}

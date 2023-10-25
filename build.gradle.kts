import io.github.cdsap.talaiot.plugin.influxdb2.Influxdb2Extension

plugins{
    id("io.github.cdsap.talaiot.plugin.influxdb2") version ("1.5.3")
}

val talaiotExtension = project.extensions.getByType(Influxdb2Extension::class.java)
talaiotExtension.logger = io.github.cdsap.talaiot.logger.LogTracker.Mode.INFO

talaiotExtension.publishers {
    val influxDB2Token: String by project
    val influxDB2Url: String by project

    influxDb2Publisher {
        url = "http://localhost:8086"
        // token = "<token>"
        bucket = "myBucketName"
        org = "MyOrg"
        buildMetricName = "build"
        taskMetricName = "task"
    }
}

talaiotExtension.metrics {
    defaultMetrics = true
    environmentMetrics = true
    gitMetrics = true
    gradleSwitchesMetrics = true
    performanceMetrics = true

}
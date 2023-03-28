package org.igt.externaldashboard;

import org.igt.configfactory.ConfigFactory;
import org.igt.configfactory.InfluxDBFactory;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.write.Point;

/**
 * Send test execution status to InfluxDB database to display these data on Grafana dashboard to see live execution. 
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ConfigFactory
 * @see InfluxDBFactory
 */
public class SendResultToInfluxDB {
	/**
	 * Method to push data to InfluxDB based on configuration and URL provided from configuration. 
	 * Mar 14, 2023
	 * @author Mandeep Sheoran
	 */
	public static void sendStatusToInfluxDB(Point point) throws RuntimeException {
		if ((ConfigFactory.getConfig().isInfluxDbGrafanaEnabled()).toLowerCase().equalsIgnoreCase("yes")) {
			String token = InfluxDBFactory.getConfig().influxDBToken();
			String bucket = InfluxDBFactory.getConfig().influxdbBucket();
			String org = InfluxDBFactory.getConfig().influxdbUserOrg();
			String url = InfluxDBFactory.getConfig().influxdbURL();
			InfluxDBClient influxDBClient = InfluxDBClientFactory.create(url, token.toCharArray());
			WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();
			writeApi.writePoint(bucket, org, point);
			influxDBClient.close();
		} else {
			System.out.println(
					"Config key to send results to InfluxDB-Grafana is off hence not sending data to InfluxDB.");
		}
	}
}

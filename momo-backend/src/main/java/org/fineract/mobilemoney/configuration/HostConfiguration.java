package org.fineract.mobilemoney.configuration;

import org.springframework.beans.factory.annotation.Value;

public class HostConfiguration {

	@Value("${hostconfig.host-address}")
	private String hostName;

	@Value("${hostconfig.protocol}")
	private String protocol;

	@Value("${server.port}")
	private Integer port;

	public String getHostName() {
		return this.hostName;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public Integer getPort() {
		return this.port;
	}

}

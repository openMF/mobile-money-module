package org.fineract.mobilemoney.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HostConfiguration {

	@Value("${hostconfig.host-address}")
	private String hostName;

	@Value("${hostconfig.protocol}")
	private String protocol;

	@Value("${server.port}")
	private Integer port;
	
	private String fineractHostName;

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

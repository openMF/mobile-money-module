package org.fineract.mobilemoney.serialization;

import org.fineract.mobilemoney.helpers.FromJsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileMoneyBridgeSerializer {

	private final FromJsonHelper fromApiJsonHelper;

	@Autowired
	public MobileMoneyBridgeSerializer(final FromJsonHelper fromApiJsonHelper) {
		this.fromApiJsonHelper = fromApiJsonHelper;
	}
}

package com.modeln.pms.repositories.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator{
	private static int pid = 101;
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		return new String("MODELN_PROJ_"+(pid++));
	}

}

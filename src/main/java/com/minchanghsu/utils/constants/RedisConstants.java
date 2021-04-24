package com.minchanghsu.utils.constants;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RedisConstants {

	public static final String SYSTEM_ALL_CONFIG = "allConfig";
	public static final String PAYMENT_DOMAIN = "paymentDomain";
	public static final String PAYMENT_URL = "paymentUrl";
	public static final String PAYMENT_WAY = "payWay";
	public static final String PAYMENT_WAY_CATEGORY = "payWayCategory";
	public static final String SYSTEM_ALL_API = "AllApi";
	public static final String PAYMENT_SYSTEM_USER = "user";
	public static final String PAYMENT_SYSTEM_USER_ROLES = "userRoles";


	public static final String CACHE_NAME_SYSTEM_CONFIG = "systemConfig";
	public static final String CACHE_NAME_PAYMENT_WAY = "paymentWay";
	public static final String CACHE_NAME_PAYMENT_WAY_CATEGORY = "paymentWayCategory";
	public static final String CACHE_NAME_PAYMENT_ORDER = "paymentOrder";
	public static final String CACHE_NAME_SYSTEM_API = "systemApi";
	public static final String CACHE_NAME_PAYMENT_SYSTEM_USER = "paymentSystemUser";


	public static final List<CacheName> list = Collections.unmodifiableList(
			new ArrayList<CacheName>() {{
				add(new CacheName(CACHE_NAME_SYSTEM_CONFIG, true, 86400));
				add(new CacheName(CACHE_NAME_PAYMENT_ORDER, true));
				add(new CacheName(CACHE_NAME_PAYMENT_WAY, true));
				add(new CacheName(CACHE_NAME_PAYMENT_WAY_CATEGORY, true));
				add(new CacheName(CACHE_NAME_SYSTEM_API, true));
				add(new CacheName(CACHE_NAME_PAYMENT_SYSTEM_USER, true));
			}});

	@Data
	public static class CacheName {
		private String name;
		private boolean effective;
		private int expireTime;

		public CacheName(String name, boolean effective) {
			this.name = name;
			this.effective = effective;
			this.expireTime = 3600;
		}

		public CacheName(String name, boolean effective, int expireTime) {
			this.name = name;
			this.effective = effective;
			this.expireTime = expireTime;
		}
	}
}

	/**
	 * 
	 */
	package com.newsportal.core.services;
	
	import org.osgi.service.component.annotations.Component;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	
	/**
	 * 
	 */
	@Component(service = Assets.class,immediate = true,
	property=("country=un"))
	public class AssetImpl implements Assets{
		private static final Logger log=LoggerFactory.getLogger("AssetImpl");
		@Override
		public String getAsset() {
			log.debug("asset are successfully delete");
			return "Asset data";
		}
	
	}

	package com.newsportal.core.servlets;
	
	import java.io.IOException;
	
	import javax.servlet.Servlet;
	import javax.servlet.ServletException;
	
	import org.apache.sling.api.SlingHttpServletRequest;
	import org.apache.sling.api.SlingHttpServletResponse;
	import org.apache.sling.api.servlets.SlingAllMethodsServlet;
	import org.osgi.service.component.annotations.Component;
	import org.osgi.service.component.annotations.Reference;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import com.newsportal.core.services.Assets;
	@Component(service = Servlet.class,immediate = true)
	public class AssetServlet extends SlingAllMethodsServlet{
		
		private static Logger log=LoggerFactory.getLogger("AssetServlet.class");
		
		//if incase we are having multiple implementations(services)then we go with target
		
		@Reference(target=("country=us"))
		public Assets assets;
	 @Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		 String result=assets.getAsset(); 
		 response.getWriter().write(result);
	}
		
	
	}

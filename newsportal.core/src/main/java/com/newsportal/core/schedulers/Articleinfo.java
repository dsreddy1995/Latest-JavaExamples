package com.newsportal.core.schedulers;

import java.util.Date;
import java.util.Iterator;

import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service=Runnable.class,immediate = true)
@Designate(ocd=ArticleExpiryConfig.class)
public class Articleinfo implements Runnable {
	
	@Reference
	ResourceResolverFactory resolverFactory;
	
	@Reference
	 Replicator replicator;
	
	@Reference
	Scheduler scheduler;
	
	
	@Activate
	public void activate(ArticleExpiryConfig config) {
		schedule(config);
	}
	
	@Modified
	public void update(ArticleExpiryConfig config) {
		schedule(config);
	}
	
	public void schedule(ArticleExpiryConfig config) {
		scheduler.EXPR(config.schdulerName());
		
		
		
		scheduler.schedule(this, null);
	}

	private static final Logger log= LoggerFactory.getLogger("Articleinfo");
	
	@Override
	public void run() {
		log.info("enter into run method");
		
		try {
			ResourceResolver resolver=resolverFactory.getResourceResolver(null);
		    PageManager pageManager=resolver.adaptTo(PageManager.class);
		    Page articlePage=pageManager.getPage("/content/newsportal/us/en/my-account");
		  Iterator<Page> childpages=articlePage.listChildren();
		  while (childpages.hasNext()) {
			Page page = (Page) childpages.next();
			Resource resource= page.getContentResource();
			ValueMap properties=resource.getValueMap();
			Date articleExpiry=properties.get("articleExpiry", Date.class);
			Date toDate =new Date();
			if(articleExpiry!= null && articleExpiry.compareTo(toDate)<0) {
				
				Session session=resolver.adaptTo(Session.class);
				replicator.replicate(session, ReplicationActionType.DEACTIVATE, page.getPath());
				
				}
		}
		    
		} catch (LoginException e) {
		
			e.printStackTrace();
		} catch (ReplicationException e) {
			
			e.printStackTrace();
		}
		
	}
	

}


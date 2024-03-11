package com.newsportal.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name ="articleexpirydetails")
public @interface ArticleExpiryConfig {

	@AttributeDefinition(name="enable schduler")
	public boolean  enable() default true;
	
	@AttributeDefinition(name="schduler name")
	public String  schdulerName() default "articleExpiry";
	
	@AttributeDefinition(name="cron expression")
	public String  cron();
	
	
}

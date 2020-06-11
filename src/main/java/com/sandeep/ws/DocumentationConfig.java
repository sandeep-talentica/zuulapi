package com.sandeep.ws;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary // Override Original swagger implementation with custom swagger resource
			// provider.
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Override
	public List get() {
		List resources = new ArrayList();
		resources.add(swaggerResource("microdb-ws", "/v2/api-docs", "2.0"));
		// resources.add(swaggerResource("news-service", "/news/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
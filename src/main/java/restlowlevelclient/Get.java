package restlowlevelclient;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Get {

	Connect conect = new Connect();
	
	public void Get() throws IOException   {
		//GET
		ObjectMapper objectMapper = new ObjectMapper();
//		final String document = "{\"key\": 1 }";
		JsonNode document = objectMapper.readTree("{\"query\": {\"bool\": {\"must\": [{\"query_string\": {\"query\": \"*\",\"analyze_wildcard\": true,\"default_field\": \"*\"}}]}}}");
		HttpEntity httpEntity = new NStringEntity(document.toString(), ContentType.APPLICATION_JSON);
		Response response = conect.test().performRequest("GET", "/apimanagees/clusters/_search", Collections.<String, String>emptyMap(), httpEntity);
		conect.test().close();
		//Now you can print the response
		System.out.println(EntityUtils.toString(response.getEntity()));
		//OR get the content
//		JsonNode content = objectMapper.readTree(response.getEntity().getContent());
//		System.out.println(response.getEntity().getContent());
	}
	
}

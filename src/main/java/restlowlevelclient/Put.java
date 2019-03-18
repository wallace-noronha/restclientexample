package restlowlevelclient;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;

public class Put {

	Connect conect = new Connect();
	
	public void put() throws IOException {
		//PUT
		String document = "{\"nome\": \"BDR-teste\", \"URL\" : \"http://www.testebdr.com.br\" }";
		HttpEntity httpEntity = new NStringEntity(document, ContentType.APPLICATION_JSON);
//		Integer id = 2;
		Response response = conect.test().performRequest("POST", "/apimanagees/clusters/", Collections.<String, String>emptyMap(), httpEntity);
		//Now you can print the response
		System.out.println(EntityUtils.toString(response.getEntity()));
	}
	
	
}

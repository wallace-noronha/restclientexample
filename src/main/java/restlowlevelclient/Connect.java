package restlowlevelclient;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;

public class Connect {

	public final CredentialsProvider credentials() {
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "ida;osEii5U@"));
		return credentialsProvider;
	}
	
	public RestClient test() {
		RestClientBuilder builder = RestClient.builder(new HttpHost("escoobdm.dcbr01.corp", 9203,"https"))
		    .setHttpClientConfigCallback(new HttpClientConfigCallback() {
		        public HttpAsyncClientBuilder customizeHttpClient(
		                HttpAsyncClientBuilder httpClientBuilder) {
		            httpClientBuilder.setDefaultCredentialsProvider(credentials());
		            httpClientBuilder.setProxy(new HttpHost("proxy.santanderbr.corp", 80, "http"));
		            return httpClientBuilder;
		        }
		    });
		return builder.build();
	}
	
	
}

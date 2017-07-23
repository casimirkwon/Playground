import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

public class APITest3 {

	public static void main(String[] args) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder(
				"https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/closeindex".replace("{marketcode}",
						URLEncoder.encode("kospi", "UTF-8")));
		urlBuilder.append("?");
		urlBuilder.append(URLEncoder.encode("apikey", "UTF-8") + "="
				+ URLEncoder.encode("l7xx230ef2235e34448c982eb192ac98e206", "UTF-8"));

		// http response 획득. using fluent style method call.
		HttpResponse response = Request.Get(urlBuilder.toString())
									.execute()
									.returnResponse();
		
		// http status code
		System.out.println("status code : " + response.getStatusLine().getStatusCode());
		
		// http header 
		for(Header header : response.getAllHeaders() ) {
			System.out.println(header.getName() + ": " + header.getValue());
		}
		
		// http response body 출력
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

}

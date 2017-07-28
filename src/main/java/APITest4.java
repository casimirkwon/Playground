import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.fluent.Request;

public class APITest4 {
	// TODO [실습 3-02] http client를 이용하여 API 호출을 수행한 후, response body(json 데이터)를 출력한다.
	
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder(
				"https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/closeindex".replace("{marketcode}",
						URLEncoder.encode("kospi", "UTF-8")));
		urlBuilder.append("?");
		urlBuilder.append(URLEncoder.encode("apikey", "UTF-8") + "="
				+ URLEncoder.encode("l7xx230ef2235e34448c982eb192ac98e206", "UTF-8"));

		// http response 획득. using fluent style method call.
		String response = Request.Get(urlBuilder.toString())
									.execute()
									.returnContent()
									.asString();
		
		// http response body 출력
		System.out.println(response);
	}

}

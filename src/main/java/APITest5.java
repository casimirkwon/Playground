import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class APITest5 {

	public static void main(String[] args) throws IOException {

		StringBuilder urlBuilder = new StringBuilder(
				"https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/closeindex".replace("{marketcode}",
						URLEncoder.encode("kospi", "UTF-8")));
		urlBuilder.append("?");
		urlBuilder.append(URLEncoder.encode("apikey", "UTF-8") + "="
				+ URLEncoder.encode("l7xx230ef2235e34448c982eb192ac98e206", "UTF-8"));

		String data = Request.Get(urlBuilder.toString())
				.execute()
				.returnContent()
				.asString();
		
		Gson gson = new Gson();
		
		// json object로 변환
		JsonObject root = gson.fromJson(data, JsonElement.class).getAsJsonObject();
		
		// json element에서 result object를 추출  
		JsonObject result = root.get("result").getAsJsonObject();
		
		System.out.println(result.toString());

	}
}

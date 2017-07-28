import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class APITest6 {
	// TODO [실습 3-03] jackson 라이브러리를 사용하여 API 호출로 획득한 시세 데이터 json object 내용 중 원하는 값(ex. 현재가)만 출력한다.
	
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
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode root = objectMapper.readValue(data, ObjectNode.class);
		JsonNode trdPrc = root.get("result").get("trdPrc");
		
		System.out.println("trdPrc : " + trdPrc.asDouble());

	}	
}

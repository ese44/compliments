import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class ComplimentClient {

    private static final String SERVER_URL = "http://127.0.0.1:8080";
    private static final String TEXT = "text";

    private static final String USER_ERROR_MSG = "<html>Sorry, an error happened. " + "<br>Good thing you are AWESOME at debugging!</html>";

    public static  String getCompliment(){

        try{
            HttpResponse<JsonNode> response = Unirest.get(SERVER_URL + "random")
                    .header("accept", "application/json")
                    .asJson();

            JSONObject jsonObject = response.getBody().getObject;
            return jsonObject.getString(TEXT);

        }catch (UnirestException e){
            System.out.println(e);
            return USER_ERROR_MSG;
        }
    }
}

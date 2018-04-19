import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import org.json.JSONObject;

public class ComplimentClient { // create the ComplimentClient class

    private static final String SERVER_URL = "https://helloworldapi.herokuapp.com/"; // set the server url as my helloworldapi server
    private static final String TEXT = "text"; // string for the compliment?

    // error message
    private static final String USER_ERROR_MSG = "<html>Sorry, an error happened. " + "<br>Good thing you are AWESOME at debugging!</html>";

    public static void getCompliment(final ComplimentGUI gui){ // getCompliment method

        // use unirest to get response from server
        Unirest.get(SERVER_URL + "random") //
                .header("accept", "application/json")
                .asJsonAsync(new Callback<JsonNode>() {
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        JSONObject json = httpResponse.getBody().getObject();
                        gui.complimentMessage(json.getString(TEXT));
                    }

                    public void failed(UnirestException e) {
                        gui.complimentMessage(USER_ERROR_MSG);
                    }

                    public void cancelled() {
                        System.out.println("Request cancelled");
                    }
                });
    }
}

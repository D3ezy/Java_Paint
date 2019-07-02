/*
 * RESTClient.java
 * cs338-gui
 * Drexel University - CS338 
 * 
 * Author: Matthew Dey
 * Date Created: 
 * 
 * RESTClient.java is the driver for the program.
 * 
 */
package cs338.gui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTClient {

    private Client client;
    private WebResource webResource;
    private ClientResponse cr;
    private String currResponse;

    RESTClient(String call) {
        this.client = Client.create();
        this.webResource = client.resource(call);
    }

    public void getResponse() {
        try {
            this.cr = this.webResource.accept("application/json").get(ClientResponse.class);
            if (this.cr.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                + this.cr.getStatus());
            }
            this.currResponse = this.cr.getEntity(String.class);
            printJSONFormatted(this.currResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJSONFormatted(String jso) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jso).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formatted = gson.toJson(json);
        System.out.println("Output from Server .... \n");
        System.out.println(formatted);
    }
}
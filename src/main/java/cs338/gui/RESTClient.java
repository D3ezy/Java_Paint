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
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.HashMap;
import java.util.Map;

public class RESTClient {

    private Client client;
    private WebResource webResource;
    private ClientResponse cr;
    private final String baseSite = "https://fishbase.ropensci.org/";

    RESTClient() {
        this.client = Client.create();
    }

    public String getResponse() {
        try {
            this.cr = this.webResource.accept("application/json").get(ClientResponse.class);
            if (this.cr.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                + this.cr.getStatus());
            }
            String response = this.cr.getEntity(String.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getCommonName(String id) {
        String taxa = "taxa/";
        System.out.println(baseSite + taxa + id + "?");
        this.webResource = client.resource(baseSite + taxa + id + "?");
        String response = this.getResponse();
        System.out.println(response);
        Gson gson = new Gson();
        TaxaByID t = gson.fromJson(response, TaxaByID.class);
        System.out.println(t.data);
        return null; // commonName;
    }

    // private methods
    private static void parseJSON() {
        return;
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
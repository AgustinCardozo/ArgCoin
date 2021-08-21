package domain.servicioCriptomoneda;

import domain.excepcion.FalloAPICriptoException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class APICriptomonedas {
    private static APICriptomonedas instancia = null;

    private APICriptomonedas(){}

    public static APICriptomonedas getInstance(){
        if(instancia == null){
            instancia = new APICriptomonedas();
        }
        return instancia;
    }

    public List<Criptomoneda> Get_Criptomonedas() throws IOException {
        List<Criptomoneda> criptomonedas = new ArrayList<Criptomoneda>();
        FileReader file = new FileReader("properties/API.properties");

        Properties properties = new Properties();
        properties.load(file);
        String url = properties.getProperty("UrlCriptomoneda");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el codigo sea 200, sino hay algun problema con la API
                    // Traigo el string
                    String result = EntityUtils.toString(entity);

                    // Convierto a un objeto JSON y traigo el array con las criptomonedas
                    JSONObject obj = new JSONObject(result);
                    JSONArray currencies = obj.getJSONArray("data");

                    // Itero sobre la lista de criptomonedas y seteo los correspondientes atributos
                    for (int i = 0; i < currencies.length(); i++) {
                        JSONObject monedita = (JSONObject) currencies.get(i);
                        Criptomoneda nuevaMoneda = new Criptomoneda(monedita.getString("id"), monedita.getInt("rank"), monedita.getString("symbol"), monedita.getString("priceUsd"));
                        criptomonedas.add(nuevaMoneda);
                    }
                }

            }catch(Exception e){
                throw new FalloAPICriptoException(e.toString());
            }
            finally {
                response.close();
            }

        } finally {
            httpClient.close();
        }

        return criptomonedas;
    }
}

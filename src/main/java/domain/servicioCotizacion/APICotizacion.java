package domain.servicioCotizacion;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class APICotizacion {
    private static APICotizacion instancia = null;

    private APICotizacion(){}

    public static APICotizacion getInstance(){
        if(instancia == null){
            instancia = new APICotizacion();
        }
        return instancia;
    }

    public Cotizacion Get_Cotizacion() throws IOException {
        Cotizacion moneda = new Cotizacion();
        FileReader file = new FileReader("properties/API.properties");

        Properties properties = new Properties();
        properties.load(file);
        String url = properties.getProperty("UrlCotizacion");

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try {
                HttpGet request = new HttpGet(url);

                CloseableHttpResponse response = httpClient.execute(request);

                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el codigo sea 200, sino hay algun problema con la API
                        String result = EntityUtils.toString(entity);

                        JSONObject obj = new JSONObject(result);
                        moneda =new Cotizacion(1,obj.getString("fecha"), obj.getString("compra"), obj.getString("venta"));
                    }

                } finally {
                    response.close();
                }

            } finally {
                httpClient.close();
            }
        }

        return moneda;
    }
}

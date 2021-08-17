package domain.servicioCotizacion;

import domain.servicioCriptomoneda.Criptomoneda;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class APICotizacion {
    public static Moneda Get_Cotizacion() throws IOException {
        Moneda moneda = new Moneda();
        String url = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial/";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try {
                HttpGet request = new HttpGet(url);

                CloseableHttpResponse response = httpClient.execute(request);

                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null && response.getStatusLine().getStatusCode() == 200) { // Debo validar que el codigo sea 200, sino hay algun problema con la API
                        String result = EntityUtils.toString(entity);

                        JSONObject obj = new JSONObject(result);
                        moneda =new Moneda(1,obj.getString("fecha"), obj.getString("compra"), obj.getString("venta"),0);
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

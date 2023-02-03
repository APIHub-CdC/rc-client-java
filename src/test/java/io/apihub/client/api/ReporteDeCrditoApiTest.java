package io.apihub.client.api;

import io.apihub.client.ApiClient;
import io.apihub.client.ApiException;
import io.apihub.client.model.*;
import io.apihub.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Ignore
public class ReporteDeCrditoApiTest {
    private final ReporteDeCrditoApi api = new ReporteDeCrditoApi();
    private ApiClient apiClient;
    private String xApiKey = null;
    private String username = null;
    private String password = null;
    private String folioConsulta = null;

    @Before()
    public void setUp() {

        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath("the_url");

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new SignerInterceptor())
                .build();
        apiClient.setHttpClient(okHttpClient);
        this.xApiKey = "your_api_key";
        this.username = "your_username";
        this.password = "your_password";
    }


    @Test
    public void getReporteTest() throws ApiException {

        PersonaPeticion body = new PersonaPeticion();
        body.setPrimerNombre("XXXXXX");
        body.setApellidoPaterno("XXXXXX");
        body.setApellidoMaterno("XXXXXX");
        body.setFechaNacimiento("yyyy-mm-dd");
        body.setRFC("XXXXXX");
        body.setNacionalidad("XX");
        DomicilioPeticion domicilio = new DomicilioPeticion();
        domicilio.setDireccion("XXXXXX");
        domicilio.setColoniaPoblacion("XXXXXX");
        domicilio.setDelegacionMunicipio("XXXXXX");
        domicilio.setCiudad("XXXXXX");
        domicilio.setEstado(CatalogoEstados.JAL);
        domicilio.setCP("XXXXXX");
        domicilio.setFechaResidencia("yyyy-mm-dd");
        domicilio.setNumeroTelefono("XXXXXX");
        domicilio.setTipoAsentamiento(CatalogoTipoAsentamiento._28);
        domicilio.setTipoDomicilio(CatalogoTipoDomicilio.C);
        body.setDomicilio(domicilio);
        Respuesta response = api.getReporte(this.xApiKey, this.username, this.password, body);
        Assert.assertTrue(response.getFolioConsulta() != null);

    }

}

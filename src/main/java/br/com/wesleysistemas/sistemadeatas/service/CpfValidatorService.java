package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.CpfDtoInDataThirdPartyAPI;
import br.com.wesleysistemas.sistemadeatas.interfaces.Messages;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CpfValidatorService {
    public boolean validateCpf(String cpf) {
        HttpGet request = new HttpGet("https://api.nfse.io/validate/NaturalPeople/taxNumber/" + cpf);
        try (CloseableHttpClient client = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = client.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                CpfDtoInDataThirdPartyAPI cpfDtoInDataThirdPartyAPI = gson.fromJson(result, CpfDtoInDataThirdPartyAPI.class);
                return Objects.equals(cpfDtoInDataThirdPartyAPI.getValid().trim().toLowerCase(), "true");
            }
        } catch (Exception e) {
            throw new RuntimeException(Messages.THIRD_PARTY_SERVICE_FAILED);
        }
        return false;
    }
}

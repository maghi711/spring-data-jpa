package com.maghi711.bootsecuritydemo.restclient;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CoreJavaRestClient {

    private static final String accessToken = "eyJzdWIiOiJscm46aW90OmFhbTo6ODAwMDAwMDAxOTpwcmluY2lwYWw6c2VydmljZTpyb290LXNlcnZpY2UiLCJraWQiOiI0ODczMTc0Mi0xOTc2LTQ2MzgtOTRjNC03ZGUzNjZlMzVlNzQiLCJpc3MiOiJzaWduaWZ5LmlvdCIsInR5cCI6IkpXVCIsImV4cCI6MTY0MjUwNzgzNSwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiI2ZTIxMjlkMi1lNWJiLTRjMTktOGVkNC04YmMwOWQ2NTcwODYiLCJzdWIiOiJscm46aW90OmFhbTo6ODAwMDAwMDAxOTpwcmluY2lwYWw6c2VydmljZTpyb290LXNlcnZpY2UiLCJleHAiOjE2NDI1MDc4MzUsImlvdF90dCI6InNpZ25pZnkuaW90LmFjY2Vzcy10b2tlbiIsImF1ZCI6Imxybjppb3Q6YWFtOjo4MDAwMDAwMDE5Ojo6IiwiaXNzIjoibHJuOmlvdDphYW06OjAwMDAwMDEwMDA6OjoiLCJpYXQiOjE2NDI1MDQyMzUsImlvdF9wcmlfYWNjIjoiODAwMDAwMDAxOSIsImlvdF90diI6IjEiLCJpb3R0b2tlbnZlcnNpb24iOiIxIn0.OMjVRqTrtzYMCZOkjAwPCZrmlQWdoiqrRdZVESkDsUA6e36fsoSMjxc5ugTn9gUwZvGB7xDiH22919v_vBnGhZGipmJgjvFFeUQDrvT8MUFy_wzkOS7ImzNuCXzd7AsuEMy47xYf1ecjmNxVvr-qzlz56yk9S4nqByYuolgauoEsZWDfwome_9Ob7MKmDhlX01HuvpO4Yk7wdFgWqq4B-eAPiQnCIPx2op-Yi9kDU-35YQusyXkI8oRmBRfX3Ep_uAcykyZCF4Tm8ZamWsUiea7oYzo4kmf1lJpVzznlW-4xMZ2cwJj4iFMrRJzaoYJwP8SXTji59invAIvAzb6iZNCD5V7cslZ5EsjHqKxm-lrCj7sB3vWCDv8C0c4PbAxHv1q_aoBCw15-7p1hYOy_bCp7qBE1UhpHMerqdRD-5V2fY7Lp10giiCAJnFvAIaG2-DvcFCSHYzuS4S1790Va1o7jA4HDXWWchhuSypS3Kx894sSSkjg1fobeRfq8JXzyHTFEsS9gLp3Bt-456Ls1eVGslB8dq7w9tbO_JZN2xtYZzV9tQhmXs2SUu-7_fSpY7ObG-Epizi8cQA6Xw6h5HVTO5UiX4bpDYICGE4kEgyqmH0rVkrNj3AKP3zVciOfEj4ZaiqFCo30hVA-PqFM1DuZD2Eh0FNr3t6SXZU2m-MU";

    private static final String authUri = "https://eu.api.iotplatform.signify.com/security/identity/v1/services/root-service/authenticate";

    private static final String getUri = "https://reqres.in/api/users?page=2";

    private static final String packageInfo = "https://eu.api.iotplatform.signify.com/device-management/software/v1/packages";

    public String getPackageInfo (String token) {
        String endUrl = packageInfo + "/identity/964461ef-75b4-4e10-97d0-06202217170c";
        try {
            final HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(endUrl))
                    .headers("Content-Type", "application/json")
                    .headers("Authorization", "Bearer " + token)
                    .version(HttpClient.Version.HTTP_1_1)
                    .timeout(Duration.ofMinutes(5))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            TypeReference<PackageResponse> typeRef = new TypeReference<PackageResponse>() {};
            PackageResponse stringStringHashMap = null;
            try {
                stringStringHashMap = objectMapper.readValue(response.body(), typeRef);
                System.out.println(stringStringHashMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("response.body() = " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String authenticate() {
        try {
            final HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(authUri))
                    .headers("Content-Type", "application/json")
                    .version(HttpClient.Version.HTTP_1_1)
                    .timeout(Duration.ofMinutes(5))
                    .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                            "  \"accountId\": \"8000000019\",\n" +
                            "  \"secret\": \"61idR!#t7Kub\"\n" +
                            "}"))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.body() = " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void simpleGetReqResJson() {
        try {
            final HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(getUri))
                    .headers("name", "value")
                    .version(HttpClient.Version.HTTP_1_1)
                    .timeout(Duration.ofMinutes(5))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.body() = " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CoreJavaRestClient client = new CoreJavaRestClient();
        client.getPackageInfo(accessToken);
    }
}

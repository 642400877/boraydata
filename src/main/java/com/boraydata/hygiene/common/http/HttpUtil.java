package com.boraydata.hygiene.common.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpUtil {

    public static String httpGetConnection(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(requestConfig);

        try {
            response = httpClient.execute(httpGet, new BasicHttpContext());

            if (response.getStatusLine().getStatusCode() != 200) {

                log.info("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            }
        } catch (IOException e) {
            log.error("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public static String httpGetConnection(String url, Map<String, String> paramsMap) throws UnsupportedEncodingException, URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(url);

        if (null != paramsMap) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            uriBuilder.setParameters(params);
        }

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(10000).setConnectTimeout(10000).build();
        httpGet.setConfig(requestConfig);

        try {
            response = httpClient.execute(httpGet, new BasicHttpContext());

            if (response.getStatusLine().getStatusCode() != 200) {

                log.info("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            }
        } catch (IOException e) {
            log.error("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public static String httpGetConnection(String url, String param) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(requestConfig);

        try {
            response = httpClient.execute(httpGet, new BasicHttpContext());

            if (response.getStatusLine().getStatusCode() != 200) {

                log.info("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            }
        } catch (IOException e) {
            log.error("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}

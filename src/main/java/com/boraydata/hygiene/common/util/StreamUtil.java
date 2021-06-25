package com.boraydata.hygiene.common.util;

import com.boraydata.hygiene.web.request.AreaMapRequest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

    public static String readLocalFile(String fileName) throws IOException {
        List<AreaMapRequest> areaMapRequestList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(fileName);
        InputStream file = resource.getInputStream();
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}

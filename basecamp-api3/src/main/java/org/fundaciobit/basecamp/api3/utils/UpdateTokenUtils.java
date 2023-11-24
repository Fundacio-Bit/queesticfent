package org.fundaciobit.basecamp.api3.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author anadal
 *
 */
public class UpdateTokenUtils {

    public static final String BASECAMP_URL_GET_TOKEN = "https://launchpad.37signals.com/authorization/token";

    public static final String BASECAMP_URL_GET_CODE = "https://launchpad.37signals.com/authorization/new";

    public static final String getGetCodeUrl(String client_id, String redirect_uri) {
        return BASECAMP_URL_GET_CODE + "?client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&type=web_server";
    }

    public static TokenResponse getNewToken(String client_id, String client_secret, String redirect_uri, String code)
            throws Exception {

        final String urlParameters = "client_id=" + client_id + "&" + "client_secret=" + client_secret + "&"
                + "type=web_server" + "&" + "redirect_uri=" + redirect_uri + "&" + "code=" + code;

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = new URL(BASECAMP_URL_GET_TOKEN);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();

        InputStream is = conn.getInputStream();

        StringBuilder sb = new StringBuilder();
        for (int c; (c = is.read()) >= 0;)
            sb.append((char) c);
        String response = sb.toString();

        System.out.println(response);

        Gson gson = new GsonBuilder().create();

        TokenResponse t = gson.fromJson(response, TokenResponse.class);

        return t;

    }

    public static void updateBasecampTokenProperties(File basecampTokenFile, TokenResponse token)
            throws IOException, FileNotFoundException {
        Properties newProperties = new Properties();

        newProperties.setProperty("accessToken", token.getAccessToken());
        newProperties.setProperty("expiresIn", String.valueOf(token.getExpiresIn()));
        newProperties.setProperty("refreshToken", token.getRefreshToken());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, token.getExpiresIn());

        newProperties.store(new FileOutputStream(basecampTokenFile), "Token Info (Expira dia " + cal.getTime() + ")");
    }

}

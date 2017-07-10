package com.francisco.kazoku.comunicacion.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;
import com.francisco.kazoku.comunicacion.interfaces.PrediccionClimaI;

public class PrediccionClimaImpl implements PrediccionClimaI{
    
    @Value("${clima.api.id}")
    private String apiId;
    
    @Value("${clima.ciudad}")
    private String ciudad;
    
    @Value("${clima.prediccion.limite}")
    private String limite;
    
    @Value("${clima.unidades}")
    private String unidades;

    @Override
    public CiudadClima getPredicciones() {
        String resultado = "";
        try {
            String MontarUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?id=524901&cnt=7&units=metric&appid=77cd5a8bc3da25900b074a04e40a5534";
            final URL url = new URL(MontarUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-length", "0");
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.connect();
            final int status = conn.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    resultado = sb.toString();
            }
            
            JSONObject objJson = (JSONObject) new JSONParser().parse(resultado);
            Object ciudad = objJson.get("city");
            
        } catch (MalformedURLException e) {
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(ParseException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}

package com.francisco.kazoku.comunicacion.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;
import com.francisco.kazoku.comunicacion.dto.PrediccionClima;
import com.francisco.kazoku.comunicacion.interfaces.PrediccionClimaDaoI;

@Component
public class PrediccionClimaDaoImpl implements PrediccionClimaDaoI{

    @Override
    public CiudadClima getPredicciones() {
        CiudadClima ciudad = new CiudadClima();
        String resultado = "";
        try {
            List<PrediccionClima> prediccion = new ArrayList<PrediccionClima>();
            
            String MontarUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?id=3109718&cnt=7&units=metric&appid=77cd5a8bc3da25900b074a04e40a5534";
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
            JSONObject ciudadJson = (JSONObject) objJson.get("city");
            ciudad.setNombre(ciudadJson.get("name").toString());
            JSONObject coordenadasJson = (JSONObject) ciudadJson.get("coord");
            ciudad.setLongitud(new BigDecimal(coordenadasJson.get("lon").toString()));
            ciudad.setLatitud(new BigDecimal(coordenadasJson.get("lat").toString()));
            ciudad.setPais(ciudadJson.get("country").toString());
            ciudad.setPoblacion(Integer.parseInt(ciudadJson.get("population").toString()));
            
            JSONArray listaPrediccionJson = (JSONArray) objJson.get("list");
            for(Object prediccionJson : listaPrediccionJson){
                if(prediccionJson instanceof JSONObject){
                    PrediccionClima pred = new PrediccionClima();
                    Timestamp stamp = new Timestamp(Long.parseLong(((JSONObject) prediccionJson).get("dt").toString()));
                    pred.setFecha(new Date(stamp.getTime()));
                    JSONObject temperaturas = (JSONObject)((JSONObject) prediccionJson).get("temp");
                    pred.setTemperaturaDia(new BigDecimal(temperaturas.get("day").toString()));
                    pred.setTemperaturaMinima(new BigDecimal(temperaturas.get("min").toString()));
                    pred.setTemperaturaMaxima(new BigDecimal(temperaturas.get("max").toString()));
                    pred.setTemperaturaNoche(new BigDecimal(temperaturas.get("night").toString()));
                    pred.setTemperaturaAtardecer(new BigDecimal(temperaturas.get("eve").toString()));
                    pred.setTemperaturaAmanecer(new BigDecimal(temperaturas.get("morn").toString()));
                    pred.setPresion(new BigDecimal(((JSONObject) prediccionJson).get("pressure").toString()));
                    pred.setHumedad(new BigDecimal(((JSONObject) prediccionJson).get("humidity").toString()));
                    JSONArray climaArr = (JSONArray) ((JSONObject)prediccionJson).get("weather");
                    for(Object clima : climaArr){
                        pred.setClima(((JSONObject)clima).get("main").toString());
                        pred.setClimaDescripcion(((JSONObject)clima).get("description").toString());
                        pred.setIcono(((JSONObject)clima).get("icon").toString());
                    }
                    pred.setVelocidadViento(new BigDecimal(((JSONObject) prediccionJson).get("speed").toString()));
                    pred.setDireccionViento(new BigDecimal(((JSONObject) prediccionJson).get("deg").toString()));
                    pred.setNubosidad(new BigDecimal(((JSONObject) prediccionJson).get("clouds").toString()));
                    prediccion.add(pred);
                }
            }
            
            ciudad.setPredicciones(prediccion);
            
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch(ParseException e){
        }
        return ciudad;
    }

    @Override
    public CiudadClima getPrediccionesNombreCiudad(String ciudadNombre, String limite, String unidades, String apiId) {
        CiudadClima ciudad = new CiudadClima();
        String resultado = "";
        try {
            List<PrediccionClima> prediccion = new ArrayList<PrediccionClima>();
            
            String MontarUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+ciudadNombre+
                                "&cnt="+limite+
                                "&units="+unidades+
                                "&appid="+apiId;
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
            JSONObject ciudadJson = (JSONObject) objJson.get("city");
            ciudad.setNombre(ciudadJson.get("name").toString());
            JSONObject coordenadasJson = (JSONObject) ciudadJson.get("coord");
            ciudad.setLongitud(new BigDecimal(coordenadasJson.get("lon").toString()));
            ciudad.setLatitud(new BigDecimal(coordenadasJson.get("lat").toString()));
            ciudad.setPais(ciudadJson.get("country").toString());
            ciudad.setPoblacion(Integer.parseInt(ciudadJson.get("population").toString()));
            
            JSONArray listaPrediccionJson = (JSONArray) objJson.get("list");
            for(Object prediccionJson : listaPrediccionJson){
                if(prediccionJson instanceof JSONObject){
                    PrediccionClima pred = new PrediccionClima();
                    JSONObject temperaturas = (JSONObject)((JSONObject) prediccionJson).get("temp");
                    pred.setTemperaturaDia(new BigDecimal(temperaturas.get("day").toString()));
                    pred.setTemperaturaMinima(new BigDecimal(temperaturas.get("min").toString()));
                    pred.setTemperaturaMaxima(new BigDecimal(temperaturas.get("max").toString()));
                    pred.setTemperaturaNoche(new BigDecimal(temperaturas.get("night").toString()));
                    pred.setTemperaturaAtardecer(new BigDecimal(temperaturas.get("eve").toString()));
                    pred.setTemperaturaAmanecer(new BigDecimal(temperaturas.get("morn").toString()));
                    pred.setPresion(new BigDecimal(((JSONObject) prediccionJson).get("pressure").toString()));
                    pred.setHumedad(new BigDecimal(((JSONObject) prediccionJson).get("humidity").toString()));
                    JSONArray climaArr = (JSONArray) ((JSONObject)prediccionJson).get("weather");
                    for(Object clima : climaArr){
                        pred.setClima(((JSONObject)clima).get("main").toString());
                        pred.setClimaDescripcion(((JSONObject)clima).get("description").toString());
                        pred.setIcono(((JSONObject)clima).get("icon").toString());
                    }
                    pred.setVelocidadViento(new BigDecimal(((JSONObject) prediccionJson).get("speed").toString()));
                    pred.setDireccionViento(new BigDecimal(((JSONObject) prediccionJson).get("deg").toString()));
                    pred.setNubosidad(new BigDecimal(((JSONObject) prediccionJson).get("clouds").toString()));
                    prediccion.add(pred);
                }
            }
            
            ciudad.setPredicciones(prediccion);
            
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch(ParseException e){
        }
        return ciudad;
    }
    
}

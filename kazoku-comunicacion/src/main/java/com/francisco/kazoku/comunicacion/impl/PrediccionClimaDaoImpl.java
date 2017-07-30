package com.francisco.kazoku.comunicacion.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    public CiudadClima getPrediccionActual(String idCiudad, String unidades, String apiId) {
        CiudadClima ciudad = new CiudadClima();
        
        String resultado = "";
        try {
            List<PrediccionClima> prediccion = new ArrayList<PrediccionClima>();
            
            String MontarUrl = "http://api.openweathermap.org/data/2.5/weather?id="+idCiudad+"&units="+unidades+"&appid="+apiId;
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
            JSONObject coordenadasJson = (JSONObject) objJson.get("coord");
            ciudad.setLongitud(new BigDecimal(coordenadasJson.get("lon").toString()));
            ciudad.setLatitud(new BigDecimal(coordenadasJson.get("lat").toString()));
            
            PrediccionClima pred = new PrediccionClima();
            
            JSONArray climaArr = (JSONArray) ((JSONObject)objJson).get("weather");
            for(Object clima : climaArr){
                pred.setClima(((JSONObject)clima).get("main").toString());
                pred.setClimaDescripcion(((JSONObject)clima).get("description").toString());
                pred.setIcono(((JSONObject)clima).get("icon").toString());
            }
            
            JSONObject temperaturasJson = (JSONObject) objJson.get("main");
            pred.setTemperatura(new BigDecimal(temperaturasJson.get("temp").toString()));
            pred.setPresion(new BigDecimal(((JSONObject) temperaturasJson).get("pressure").toString()));
            pred.setHumedad(new BigDecimal(((JSONObject) temperaturasJson).get("humidity").toString()));
            pred.setTemperaturaMinima(new BigDecimal(temperaturasJson.get("temp_min").toString()));
            pred.setTemperaturaMaxima(new BigDecimal(temperaturasJson.get("temp_max").toString()));
            
            pred.setVisibilidad(new BigDecimal(objJson.get("visibility").toString()));
            
            JSONObject vientoJson = (JSONObject) objJson.get("wind");
            pred.setVelocidadViento(new BigDecimal(((JSONObject) vientoJson).get("speed").toString()));
            if(((JSONObject) vientoJson).get("deg") != null){
                pred.setDireccionViento(new BigDecimal(((JSONObject) vientoJson).get("deg").toString()));
            }
            JSONObject nubosidadJson = (JSONObject) objJson.get("clouds");
            pred.setNubosidad(new BigDecimal(((JSONObject) nubosidadJson).get("all").toString()));
            
            pred.setFecha(new Date(Long.parseLong(objJson.get("dt").toString())*1000));
            ciudad.setNombre(objJson.get("name").toString());
            ciudad.setId(objJson.get("id").toString());
            
            JSONObject sistemaJson = (JSONObject) objJson.get("sys");
            ciudad.setPais(sistemaJson.get("country").toString());
            ciudad.setAmanecer(new Date(Long.parseLong(sistemaJson.get("sunrise").toString())*1000));
            ciudad.setAtardecer(new Date(Long.parseLong(sistemaJson.get("sunset").toString())*1000));
            
            prediccion.add(pred);
            
            ciudad.setPredicciones(prediccion);
            
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch(ParseException e){
        }
        return ciudad;
    }
    
    @Override
    public CiudadClima getPredicciones(String idCiudad, String unidades, String apiId, Integer numeroDias) {
        CiudadClima ciudad = new CiudadClima();
        String resultado = "";
        try {
            List<PrediccionClima> prediccion = new ArrayList<PrediccionClima>();
            
            String MontarUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?id="+idCiudad+"&cnt="+numeroDias+"&units="+unidades+"&appid="+apiId;
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
                    pred.setFecha(new Date(Long.parseLong(((JSONObject) prediccionJson).get("dt").toString())*1000));
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

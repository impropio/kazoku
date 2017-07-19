package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.francisco.kazoku.comunicacion.dto.PrediccionClima;

/**
 * 
 * @author Francisco Moro
 *
 */
public class PrediccionClimaDto implements Serializable{
    
    /** Constante serialVersionUID. */
    private static final long serialVersionUID = -5531237834121758458L;
    
    private Date fecha;
    private String temperatura;
    private String temperaturaDia;
	private String temperaturaMinima;
	private String temperaturaMaxima;
	private String temperaturaNoche;
	private String temperaturaAtardecer;
	private String temperaturaAmanecer;
	private String presion;
	private String humedad;
	private String clima;
	private String climaDescripcion;
	private String icono;
	private String visibilidad;
	private String velocidadViento;
	private String direccionViento;
	private String velocidadRafagaViento;
	private String nubosidad;
	private String cantidadLluvia;
	private String cantidadNieve;

    /**
	 * Constructor sin parametros
	 */
	public PrediccionClimaDto(){
	    
	}
	
	/**
	 * Constructor con parámetros
	 * 
	 * @param fecha
	 * @param temperaturaDia
	 * @param temperaturaMinima
	 * @param temperaturaMaxima
	 * @param temperaturaNoche
	 * @param temperaturaAtardecer
	 * @param temperaturaAmanecer
	 * @param presion
	 * @param humedad
	 * @param clima
	 * @param climaDescripcion
	 * @param icono
	 * @param velocidadViento
	 * @param direccionViento
	 * @param velocidadRafagaViento
	 * @param nubosidad
	 * @param cantidadLluvia
	 * @param cantidadNieve
	 */
	public PrediccionClimaDto(Date fecha, String temperatura, String temperaturaDia, String temperaturaMinima, 
	        String temperaturaMaxima, String temperaturaNoche, String temperaturaAtardecer, 
	        String temperaturaAmanecer, String presion, String humedad, String clima, String climaDescripcion, 
	        String icono, String visibilidad, String velocidadViento, String direccionViento, 
	        String velocidadRafagaViento, String nubosidad, String cantidadLluvia, String cantidadNieve){
	    this.fecha = fecha;
	    this.temperatura = temperatura;
	    this.temperaturaDia = temperaturaDia;
	    this.temperaturaMinima = temperaturaMinima;
	    this.temperaturaMaxima = temperaturaMaxima;
	    this.temperaturaNoche = temperaturaNoche;
	    this.temperaturaAtardecer = temperaturaAtardecer;
	    this.temperaturaAmanecer = temperaturaAmanecer;
	    this.presion = presion;
	    this.humedad = humedad;
	    this.clima = clima;
	    this.climaDescripcion = climaDescripcion;
	    this.icono = icono;
	    this.visibilidad = visibilidad;
	    this.velocidadViento = velocidadViento;
	    this.direccionViento = direccionViento;
	    this.velocidadRafagaViento = velocidadRafagaViento;
	    this.nubosidad = nubosidad;
	    this.cantidadLluvia = cantidadLluvia;
	    this.cantidadNieve = cantidadNieve;
	}
	
	/**
	 * Transforma el objeto PrediccionClima en el Dto
	 * 
	 * @param prediccion
	 * @return
	 */
	public PrediccionClimaDto objectToDto(PrediccionClima prediccion){
	    this.fecha = prediccion.getFecha();
	    this.temperatura = (prediccion.getTemperatura() != null)?prediccion.getTemperatura().toString():"-";
	    this.temperaturaDia = (prediccion.getTemperaturaDia() != null)?prediccion.getTemperaturaDia().toString():"-";
        this.temperaturaMinima = (prediccion.getTemperaturaMinima() != null)?prediccion.getTemperaturaMinima().toString():"-";
        this.temperaturaMaxima = (prediccion.getTemperaturaMaxima() != null)?prediccion.getTemperaturaMaxima().toString():"-";
        this.temperaturaNoche = (prediccion.getTemperaturaNoche() != null)?prediccion.getTemperaturaNoche().toString():"-";
        this.temperaturaAtardecer = (prediccion.getTemperaturaAtardecer() != null)?prediccion.getTemperaturaAtardecer().toString():"-";
        this.temperaturaAmanecer = (prediccion.getTemperaturaAmanecer() != null)?prediccion.getTemperaturaAmanecer().toString():"-";
        this.presion = (prediccion.getPresion() != null)?prediccion.getPresion().toString():"-";
        this.humedad = (prediccion.getHumedad() != null)?prediccion.getHumedad().toString():"-";
        this.clima = prediccion.getClima();
        this.climaDescripcion = prediccion.getClimaDescripcion();
        this.icono = prediccion.getIcono();
        this.visibilidad = (prediccion.getVisibilidad() != null)?prediccion.getVisibilidad().toString():"-";
        this.velocidadViento = (prediccion.getVelocidadViento() != null)?prediccion.getVelocidadViento().toString():"-";
        if(prediccion.getDireccionViento() != null){
            BigDecimal direccion = prediccion.getDireccionViento();
            if(direccion.compareTo(new BigDecimal(337.5)) >= 0 || direccion.compareTo(new BigDecimal(22.5)) <= 0){
                this.direccionViento = "n";
            }
            if(direccion.compareTo(new BigDecimal(22.5)) == 1 && direccion.compareTo(new BigDecimal(67.5)) == -1){
                this.direccionViento = "ne";
            }
            if(direccion.compareTo(new BigDecimal(67.5)) >= 0 && direccion.compareTo(new BigDecimal(112.5)) <= 0){
                this.direccionViento = "e";
            }
            if(direccion.compareTo(new BigDecimal(112.5)) == 1 && direccion.compareTo(new BigDecimal(157.5)) == -1){
                this.direccionViento = "se";
            }
            if(direccion.compareTo(new BigDecimal(157.5)) >= 0 && direccion.compareTo(new BigDecimal(202.5)) <= 0){
                this.direccionViento = "s";
            }
            if(direccion.compareTo(new BigDecimal(202.5)) == 1 && direccion.compareTo(new BigDecimal(247.5)) == -1){
                this.direccionViento = "so";
            }
            if(direccion.compareTo(new BigDecimal(247.5)) >= 0 && direccion.compareTo(new BigDecimal(292.5)) <= 0){
                this.direccionViento = "o";
            }
            if(direccion.compareTo(new BigDecimal(292.5)) == 1 && direccion.compareTo(new BigDecimal(337.5)) == -1){
                this.direccionViento = "no";
            }
        }else{
            this.direccionViento = "sinDatos";
        }
        this.velocidadRafagaViento = (prediccion.getVelocidadRafagaViento() != null)?prediccion.getVelocidadRafagaViento().toString():"-";
        this.nubosidad = (prediccion.getNubosidad() != null)?prediccion.getNubosidad().toString():"-";
        this.cantidadLluvia = (prediccion.getCantidadLluvia() != null)?prediccion.getCantidadLluvia().toString():"-";
        this.cantidadNieve = (prediccion.getCantidadNieve() != null)?prediccion.getCantidadNieve().toString():"-";
	    return this;
	}
	
	/**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }
    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    /**
     * @return the temperaturaDia
     */
    public String getTemperaturaDia() {
        return temperaturaDia;
    }
    /**
     * @param temperaturaDia the temperaturaDia to set
     */
    public void setTemperaturaDia(String temperaturaDia) {
        this.temperaturaDia = temperaturaDia;
    }
    /**
     * @return the temperaturaMinima
     */
    public String getTemperaturaMinima() {
        return temperaturaMinima;
    }
    /**
     * @param temperaturaMinima the temperaturaMinima to set
     */
    public void setTemperaturaMinima(String temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }
    /**
     * @return the temperaturaMaxima
     */
    public String getTemperaturaMaxima() {
        return temperaturaMaxima;
    }
    /**
     * @param temperaturaMaxima the temperaturaMaxima to set
     */
    public void setTemperaturaMaxima(String temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }
    /**
     * @return the temperaturaNoche
     */
    public String getTemperaturaNoche() {
        return temperaturaNoche;
    }
    /**
     * @param temperaturaNoche the temperaturaNoche to set
     */
    public void setTemperaturaNoche(String temperaturaNoche) {
        this.temperaturaNoche = temperaturaNoche;
    }
    /**
     * @return the temperaturaAtardecer
     */
    public String getTemperaturaAtardecer() {
        return temperaturaAtardecer;
    }
    /**
     * @param temperaturaAtardecer the temperaturaAtardecer to set
     */
    public void setTemperaturaAtardecer(String temperaturaAtardecer) {
        this.temperaturaAtardecer = temperaturaAtardecer;
    }
    /**
     * @return the temperaturaAmanecer
     */
    public String getTemperaturaAmanecer() {
        return temperaturaAmanecer;
    }
    /**
     * @param temperaturaAmanecer the temperaturaAmanecer to set
     */
    public void setTemperaturaAmanecer(String temperaturaAmanecer) {
        this.temperaturaAmanecer = temperaturaAmanecer;
    }
    /**
     * @return the presion
     */
    public String getPresion() {
        return presion;
    }
    /**
     * @param presion the presion to set
     */
    public void setPresion(String presion) {
        this.presion = presion;
    }
    /**
     * @return the humedad
     */
    public String getHumedad() {
        return humedad;
    }
    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }
    /**
     * @return the clima
     */
    public String getClima() {
        return clima;
    }
    /**
     * @param clima the clima to set
     */
    public void setClima(String clima) {
        this.clima = clima;
    }
    /**
     * @return the climaDescripcion
     */
    public String getClimaDescripcion() {
        return climaDescripcion;
    }
    /**
     * @param climaDescripcion the climaDescripcion to set
     */
    public void setClimaDescripcion(String climaDescripcion) {
        this.climaDescripcion = climaDescripcion;
    }
    /**
     * @return the icono
     */
    public String getIcono() {
        return icono;
    }
    /**
     * @param icono the icono to set
     */
    public void setIcono(String icono) {
        this.icono = icono;
    }
    /**
     * @return the visibilidad
     */
    public String getVisibilidad() {
        return visibilidad;
    }
    /**
     * @param visibilidad the visibilidad to set
     */
    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }
    /**
     * @return the velocidadViento
     */
    public String getVelocidadViento() {
        return velocidadViento;
    }
    /**
     * @param velocidadViento the velocidadViento to set
     */
    public void setVelocidadViento(String velocidadViento) {
        this.velocidadViento = velocidadViento;
    }
    /**
     * @return the direccionViento
     */
    public String getDireccionViento() {
        return direccionViento;
    }
    /**
     * @param direccionViento the direccionViento to set
     */
    public void setDireccionViento(String direccionViento) {
        this.direccionViento = direccionViento;
    }
    /**
     * @return the velocidadRafagaViento
     */
    public String getVelocidadRafagaViento() {
        return velocidadRafagaViento;
    }
    /**
     * @param velocidadRafagaViento the velocidadRafagaViento to set
     */
    public void setVelocidadRafagaViento(String velocidadRafagaViento) {
        this.velocidadRafagaViento = velocidadRafagaViento;
    }
    /**
     * @return the nubosidad
     */
    public String getNubosidad() {
        return nubosidad;
    }
    /**
     * @param nubosidad the nubosidad to set
     */
    public void setNubosidad(String nubosidad) {
        this.nubosidad = nubosidad;
    }
    /**
     * @return the cantidadLluvia
     */
    public String getCantidadLluvia() {
        return cantidadLluvia;
    }
    /**
     * @param cantidadLluvia the cantidadLluvia to set
     */
    public void setCantidadLluvia(String cantidadLluvia) {
        this.cantidadLluvia = cantidadLluvia;
    }
    /**
     * @return the cantidadNieve
     */
    public String getCantidadNieve() {
        return cantidadNieve;
    }
    /**
     * @param cantidadNieve the cantidadNieve to set
     */
    public void setCantidadNieve(String cantidadNieve) {
        this.cantidadNieve = cantidadNieve;
    }
	
}

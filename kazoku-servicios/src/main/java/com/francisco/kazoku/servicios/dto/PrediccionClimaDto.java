package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.francisco.kazoku.comunicacion.dto.PrediccionClima;

/**
 * 
 * @author Francisco Moro
 *
 */
public class PrediccionClimaDto implements Serializable{
    
    /** Constante serialVersionUID. */
    private static final long serialVersionUID = -5531237834121758458L;
    
    private BigDecimal temperaturaDia;
	private BigDecimal temperaturaMinima;
	private BigDecimal temperaturaMaxima;
	private BigDecimal temperaturaNoche;
	private BigDecimal temperaturaAtardecer;
	private BigDecimal temperaturaAmanecer;
	private BigDecimal presion;
	private BigDecimal humedad;
	private String clima;
	private String climaDescripcion;
	private String icono;
	private BigDecimal velocidadViento;
	private BigDecimal direccionViento;
	private BigDecimal velocidadRafagaViento;
	private BigDecimal nubosidad;
	private BigDecimal cantidadLluvia;
	private BigDecimal cantidadNieve;
	
	/**
	 * Constructor sin parametros
	 */
	public PrediccionClimaDto(){
	    
	}
	
	/**
	 * Constructor con parámetros
	 * 
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
	public PrediccionClimaDto(BigDecimal temperaturaDia, BigDecimal temperaturaMinima, BigDecimal temperaturaMaxima,
	        BigDecimal temperaturaNoche, BigDecimal temperaturaAtardecer, BigDecimal temperaturaAmanecer,
	        BigDecimal presion, BigDecimal humedad, String clima, String climaDescripcion, String icono,
	        BigDecimal velocidadViento, BigDecimal direccionViento, BigDecimal velocidadRafagaViento,
	        BigDecimal nubosidad, BigDecimal cantidadLluvia, BigDecimal cantidadNieve){
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
	    this.temperaturaDia = prediccion.getTemperaturaDia();
        this.temperaturaMinima = prediccion.getTemperaturaMinima();
        this.temperaturaMaxima = prediccion.getTemperaturaMaxima();
        this.temperaturaNoche = prediccion.getTemperaturaNoche();
        this.temperaturaAtardecer = prediccion.getTemperaturaAtardecer();
        this.temperaturaAmanecer = prediccion.getTemperaturaAmanecer();
        this.presion = prediccion.getPresion();
        this.humedad = prediccion.getHumedad();
        this.clima = prediccion.getClima();
        this.climaDescripcion = prediccion.getClimaDescripcion();
        this.icono = prediccion.getIcono();
        this.velocidadViento = prediccion.getVelocidadViento();
        this.direccionViento = prediccion.getDireccionViento();
        this.velocidadRafagaViento = prediccion.getVelocidadRafagaViento();
        this.nubosidad = prediccion.getNubosidad();
        this.cantidadLluvia = prediccion.getCantidadLluvia();
        this.cantidadNieve = prediccion.getCantidadNieve();
	    return this;
	}
	
    /**
     * @return the temperaturaDia
     */
    public BigDecimal getTemperaturaDia() {
        return temperaturaDia;
    }
    /**
     * @param temperaturaDia the temperaturaDia to set
     */
    public void setTemperaturaDia(BigDecimal temperaturaDia) {
        this.temperaturaDia = temperaturaDia;
    }
    /**
     * @return the temperaturaMinima
     */
    public BigDecimal getTemperaturaMinima() {
        return temperaturaMinima;
    }
    /**
     * @param temperaturaMinima the temperaturaMinima to set
     */
    public void setTemperaturaMinima(BigDecimal temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }
    /**
     * @return the temperaturaMaxima
     */
    public BigDecimal getTemperaturaMaxima() {
        return temperaturaMaxima;
    }
    /**
     * @param temperaturaMaxima the temperaturaMaxima to set
     */
    public void setTemperaturaMaxima(BigDecimal temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }
    /**
     * @return the temperaturaNoche
     */
    public BigDecimal getTemperaturaNoche() {
        return temperaturaNoche;
    }
    /**
     * @param temperaturaNoche the temperaturaNoche to set
     */
    public void setTemperaturaNoche(BigDecimal temperaturaNoche) {
        this.temperaturaNoche = temperaturaNoche;
    }
    /**
     * @return the temperaturaAtardecer
     */
    public BigDecimal getTemperaturaAtardecer() {
        return temperaturaAtardecer;
    }
    /**
     * @param temperaturaAtardecer the temperaturaAtardecer to set
     */
    public void setTemperaturaAtardecer(BigDecimal temperaturaAtardecer) {
        this.temperaturaAtardecer = temperaturaAtardecer;
    }
    /**
     * @return the temperaturaAmanecer
     */
    public BigDecimal getTemperaturaAmanecer() {
        return temperaturaAmanecer;
    }
    /**
     * @param temperaturaAmanecer the temperaturaAmanecer to set
     */
    public void setTemperaturaAmanecer(BigDecimal temperaturaAmanecer) {
        this.temperaturaAmanecer = temperaturaAmanecer;
    }
    /**
     * @return the presion
     */
    public BigDecimal getPresion() {
        return presion;
    }
    /**
     * @param presion the presion to set
     */
    public void setPresion(BigDecimal presion) {
        this.presion = presion;
    }
    /**
     * @return the humedad
     */
    public BigDecimal getHumedad() {
        return humedad;
    }
    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(BigDecimal humedad) {
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
     * @return the velocidadViento
     */
    public BigDecimal getVelocidadViento() {
        return velocidadViento;
    }
    /**
     * @param velocidadViento the velocidadViento to set
     */
    public void setVelocidadViento(BigDecimal velocidadViento) {
        this.velocidadViento = velocidadViento;
    }
    /**
     * @return the direccionViento
     */
    public BigDecimal getDireccionViento() {
        return direccionViento;
    }
    /**
     * @param direccionViento the direccionViento to set
     */
    public void setDireccionViento(BigDecimal direccionViento) {
        this.direccionViento = direccionViento;
    }
    /**
     * @return the velocidadRafagaViento
     */
    public BigDecimal getVelocidadRafagaViento() {
        return velocidadRafagaViento;
    }
    /**
     * @param velocidadRafagaViento the velocidadRafagaViento to set
     */
    public void setVelocidadRafagaViento(BigDecimal velocidadRafagaViento) {
        this.velocidadRafagaViento = velocidadRafagaViento;
    }
    /**
     * @return the nubosidad
     */
    public BigDecimal getNubosidad() {
        return nubosidad;
    }
    /**
     * @param nubosidad the nubosidad to set
     */
    public void setNubosidad(BigDecimal nubosidad) {
        this.nubosidad = nubosidad;
    }
    /**
     * @return the cantidadLluvia
     */
    public BigDecimal getCantidadLluvia() {
        return cantidadLluvia;
    }
    /**
     * @param cantidadLluvia the cantidadLluvia to set
     */
    public void setCantidadLluvia(BigDecimal cantidadLluvia) {
        this.cantidadLluvia = cantidadLluvia;
    }
    /**
     * @return the cantidadNieve
     */
    public BigDecimal getCantidadNieve() {
        return cantidadNieve;
    }
    /**
     * @param cantidadNieve the cantidadNieve to set
     */
    public void setCantidadNieve(BigDecimal cantidadNieve) {
        this.cantidadNieve = cantidadNieve;
    }
	
}

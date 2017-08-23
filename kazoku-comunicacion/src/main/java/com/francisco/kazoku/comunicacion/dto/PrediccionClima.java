package com.francisco.kazoku.comunicacion.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class PrediccionClima{
    
    private Date fecha;
    private BigDecimal temperatura;
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
	private BigDecimal visibilidad;
	private BigDecimal velocidadViento;
	private BigDecimal direccionViento;
	private BigDecimal velocidadRafagaViento;
	private BigDecimal nubosidad;
	private BigDecimal cantidadLluvia;
	private BigDecimal cantidadNieve;
	
	/**
	 * 
	 * @return the fecha
	 */
    public Date getFecha(){
        return fecha;
    }
    /**
     * 
     * @param fecha
     */
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    /**
     * @return the temperatura
     */
    public BigDecimal getTemperatura() {
        return temperatura;
    }
    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
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
     * @return the visibilidad
     */
    public BigDecimal getVisibilidad() {
        return visibilidad;
    }
    /**
     * @param velocidadViento the velocidadViento to set
     */
    public void setVisibilidad(BigDecimal visibilidad) {
        this.visibilidad = visibilidad;
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

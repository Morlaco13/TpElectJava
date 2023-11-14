package entidades;

import java.util.Date;

public class Envio {

	private String direccion;
	private Date fechaEnvio;
	private Integer costoEnvio;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Integer getCostoEnvio() {
		return costoEnvio;
	}
	public void setCostoEnvio(Integer costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
	
	
}

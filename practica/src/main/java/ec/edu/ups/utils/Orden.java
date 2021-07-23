package ec.edu.ups.utils;

public class Orden {

	private String nombre;
	private String apellido;
	private String cedula;
	private String estado;
	private Detalle detalle;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Detalle getDetalle() {
		return detalle;
	}
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "Orden [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", estado=" + estado
				+ ", detalle=" + detalle + "]";
	}
	
	
	
	
}

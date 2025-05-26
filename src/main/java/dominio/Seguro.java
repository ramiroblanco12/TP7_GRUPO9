package dominio;

public class Seguro {
	private int id;
	private String descripcion;
	private int idtipo;
	private float costoContracion;
	private float costoAsegurado;
	
	public Seguro() {}

	public Seguro(int id, String descripcion, int idtipo, float costoContracion, float costoAsegurado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idtipo = idtipo;
		this.costoContracion = costoContracion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public float getCostoContracion() {
		return costoContracion;
	}

	public void setCostoContracion(float costoContracion) {
		this.costoContracion = costoContracion;
	}

	public float getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", descripcion=" + descripcion + ", idtipo=" + idtipo + ", costoContracion="
				+ costoContracion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
}
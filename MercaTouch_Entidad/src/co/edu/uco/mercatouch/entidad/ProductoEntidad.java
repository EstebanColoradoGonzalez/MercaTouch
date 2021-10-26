package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "producto")
public class ProductoEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int codigo;
	@Column
	String nombre;
	@Column
	String descripcion;
	@Column
	double precio;
	@OneToOne
	CategoriaEntidad categoria;
	
	private ProductoEntidad(int codigo, String nombre, String descripcion, double precio, CategoriaEntidad categoria) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCategoria(categoria);
	}
	
	public static ProductoEntidad crear(int codigo, String nombre, String descripcion, double precio, CategoriaEntidad categoria)
	{
		return new ProductoEntidad(codigo, nombre, descripcion, precio, categoria);
	}
	
	public static ProductoEntidad crear()
	{
		return new ProductoEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CategoriaEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public ProductoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ProductoEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public ProductoEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public ProductoEntidad setPrecio(double precio) 
	{
		this.precio = precio;
		return this;
	}

	public CategoriaEntidad getCategoria() 
	{
		return categoria;
	}

	public ProductoEntidad setCategoria(CategoriaEntidad categoria) 
	{
		this.categoria = categoria;
		return this;
	}
}
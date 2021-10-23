package co.edu.uco.mercatouch.negocio.validador.implementacion.tienda;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DepartamentoValidoTiendaRegla implements Regla<TiendaDominio>
{
	private static final Regla<TiendaDominio> INSTANCIA = new DepartamentoValidoTiendaRegla();
	
	private DepartamentoValidoTiendaRegla()
	{
		super();
	}
	
	public static Regla<TiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(TiendaDominio dato) 
	{
		validarCiudadVacio(dato.getCiudad());
		validarLongitudCiudadValida(dato.getCiudad());
		validarCiudadContengaLetrasYEspacios(dato.getCiudad());
	}
	
	private void validarCiudadVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La ciudad de una tienda no puede estar vacio");
		}
	}
		
	private void validarLongitudCiudadValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("La ciudad de una tienda debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarCiudadContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La ciudad de una tienda solo puede contener letras y espacios");
		}
	}
}
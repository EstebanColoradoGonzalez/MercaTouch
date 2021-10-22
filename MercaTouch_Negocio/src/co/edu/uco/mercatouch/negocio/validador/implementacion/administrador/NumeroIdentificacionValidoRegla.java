package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class NumeroIdentificacionValidoRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new NumeroIdentificacionValidoRegla();
	
	private NumeroIdentificacionValidoRegla()
	{
		super();
	}
	
	public static Regla<AdministradorDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(AdministradorDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getNumeroIdentificacion());
	}
	
	private void validarCodigoEsMayorQueCero(long numeroIdentificacion)
	{
		if(UtilNumero.numeroEsMenorOIgual(numeroIdentificacion, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de identificacion de un Usuario no puede ser menor o igual que cero");
		}
	}
}

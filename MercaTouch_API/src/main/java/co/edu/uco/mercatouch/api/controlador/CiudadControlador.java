package co.edu.uco.mercatouch.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.mercatouch.api.controlador.respuesta.Respuesta;
import co.edu.uco.mercatouch.api.controlador.respuesta.enumerador.EstadoRespuestaEnum;
import co.edu.uco.mercatouch.dto.CiudadDTO;
import co.edu.uco.mercatouch.negocio.fachada.CiudadFachada;
import co.edu.uco.mercatouch.negocio.fachada.DepartamentoFachada;

@RestController
@RequestMapping("/api/ciudad")
@CrossOrigin(origins = "http://localhost:4200")
public class CiudadControlador 
{
	@Autowired
	CiudadFachada ciudadFachada;
	
	@Autowired
	DepartamentoFachada departamentoFachada;
	
	@GetMapping
	public ResponseEntity<Respuesta<CiudadDTO>> consultar()
	{
		ResponseEntity<Respuesta<CiudadDTO>> entidadRespuesta;
		Respuesta<CiudadDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<CiudadDTO> ciudades = ciudadFachada.consultar(CiudadDTO.crear());
				
			respuesta.setDatos(ciudades);
			respuesta.adicionarMensaje("Las Ciudades se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la informaci??n de las Ciudades");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		
		return entidadRespuesta;
	}
	
	@GetMapping("/{departamento}")
	public ResponseEntity<Respuesta<CiudadDTO>> consultar(@PathVariable String departamento)
	{
		ResponseEntity<Respuesta<CiudadDTO>> entidadRespuesta;
		Respuesta<CiudadDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<CiudadDTO> ciudades = ciudadFachada.consultar(CiudadDTO.crear());
			var ciudadesDTO = new ArrayList<CiudadDTO>();
			
			for(int i = 0; i < ciudades.size(); i++)
			{
				if(ciudades.get(i).getDepartamento().getNombre().equals(departamento)) 
				{
					ciudadesDTO.add(ciudades.get(i));
				}
			}
				
			respuesta.setDatos(ciudadesDTO);
			respuesta.adicionarMensaje("Las Ciudades se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la informaci??n de las Ciudades");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		
		return entidadRespuesta;
	}
}
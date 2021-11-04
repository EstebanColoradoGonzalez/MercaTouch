package co.edu.uco.mercatouch.datos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import co.edu.uco.mercatouch.entidad.PrecioEntidad;

@Repository
@Component
public interface PrecioDAO extends CrudRepository<PrecioEntidad, Integer>
{

}
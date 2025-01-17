package betoledo.contactos.repositorio;

import betoledo.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
/// CAPA REPOSITORIO
// de esta manera interactuaremos con nuestra base de datos (para realizar el crud)
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
}

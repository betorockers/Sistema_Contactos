package betoledo.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

///  CAPA ENTIDAD
// luego de conectar la base de datos a nuestras app,
// con el siguiente scripts creamos y le damos los atributos a nuestra nueva tabla
@Entity
@Data
@NoArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContacto;
    String nombre;
    String celular;
    String email;
}

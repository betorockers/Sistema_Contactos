package betoledo.contactos.servicio;

import betoledo.contactos.modelo.Contacto;
import betoledo.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
///  CAPA DE SERVICIO
///  aca implementaremos todos los metodos creados en la interfaz de contacto servicio
@Service
public class ContactoServicio implements IContactoServicio{
    // inyectaremos la capa de repositorio en nuestra capa de servicio
    @Autowired
    private ContactoRepositorio contactoRepositorio;


    @Override
    public List<Contacto> listarContactos() {
        // listaremos todos los contactos con el metodo findAll()
        return contactoRepositorio.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        /// utilizaremos el metodo findById para obtener el contacto deseado si lo encuentra
        /// de lo contrario solo retornara un valor nulo
        Contacto contacto = contactoRepositorio.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
    // utilizaremos el metodo save para guardar un nuevo contacto
        // si idContacto es nulo, de lo contrario actualiza la entrada
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        // para eliminar algun contacto utilizamos el metodo delete
        contactoRepositorio.delete(contacto);
    }
}

package betoledo.contactos.servicio;

import betoledo.contactos.modelo.Contacto;

import java.util.List;
///  CAPA DE INTERFAZ DE SERVICIO
/// aca agregaremos los metodos del CRUD de contacto
public interface IContactoServicio {
    // metodo de listar contactos(firma)
    public List<Contacto> listarContactos();

    // metodo buscar contacto por id
    public Contacto buscarContactoPorId(Integer idContacto);

    // metodo de guardar contacto (sera de tipo void)
    public void guardarContacto(Contacto contacto);

    // metodo elimiar contacto
    public void eliminarContacto(Contacto contacto);



}

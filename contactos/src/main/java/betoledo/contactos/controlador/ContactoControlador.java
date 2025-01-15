package betoledo.contactos.controlador;

import betoledo.contactos.modelo.Contacto;
import betoledo.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// para que esta clase se considere un controlador en spring debemos utilizar las siguientes notaciones
@Controller
public class ContactoControlador {
    /// definiremos una variable para mandar info al loger de nuestra apps
    /// y establecemos que mandaremos info desde esta misma clase y la pasamos como parametro
    /// este script muestra los registros en la consola
    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    /// inyectaremos nuestra clase servicio a la clase ContactoControlador

     // de esta manera se inyecta de manera automatica
    // con este atributo ya tendremos acceso directo a la capa de servicio
    // y comunicacion directa con la base de datos
    @Autowired
    ContactoServicio contactoServicio;

    // procesaremos la peticion de tipo URL
    @GetMapping("/") // aca indicamos la URL que queremos procesar

    // definiremos un metodo del tipo get
    public String iniciar(ModelMap modelo) {
        // recuperaremos una lista de objetos del tipo contacto
        List<Contacto> contactos = contactoServicio.listarContactos();
        // de esta manera mostramos el listado de nuestros objetos por consola mandandolo a imprimir
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index"; // index.html
    }

    ///  agregaremos un metodo del tipo get para confgurar el boton Agregar contacto
    @GetMapping("/agregar")

    public String mostrarAgregar(){
        return "agregar"; //  redirecciona a agregar.html
    }

    /// procesaremos una peticion de tipo post para nuestro fomulario de agregar contacto
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Contacto a agregar: " + contacto);
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; // redirigimos al controlador el path "/"
    }

}

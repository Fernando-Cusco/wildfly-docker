package ec.edu.ups.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ejb.EJB;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.utils.Login;
import ec.edu.ups.utils.Mensaje;
import ec.edu.ups.utils.Register;
import ec.edu.ups.utils.Usuario;

@Path("/cliente")
public class PersonResource {
	
	@EJB
    PersonaFacade personaFacade;

	
	private Persona persona;



	@POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/login")
    public Response inicioSesion(Login login) {
        persona = new Persona();
        persona = personaFacade.verificarUsuario(login.getCorreo());

        if(persona != null) {

            if (persona.getPassword().equals(login.getPassword()) && persona.isEstado()) {
                System.out.println("usuario encontrado");
                Usuario usuario = new Usuario();
                usuario.setId(persona.getId());
                usuario.setCorreo(persona.getCorreo());
                usuario.setPassword(persona.getPassword());
                usuario.setDireccion(persona.getDireccion());
                usuario.setCedula(persona.getCedula());
                usuario.setTelefono(persona.getTelefono());
                usuario.setNombre(persona.getNombre());
                usuario.setApellido(persona.getApellido());
                return Response.ok(usuario).build();
            }else {
                System.out.println("usuario  encontrado");
                return Response.ok("contrase�a incorrecto").build();
            }


        }else {
            return Response.status(404).entity("Usuario no encontrado").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/edit")
    public Response editar(Usuario usuario) {
    	Mensaje mensaje = new Mensaje();
        persona = new Persona();
        persona = personaFacade.buscarCliente(usuario.getCedula());

        if(persona != null) {
            Persona persona2 = new Persona();
            persona2 = personaFacade.buscarCliente(usuario.getCedula());
            persona2.setNombre(usuario.getNombre());
            persona2.setApellido(usuario.getApellido());
            persona2.setTelefono(usuario.getTelefono());
            persona2.setDireccion(usuario.getDireccion());
            persona2.setCorreo(usuario.getCorreo());
            persona2.setPassword(usuario.getPassword());

            try{
                personaFacade.edit(persona2);
                mensaje.setMensaje("Usuario modificado correctamente");
                mensaje.setEstado(true);
                return Response.ok(true).build();

            }catch (Exception e){
            	mensaje.setMensaje("Error no se puedo modificar el usuario");
                mensaje.setEstado(false);
                return Response.status(500).entity(mensaje).build();
            }

        }else{
        	mensaje.setMensaje("Usuario no encontrado");
            mensaje.setEstado(false);
            return Response.status(404).entity(mensaje).build();
        }
    }

    @PUT
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registro(Register register) {
    	Mensaje mensaje = new Mensaje();
        persona = new Persona();
        persona = personaFacade.buscarCliente(register.getCedula());
        if(persona != null){
            persona.setCorreo(register.getCorreo());
            persona.setPassword(register.getPassword());
            persona.setEstado(true);
            try{
                personaFacade.edit(persona);
                mensaje.setMensaje("Usuario regitrado");
                mensaje.setEstado(true);
                return Response.ok(mensaje).build();

            }catch (Exception e){
            	mensaje.setMensaje("Error al registrar el usuario");
                mensaje.setEstado(false);
                return Response.status(500).entity(mensaje).build();
            }
        }else{
        	mensaje.setMensaje("Usuario no encontrado");
            mensaje.setEstado(false);
            return Response.status(404).entity(mensaje).build();
        }
    }

    @PUT
    @Path("/anular/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response anularCliente(@PathParam("cedula") String cedula){
    	Mensaje mensaje = new Mensaje();
        persona = new Persona();
        persona = personaFacade.buscarCliente(cedula);
        if(persona != null){
            try{
                persona.setEstado(false);
                personaFacade.edit(persona);
                mensaje.setMensaje("Usuario eliminado");
                mensaje.setEstado(true);
                return Response.ok(mensaje).build();
            }catch (Exception e){
            	mensaje.setMensaje("Error al anular el usuario");
                mensaje.setEstado(false);
                return Response.status(500).entity(mensaje).build();
            }
        }else{
        	mensaje.setMensaje("Usuario no encontrado");
            mensaje.setEstado(false);
            return Response.status(404).entity("Usuario no encontrado").build();
        }
    }
    
    @GET
    @Path("/buscar/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("cedula") String cedula) {
    	 persona = new Persona();
         persona = personaFacade.buscarCliente(cedula);
         if(persona != null){
        	 Usuario usuario = new Usuario();
             usuario.setId(persona.getId());
             usuario.setCorreo(persona.getCorreo());
             usuario.setPassword(persona.getPassword());
             usuario.setDireccion(persona.getDireccion());
             usuario.setCedula(persona.getCedula());
             usuario.setTelefono(persona.getTelefono());
             usuario.setNombre(persona.getNombre());
             usuario.setApellido(persona.getApellido());
            return Response.ok(usuario).build();
         } else {
        	 return Response.status(404).entity("Usuario no encontrado").build();
         }
    }


	
	@GET
    @Path("/login/{correo}/{password}")
  //  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@PathParam("correo") String correo, @PathParam("password") String contrasena) throws IOException {
		persona = new Persona();
		persona = personaFacade.verificarUsuario(correo);
		
		if(persona != null) {
			
			if (persona.getPassword().equals(contrasena) && persona.isEstado()) {
				System.out.println("usuario encontrado");
			return Response.ok("Inicio de Sesion Correcto").build();
			}else {
				System.out.println("usuario  encontrado");
				return Response.ok("contrase�a incorrecto").build();
			}
	

		}else {
			return Response.status(404).entity("Usuario no encontrado").build();	
		}
		
    }




	
	@POST
    @Path("/registrar/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(@FormParam("cedula") String cedula, @FormParam("correo") String correo, @FormParam("contrase�a") String contrasena){
		persona = new Persona();
        persona = personaFacade.buscarCliente(cedula);
        
        if(persona != null){
            persona.setCorreo(correo);
            persona.setPassword(contrasena);
            persona.setEstado(true);
           
            try{
                personaFacade.edit(persona);
                return Response.ok("Usuario Registrado").build();
                
            }catch (Exception e){
                return Response.status(500).entity("Error al registrar usuario " + e).build();
            }
        }else{
            return Response.status(404).entity("Usuario no encontrado").build();
        }
    }
	
	
	@PUT
    @Path("/modificar/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(@FormParam("cedula") String cedula, @FormParam("nombre") String nombre,
                           @FormParam("apellido") String apellido, @FormParam("direccion") String direccion, @FormParam("telefono") String telefono,
                           @FormParam("correo") String correo, @FormParam("contrase�a") String contrasena){

		persona = new Persona();
        persona = personaFacade.buscarCliente(cedula);
        
		if(persona != null) {
			Persona persona2 = new Persona();
	        persona2 = personaFacade.buscarCliente(cedula);
	        persona2.setNombre(nombre);
	        persona2.setApellido(apellido);
	        persona2.setTelefono(telefono);
	        persona2.setDireccion(direccion);
	        persona2.setCorreo(correo);
	        persona2.setPassword(contrasena);
	        
			try{
                personaFacade.edit(persona2);
                return Response.ok("Usuario Modificado").build();
                
            }catch (Exception e){
                return Response.status(500).entity("Error al modificar usuario " + e).build();
            }
			
		}else{
            return Response.status(404).entity("Usuario no encontrado").build();
        }
    }
	
	
	
	@DELETE
    @Path("/anular/{cedula}")
   // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response anular(@PathParam("cedula") String cedula){
		
		persona = new Persona();
        persona = personaFacade.buscarCliente(cedula);
        
        if(persona != null){
            try{
            	persona.setEstado(false);
                personaFacade.edit(persona);
                return Response.ok("Usuario Anulado").build();
                
            }catch (Exception e){
                return Response.status(500).entity("Error al anular usuario " + e).build();
            }
        }else{
            return Response.status(404).entity("Usuario no encontrado").build();
        }
		
    }
	
	
	
	
	
	
	
	
    // Ejemplo con JSON

    @GET
    @Path("/login/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
    	
    	System.out.println("ver id + " + id);
//	Jsonb jsonb = JsonbBuilder.create();
	Persona person = new Persona(id, "Juan", "Cordova", "098654654", "Av Loja", "0980644260", "juan@gmail.com", "123456", 'A', true);
	return Response.ok(person, MediaType.APPLICATION_JSON).build();
    }

    /*
    

    @PUT
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJSON(String jsonPerson) {
	Jsonb jsonb = JsonbBuilder.create();
	Person person = jsonb.fromJson(jsonPerson, Person.class);

	System.out.println("REST/client:putJSON-->" + person);
	return Response.status(204).entity("Usuario actualizaado..." + person).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id") Integer id) {
	System.out.println("REST/client:delete-->" + id);
	return Response.status(204).entity("Usuario borrado..." + id).build();
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPersons() {
	
	Jsonb jsonb = JsonbBuilder.create();
	List<Person> list = new ArrayList<Person>();
	Person person1= new Person(1, "Pepito", "pepito@test.com", 20, LocalDate.of(2020, 6, 30),
		BigDecimal.valueOf(123.7));
	Person person2 = new Person(2, "Juanito", "juanito@test.com", 21, LocalDate.of(2020, 6, 30),
		BigDecimal.valueOf(223.1));
	Person person3 = new Person(3, "Jaimito", "jaimito@test.com", 22, LocalDate.of(2020, 6, 30),
		BigDecimal.valueOf(323.4));
	list.add(person1);
	list.add(person2);
	list.add(person3);
	
	// para evitar el error del CORS se agregan los headers
	return Response.ok(jsonb.toJson(list))
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    */
}
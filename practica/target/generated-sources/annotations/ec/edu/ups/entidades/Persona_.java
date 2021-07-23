package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> password;
	public static volatile SingularAttribute<Persona, Boolean> estado;
	public static volatile SingularAttribute<Persona, String> cedula;
	public static volatile SingularAttribute<Persona, String> apellido;
	public static volatile SingularAttribute<Persona, String> correo;
	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile ListAttribute<Persona, FacturaCabecera> facturasCab;
	public static volatile SingularAttribute<Persona, Integer> id;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> nombre;
	public static volatile ListAttribute<Persona, PedidoCabecera> pedidosCab;
	public static volatile SingularAttribute<Persona, Character> rol;

}


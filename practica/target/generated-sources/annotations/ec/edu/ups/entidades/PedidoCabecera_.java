package ec.edu.ups.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PedidoCabecera.class)
public abstract class PedidoCabecera_ {

	public static volatile SingularAttribute<PedidoCabecera, Date> fecha;
	public static volatile SingularAttribute<PedidoCabecera, String> estadoActual;
	public static volatile SingularAttribute<PedidoCabecera, Float> total;
	public static volatile SingularAttribute<PedidoCabecera, String> estado;
	public static volatile ListAttribute<PedidoCabecera, PedidoDetalle> pedidosDetale;
	public static volatile SingularAttribute<PedidoCabecera, String> estadoSiguiente;
	public static volatile SingularAttribute<PedidoCabecera, Persona> persona;
	public static volatile SingularAttribute<PedidoCabecera, Float> iva;
	public static volatile SingularAttribute<PedidoCabecera, Float> subtotal;
	public static volatile SingularAttribute<PedidoCabecera, Integer> id;

}


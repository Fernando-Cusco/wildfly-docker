package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PedidoDetalle.class)
public abstract class PedidoDetalle_ {

	public static volatile SingularAttribute<PedidoDetalle, Float> total;
	public static volatile SingularAttribute<PedidoDetalle, Integer> id;
	public static volatile SingularAttribute<PedidoDetalle, Integer> cantidad;
	public static volatile SingularAttribute<PedidoDetalle, Producto> producto;
	public static volatile SingularAttribute<PedidoDetalle, PedidoCabecera> pedidoCabecera;

}


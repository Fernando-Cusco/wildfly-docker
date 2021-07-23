package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, Float> precio;
	public static volatile SingularAttribute<Producto, Character> estado;
	public static volatile ListAttribute<Producto, Bodega> bodegas;
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	public static volatile SingularAttribute<Producto, Integer> id;
	public static volatile SingularAttribute<Producto, Integer> stock;
	public static volatile SingularAttribute<Producto, String> nombre;
	public static volatile ListAttribute<Producto, FacturaDetalle> facturaDetalles;
	public static volatile ListAttribute<Producto, PedidoDetalle> pedidoDetalle;

}


package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bodega.class)
public abstract class Bodega_ {

	public static volatile SingularAttribute<Bodega, Ciudad> ciudad;
	public static volatile SingularAttribute<Bodega, String> direccion;
	public static volatile SingularAttribute<Bodega, Integer> id;
	public static volatile SingularAttribute<Bodega, String> nombre;
	public static volatile ListAttribute<Bodega, Producto> productos;

}


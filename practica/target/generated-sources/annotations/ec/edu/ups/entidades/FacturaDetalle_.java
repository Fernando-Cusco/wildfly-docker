package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturaDetalle.class)
public abstract class FacturaDetalle_ {

	public static volatile SingularAttribute<FacturaDetalle, Float> total;
	public static volatile SingularAttribute<FacturaDetalle, FacturaCabecera> facturaCabecera;
	public static volatile SingularAttribute<FacturaDetalle, Integer> id;
	public static volatile SingularAttribute<FacturaDetalle, Integer> cantidad;
	public static volatile SingularAttribute<FacturaDetalle, Producto> producto;

}


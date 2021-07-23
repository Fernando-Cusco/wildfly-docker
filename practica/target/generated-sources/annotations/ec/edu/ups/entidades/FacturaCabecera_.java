package ec.edu.ups.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturaCabecera.class)
public abstract class FacturaCabecera_ {

	public static volatile SingularAttribute<FacturaCabecera, Date> fecha;
	public static volatile SingularAttribute<FacturaCabecera, Float> total;
	public static volatile SingularAttribute<FacturaCabecera, Character> estado;
	public static volatile SingularAttribute<FacturaCabecera, Persona> persona;
	public static volatile SingularAttribute<FacturaCabecera, Float> iva;
	public static volatile SingularAttribute<FacturaCabecera, Float> subtotal;
	public static volatile SingularAttribute<FacturaCabecera, Integer> id;
	public static volatile ListAttribute<FacturaCabecera, FacturaDetalle> facturasDetalle;

}


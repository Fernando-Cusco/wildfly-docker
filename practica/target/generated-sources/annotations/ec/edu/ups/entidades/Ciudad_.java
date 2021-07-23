package ec.edu.ups.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ciudad.class)
public abstract class Ciudad_ {

	public static volatile ListAttribute<Ciudad, Bodega> bodegas;
	public static volatile SingularAttribute<Ciudad, Integer> id;
	public static volatile SingularAttribute<Ciudad, Provincia> provincia;
	public static volatile SingularAttribute<Ciudad, String> nombre;

}


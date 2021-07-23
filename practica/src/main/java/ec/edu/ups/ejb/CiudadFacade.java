package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Ciudad;

@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext
    private EntityManager em;

    public CiudadFacade() {
        super(Ciudad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}


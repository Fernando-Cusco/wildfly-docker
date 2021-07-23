package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.FacturaDetalle;

@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {

    @PersistenceContext
    private EntityManager em;

    public FacturaDetalleFacade() {
        super(FacturaDetalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}


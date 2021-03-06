package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Producto;

@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

	@PersistenceContext
	private EntityManager em;

	public CategoriaFacade() {
		super(Categoria.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Categoria obtenerCategoriaPorID(Producto producto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.id=" + producto.getId();
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}

	public Categoria obtenerCategoriaPorNombre(String nombreProducto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.nombre= '" + nombreProducto + "'";
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}

	public Categoria obtenerCategoria(String nombreCategoria) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.nombre= '" + nombreCategoria + "'";
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}

	public List<Categoria> categoriasOrdenadas() {
		String jpql = "SELECT cat FROM Categoria cat ORDER BY cat.nombre";
		List<Categoria> cat = em.createQuery(jpql).getResultList();
		return cat;
	}
}

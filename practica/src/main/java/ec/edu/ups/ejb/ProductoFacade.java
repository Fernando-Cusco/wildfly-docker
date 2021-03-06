package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Producto;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

	@PersistenceContext
	private EntityManager em;

	public ProductoFacade() {
		super(Producto.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Producto> buscarPorNombre(String nombre) {
		List<Producto> productos = new ArrayList<Producto>();
		String consulta = "Select p From Producto p Where p.nombre like '%" + nombre + "%'";
		try {
			productos = em.createQuery(consulta).getResultList();
		} catch (Exception e) {
			System.out.println(">>>Warning (ProductoFacade:buscarPorNombre: )" + e.getMessage());
		}
		return productos;
	}

	public List<Producto> buscarPorNombreYBodega(String nombre, int id) {
		List<Producto> productos = new ArrayList<Producto>();
		String consulta = "Select p From Producto p Where p.nombre like '%" + nombre + "%' and p.bodegas.id=" + id;
		try {
			productos = em.createQuery(consulta).getResultList();
		} catch (Exception e) {
			System.out.println(">>>Warning (ProductoFacade:buscarPorNombre: )" + e.getMessage());
		}
		return productos;
	}
	
	
	
	
	public List<Producto> buscarBodega(int id) {
		List<Producto> productos = new ArrayList<Producto>();
		String consulta = "Select p From Producto p Where p.bodegas.id=" + id;
		try {
			productos = em.createQuery(consulta).getResultList();
		} catch (Exception e) {
			System.out.println(">>>Warning (ProductoFacade:buscarPorNombre: )" + e.getMessage());
		}
		return productos;
	}

	public List<Producto> buscarProductoPorCategoria(int categoria_id) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.id=" + categoria_id;
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> buscarProductoPorCategoriaYNombre(String categoriaNombre, String productoNombre) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.nombre='" + categoriaNombre
				+ "' AND pro.nombre='" + productoNombre + "'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> buscarProductoPorCategoriaNombreUnico(String categoriaNombre) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.nombre='" + categoriaNombre
				+ "' GROUP BY pro.nombre";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> productosOrdenadosAlfabeticamente() {
		String jpql = "SELECT pro FROM Producto pro ORDER BY pro.nombre ASC";

		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> buscarProductoPorNombre(String producto) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.estado != 'E' AND pro.nombre LIKE '" + producto + "%'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public List<Producto> buscarProductosGeneral() {

		String jpql = "SELECT sum(pro.stock) FROM Producto pro WHERE pro.estado != 'E' GROUP BY pro.nombre ORDER BY pro.nombre DESC";
		List<Long> stocks = em.createQuery(jpql).getResultList();

		String jpql2 = "SELECT max(pro.precio) FROM Producto pro WHERE pro.estado != 'E' GROUP BY pro.nombre ORDER BY pro.nombre DESC";
		List<Float> precios = em.createQuery(jpql2).getResultList();

		String jpql3 = "SELECT pro.nombre FROM Producto pro WHERE pro.estado != 'E' GROUP BY pro.nombre ORDER BY pro.nombre DESC";
		List<String> nombres = em.createQuery(jpql3).getResultList();

		List<Producto> productos = new ArrayList<Producto>();

		Bodega bodega = new Bodega();
		bodega.setNombre("General");
		List<Bodega> bodegas = new ArrayList<Bodega>();
		bodegas.add(bodega);

		for (int i = 0; i < stocks.size(); i++) {
			String jpql44 = "SELECT pro FROM Producto pro WHERE pro.nombre='" + nombres.get(i) + "'";
			List<Producto> categoria2 = em.createQuery(jpql44).getResultList();

			Producto pro = new Producto();
			pro.setNombre(nombres.get(i));
			pro.setBodegas(bodegas);
			pro.setCategoria(categoria2.get(0).getCategoria());
			pro.setPrecio(precios.get(i));

			System.out.println(stocks.get(i));
			int stock = Integer.parseInt(stocks.get(i) + "");
			System.out.println(stock);
			pro.setStock(stock);
			productos.add(pro);
		}

		return productos;
	}
	
	

	public List<Producto> buscarProductoPorCategoriaGeneral() {
		System.out.println("llega");
		String jpql = "SELECT pro FROM Producto pro ORDER BY pro.categoria.id";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}

	public Producto buscarProductoPorNombreUnico(String producto) {
		try {
			String jpql = "SELECT pro FROM Producto pro WHERE pro.estado != 'E' AND pro.nombre='" + producto + "'";
			Producto pro = (Producto) em.createQuery(jpql).getSingleResult();
			return pro;

		} catch (Exception e) {
			return null;
		}

	}
	
	public Producto buscarProducto(int id) {
		try {
			String jpql = "SELECT pro FROM Producto pro WHERE pro.estado != 'E' AND pro.id='" + id + "'";
			Producto pro = (Producto) em.createQuery(jpql).getSingleResult();
			return pro;

		} catch (Exception e) {
			return null;
		}

	}
}

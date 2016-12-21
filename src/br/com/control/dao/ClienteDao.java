package br.com.control.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.control.classes.Cliente;
import br.com.control.connections.Conexao;

public class ClienteDao {
	
	public int salva(Cliente cliente) {
		int id = -1;
		EntityManager em = Conexao.getConexao().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(cliente);
		tx.commit();
		em.close();
		
		return id;
	}
	
	public void exclui(Cliente cliente) {		
		EntityManager em = Conexao.getConexao().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.remove(em.getReference(Cliente.class, cliente.getId()));
		tx.commit();
		em.close();				
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> list(){
		List<Cliente> lista = null;
		try{						
			EntityManager em = Conexao.getConexao().createEntityManager();
			Query q = em.createQuery("select a from Cliente a", Cliente.class);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro wila: " + e.getMessage());
		}
		return lista;
	}

}

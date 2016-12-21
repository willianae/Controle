package br.com.control.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.control.classes.Usuario;
import br.com.control.connections.Conexao;

public class UsuarioDao {
	public int salva(Usuario usuario) {
		int id = -1;
		/* SALVA PELO HIBERNATE
		try {
			Session session = Conexao.getConexao().openSession();
			session.beginTransaction();
			id = (Integer) session.save(usuario);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Erro wila: " + e.getMessage());
		}*/
		
		EntityManager em = Conexao.getConexao().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(usuario);
		tx.commit();
		
		em.close();
				
		return id;
		
	}
	
	/*public Usuario getUsuarioById(int id){
		Usuario usuario = null;
		try {
			Session session = Conexao.getConexao().openSession();			
			usuario = (Usuario) session.get(Usuario.class, id);			
			session.close();
		} catch (Exception e) {
			System.out.println("Erro wila: " + e.getMessage());
		}
		return usuario;
	}
	
	*/	
	@SuppressWarnings("unchecked")
	public List<Usuario> list(){
		List<Usuario> lista = null;
		try{
			/*
			Session session = Conexao.getConexao().openSession();
			lista = (List<Usuario>) session.createCriteria(Usuario.class).list();
			*/
						
			EntityManager em = Conexao.getConexao().createEntityManager();
			Query q = em.createQuery("select a from Usuario a", Usuario.class);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro wila: " + e.getMessage());
		}
		return lista;
	}
	
}

package br.com.control.connections;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	//private static SessionFactory sessionFactory;
	//private static ServiceRegistry serviceRegistry;
	
	private static EntityManagerFactory entityManagerFactory;
	
	public Conexao(){
		
	}
	
	/* CONEXAO PELO HIBERNATE
	 * public static SessionFactory getConexao(){
		if (sessionFactory == null){
			// Abrindo conexão pelo Hibernate 4
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}
	*/
	
	public static EntityManagerFactory getConexao(){
		if (entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("default");
		}
		
		return entityManagerFactory;
	}
}

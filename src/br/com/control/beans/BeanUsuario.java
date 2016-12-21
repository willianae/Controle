package br.com.control.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.control.classes.FacesUtils;
import br.com.control.classes.Usuario;
import br.com.control.dao.UsuarioDao;

@ManagedBean
@ApplicationScoped
public class BeanUsuario {

	private Usuario usuario = new Usuario();
	private List<Usuario> listaUsuario;

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	 * public void logar(){ try{ SessionFactory sf = new
	 * Configuration().configure().buildSessionFactory(new
	 * StandardServiceRegistryBuilder().build()); Session session =
	 * sf.getCurrentSession(); session.beginTransaction();
	 * 
	 * session.save(usuario); session.getTransaction().commit();
	 * 
	 * addMessage("Informação", "Logado com sucesso!"); }catch(Exception e){
	 * addMessage(e.getMessage(), ""); }
	 * 
	 * addMessage("Informação", "Logado com sucesso!"); }
	 */

	public void logar(){
		UsuarioDao usuarioDao = new UsuarioDao();
		try{
			usuarioDao.salva(usuario);
			usuarioDao.list();
			FacesUtils.addMessage(usuario.getLogin(), usuario.getLogin());			
		}catch(Exception e){
			FacesUtils.addMessage("Ocorreu o seguinte erro: " + e.getMessage(), "");
		}
				
	}
	
	public void carregaLista(){
		UsuarioDao usuarioDao = new UsuarioDao();
		listaUsuario = usuarioDao.list();	
		
	}
	
	public void gotoCadastroCliente(){
		//return "cliente";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("pages/cadastroCliente.jsf");
		} catch (IOException e) {
			FacesUtils.addMessage("Erro", e.getMessage());
			e.printStackTrace();
		}
		
	}

}

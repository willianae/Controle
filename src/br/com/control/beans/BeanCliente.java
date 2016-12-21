package br.com.control.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.control.classes.Cliente;
import br.com.control.classes.FacesUtils;
import br.com.control.dao.ClienteDao;
import br.com.control.enums.EnumUF;

@ManagedBean
@SessionScoped
public class BeanCliente {
	private Cliente cliente = new Cliente();
	//private List<Cliente> listaClientes;
	private DataModel<Cliente> listaClientes;
	
	public BeanCliente(){
		getListaClientes();
	}
	
	public void novoCliente(){
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public DataModel<Cliente> getListaClientes() {
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> lista = clienteDao.list();
		listaClientes = new ListDataModel<Cliente>(lista);        
		return listaClientes;
	}
	public void setListaClientes(DataModel<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	/*
	public void carregaLista(){
		ClienteDao clienteDao = new ClienteDao();
		listaClientes = clienteDao.list();	
	}
	*/
	
	public void salvaCliente(){
		ClienteDao clienteDao = new ClienteDao();
		try{
			clienteDao.salva(cliente);
			cliente = new Cliente();
			getListaClientes();
			FacesUtils.addMessage("Cadastrado com sucesso!", "");			
		}catch(Exception e){
			FacesUtils.addMessage("Ocorreu o seguinte erro: " + e.getMessage(), "");
		}
				
	}		
	
	public void excluiCliente(Cliente cliente){
		ClienteDao clienteDao = new ClienteDao();
		try{
			clienteDao.exclui(cliente);			
			getListaClientes();
			FacesUtils.addMessage("Excluido com sucesso!", "");			
		}catch(Exception e){
			FacesUtils.addMessage("Ocorreu o seguinte erro: " + e.getMessage(), "");
		}
	}
	
	public void preparaAlterarCliente(ActionEvent actionEvent){
		cliente = (Cliente)(listaClientes.getRowData());
    }
	
	public void alteraCliente(){
		FacesUtils.addMessage(this.cliente.getNome(), "");
	}
	
	public EnumUF[] getUfs(){
		return EnumUF.values();
	}
	
	
	

}

package br.com.MeuRestaurante.infra;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import br.com.MeuRestaurante.model.Cliente;

public class ChamaWeb {
	
	private static String URI = "http://meurestaurantezsul.com.br/CadastroRestaurantes/cliente/";

	
	public Cliente getCliente(int id) throws Exception {
		String[] json = new WebService().get(URI + id);
		
		if(json[0].equals("200")){
			Gson gson = new Gson();
			Cliente cliente = gson.fromJson(json[1],Cliente.class);
			return cliente;
		}else{
			throw new Exception(json[1]);
		}
		
		
		
	}
	
	public ArrayList<Cliente> getListaCliente() throws Exception{
		
		String[] json = new WebService().get(URI + "listarTodos");
		
		
		if (json[0].equals("200")){
			
			Gson gson = new Gson();
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();
			
			for (int i = 0; i < array.size(); i++){
				clientes.add(gson.fromJson(array.get(i), Cliente.class));
			}
			return clientes;
			
		}else {
	        throw new Exception(json[1]);
		
		
		
		}
	}
}	

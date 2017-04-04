package br.com.MeuRestaurante.task;

import java.util.ArrayList;

import java.util.List;









import br.com.MeuRestaurante.activity.ListaRestaurante;

import br.com.MeuRestaurante.infra.ChamaWeb;
import br.com.MeuRestaurante.model.Cliente;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.sax.StartElementListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class BuscaLista extends AsyncTask<Void, Void, List<Cliente>> {

	
	private final Context context;
	ProgressDialog progress;
	private ListaRestaurante restaurante;	
	
	
	
	public BuscaLista(ListaRestaurante restaurante){
		context = restaurante;
		this.restaurante = restaurante;
	}

	

	@Override
	protected void onPreExecute() {
		
		progress = ProgressDialog.show(context, "Por favor Aguarde...",
				"Buscando Lista", true, true);
		super.onPreExecute();
	}

	@Override
	protected List<Cliente> doInBackground(Void... params)  {
		
		ChamaWeb web = new ChamaWeb();	
		ArrayList<Cliente> listaClientes = null;
		try {
			listaClientes = (ArrayList<Cliente>) web.getListaCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		return listaClientes;
		
		
	

	}

		
			
			
	
	
		@Override
		protected void onPostExecute(List<Cliente> result) {
			super.onPostExecute(result);
			progress.dismiss();
			
			restaurante.atualizaListaCom(result);
			
			
		
		}	

}

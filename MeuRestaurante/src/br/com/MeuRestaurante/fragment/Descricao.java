package br.com.MeuRestaurante.fragment;


import br.com.MeuRestaurante.activity.ListaRestaurante;
import br.com.MeuRestaurante.model.Cliente;

import com.example.meurestaurante.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Descricao extends Fragment {
	private Cliente cliente;
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.detalhes, container,
				false);
		if(getArguments() != null){
			this.cliente = (Cliente) getArguments().getSerializable("cliente");
		}
		
		if(this.cliente != null){
			
			
			
		TextView descricao = (TextView) rootView.findViewById(R.id.descricao);
					descricao.setText(this.cliente.getDescricao());
					
					
			
		}
		
		
		
		return rootView;
		
		
		
					
	
	
	}
	
}
	


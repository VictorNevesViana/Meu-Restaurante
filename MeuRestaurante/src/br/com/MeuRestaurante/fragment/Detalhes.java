package br.com.MeuRestaurante.fragment;

import br.com.MeuRestaurante.adapter.ListaRestauranteAdapter;
import br.com.MeuRestaurante.model.Cliente;

import com.example.meurestaurante.R;
import com.example.meurestaurante.R.id;
import com.example.meurestaurante.R.layout;
import com.example.meurestaurante.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class Detalhes extends Activity {
	private Cliente cliente;
	private ListaRestauranteAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhes);
		
		
		
		Intent intent = this.getIntent();
		
		 cliente = (Cliente) intent.getSerializableExtra("clienteSelecionados");
		
		 
				
				
				
				TextView descricao = (TextView) findViewById(R.id.descricao);
							descricao.setText(this.cliente.getDescricao());
		 
		
		 
		
		
		
		
		
		
		
		
		
		
		
	
	}
	


	
}

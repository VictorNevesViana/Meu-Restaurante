package br.com.MeuRestaurante.activity;


import br.com.MeuRestaurante.model.Cliente;

import com.example.meurestaurante.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class FormularioActivyti extends ActionBarActivity {

	private Cliente cliente;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);

			
		cliente = (Cliente) getIntent().getSerializableExtra("clienteSelecionado");
		
		
		
		Button botao = (Button) findViewById(R.id.botao);
		
		botao.setText("Voltar");
		
		
		
	}
	

}

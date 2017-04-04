package com.example.meurestaurante;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.os.Build;

public class ListaRestaurante extends ActionBarActivity {
	private ListView listaRestaurantes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_restaurante);

		String[] restaurantes = { "Minha comida", "Comida Favorita",
				"Comida Boa" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, restaurantes);

		this.listaRestaurantes = (ListView) findViewById(R.id.lista_restaurantes);
		listaRestaurantes.setAdapter(adapter);

		listaRestaurantes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Toast.makeText(ListaRestaurante.this,
						"Posição Selecionada" + posicao, Toast.LENGTH_LONG)
						.show();

			}

		});

		listaRestaurantes
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> adapter,
							View view, int posicao, long id) {

						String restaurante = (String) adapter
								.getItemAtPosition(posicao);
						Toast.makeText(ListaRestaurante.this,
								"Clique Longo:" + restaurante,
								Toast.LENGTH_LONG).show();

						return true;
					}

				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);

		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case R.id.menu_pizzarias:
			Intent intent = new Intent(this, ListaPizzarias.class);
			startActivity(intent);
			return false;
		default:
		return super.onOptionsItemSelected(item);
		
		}
	}

}

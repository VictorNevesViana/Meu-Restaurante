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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.os.Build;

public class ListaPizzarias extends ActionBarActivity {
	private ListView listaPizzarias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_pizzarias);

		String[] restaurantes = { "Pizzaria Pacheco", "Pizzaria Santos",
				"Pizzaria Lago Sul" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, restaurantes);

		this.listaPizzarias = (ListView) findViewById(R.id.lista_pizzarias);
		listaPizzarias.setAdapter(adapter);

		listaPizzarias.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Toast.makeText(ListaPizzarias.this,
						"Posição Selecionada" + posicao, Toast.LENGTH_LONG)
						.show();

			}

		});

		listaPizzarias
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> adapter,
							View view, int posicao, long id) {

						String pizzarias = (String) adapter
								.getItemAtPosition(posicao);
						Toast.makeText(ListaPizzarias.this,
								"Clique Longo:" + pizzarias, Toast.LENGTH_LONG)
								.show();

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
		case R.id.menu_restaurantes:
			Intent intent = new Intent(this, ListaRestaurante.class);
			startActivity(intent);
			return false;
		default:
		return super.onOptionsItemSelected(item);
		}

	}
}	

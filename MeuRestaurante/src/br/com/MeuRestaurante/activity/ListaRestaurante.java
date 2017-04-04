package br.com.MeuRestaurante.activity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import br.com.MeuRestaurante.adapter.ListaRestauranteAdapter;
import br.com.MeuRestaurante.fragment.Descricao;
import br.com.MeuRestaurante.fragment.Detalhes;
import br.com.MeuRestaurante.fragment.MapaFragment;
import br.com.MeuRestaurante.infra.ChamaWeb;
import br.com.MeuRestaurante.model.Cliente;
import br.com.MeuRestaurante.task.BuscaLista;
import com.example.meurestaurante.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ListaRestaurante extends FragmentActivity {
	private ListView listaRestaurantes;
	private Cliente clienteSelecionado;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_restaurante);
		
		this.listaRestaurantes = (ListView) findViewById(R.id.lista_restaurantes);
		
		new BuscaLista(this).execute();
		
		registerForContextMenu(listaRestaurantes);
		
		
				
		listaRestaurantes.setOnItemLongClickListener(new OnItemLongClickListener() {

			

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				clienteSelecionado = (Cliente) adapter.getItemAtPosition(posicao);
				return false;
			}
		});
		
		listaRestaurantes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {
				
				if(isTablet()){
					Bundle argumentos = new Bundle();
					argumentos.putSerializable("cliente", (Cliente) listaRestaurantes.getItemAtPosition(posicao));
					Descricao descricao = new Descricao();
					descricao.setArguments(argumentos);
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					ft.replace(R.id.detalhes_view, descricao);
					ft.commit();
				}else{
				
				Intent intent = new Intent(ListaRestaurante.this, Detalhes.class);
				intent.putExtra("clienteSelecionados",(Cliente) listaRestaurantes.getItemAtPosition(posicao));
				startActivity(intent);
				}
				
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
		switch (item.getItemId()) {
		case R.id.menu_pizzarias:
			Intent intent = new Intent(this, ListaPizzarias.class);
			startActivity(intent);
			
		case R.id.menu_mapa:
			Intent mapa = new Intent(this,MostraRestaurantesProximos.class);
			startActivity(mapa);
			
			return false;
		default:
			return super.onOptionsItemSelected(item);

		}
	}
	
	public void atualizaListaCom(List<Cliente> clientes){
		ListaRestauranteAdapter adapter = new ListaRestauranteAdapter(this, clientes);
		listaRestaurantes.setAdapter(adapter);	
		
		

	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuItem ligar = menu.add("Ligar");
		
		Intent intentLigar = new Intent(Intent.ACTION_CALL);
		intentLigar.setData(Uri.parse("tel:"+clienteSelecionado.getTelefone()));
		ligar.setIntent(intentLigar);
		
		
	MenuItem site =	 menu.add("Navegar no site");
	
	Intent intentSite = new Intent(Intent.ACTION_VIEW);
	String http = clienteSelecionado.getSite().contains("http://")?"":"http:";
	intentSite.setData(Uri.parse(http+clienteSelecionado.getSite()));
	site.setIntent(intentSite);
	
	MenuItem acharnoMapa = menu.add("Achar no Mapa");
	Intent intentMapa = new Intent(Intent.ACTION_VIEW);
	intentMapa.setData(Uri.parse("geo:0,0?z=14&q"+clienteSelecionado.getEndereco()));
	acharnoMapa.setIntent(intentMapa);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	
	public boolean isTablet(){
		return getResources().getBoolean(R.bool.isTablet);
	}
	
		
}

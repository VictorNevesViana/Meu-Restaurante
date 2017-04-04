package br.com.MeuRestaurante.activity;

import br.com.MeuRestaurante.fragment.MapaFragment;
import br.com.MeuRestaurante.model.Cliente;

import com.example.meurestaurante.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MostraRestaurantesProximos extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.map_layout);
		
		
		MapaFragment mapaFragment = new MapaFragment();
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.mapa, mapaFragment);
		ft.commit();
	}

	
}

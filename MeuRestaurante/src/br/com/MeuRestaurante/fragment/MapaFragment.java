package br.com.MeuRestaurante.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView.FindListener;

import br.com.MeuRestaurante.model.Cliente;
import br.com.MeuRestaurante.util.Localizador;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends SupportMapFragment {
	
	LatLng local;

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		local = new LatLng(-23.716683, -46.778028);
		
		this.centralizaNo(local);
	}

	private void centralizaNo(LatLng local) {
		GoogleMap mapa = getMap();
		mapa.addMarker(new MarkerOptions().title("Pizzaria x")
				.snippet("A Melhor da Região").position(local));
		mapa.addMarker(new MarkerOptions().title("Restaurante Minha Comida")
				.snippet("A sua Comida").position(new LatLng(-23.717449, -46.779594)));
		mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 17));

	}

}

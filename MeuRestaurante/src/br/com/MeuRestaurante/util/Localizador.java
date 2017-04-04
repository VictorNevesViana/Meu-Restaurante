package br.com.MeuRestaurante.util;

import java.io.IOException;
import java.util.List;




















import com.google.android.gms.maps.model.LatLng;




import android.content.Context;
import android.location.Address;
import android.location.Geocoder;



public class Localizador {
	private Geocoder geo;
	
	public Localizador (Context context){
		geo = new Geocoder(context);
	}
	
	public LatLng getCoordenada(String endereco){
		List<Address> listaEnderecos; 
		try {
			
			listaEnderecos = geo.getFromLocationName(endereco, 1);
			
			if(!listaEnderecos.isEmpty()){
				Address address = listaEnderecos.get(0);
				return new LatLng(address.getLatitude(), address.getLongitude());
			}else{
			return null;	
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
		
	}
	

}

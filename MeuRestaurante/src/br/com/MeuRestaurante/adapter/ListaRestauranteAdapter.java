package br.com.MeuRestaurante.adapter;

import java.util.List;

import com.example.meurestaurante.R;
import com.loopj.android.image.SmartImageView;

import br.com.MeuRestaurante.model.Cliente;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListaRestauranteAdapter extends BaseAdapter {
	private final List<Cliente> clientes;
	private final Activity activity;
	private SmartImageView imagem;
	
	public ListaRestauranteAdapter(Activity activity, List<Cliente> clientes){
		this.activity = activity;
		this.clientes = clientes;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return clientes.size();
	}

	@Override
	public Object getItem(int posicao) {
		// TODO Auto-generated method stub
		return clientes.get(posicao);
	}

	@Override
	public long getItemId(int posicao) {
		// TODO Auto-generated method stub
		return clientes.get(posicao).getId();
	}

	@Override
	public View getView(int posicao, View convertView, ViewGroup parent) {
View view = activity.getLayoutInflater().inflate(R.layout.item, null);
		
		if(posicao % 2 == 0){
			view.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
		}
		
		Cliente cliente = clientes.get(posicao);
		
		imagem = (SmartImageView) view.findViewById(R.id.imagem);
		imagem.setImageUrl(cliente.getImagem());
		
		TextView nome = (TextView) view.findViewById(R.id.nome);
		nome.setText(cliente.getNome());
		
		TextView telefone = (TextView) view.findViewById(R.id.telefone);
		telefone.setText(cliente.getTelefone());
		
		TextView endereco = (TextView) view.findViewById(R.id.endereco);
		endereco.setText(cliente.getEndereco());
		
		TextView site = (TextView) view.findViewById(R.id.site);
		site.setText(cliente.getSite());
		
		
		
		return view;
	}
		
	
}

package com.example.trabalho;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdutoImagem extends Activity{
	
	TextView nome, preco;
	ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produto_imagem);
		
		MainActivity m = new MainActivity();
		
		nome = (TextView) findViewById(R.id.nome);
		preco = (TextView) findViewById(R.id.preco);
		img = (ImageView) findViewById(R.id.imageView1);
		
		Bundle extras = getIntent().getExtras();
		int posicao = extras.getInt("posicao");

		nome.setText(m.produtos[posicao].getNome());
		preco.setText(""+ m.produtos[posicao].getPreco());
		img.setImageResource(m.produtos[posicao].getImagemId());

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		

	}


}
package com.example.trabalho;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Produtos p1 = new Produtos("caderno", 10.0, R.drawable.caderno, "127035240760");
	Produtos p2 = new Produtos("manteiga", 5.30, R.drawable.manteiga, "138055651547");
	Produtos p3 = new Produtos("toddy", 5.30, R.drawable.t, "5503242343430");
	
	Produtos [] produtos = {p1,p2,p3};
	Button button1;
	GridView gvImagens;
	boolean existe;
	int pos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		gvImagens = (GridView) findViewById(R.id.gvimagens);
		gvImagens.setAdapter(new ProdutoAdapter(this));
		button1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
	
	public MainActivity(){
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  existe=false;
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		  if (scanResult != null) {
		    String barCode;
		    
		    barCode = scanResult.getContents();
		    for(int i=0;i<produtos.length;i++){
		    	if(produtos[i].getCod_Barra().equals(barCode)){
		    		pos = i;
		    		existe = true;
		    	}

		  }
		    

	}
if(existe == true){
    		Intent j = new Intent(getApplicationContext(), ProdutoImagem.class);
    		j.putExtra("posicao", pos);
    		startActivity(j);
    	}
    	else
    		Toast.makeText(getApplicationContext(),"Produto não encontrado",Toast.LENGTH_SHORT).show();
    		
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
		
	}
	
	
	public class ProdutoAdapter extends BaseAdapter{

		private Context context;
		
		public ProdutoAdapter(Context c){
			context = c;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return produtos.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView im;
			if(arg1 == null){
				im = new ImageView(context);	
				im.setLayoutParams(new GridView.LayoutParams(150, 150));
			}
			else {
				im = (ImageView) arg1;
			}
			im.setImageResource(produtos[arg0].getImagemId());
			return im;
		}

		
	}

}

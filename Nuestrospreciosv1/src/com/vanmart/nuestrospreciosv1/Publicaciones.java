package com.vanmart.nuestrospreciosv1;

import com.vanmart.nuestrospreciosv1.GalleryView.ImageAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;

public class Publicaciones extends Activity {
String negocios[] = {"101 perros","juanValdez","manillasHippie","chessCake","ZonaRefresacnte"};
Integer[] IDsimagenes = {R.drawable.juanvaldez,
        R.drawable.perros,
        R.drawable.arturocalle,
        R.drawable.biohazard,
        R.drawable.cinecolombia,
        R.drawable.macdonalds,
        R.drawable.qbano
        };
private Button verLista;
private Button administrar,salir;
@Override
    public void onCreate(Bundle savedInstanceState) {
	    
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);
        verLista = (Button) findViewById(R.id.botonverlista);
        administrar = (Button) findViewById(R.id.administrar);
        salir = (Button) findViewById(R.id.salir);
        //setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,negocios));    
        
        
        
        Gallery galeria = (Gallery) findViewById(R.id.galerianegocios);
        galeria.setAdapter(new ImageAdapter(this));

        
        
        
        
        
        /*
        verLista.setOnClickListener(new OnClickListener() {
        		
        		public void onClick(View v) {
        			// TODO Auto-generated method stub
        			Intent intent = new Intent (Publicaciones.this,ListaDePrecios.class);
        	    	//EditText passw =(EditText)findViewById(R.id.pass);
        		  	
        	    	//String pass = passw.getText().toString();
        	    	//intent.putExtra(EXTRA_MESSAGE, pass); 
        	    	startActivity(intent);
        			
        		}

				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
        		
        	});
*/
        
        galeria.setOnItemClickListener(new OnItemClickListener() {
            
            public void onItemClick(AdapterView<?>parent,View v, int position,long id){
            	 Toast.makeText(getBaseContext(),"negocio"+(position+1)+"seleccionado",
            			 Toast.LENGTH_SHORT).show();
            	 
            	 ImageView imageView = (ImageView) findViewById(R.id.imagen);
            	 imageView.setImageResource(IDsimagenes[position]);
            }
            	
    		});
        
        
        
        
        
     
        
    }
	
	public class ImageAdapter extends BaseAdapter{
		private Context contexto;
		private int itemBackground;
		
		public ImageAdapter(Context c){
			contexto = c;
			//Configuracion de estilo
			TypedArray a = obtainStyledAttributes(R.styleable.Galeria);
			itemBackground = a.getResourceId(R.styleable.Galeria_android_galleryItemBackground, 0);
			a.recycle();
			
		}
		
		public int getCount(){
			return IDsimagenes.length;
		}
		
		
		
		public long getItemId(int position){
			return position;
		}
		
		/*si queremos que al pulzar aparesca la imagen mas grande*/
		public View getView(int position,View convertirView,ViewGroup parent){
			
			ImageView imageView = new ImageView(contexto);
			imageView.setImageResource(IDsimagenes[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position; 
		}
        
    
    }
    
    public void onListItemClik(ListView parent,View v,int position,long id){
    	
    Toast.makeText(this,"ome aka va la lista de precios"+negocios[position],Toast.LENGTH_SHORT).show();	
    }

    public void onClickVerLista(View view){
    	//EditText passw =(EditText)findViewById(R.id.pass);
    	Intent intent = new Intent (Publicaciones.this,ListaDePrecios.class);
    	
    	//String pass = passw.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, pass); 
    	startActivity(intent);
    }
    
    public void onClickAdministrar(View view){
    	//EditText passw =(EditText)findViewById(R.id.pass);
    	Intent intent = new Intent (Publicaciones.this,login.class);
    	
    	//String pass = passw.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, pass); 
    	startActivity(intent);
    }
    
    public void onClickSalirAdm(View view){
          finish();
    }
    
}

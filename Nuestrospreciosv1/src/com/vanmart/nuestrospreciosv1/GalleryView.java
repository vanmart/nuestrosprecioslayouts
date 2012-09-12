package com.vanmart.nuestrospreciosv1;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryView extends Activity {

    Integer[] IDsimagenes = {R.drawable.juanvaldez,
    		                 R.drawable.perros,
    		                 R.drawable.arturocalle,
    		                 R.drawable.biohazard,
    		                 R.drawable.cinecolombia,
    		                 R.drawable.macdonalds,
    		                 R.drawable.qbano
    		                 };
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listanegociosimagenes);
        Gallery galeria = (Gallery) findViewById(R.id.galerianegocios);
        galeria.setAdapter(new ImageAdapter(this));
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

 
    
}

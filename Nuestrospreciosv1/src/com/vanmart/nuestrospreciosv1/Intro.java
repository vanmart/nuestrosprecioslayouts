package com.vanmart.nuestrospreciosv1;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class Intro extends Activity {
//mejor declarar privadas las variables que utilizaras
	private ImageView imagen,by,titulo;
	//private TextView titulo;
	private Button boton;
	 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    
    imagen = (ImageView) findViewById(R.id.vandeimagenintro);    
    by = (ImageView) findViewById(R.id.imagen_byvande);
    titulo = (ImageView) findViewById(R.id.titulo);
    boton = (Button) findViewById(R.id.botonintro);

    
    boton.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			accionAnimar(v);
			Intent intent = new Intent (Intro.this,Publicaciones.class);
	    	//EditText passw =(EditText)findViewById(R.id.pass);
		  	
	    	//String pass = passw.getText().toString();
	    	//intent.putExtra(EXTRA_MESSAGE, pass); 
	    	startActivity(intent);
			
		}
		
	
    });
    
    imagen.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		    	Intent intent = new Intent(Intro.this, Publicaciones.class);
		    	startActivity(intent);
		    
		}
	});
    
    titulo.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
				accionAnimar(v);
			
		}
	});
    

   
    
	}

	public void accionAnimar(View v){
		Animation rotar = AnimationUtils.loadAnimation(this,R.anim.rotar);
		rotar.reset();
		
		switch (v.getId()) {
		case R.id.vandeimagenintro:
			Animation escalar = AnimationUtils.loadAnimation(this,R.anim.escalar);  
			escalar.reset();
			imagen.startAnimation(escalar);
			break;
		
		case R.id.botonintro:
			Animation rotacion = AnimationUtils.loadAnimation(this,R.anim.rotar);
            rotacion.reset();
            imagen.startAnimation(rotacion);
            break;
        
		case R.id.titulo:
			Animation rotacion1 = AnimationUtils.loadAnimation(this,R.anim.rotar);
            rotacion1.reset();
            imagen.startAnimation(rotacion1);
            break;
		default:
			break;
		}
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_intro, menu);
        return true;
    }

    
}

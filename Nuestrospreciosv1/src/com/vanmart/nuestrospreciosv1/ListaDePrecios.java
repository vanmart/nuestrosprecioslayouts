package com.vanmart.nuestrospreciosv1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class ListaDePrecios extends Activity {
Button volver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_precios);
        volver = (Button)findViewById(R.id.volver);   
     
       
        
        
    }

    public void onClickVolver(View view){
    	//EditText passw =(EditText)findViewById(R.id.pass);
    	Intent intent = new Intent (ListaDePrecios.this,Publicaciones.class);
    	
    	//String pass = passw.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, pass); 
    	startActivity(intent);
    }

    
}

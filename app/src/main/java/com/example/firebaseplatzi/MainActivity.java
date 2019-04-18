package com.example.firebaseplatzi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

        private TextView tvdescuento;
        private Button suscribeAndroid,suscribeFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        tvdescuento = (TextView) findViewById(R.id.tvMensaje);
        suscribeAndroid = (Button) findViewById(R.id.suscribirse);
        suscribeFirebase = (Button) findViewById(R.id.suscribeFirebase);

        tvdescuento.setVisibility(View.GONE);

        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_SHORT).show();

        if(getIntent().getExtras() != null){
            tvdescuento.setVisibility(View.VISIBLE);
            String descount = getIntent().getExtras().getString(PlatziFirebaseMessaginService.KEY_DESCOUNT);
            tvdescuento.append(descount);
        }

    }

    public void suscribeAndroid(View v){
        FirebaseMessaging.getInstance().subscribeToTopic("Android");
        Toast.makeText(getApplicationContext(), "Felicidades te suscribiste a android", Toast.LENGTH_SHORT).show();

    }
    public void suscribeFirebase(View v){

        FirebaseMessaging.getInstance().subscribeToTopic("Firebase");
        Toast.makeText(getApplicationContext(), "Felicidades te suscribiste a firebase", Toast.LENGTH_SHORT).show();
    }
}

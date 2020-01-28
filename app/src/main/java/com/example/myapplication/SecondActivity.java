package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Question b) //
        /*
        Intent intent = getIntent();
        String var = "";
        if (intent != null) {
            var = intent.getStringExtra("variable") ;
            TextView textView = (TextView) findViewById(R.id.textView1);
            textView.setText(var);
        }*/

        // Question c) //

        onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null){
            String var = savedInstanceState.getString("variableBundle");
            TextView textView = (TextView) findViewById(R.id.textView1);
            textView.setText(var);
        }

        popUp("onCreate()");
    }
    /** =============================================================
     * Exécuté que l'activité arrêtée via un "stop" redémarre.
     *
     * La fonction onRestart() est suivie de la fonction onStart().
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }
    /** ==============================================================
     * Exécuté lorsque l'activité devient visible à l'utilisateur.
     *
     * La fonction onStart() est suivie de la fonction onResume().
     */
    @Override
    protected void onStart() {
        super.onStart();
        popUp("onStart()");
    }
    /** ==============================================================
     * Exécutée à chaque passage en premier plan de l'activité.
     * Ou bien, si l'activité passe à nouveau en premier
     * (si une autre activité était passée en premier plan entre temps).
     *
     * La fonction onResume() est suivie de l'exécution de l'activité.
     */
    @Override
    protected void onResume() {
        super.onResume();
        popUp("onResume()");
    }
    /** =============================================================
     * La fonction onPause() est suivie :
     * - d'un onResume() si l'activité passe à nouveau en premier plan
     * - d'un onStop() si elle devient invisible à l'utilisateur
     *
     * L'exécution de la fonction onPause() doit être rapide,
     * car la prochaine activité ne démarrera pas tant que l'exécution
     * de la fonction onPause() n'est pas terminée.
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
    }
    /** ==============================================================
     * La fonction onStop() est exécutée :
     * - lorsque l'activité n'est plus en premier plan
     * - ou bien lorsque l'activité va être détruite
     *
     * Cette fonction est suivie :
     * - de la fonction onRestart() si l'activité passe à nouveau en premier plan
     * - de la fonction onDestroy() lorsque l'activité se termine
     *    ou bien lorsque le système décide de l'arrêter
     */
    @Override
    protected void onStop() {
        super.onStop();
        popUp("onStop()");
    }
    /** =============================================================
     * Cette fonction est exécutée lorsque l'activité se termine ou bien lorsque
     * le système décide de l'arrêter.
     *
     * La fonction onCreate() devra à nouveau être exécutée pour obtenir à nouveau l'activité.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        popUp("onDestroy()");
    }

    public void popUp(String message) {
        Toast.makeText(this, message+" from activity 2", Toast.LENGTH_LONG).show();
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String valeur = savedInstanceState.getString("variableBundle");
    }
}
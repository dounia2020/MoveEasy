package com.example.moveeasy;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class page6 extends AppCompatActivity {
    private EditText edi1 = null;
    private EditText edi2 = null;
    private EditText edi10 = null;
    private EditText N = null;
    private EditText emaill = null;
    private EditText pass= null;
    private EditText edi4 = null;
    private EditText edi3 = null;
    private EditText ad = null;
    private EditText sex = null;
    private Button butto = null;
    private FirebaseAuth mAuth;
    String Nom = null;
    String Prénom = null;
    String Date_De_Naissance = null;
    String N_Téléphone = null;
    String Gmail = null;
    String Mot_De_Passe = null;
    String Spécialité = null;
    String Diplôme = null;
    String Adresse = null;
    String Sexe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//This line hides the action bar
        setContentView(R.layout.activity_page6);

        mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        edi1 = (EditText) findViewById(R.id.edi1);
        edi2 = (EditText) findViewById(R.id.edi2);
        edi10 = (EditText) findViewById(R.id.edi10);
        N= (EditText) findViewById(R.id.N);
        emaill = (EditText) findViewById(R.id.emaill);
        pass = (EditText) findViewById(R.id.pass);
        edi4 = (EditText) findViewById(R.id.edit4);
        edi3 = (EditText) findViewById(R.id.edi3);
        ad = (EditText) findViewById(R.id.ad);
        sex = (EditText) findViewById(R.id.sex);
        butto = (Button) findViewById(R.id.btn);
        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }



    private void registerUser() {

        if (isValidData()) {
            //MediaRouteButton progressBar = null;
            //progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(Gmail, Mot_De_Passe)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Médecin user = new Médecin(Nom, Prénom, Date_De_Naissance, N_Téléphone, Gmail,Spécialité, Diplôme, Adresse, Sexe);

                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("donateur").child("Gmail");
                                reference.child("Nom").setValue(Nom);
                                reference.child("Prénom").setValue(Prénom);
                                reference.child("Date_De_Naissance").setValue(Date_De_Naissance);
                                reference.child("Spécialité").setValue(Spécialité);
                                reference.child("N_Téléphone").setValue(N_Téléphone);
                                reference.child("Gmail").setValue(Gmail);
                                reference.child("Diplôme").setValue(Diplôme);
                                reference.child("Adresse").setValue(Adresse);
                                reference.child("Sexe").setValue(Sexe)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {

                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(page6.this, "user has been registered Successfully ", Toast.LENGTH_LONG).show();


                                                } else {
                                                    Toast.makeText(page6.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();

                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(page6.this, "Failed to register", Toast.LENGTH_LONG).show();

                            }

                        }
                    });

        }
    }

    private boolean isValidData() {
        return false;
    }
}
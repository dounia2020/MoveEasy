package com.example.moveeasy;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class page7 extends AppCompatActivity {

    private VideoView simpleVideoView;
    private VideoView vrVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        // Initialisation des VideoViews
        //simpleVideoView = findViewById(R.id.simpleVideoView);
        //vrVideoView = findViewById(R.id.vrVideoView);
    }

    public void onEditTextClicked(View view) {
        String videoType = "";
/*
        switch (view.getId()) {
            case R.id.btn_kinesitherapie:
            case R.id.btn_Rééducation_neurologique:
            case R.id.btn_Rééducation_respiratoire:
            case R.id.btn_Rééducation_cardiaque:
            case R.id.btn_Ergothérapie:
            case R.id.btn_Rééducation_vestibulaire:
            case R.id.btn_Rééducation_en_psychomotricité:
            case R.id.btn_Rééducation_posturale_globale_RPG:
                videoType = "simple"; // Ou "vr" pour la réalité virtuelle
                break;
        }
*/
        // Afficher la vidéo correspondante
        if ("simple".equals(videoType)) {
            // Affichez la vidéo simple
            simpleVideoView.setVisibility(View.VISIBLE);
            vrVideoView.setVisibility(View.GONE);
            // Ici, vous devrez charger et démarrer votre vidéo simple.
            // Par exemple :
            // simpleVideoView.setVideoPath("chemin_vers_votre_video.mp4");
            // simpleVideoView.start();
        } else if ("vr".equals(videoType)) {
            // Affichez la réalité virtuelle
            vrVideoView.setVisibility(View.VISIBLE);
            simpleVideoView.setVisibility(View.GONE);
            // Ici, vous devrez charger et démarrer votre vidéo en réalité virtuelle.
            // Par exemple :
            // vrVideoView.setVideoPath("chemin_vers_votre_video_vr.mp4");
            // vrVideoView.start();
        } else {
            Toast.makeText(this, "Aucune vidéo trouvée pour ce type de rééducation", Toast.LENGTH_SHORT).show();
        }
    }
}

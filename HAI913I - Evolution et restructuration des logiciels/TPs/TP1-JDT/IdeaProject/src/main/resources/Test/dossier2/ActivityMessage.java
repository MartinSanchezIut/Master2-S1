package Test.dossier2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.projetmobile.Model.Annonce;
import com.google.gson.Gson;

public class ActivityMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);



    }
}
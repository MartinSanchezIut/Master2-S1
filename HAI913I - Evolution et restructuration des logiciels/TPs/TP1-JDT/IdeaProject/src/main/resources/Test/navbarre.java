package Test;

import Test.dossier1.Acceuille;
import Test.dossier1.ActivityConversation;
import Test.dossier1.dossier12.DetailAnnonce;
import Test.dossier2.ActivityMessage;
import Test.dossier2.AjouterAnnonce;
import Test.dossier2.Connexion;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.example.projetmobile.BDD.models.Controllers.UserControlers;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class navbarre extends Fragment {
    private static final long GAME_LENGTH_MILLISECONDS = 3000;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    private static final String TAG = "MyActivity";

    private InterstitialAd interstitialAd;
     BottomNavigationView bottomNavigationView;
    public navbarre() {

    }




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_navbarre, container, false);
        bottomNavigationView = root.findViewById(R.id.bottomNavigationView);
        UserControlers userControlers = new ViewModelProvider(this).get(UserControlers.class);
        userControlers.init(getContext());
        if(userControlers.Count()==0) {
            bottomNavigationView.inflateMenu(R.menu.bottom_navigation_view);
        }else{
            bottomNavigationView.inflateMenu(R.menu.bottom_navigation_view_connecter);
        }
        String c = getContext().getClass().getName();
        if (Acceuille.class.getName().equals(c) || Recherche.class.getName().equals(c) || DetailAnnonce.class.getName().equals(c)) {
            bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
        } else if (Inscription.class.getName().equals(c)) {
            bottomNavigationView.getMenu().findItem(R.id.navigate_inscription).setChecked(true);
        } else if (Profil.class.getName().equals(c) || ActivityMessage.class.getName().equals(c) || ActivityConversation.class.getName().equals(c) ) {
            bottomNavigationView.getMenu().findItem(R.id.navigate_profile).setChecked(true);
        } else if (Connexion.class.getName().equals(c)) {
            bottomNavigationView.getMenu().findItem(R.id.navigation_connexion).setChecked(true);
        } else if (AjouterAnnonce.class.getName().equals(c)) {
            bottomNavigationView.getMenu().findItem(R.id.navigate_publication).setChecked(true);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> updateMainFragment(item.getItemId()));
        return root;
    }
    private Boolean updateMainFragment(Integer integer){
        switch (integer) {
            case R.id.navigation_home:
                startActivity(new Intent(getActivity().getApplication(), Acceuille.class));
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.navigate_inscription:
                startActivity(new Intent(getActivity().getApplication(), Inscription.class));
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.navigate_profile:
                startActivity(new Intent(getActivity().getApplication(), Profil.class));
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.navigation_connexion:
                startActivity(new Intent(getActivity().getApplication(), Connexion.class));
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.navigate_publication:
                startActivity( new Intent(getActivity().getApplication(), AjouterAnnonce.class));
                getActivity().overridePendingTransition(0, 0);
                break;
        }
        return true;
    }


}

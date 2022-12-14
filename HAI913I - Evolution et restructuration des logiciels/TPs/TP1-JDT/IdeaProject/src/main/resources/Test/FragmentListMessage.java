package Test;

import Test.dossier1.ActivityConversation;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.example.projetmobile.BDD.models.Controllers.UserControlers;
import com.example.projetmobile.Model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentListMessage extends Fragment {


    private GridView listView ;
    private ArrayList<MessageAffichage> message;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_message, container, false);
        listView = (GridView ) root.findViewById(R.id.gridView);
        UserControlers userControlers = new ViewModelProvider(getActivity()).get(UserControlers.class);
        userControlers.init(getContext());
        long id = userControlers.getPlanning().get(0).getId_user();
        String result = null;
        try {
            serveur s = new serveur("message/MessageByIdAnnonceur");
             result = s.PostRequest(String.valueOf(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Gson gson = new Gson();
        message = gson.fromJson(result, new TypeToken<ArrayList<MessageAffichage>>(){}.getType());
        /*
        for(MessageAffichage m : message) {
            System.out.println(m.getTitreAnnonce());
        }

         */

        ListMessageAdaptater myAdapter=new ListMessageAdaptater(getContext(),message);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
        {

            Gson gson = new Gson();
            String result = null;
            try {
                serveur s = new serveur("message/ConversationById");
                result = s.PostRequest(String.valueOf(message.get(position).getId_conversation()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Intent intention= new Intent(getContext(), ActivityConversation.class);
            intention.putExtra("Conversation",result);
            startActivity(intention);

        }
        });
        return root;
    }

}

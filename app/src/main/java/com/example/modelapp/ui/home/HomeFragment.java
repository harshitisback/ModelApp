package com.example.modelapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modelapp.Adapters.OngoingAdapter;
import com.example.modelapp.Adapters.UpcommingAdapter;
import com.example.modelapp.Models.OngoingModel;
import com.example.modelapp.Models.UpcommingModel;
import com.example.modelapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView up_rec;
    RecyclerView on_rec;
    FirebaseFirestore db;

    public  HomeFragment() {

    }



    // upcomming events
    List<UpcommingModel> upcommingModelList;
    UpcommingAdapter upcommingAdapter;

    // ongoing events
    List<OngoingModel> ongoingModelList;
    OngoingAdapter ongoingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        db = FirebaseFirestore.getInstance();

        up_rec = root.findViewById(R.id.upc_rec);
        on_rec = root.findViewById(R.id.ongoing_rec);

        // upcomiing evets set
        up_rec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        upcommingModelList = new ArrayList<>();
        upcommingAdapter = new UpcommingAdapter(getActivity(),upcommingModelList);
        up_rec.setAdapter(upcommingAdapter);

        db.collection("UpcommingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                UpcommingModel upcommingModel = document.toObject(UpcommingModel.class);
                                upcommingModelList.add(upcommingModel);
                                upcommingAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });

// ongoing event set
        on_rec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
        ongoingModelList = new ArrayList<>();
        ongoingAdapter = new OngoingAdapter(getActivity(),ongoingModelList);
        on_rec.setAdapter(ongoingAdapter);


        db.collection("OngoingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                OngoingModel ongoingModel = document.toObject(OngoingModel.class);
                                ongoingModelList.add(ongoingModel);
                                ongoingAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });













        return root;
    }


}
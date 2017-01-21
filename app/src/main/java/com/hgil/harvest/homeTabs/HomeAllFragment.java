package com.hgil.harvest.homeTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hgil.harvest.R;
import com.hgil.harvest.adapter.RecylerSampleAdapter;
import com.hgil.harvest.retrofit.RetrofitService;
import com.hgil.harvest.retrofit.RetrofitUtil;
import com.hgil.harvest.retrofit.loginResponse.loginResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAllFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeAllFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
/*    public static HomeAllFragment newInstance(String param1, String param2) {
        HomeAllFragment fragment = new HomeAllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    public static HomeAllFragment newInstance() {
        HomeAllFragment fragment = new HomeAllFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_all, container, false);
    }

    @BindView(R.id.myRecycler)
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mRecyclerView = (RecyclerView) view.findViewById(R.id.myRecycler);

        ButterKnife.bind(this, view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> myDataset = new ArrayList<>();
        myDataset.add("Ankush");
        myDataset.add("Kumar");
        myDataset.add("Bist");
        myDataset.add("Suriender");
        myDataset.add("Manish");
        myDataset.add("Mohan");

        // specify an adapter (see also next example)
        mAdapter = new RecylerSampleAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    /*retrofit call test example*/
    public void getCallLogs() {

        RetrofitUtil.showDialog(getActivity());
        RetrofitService service = RetrofitUtil.retrofitClient();
        Call<loginResponse> apiCall = service.postUserLogin("username", "password");
        apiCall.enqueue(new Callback<loginResponse>() {
            @Override
            public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                RetrofitUtil.hideDialog();

                //ResponseBody bodyResponse = response.body();

                // rest call to read data from api service
                if (true) {

                } else {
                    RetrofitUtil.showToast(getActivity(), "Error login");
                }
            }

            @Override
            public void onFailure(Call<loginResponse> call, Throwable t) {
                RetrofitUtil.hideDialog();

                // show some error toast or message to display the api call issue
                RetrofitUtil.showToast(getActivity(), "Unable to access API");

            }
        });

    }
}

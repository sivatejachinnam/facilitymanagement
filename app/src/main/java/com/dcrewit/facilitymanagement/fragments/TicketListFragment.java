package com.dcrewit.facilitymanagement.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dcrewit.facilitymanagement.R;
import com.dcrewit.facilitymanagement.activities.AddTicket;
import com.dcrewit.facilitymanagement.adapters.TicketListAdapter;
import com.dcrewit.facilitymanagement.models.TicketListItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TicketListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TicketListFragment ticketListFragment;
    private TicketListAdapter ticketListAdapter;
    private FloatingActionButton addTicket;
    private List<TicketListItem> ticketList = new ArrayList<>();
    public TicketListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_ticket_list, container, false);
        ticketListFragment = new TicketListFragment();

        ticketListAdapter = new TicketListAdapter(ticketList);
        addTicket = (FloatingActionButton) view.findViewById(R.id.fab_addticket);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_ticket);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ticketListAdapter);

        TicketListItem ticketListItem = new TicketListItem("1","Ticket1","client1","Done","15/10/2019");
        ticketList.add(ticketListItem);
        ticketListItem = new TicketListItem("2","Ticket2","client2","Done","15/10/2019");
        ticketList.add(ticketListItem);
        ticketListItem = new TicketListItem("3","Ticket3","client3","Done","15/10/2019");
        ticketList.add(ticketListItem);
        ticketListAdapter.notifyDataSetChanged();

        addTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddTicket.class);
                startActivityForResult(intent,1);
            }
        });

        return view;
    }

}

package com.dcrewit.facilitymanagement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dcrewit.facilitymanagement.R;
import com.dcrewit.facilitymanagement.models.TicketListItem;

import java.util.List;

public class TicketListAdapter extends RecyclerView.Adapter<TicketListAdapter.ViewHolder> {
    private List<TicketListItem> ticketListItemList;
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtViewticketId,txtViewTicketDesc,txtViewAssignedTo,txtViewticketStatus,txtViewCreatedDate;

        ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewticketId = itemLayoutView.findViewById(R.id.ticketIdtv);
            txtViewTicketDesc = itemLayoutView.findViewById(R.id.ticketDesctv);
            txtViewAssignedTo = itemLayoutView.findViewById(R.id.assignedTotv);
            txtViewticketStatus = itemLayoutView.findViewById(R.id.ticketStatustv);
            txtViewCreatedDate = itemLayoutView.findViewById(R.id.createdDatetv);
        }
    }

    public TicketListAdapter(List<TicketListItem> ticketListItemList) {
        this.ticketListItemList = ticketListItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ticketlist, parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        TicketListItem ticketListItem = ticketListItemList.get(position);
        holder.txtViewticketId.setText( ticketListItem.getTicketId());
        holder.txtViewTicketDesc.setText(ticketListItem.getTicketDes());
        holder.txtViewAssignedTo.setText(ticketListItem.getAssignedTo());
        holder.txtViewticketStatus.setText(ticketListItem.getTicketStatus());
        holder.txtViewCreatedDate.setText(ticketListItem.getCreatedDate());
    }
    @Override
    public int getItemCount() {
        return ticketListItemList.size();
    }
}


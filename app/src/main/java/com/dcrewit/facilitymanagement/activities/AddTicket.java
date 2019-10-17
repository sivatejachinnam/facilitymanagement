package com.dcrewit.facilitymanagement.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dcrewit.facilitymanagement.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class AddTicket extends AppCompatActivity {

    private TextInputEditText ticketDesc,assignedTo,ticketStatus,createdDate;
    private Button addNewTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ticket);

        ticketDesc = (TextInputEditText)findViewById(R.id.edittext_ticketdesc);
        assignedTo = (TextInputEditText)findViewById(R.id.edittext_assignedTo);
        ticketStatus = (TextInputEditText)findViewById(R.id.edittext_ticketstatus);
        createdDate = (TextInputEditText)findViewById(R.id.edittext_createdDate);
        addNewTicket = (Button) findViewById(R.id.btn_addTicket);

        addNewTicket=(Button)findViewById(R.id.btn_addTicket);
        addNewTicket.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String td=ticketDesc.getText().toString().trim();
                String assign=assignedTo.getText().toString().trim();
                String ticketstatus=ticketStatus.getText().toString().trim();
                String cd=createdDate.getText().toString().trim();
                addNewTicket(td,assign,ticketstatus,cd);
            }

            private void addNewTicket(final String td,final String assign,final String ticketStatus,final String cd) {
                Log.d("assa", "addNewTicket:12 ");
                RequestQueue addticket= Volley.newRequestQueue(AddTicket.this);
                StringRequest request=new StringRequest(Request.Method.POST,Api.ROOT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("server", "response" + response.toString());
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("server",
                                        "not connected data");
                            }
                        }){
                    protected Map<String, String> getParams(){

                        Map<String, String> Params=new HashMap<>();
                        Params.put("ticketDesc",td);
                        Params.put("assignTo",assign);
                        Params.put("ticketstatus",ticketStatus);
                        Params.put("createDate",cd);

                        return Params;
                                            }
                };
                addticket.add(request);
//
            }
        });
    }

}

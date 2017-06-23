package com.example.home.firefest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Act1 extends AppCompatActivity implements View.OnClickListener {

    private Firebase mref;
    private String url1="https://firefest-9d28b.firebaseio.com/";
    Button var11,var21;
    TextView ques1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        ques1= (TextView) findViewById(R.id.ques1);

        var11= (Button) findViewById(R.id.var1);
        var21= (Button) findViewById(R.id.var2);

        mref = new Firebase(url1);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot

                    Person person = postSnapshot.getValue(Person.class);
                    //Adding it to a string
                    String string = " qus:-" + person.getques() +  "\n\n";

                    String st1=""+person.getvar1();
                    String st2=""+person.getvar2();


                    //Displaying it on textview
                    if(person.getques()!=null)
                       ques1 .setText(string);


                    if(person.getques2()!=null)
                        var11.setText(st1);

                    if(person.getques3()!=null)
                        var21.setText(st2);

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(Act1.this,"NO INTERNET CONNECTION",Toast.LENGTH_LONG).show();
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        var11.setOnClickListener(this);
        var21.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.var1: {
                Toast.makeText(Act1.this,  "var1 selected", Toast.LENGTH_LONG).show();

                break;
            }


            case R.id.var2: {
                Toast.makeText(Act1.this, "var2 selected", Toast.LENGTH_LONG).show();

                break;
            }
        }

    }
}

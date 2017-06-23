package com.example.home.firefest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Firebase mref;
    private String url1="https://firefest-9d28b.firebaseio.com/";
    Button cen,cen1,cen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(MainActivity.this);
        cen = (Button) findViewById(R.id.cv);
        cen1 = (Button) findViewById(R.id.cv1);
        cen2 = (Button) findViewById(R.id.cv2);
        mref = new Firebase(url1);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Toast.makeText(MainActivity.this,"part11",Toast.LENGTH_LONG).show();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot

                    Person person = postSnapshot.getValue(Person.class);
                    //Adding it to a string
                    String string = "News:1-: " + person.getques() +  "\n\n";

                    String string2="News:2-: " +  person.getques2()+ "\n\n";

                    String string3="News:2-: " +  person.getques3()+ "\n\n";

                    //Displaying it on textview
                    if(person.getques()!=null)
                        cen.setText(string);

                    if((person.getques()==null) )
                        cen.setText("No news ");

                    if(person.getques2()!=null)
                        cen1.setText(string2);

                    if(person.getques3()!=null)
                        cen2.setText(string3);

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(MainActivity.this,"NO INTERNET CONNECTION",Toast.LENGTH_LONG).show();
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


        cen.setOnClickListener(this);
        cen1.setOnClickListener(this);
        cen2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch(v.getId())
        {
            case R.id.cv: {
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(MainActivity.this,Act1.class));
                break;
            }


            case R.id.cv1: {
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,Act2.class));
                break;
            }

            case R.id.cv2: {
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,Act3.class));
                break;

            }
            }


    }



}

package compiler.vizdot.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetWebSeriesPath();
    }

    private void GetWebSeriesPath() {

        try {
            Firebase.setAndroidContext(Objects.requireNonNull(this));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Firebase ref;
        ref = new Firebase("https://luffer-5cdef.firebaseio.com/path");
        ref.keepSynced(true);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try {
                    String webSeriesPath = dataSnapshot.child("webseries").getValue().toString();

                    System.out.println("\n all path : " +webSeriesPath);

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("\n error : " +firebaseError.getMessage());

            }



        });
    }
}
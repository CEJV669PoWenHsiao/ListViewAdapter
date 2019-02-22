package cejv669.concordia.com.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> myList = new ArrayList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");

        final ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);

        ListView lv = findViewById(R.id.list_view_results);

        lv.setAdapter(itemsAdapter);

        Button addNum = findViewById(R.id.btnAddNum);

        addNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(String.valueOf((int)(Math.random()*100+1)));
                itemsAdapter.notifyDataSetChanged();
            }
        });

        Button addChar = findViewById(R.id.btnAddChar);

        addChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                char c = (char)(r.nextInt(26) + 'a');
                itemsAdapter.add(String.valueOf(c));
            }
        });

        Button sort = findViewById(R.id.btnSort);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        });
    }
}

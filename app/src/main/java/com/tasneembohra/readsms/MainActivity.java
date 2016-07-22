package com.tasneembohra.readsms;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create Sent box URI
        Uri sentURI = Uri.parse("content://sms/sent");

        // List required columns
        String[] reqCols = new String[] { "_id", "address", "body" };

        // Get Content Resolver object, which will deal with Content Provider
        ContentResolver cr = getContentResolver();

        // Fetch Sent SMS Message from Built-in Content Provider
        Cursor c = cr.query(sentURI, reqCols, null, null, null);
        c.moveToNext();
        Log.d(TAG, c.getString(c.getColumnIndex("address")));
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView sender;
            TextView text;

            public ItemViewHolder(View itemView) {
                super(itemView);
                sender = (TextView)itemView.findViewById(R.id.sender);
                text = (TextView)itemView.findViewById(R.id.text);
            }
        }
    }
}

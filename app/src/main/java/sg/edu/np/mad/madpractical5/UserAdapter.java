package sg.edu.np.mad.madpractical5;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> users;

    ListActivity activity;

    public UserAdapter(ArrayList<User> users, ListActivity activity) {
        this.users = users;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_activity_list,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String tempName = users.get(position).getName();
        holder.name.setText(tempName);
        holder.desc.setText(users.get(position).getDescription());
        int last = Integer.parseInt(tempName.substring(tempName.length() - 1));
        if (last == 7){
            holder.bigImage.setVisibility(View.VISIBLE);
        } else {
            holder.bigImage.setVisibility(View.GONE);
        }
        holder.smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Profile");
                builder.setMessage(users.get(position).getName());
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = new Intent(activity, MainActivity.class);
                        intent.putExtra("name", users.get(position).getName());
                        intent.putExtra("desc", users.get(position).getDescription());
                        intent.putExtra("follow", users.get(position).getFollowed());
                        activity.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

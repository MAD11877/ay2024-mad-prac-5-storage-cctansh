package sg.edu.np.mad.madpractical5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView smallImage;
    ImageView bigImage;
    TextView name;
    TextView desc;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        smallImage = itemView.findViewById(R.id.smallImage);
        bigImage = itemView.findViewById(R.id.bigImage);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.desc);
    }
}

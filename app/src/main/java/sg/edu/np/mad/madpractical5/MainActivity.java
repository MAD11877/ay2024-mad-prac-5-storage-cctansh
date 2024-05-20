package sg.edu.np.mad.madpractical5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);

        Intent intent = getIntent();
        User user = (User) getIntent().getSerializableExtra("user");

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView btnFollow = findViewById(R.id.btnFollow);
        TextView btnMessage = findViewById(R.id.btnMessage);

        tvName.setText(user.getName());
        tvDescription.setText(user.getDescription());
        if (user.getFollowed()) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!user.getFollowed()) {
                    btnFollow.setText("Unfollow");
                    user.setFollowed(true);
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    Log.i("btnFollow", "onClick: Followed");
                } else {
                    btnFollow.setText("Follow");
                    user.setFollowed(false);
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    Log.i("btnFollow", "onClick: Unfollowed");
                }
                db.updateUser(user);
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgIntent);
            }
        });
    }
}
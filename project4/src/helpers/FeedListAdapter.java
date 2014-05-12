package helpers;
 
import java.util.ArrayList;
import java.util.List;
 
import com.example.project4.R;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class FeedListAdapter extends BaseAdapter {
    private LayoutInflater li;
 
    //holds Message objects
    private List<Message> messages = new ArrayList<Message>();
 
    public FeedListAdapter(Context context, List<Message> messages2)
    {
        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(messages2 != null)
            messages = messages2;
    }
 
    public int getCount() {
        return messages.size();
    }
 
    public Object getItem(int position) {
        return messages.get(position);
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View v = convertView;
        final Message message = messages.get(position);
        if (v == null) {
            v = li.inflate(R.layout.activity_main, null);
        }
 
        final TextView mTitle = (TextView) v.findViewById(R.id.mLine1);
        mTitle.setText(message.getTitle());
 
        final TextView mAddress = (TextView) v.findViewById(R.id.mLine2);
        mAddress.setText(message.getDescription());
 
        return v;
    }
}

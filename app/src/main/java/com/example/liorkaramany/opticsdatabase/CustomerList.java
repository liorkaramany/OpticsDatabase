package com.example.liorkaramany.opticsdatabase;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Lior Karamany
 * @version 1.0
 * @since 1.0
 */
public class CustomerList extends ArrayAdapter<Customer> {

    /**
     * The activity that every item in the list will show.
     */
    private Activity context;
    /**
     * The list of customers that the list will display.
     */
    private List<Customer> customerList;

    /**
     * Create a CustomerList object.
     * <p>
     * Create a CustomerList object with a given activity and a list of customers.
     * </p>
     *
     * @param  context The activity that every item in the list will show.
     * @param  customerList The list of customers that the list will display.
     * @return A reference to the new CustomerList object.
     */
    public CustomerList(Activity context, List<Customer> customerList)
    {
        super(context, R.layout.list_layout, customerList);
        this.context = context;
        this.customerList = customerList;
    }


    /**
     * Get the view of the ListView.
     * <p>
     * Get the view of the ListView (what it shows immediately after it's connected to the adapter).
     * </p>
     *
     * @param  position The position of an item in the list.
     * @return The view of the ListView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView name = (TextView) listViewItem.findViewById(R.id.name);
        TextView age = (TextView) listViewItem.findViewById(R.id.age);
        TextView left = (TextView) listViewItem.findViewById(R.id.left);
        TextView right = (TextView) listViewItem.findViewById(R.id.right);
        TextView price = (TextView) listViewItem.findViewById(R.id.price);

        ImageView img = (ImageView) listViewItem.findViewById(R.id.img);

        Customer customer = customerList.get(position);

        name.setText(customer.getName());
        age.setText(""+customer.getAge());
        left.setText(""+customer.getLeft());
        right.setText(""+customer.getRight());
        price.setText(""+customer.getPrice());

        if (!customer.getUrl().equals("")) {
            Picasso.get().load(customer.getUrl()).fit().centerInside().into(img);
            img.setRotation(90);
            name.setVisibility(View.GONE);
            age.setVisibility(View.GONE);
            left.setVisibility(View.GONE);
            right.setVisibility(View.GONE);
            price.setVisibility(View.GONE);
        }
        else
            img.setVisibility(View.GONE);

        return listViewItem;
    }
}

package productions.darthplagueis.midtermassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private View rootView;
    private TextView textView;


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_numbers, container, false);
        textView = (TextView) rootView.findViewById(R.id.numbersfrag_textview);
        Bundle bundle = getArguments();
        String bundleText = bundle.get("text").toString();
        textView.setText(bundleText);
        return rootView;
    }

}

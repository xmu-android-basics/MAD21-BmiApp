package io.github.xmu_android_basics.bmiapp_2021;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.xmu_android_basics.bmiapp_2021.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "====================";

//    private List<Double> bmiRecord = new ArrayList<>();
//    private double[] doubles = {};

    BmiViewModel bmiViewModel;

    ActivityMainBinding _binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        _binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());

//        getSupportFragmentManager().beginTransaction()
//                .add(new AddFragment.newInstance(""), "")
//                .commit();


        _binding.fabGotoAdd.setOnClickListener(v -> {
            // TODO 导航到 AddActivity
            Intent addIntent = new Intent(this, AddActivity.class);
            addIntent.putExtra("EXTRA", "BBBB");
            startActivity(addIntent);


//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_SEND);
//            intent.putExtra(Intent.EXTRA_TEXT, "BMI");
//            intent.setType("text/plain");
//
//            if (intent.resolveActivity(getPackageManager()) != null) {
//                startActivity(intent);
//            }
        });


//        if (null != savedInstanceState) {
//            bmiRecord = (List<Double>) savedInstanceState.getSerializable("bmi_record");
//            Log.w(LOG_TAG, savedInstanceState.getString("my_data"));
//        } else {
//        }

        BmiAdapter adapter = new BmiAdapter();

        RecyclerView recyclerView = _binding.bmiList;
        recyclerView.setAdapter(adapter);

        bmiViewModel = new ViewModelProvider(this).get(BmiViewModel.class);
        bmiViewModel.getBmiRecord().observe(this, new Observer<List<BmiRecord>>() {
            @Override
            public void onChanged(List<BmiRecord> bmiRecords) {
                adapter.setBmi(bmiRecords);
            }
        });

        Log.w(LOG_TAG, "created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _binding = null;
        Log.w(LOG_TAG, "destroyed");
    }

    public void calculateBmi(View view) {
        final double heightValue = Double.parseDouble(_binding.editHeight.getText().toString());
        final double weightValue = Double.parseDouble(_binding.editWeight.getText().toString());

        if (0 != heightValue) {
            double bmi = weightValue / heightValue / heightValue;
            BmiRecord b = new BmiRecord(weightValue, bmi);
            b.setType(BmiRecord.Type.FEMALE);
            bmiViewModel.addBmiRecord(b);
        }

    }

    private void renderBmiRecord(TextView placeholder, List<Double> bmiRecord) {
        StringBuffer sb = new StringBuffer();
        for (Double bmi : bmiRecord) {
            sb.append(bmi + "\n");
        }

        placeholder.setText(sb.toString());
    }
}
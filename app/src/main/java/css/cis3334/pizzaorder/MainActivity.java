package css.cis3334.pizzaorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    CheckBox chkbxCheese;
    CheckBox chkbxDelivery;
    TextView txtTotal;
    TextView txtStatus;
    Spinner spinnerToppings;
    Button  orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);

        chkbxCheese = (CheckBox) findViewById(R.id.checkBoxCheese);
        chkbxDelivery = (CheckBox) findViewById(R.id.checkBoxDeluvery);

        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);
        spinnerToppings = (Spinner) findViewById(R.id.spinnerToppings);

        orderButton = (Button) findViewById(R.id.buttonOrder);

        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String topping = spinnerToppings.getSelectedItem().toString();
                String size = "large";
                if (rbSmall.isChecked()) {
                    size = "small";
                }
                if (rbMedium.isChecked()) {
                    size = "medium";
                }
                Pizza orderedPizza = new Pizza(topping, size, chkbxCheese.isChecked());
                // Call the pizza activity using an intent
                Intent detailActIntent = new Intent(v.getContext(), PizzaActivity.class);
                detailActIntent.putExtra("orderedPizza", orderedPizza);
                startActivity(detailActIntent);
            }
        });
    }

    public void onClickOrder(View view) {
        String topping = spinnerToppings.getSelectedItem().toString();
        String size = "large";
        if (rbSmall.isChecked()) {
            size = "small";
        }
        if (rbMedium.isChecked()) {
            size = "medium";
        }
        Pizza orderedPizza = new Pizza(topping, size, chkbxCheese.isChecked());
        // Call the pizza activity using an intent
        Intent detailActIntent = new Intent(this, PizzaActivity.class);
        detailActIntent.putExtra("orderedPizza", orderedPizza);
        startActivity(detailActIntent);
    }


}

package css.cis3334.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PizzaActivity extends AppCompatActivity {

    TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        textViewDescription = (TextView) findViewById(R.id.textViewDescription);

        Bundle extras = getIntent().getExtras();
        Pizza orderedPizza = (Pizza) extras.getSerializable("orderedPizza");
        textViewDescription.setText(orderedPizza.toString());

    }
}

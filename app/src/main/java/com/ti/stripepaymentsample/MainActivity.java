package com.ti.stripepaymentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView addPayment, creditcard;
    TextView amount, creditCardText;
    int REQUEST_CODE = 0077;
    Button checkOut;
    public String stripe_token = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPayment = (CardView) findViewById(R.id.addPayment);
        creditCardText = (TextView) findViewById(R.id.credit_card_text);
        creditcard = (CardView) findViewById(R.id.credit_card);
        checkOut = (Button) findViewById(R.id.checkout);

        addPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddPayment.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == resultCode){

            creditcard.setVisibility(View.VISIBLE);
            stripe_token = data.getStringExtra("stripe_token");

            if(stripe_token.length()>1)
                checkOut.setVisibility(View.VISIBLE);

            creditCardText.setText(data.getStringExtra("cardtype")+" card ending with "+data.getStringExtra("card"));

        }

    }
}

package com.dias.course.application.ui.pay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dias.course.R;
import com.dias.course.application.network.ApiClient;
import com.dias.course.application.network.ApiResponse;
import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.network.json.IRISResponseModel;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Serializable data = getIntent().getExtras().getSerializable("data");
        ProductsJsonModel jsonModel = (ProductsJsonModel) data;

        TextView textView = findViewById(R.id.pay_title);
        textView.setText(jsonModel.getName());

        ImageView imageView = findViewById(R.id.pay_img);
        imageView.setImageResource(getImage(jsonModel.getSlug()));

        Button button = findViewById(R.id.pay_btn);
        button.setText(getString(R.string.pay_button_with_args, String.valueOf(jsonModel.getAmount())));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View payButton) {
                String strAmount = String.valueOf(jsonModel.getAmount());
                ApiClient.getInstance().pay(strAmount, new ApiResponse<FinancialReceiptJsonModel>() {
                    @Override
                    public void onSuccess(FinancialReceiptJsonModel data) {
                        payButton.setEnabled(false);

                        ProgressBar progressBar = findViewById(R.id.pay_loader);
                        progressBar.setVisibility(View.VISIBLE);

                        Snackbar.make(payButton, data.getReceiptNumber(), Snackbar.LENGTH_LONG).addCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                                progressBar.setVisibility(View.GONE);
                                finish();
                            }
                        }).show();
                    }

                    @Override
                    public void onFailed(Exception exception) {
                        payButton.setEnabled(true);
                        Toast.makeText(PayActivity.this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnIris = findViewById(R.id.pay_iris_btn);
        btnIris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getInstance().getIris(jsonModel.getAmount(), new ApiResponse<IRISResponseModel>() {
                    @Override
                    public void onSuccess(IRISResponseModel data) {
                        Log.d("IRIS", data.toString());
                        String url = data.getResp().getBankSelectionToolUrl();

//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        intent.setData(Uri.parse(url));
//                        startActivity(intent);
//
//
//                        Intent intent = new Intent(PayActivity.this, WebViewActivity.class);
//                        intent.putExtra(WebViewActivity.ARG_URL, url);
//                        startActivity(intent);

                        String[] address = new String[]{"vassilis.pigadas@gmail.com"};
                        composeEmail(address, data.getMessageId());
                    }

                    @Override
                    public void onFailed(Exception exception) {

                    }
                });
            }
        });
    }

    private int getImage(String name) {
        switch (name) {
            case "apple":
                return R.drawable.apple;
            case "orange":
                return R.drawable.orange;
            case "pear":
                return R.drawable.pear;
            case "peach":
                return R.drawable.peach;
            case "grapefruit":
                return R.mipmap.ic_launcher;
            case "apricot":
                return R.drawable.apricot;
            case "black_cherry":
                return R.drawable.cherry;
            case "red-cherry":
                return R.drawable.cherry;
            case "grapes":
                return R.drawable.grapes;
            case "mandarin":
                return R.drawable.mandarin;
            case "watermelon":
                return R.drawable.watermelon;
            case "melon":
                return R.drawable.melon;
            case "lemon":
                return R.drawable.lemon;
            case "blueberry":
                return R.drawable.blueberry;
            case "mango":
                return R.drawable.mango;
            default:
                return R.mipmap.ic_launcher;
        }
    }


    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
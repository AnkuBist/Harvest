package com.hgil.harvest;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.hgil.harvest.retrofit.RetrofitService;
import com.hgil.harvest.retrofit.RetrofitUtil;
import com.hgil.harvest.retrofit.loginResponse.loginResponse;

import org.xml.sax.XMLReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUserId)
    EditText etUserId;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.cbSignIn)
    CheckBox cbSignIn;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.coordinateLayout)
    CoordinatorLayout coordinateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String lol = "<ul>\n" +
                "  <li>Coffee</li>\n" +
                "  <li>Tea</li>\n" +
                "  <li>Milk</li>\n" +
                "</ul>";

        ButterKnife.bind(this);
        btnSubmit.setText(Html.fromHtml(lol, null, new UlTagHandler()));
    }

    public class UlTagHandler implements Html.TagHandler{
        @Override
        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {
            if(tag.equals("ul")&& !opening) output.append("\n");
            if(tag.equals("li")&& opening) output.append("\n" +Html.fromHtml("&#8226;"));
        }
    }

    public void onSubmit(View view) {
        String username = etUserId.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (username.isEmpty()) {
            etUserId.requestFocus();
            Toast.makeText(this, "Enter valid user ID", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            etPassword.requestFocus();
            Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
        } else {
            // check for login

        }

        if (cbSignIn.isChecked()) {
            // save the password for the next login too

        }
    }

    /*retrofit call test example*/
    public void getCallLogs() {

        RetrofitUtil.showDialog(this);
        RetrofitService service = RetrofitUtil.retrofitClient();
        Call<loginResponse> apiCall = service.postUserLogin("username", "password");
        apiCall.enqueue(new Callback<loginResponse>() {
            @Override
            public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                RetrofitUtil.hideDialog();

                //ResponseBody bodyResponse = response.body();

                // rest call to read data from api service
                if (true) {
                   /* ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setIndeterminate(false);
                    progressDialog.setMax(100);
                    progressDialog.setCancelable(false);
                    progressDialog.setProgress(0);

                    InputStream inputStream = response.body().byteStream();

                    try {
                        getBytesFromInputStream(inputStream, progressDialog);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/


                } else {
                    RetrofitUtil.showToast(LoginActivity.this, "Error login");
                }
            }

            @Override
            public void onFailure(Call<loginResponse> call, Throwable t) {
                RetrofitUtil.hideDialog();

                // show some error toast or message to display the api call issue
                RetrofitUtil.showToast(LoginActivity.this, "Unable to access API");

            }
        });
    }


   /* public byte[] getBytesFromInputStream(InputStream inputStream, ProgressDialog progressDialog) throws IOException {
        try {
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
                // update dialog progress here only
                progressDialog.setProgress();
            }
            return output.toByteArray();
        } catch (OutOfMemoryError error) {
            return null;
        }
    }*/

    /*access code*/
    private static final int PERMISSION_REQUEST_CODE = 1;

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //startDownload();
                } else {
                    Snackbar.make(coordinateLayout, "Permission Denied, Please allow to proceed !", Snackbar.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

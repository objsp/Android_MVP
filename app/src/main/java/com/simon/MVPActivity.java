package com.simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.simon.bean.User;
import com.simon.p.PresenterUser;
import com.simon.v.ViewUser;

public class MVPActivity extends AppCompatActivity implements ViewUser, View.OnClickListener {

    private EditText inputId, inputName, inputAddr;
    private Button saveBtn, loadBtn;
    private TextView infoTxt;
    private PresenterUser presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_layout);

        this.presenter = new PresenterUser(this);
        initData();
    }

    private void initData() {
        inputId = (EditText) findViewById(R.id.id_input);
        inputName = (EditText) findViewById(R.id.name_input);
        inputAddr = (EditText) findViewById(R.id.addr_input);
        saveBtn = (Button) findViewById(R.id.input_confirm);
        loadBtn = (Button) findViewById(R.id.get_confirm);
        infoTxt = (TextView) findViewById(R.id.show);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void setViewUser(User user) {
        StringBuilder builder = new StringBuilder("");
        builder.append(user.getId());
        builder.append("\n");
        builder.append(user.getName());
        builder.append("\n");
        builder.append(user.getAddress());

        infoTxt.setText(builder.toString());
    }

    @Override
    public User getUserValues() {
        User user = new User();
        String s = inputId.getText().toString();
        if (!TextUtils.isEmpty(s)) { // 为判断是否为数字
            user.setId(Integer.parseInt(s));
        }
        user.setName(inputName.getText().toString());
        user.setAddress(inputAddr.getText().toString());
        return user;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_confirm:
                presenter.saveUser(getUserValues());
                break;
            case R.id.get_confirm:
                presenter.getUser();
                break;
        }
    }
}

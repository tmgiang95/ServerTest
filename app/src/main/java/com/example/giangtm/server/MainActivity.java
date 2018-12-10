package com.example.giangtm.server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static String TAGCLASS = "ServerJava/";
    ServerSocket listener = null;
    Thread proccessingMessage;
    Scanner reader = new Scanner(System.in);
    TextView tvLog;
    EditText etInput;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = findViewById(R.id.tvLog);
        etInput = findViewById(R.id.etInput);
        btnSend = findViewById(R.id.btnSend);

        initSocket();

    }

    private void initSocket() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Mở một ServerSocket tại cổng 9999.
                    // Chú ý bạn không thể chọn cổng nhỏ hơn 1023 nếu không là người dùng
                    // đặc quyền (privileged users (root)).
                    listener = new ServerSocket(9999);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvLog.setText("Server is waiting to accept user...");
                        }
                    });
                    Socket socketOfServer = null;
                    try {
                        socketOfServer = listener.accept();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                    // Chấp nhận một yêu cầu kết nối từ phía Client.
                                    // Đồng thời nhận được một đối tượng Socket tại server.
                                    tvLog.setText(tvLog.getText().toString() +"\n"+ "Accept a client!");
                            }
                        });
                        BufferedReader is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
                        while (true) {
                            try {
                                String line = is.readLine();
                                Log.d("giangtm1", "run: "+ line);
                                if (line != null) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tvLog.setText(tvLog.getText().toString() +"\n"+ "Tin Nhan: ");
                                        }
                                    });
                                    break;
                                }
                            } catch (IOException e) {
                                System.out.println(TAGCLASS + "initMultiThread: " + e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }).start();

    }
}

package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.Camera.AlbumActivity;
import com.example.myapplication.Camera.CameraActivity;
import com.example.myapplication.Contacts.ContactsActivity;
import com.example.myapplication.Database.DatabaseActivity;
import com.example.myapplication.LitePal.LitePalActivity;
import com.example.myapplication.Network.NetworkActivity;
import com.example.myapplication.Notification.NotificationActivity;
import com.example.myapplication.Player.PlayVideoActivity;
import com.example.myapplication.Player.PlayerAudioActivity;
import com.example.myapplication.RecyclerView.RecycleViewActivity;
import com.example.myapplication.RuntimePermissionTest.RuntimePermissionActivity;
import com.example.myapplication.UI.CustomDialogActivity;
import com.example.myapplication.UI.DialogActivity;
import com.example.myapplication.UI.ProgressActivity;
import com.example.myapplication.UI.ToastActivity;
import com.example.myapplication.Network.WebViewActivity;
import com.example.myapplication.activityLife.LifeCycleActivity;
import com.example.myapplication.broadcast.BroadcastActivity;
import com.example.myapplication.dataStorage.DataStorageActivity;
import com.example.myapplication.event.EventActivity;
import com.example.myapplication.fragment.ContainerActivity;
import com.example.myapplication.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mRtnRv;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;
    private Button mBtnEvent;
    private Button mBtnData;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnBroadcast;
    private Button mBtnRuntimePermission;
    private Button mBtnContacts;
    private Button mBtnNotification;
    private Button mBtnCamera;
    private Button mBtnAlbum;
    private Button mBtnPlayerAudio;
    private Button mBtnPlayerVideo;
    private Button mBtnDatabase;
    private Button mBtnLitePal;
    private Button mBtnWebView;
    private Button mBtnNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRtnRv = findViewById(R.id.btn_recyclerview);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnCustomDialog = findViewById(R.id.btn_customdialog);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);
        mBtnRuntimePermission = findViewById(R.id.btn_RuntimePermission);
        mBtnContacts = findViewById(R.id.btn_Contacts);
        mBtnNotification = findViewById(R.id.btn_Notification);
        mBtnCamera = findViewById(R.id.btn_Camera);
        mBtnAlbum = findViewById(R.id.btn_Album);
        mBtnPlayerAudio = findViewById(R.id.btn_PlayerAudio);
        mBtnPlayerVideo = findViewById(R.id.btn_PlayerVideo);
        mBtnDatabase = findViewById(R.id.btn_Database);
        mBtnLitePal = findViewById(R.id.btn_LitePal);
        mBtnWebView = findViewById(R.id.btn_WebView);
        mBtnNetwork = findViewById(R.id.btn_Network);
        setListeners();
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mRtnRv.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnRuntimePermission.setOnClickListener(onClick);
        mBtnContacts.setOnClickListener(onClick);
        mBtnNotification.setOnClickListener(onClick);
        mBtnCamera.setOnClickListener(onClick);
        mBtnAlbum.setOnClickListener(onClick);
        mBtnPlayerAudio.setOnClickListener(onClick);
        mBtnPlayerVideo.setOnClickListener(onClick);
        mBtnDatabase.setOnClickListener(onClick);
        mBtnLitePal.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnNetwork.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_recyclerview:
                    //跳转到recyclerview的演示界面
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;

                case R.id.btn_lifecycle:
                    //跳转到lifecycleview的演示界面
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;

                case R.id.btn_jump:
                    //跳转到AActivity的演示界面
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;

                case R.id.btn_fragment:
                    //跳转到fragment的演示界面
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;

                case R.id.btn_event:
                    //跳转到event的演示界面
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;

                case R.id.btn_data:
                    //跳转到data的演示界面
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;

                case R.id.btn_toast:
                    //跳转到toast的演示界面
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;

                case R.id.btn_dialog:
                    //跳转到dialog的演示界面
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;

                case R.id.btn_progress:
                    //跳转到progress的演示界面
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;

                case R.id.btn_customdialog:
                    //跳转到customdialog的演示界面
                    intent = new Intent(MainActivity.this, CustomDialogActivity.class);
                    break;

                case R.id.btn_broadcast:
                    //跳转到broadcast的演示界面
                    intent = new Intent(MainActivity.this, BroadcastActivity.class);
                    break;

                case R.id.btn_RuntimePermission:
                    //跳转到RuntimePermission的演示界面
                    intent = new Intent(MainActivity.this, RuntimePermissionActivity.class);
                    break;

                case R.id.btn_Contacts:
                    //跳转到Contacts的演示界面
                    intent = new Intent(MainActivity.this, ContactsActivity.class);
                    break;

                case R.id.btn_Notification:
                    //跳转到Notification的演示界面
                    intent = new Intent(MainActivity.this, NotificationActivity.class);
                    break;

                case R.id.btn_Camera:
                    //跳转到Camera的演示界面
                    intent = new Intent(MainActivity.this, CameraActivity.class);
                    break;

                case R.id.btn_Album:
                    //跳转到Album的演示界面
                    intent = new Intent(MainActivity.this, AlbumActivity.class);
                    break;

                case R.id.btn_PlayerAudio:
                    //跳转到PlayerAudio的演示界面
                    intent = new Intent(MainActivity.this, PlayerAudioActivity.class);
                    break;

                case R.id.btn_PlayerVideo:
                    //跳转到PlayerVideo的演示界面
                    intent = new Intent(MainActivity.this, PlayVideoActivity.class);
                    break;

                case R.id.btn_Database:
                    //跳转到Database的演示界面
                    intent = new Intent(MainActivity.this, DatabaseActivity.class);
                    break;

                case R.id.btn_LitePal:
                    //跳转到LitePal的演示界面
                    intent = new Intent(MainActivity.this, LitePalActivity.class);
                    break;

                case R.id.btn_WebView:
                    //跳转到WebView的演示界面
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;

                case R.id.btn_Network:
                    //跳转到Network的演示界面
                    intent = new Intent(MainActivity.this, NetworkActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

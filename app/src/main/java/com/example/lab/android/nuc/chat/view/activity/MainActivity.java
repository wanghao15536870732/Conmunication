package com.example.lab.android.nuc.chat.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.example.lab.android.nuc.chat.adapter.PageAdapter;
import com.example.lab.android.nuc.chat.tools.views.RoundImageView;
import com.example.lab.android.nuc.chat.view.fragment.DynamicsFragment;
import com.example.lab.android.nuc.chat.R;
import com.example.lab.android.nuc.chat.tools.utils.PermissionUtil;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener,IOnSearchClickListener,View.OnClickListener{

    private AlertDialog.Builder alertDialog;
    //aip.lecence初始话
    private boolean hasGotToken = false;
    public static Context mContext;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SearchFragment searchFragment;

    //拍照的Uri
    private Uri imageUri;
    //定义滑动菜单的实例
    private DrawerLayout mDrawerLayout;
    private static final int TAKE_PHOTO = 1;
    private FloatingActionButton addQuestionBtn;
    private RelativeLayout rootView;
    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        ButterKnife.bind(this);
        //先显示默认的标题Chat以后要改为其他的
//        mToolbar.setTitle("SearchDialog");//标题
        //将系统的ToolBar改为自定义的ToolBar
        setSupportActionBar(mToolbar);
        PermissionUtil.verifyStoragePermissions( this );
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            //添加返回功能
            actionBar.setDisplayHomeAsUpEnabled(true);
            //默认的是返回键，更改为菜单键
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        mToolbar.setOnMenuItemClickListener(this);
        searchFragment.setOnSearchClickListener(this);
        alertDialog = new AlertDialog.Builder(this);
        //文字提取初始化
        initAccessToken();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 1:
                if (grantResults.length > 0){
                    //循环遍历
                    for (int result : grantResults){
                        if (result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this, "必须同意所有权限才能使用该功能", Toast.LENGTH_SHORT).show();

                            return;
                        }
                    }
                    Toast.makeText( this, "权限申请成功", Toast.LENGTH_SHORT ).show();
                }else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    /**
     * 创建视图
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView(){
        //找到各自的实例
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        searchFragment = SearchFragment.newInstance();

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager(),this);
        mTabLayout.setTabMode( TabLayout.MODE_FIXED );
        ///为viewPager设置adapter
        mViewPager.setAdapter(adapter);

        //将viewPager添加进leLayout当中
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i= 0;i < mTabLayout.getTabCount();i ++){
            TabLayout.Tab tab = mTabLayout.getTabAt( i );
            //为每个tab设置自定义视图，获取自定视图的方法写在Adapter里面
            //同样也可以直接写在Activity里面
            tab.setCustomView(adapter.getTabView( i ));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search: //点击搜索
                searchFragment.show(getSupportFragmentManager(),SearchFragment.TAG);
                break;
        }
        return true;
    }

    @Override
    public void OnSearchClick(String keyword) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

        }
    }

    private FragmentManager mFragmentManager;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (requestCode == RESULT_OK){
                    String question_link = data.getStringExtra( "question_link" );
                    String question_title = data.getStringExtra("question_title");
                    String question_detail = data.getStringExtra( "question_detail" );
                    DynamicsFragment dynamicsFragment = new DynamicsFragment();

                    mFragmentManager = this.getSupportFragmentManager();
                    FragmentTransaction ft = mFragmentManager.beginTransaction();
                    //创建Bundle来封装传递给fragment
                    Bundle bundle = new Bundle( );
                    bundle.putString("link",question_link);
                    bundle.putString("title",question_title  );
                    bundle.putString( "detail",question_detail );
                    //设置传递的对象
                    dynamicsFragment.setArguments( bundle );
                }
                break;
            default:
        }
    }
    /**
     * 以license文件方式初始化
     */
    private void initAccessToken() {
        OCR.getInstance(this).initAccessToken( new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                alertText("licence方式获取token失败", error.getMessage());
            }
        }, getApplicationContext());
    }

    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }

}

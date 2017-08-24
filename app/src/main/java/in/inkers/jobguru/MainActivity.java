package in.inkers.jobguru;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private WebView wv1;
    private BottomNavigationView nav;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv1=findViewById(R.id.webView);

        nav=findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navHome:
                        wv1.setWebViewClient(new MyBrowser());
                        url = "http://www.jiss.in/jobguru";
                        wv1.getSettings().setLoadsImagesAutomatically(true);
                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        wv1.loadUrl(url);
                        break;
                    case R.id.navSearch:
                        wv1.setWebViewClient(new MyBrowser());
                        url = "http://www.inkers.in";
                        wv1.getSettings().setLoadsImagesAutomatically(true);
                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        wv1.loadUrl(url);
                        break;
                    case R.id.navReg:
                        wv1.setWebViewClient(new MyBrowser());
                        url = "http://www.google.com";
                        wv1.getSettings().setLoadsImagesAutomatically(true);
                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        wv1.loadUrl(url);
                        break;
                    case R.id.navCredit:
                        wv1.setWebViewClient(new MyBrowser());
                        url = "http://www.prominence.co.in";
                        wv1.getSettings().setLoadsImagesAutomatically(true);
                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        wv1.loadUrl(url);
                        break;
                }
                return true;
            }
        });

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (wv1.canGoBack()) {
                        wv1.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
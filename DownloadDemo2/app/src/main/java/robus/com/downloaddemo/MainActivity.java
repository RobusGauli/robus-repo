package robus.com.downloaddemo;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

   DownloadManager downloadManager;
    String downloadFileUrl = "http://ia600300.us.archive.org/4/items/NarayanGopalGoldenHitsCollectionthenpmedia.com/01MaTaLaliGuransBhayechhuthenpmedia.com.mp3";
    private long myDownloadReference;
    private BroadcastReceiver receiverDownloadComplete;
    private BroadcastReceiver receiverNotificationClicked;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        button = (Button)findViewById(R.id.download);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse(downloadFileUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setDescription("dowloading images").setTitle("Nptunes");
        request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "robusDownload.jpg");
        myDownloadReference = downloadManager.enqueue(request);



    }
}

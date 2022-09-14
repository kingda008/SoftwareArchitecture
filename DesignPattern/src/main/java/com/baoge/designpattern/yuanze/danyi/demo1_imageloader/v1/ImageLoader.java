package com.baoge.designpattern.yuanze.danyi.demo1_imageloader.v1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.ims.RcsUceAdapter;
import android.util.LruCache;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载类
 *
 * 所有内容都放在一个地方
 */
public class ImageLoader {
    LruCache<String, Bitmap> mImageCache;
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    Handler mUiHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    public ImageLoader() {
        initImageCache();
    }

    private void initImageCache() {
        //j计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cache = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cache) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void disPlayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    updateImageView(imageView, bitmap);
                }
                mImageCache.put(url, bitmap);
            }
        });
    }

    private void updateImageView(final ImageView imageView, final Bitmap bmp) {
        mUiHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bmp);
            }
        });
    }

    public Bitmap downLoadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL bitmapUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) bitmapUrl.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}

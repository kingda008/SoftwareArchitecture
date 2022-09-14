package com.baoge.designpattern.yuanze.danyi.demo1_imageloader.v2;

import android.graphics.Bitmap;
import android.util.LruCache;

public class ImageCache {

    private LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
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


    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}

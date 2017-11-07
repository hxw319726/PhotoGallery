# PhotoGallery

Android权威编程指南第26章

1. 网络连接的基本代码

            `ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             InputStream inputStream = connection.getInputStream();
 
             if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                 return null;
             }
 
             int byteRead = 0;
             byte[] buffer = new byte[1024];
             while ((byteRead = inputStream.read(buffer)) > 0) {
                 outputStream.write(buffer, 0, byteRead);
             }
             outputStream.close();
             return outputStream.toByteArray();`
2. 网络使用权限

    `<uses-permission android:name="android.permission.INTERNET"/>`
3. AsyncTask后台线程运行
4. XmlPullParser读取xml数据流中的数据
5. AsyncTask回主线程更新ui界面
6. 消息队列:消息循环由一个线程和一个looper组成，looper对象管理着线程和消息队列。
7. HandlerThread.onLooperPrepared()方法的调用发生在Looper第一次检查消息队列之前
8. setImageBitmap()设置图片之前，先调用Fragment.isVisible()检查方法，保证不会设置到无效的ImageView视图上
9. 添加search菜单的回调onSearchRequested()方法
10. 配置activity支持搜索：首先是独立的xml（searchable）配置，在AndroidManifest配置

![image](https://github.com/hxw319726/PhotoGallery/blob/master/sceenshot/1.png)
![image](https://github.com/hxw319726/PhotoGallery/blob/master/sceenshot/2.png)

11. 通过onNewIntent(Intent)方法，可监听到新的Intent
12. 使用shared preferences实现轻量数据缓存：shared preferences本质是一个文件系统中的文件，使用SharedPreferences类来进行读写。
13. 服务创建要求
- manifest注册服务
![image](https://github.com/hxw319726/PhotoGallery/blob/master/sceenshot/3.png)
- 启动服务
![image](https://github.com/hxw319726/PhotoGallery/blob/master/sceenshot/4.png)
14. 添加定时方法
![image](https://github.com/hxw319726/PhotoGallery/blob/master/sceenshot/5.png)

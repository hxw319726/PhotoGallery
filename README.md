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
4.
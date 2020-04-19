package com.amin.lw_02;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileLoader
{
	public static void Load(final String filename, final String urlString)
			throws MalformedURLException, IOException
	{
		App.Log("saveUrl.start");

		BufferedInputStream stream = null;
		FileOutputStream writer = null;
		try
		{
			/*
			URL url = new URL(urlString);
      		URLConnection conn = url.openConnection();
      		conn.connect();
      		int fileLength = conn.getContentLength();
			App.Log("saveUrl.read.fileLength="+fileLength);
			byte [] buffer = new byte[fileLength];
			stream 		= new BufferedInputStream(new URL(urlString).openStream());
			while (stream.read(buffer) != -1);
			App.Log("saveUrl.read.urlString="+urlString);
			*/
			/*
			InputStreamReader isr = new InputStreamReader(stream);
			char[] inputBuffer = new char[stream.available()];
			App.Log("saveUrl.read.fIn.available ="+stream.available());
			isr.read(inputBuffer);
			String readString = new String(inputBuffer);
			App.Log("saveUrl.read.readString ="+readString);
			 */
			// сохранение в файл
			stream 	= new BufferedInputStream(new URL(urlString).openStream());
			writer 	= new FileOutputStream(filename);
			final byte data[] = new byte[1024];
			int count;
			while ((count = stream.read(data, 0, 1024)) != -1)
			{
				writer.write(data, 0, count);
				App.Log("saveUrl.read.count="+count);
			}
		} finally
		{
			if (stream != null)
				stream.close();
			if (writer != null)
				writer.close();
		}
		App.Log("saveUrl.end");
	}}

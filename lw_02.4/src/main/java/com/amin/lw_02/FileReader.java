package com.amin.lw_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader
{
	public static String Read(String filename) throws IOException
	{
		FileInputStream stream = null;
		InputStreamReader reader = null;
		try
		{
			stream = new FileInputStream(filename);
			reader = new InputStreamReader(stream);

			int len = stream.available();
			char[] inputBuffer = new char[len];

			App.Log("saveUrl.read.stream.available ="+len);

			reader.read(inputBuffer);
			String readString 		= new String(inputBuffer);

			App.Log("saveUrl.read.readString ="+readString);

			return readString;
		}
		catch (FileNotFoundException e)
		{
			App.Error(e.getMessage());
			throw e;
		}
		catch (IOException e)
		{
			App.Error(e.getMessage());
			throw e;
		}
		finally
		{
			if (stream != null)
				stream.close();
			if (reader != null)
				reader.close();
		}
	}
}

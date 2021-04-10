package com.kostyukov;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
		printFile(path);
		System.out.println(path.toAbsolutePath());
		path = FileSystems.getDefault().getPath("files\\SubdirectoryFile.txt");
		printFile(path);
		System.out.println(path.toAbsolutePath());
		path = FileSystems.getDefault().getPath("C:\\Projects\\Java\\OutsideLocalFile.txt");
		printFile(path);
		System.out.println(path.toAbsolutePath());
	}
	
	private static void printFile(Path path)
	{
		try(BufferedReader fileReader = Files.newBufferedReader(path))
		{
			String line;
			while ((line = fileReader.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

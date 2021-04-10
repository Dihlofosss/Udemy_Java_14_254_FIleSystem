package com.kostyukov;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Path sourceFile = FileSystems.getDefault().getPath("Examples/file1.txt");
			Path destFIle = FileSystems.getDefault().getPath("Examples/file1_copy.txt");
			
			if (Files.exists(sourceFile) && Files.notExists(destFIle))
			{
				Files.copy(sourceFile,destFIle);
				System.out.println("File: " + sourceFile.toAbsolutePath() + " is copied successfully");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
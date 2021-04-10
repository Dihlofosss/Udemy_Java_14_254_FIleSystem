package com.kostyukov;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Path sourcePath = FileSystems.getDefault().getPath("Examples/file1.txt");
			Path destPath = FileSystems.getDefault().getPath("Examples/file1_copy.txt");
			
			if (Files.exists(sourcePath) && Files.notExists(destPath))
			{
				Files.copy(sourcePath, destPath);
				System.out.println("File: " + sourcePath.toAbsolutePath() + " is copied successfully");
			}
			else
			{
				System.out.println("File: " + destPath.toAbsolutePath() + " is already exists. \nOverwrite? Y/N");
				Scanner scanner = new Scanner(System.in);
				if (scanner.nextLine().equalsIgnoreCase("y"))
				{
					Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("File is overwritten");
				}
			}
			
			sourcePath = FileSystems.getDefault().getPath("Examples", "Dir1");
			destPath = FileSystems.getDefault().getPath("Examples", "Dir4");
			Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
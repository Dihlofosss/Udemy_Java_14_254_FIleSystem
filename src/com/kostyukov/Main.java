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
			Path sourceFile = FileSystems.getDefault().getPath("Examples/file1.txt");
			Path destFIle = FileSystems.getDefault().getPath("Examples/file1_copy.txt");
			
			if (Files.exists(sourceFile) && Files.notExists(destFIle))
			{
				Files.copy(sourceFile, destFIle);
				System.out.println("File: " + sourceFile.toAbsolutePath() + " is copied successfully");
			}
			else
			{
				System.out.println("File: " + destFIle.toAbsolutePath() + " is already exists. \nOverwrite? Y/N");
				Scanner scanner = new Scanner(System.in);
				if (scanner.nextLine().equalsIgnoreCase("y"))
				{
					Files.copy(sourceFile, destFIle, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("File is overwritten");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
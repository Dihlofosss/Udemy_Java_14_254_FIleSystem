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
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Coping file1.txt from ./Examples dir\nEnter a new file's name: ");
			
			Path sourcePath = FileSystems.getDefault().getPath("Examples/file1.txt");
			Path destPath = FileSystems.getDefault().getPath("Examples/" + scanner.nextLine());
			
			if (Files.exists(sourcePath) && Files.notExists(destPath))
			{
				Files.copy(sourcePath, destPath);
				System.out.println("File: " + sourcePath.toAbsolutePath() + " is copied successfully");
			}
			else
			{
				System.out.println("File: " + destPath.toAbsolutePath() + " is already exists. \nOverwrite? Y/N");
				if (scanner.nextLine().equalsIgnoreCase("y"))
				{
					Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("File is overwritten");
				}
			}
			
			System.out.println("Rename " + destPath.getFileName() + "? Y/N");
			
			if (scanner.nextLine().equalsIgnoreCase("y"))
			{
				System.out.print("Enter a new file name: ");
				sourcePath = destPath;
				destPath = FileSystems.getDefault().getPath("Examples", scanner.nextLine());
				Files.move(sourcePath, destPath);
			}
			
			System.out.println("Coping Dir1 -> Dir 4");
			
			sourcePath = FileSystems.getDefault().getPath("Examples", "Dir1");
			destPath = FileSystems.getDefault().getPath("Examples", "Dir4");
			Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
			
			//scanner.reset();
			System.out.println("Delete Dir4? Y/N?");
			if (scanner.nextLine().equalsIgnoreCase("y"))
			{
				Files.delete(destPath);
				System.out.println("Dir4 is deleted");
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
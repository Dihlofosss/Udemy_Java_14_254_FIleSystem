package com.kostyukov;

import java.io.IOException;
import java.nio.file.*;

public class Main
{
	public static void main(String[] args)
	{
		Path directory = FileSystems.getDefault().getPath("Examples");
		DirectoryStream.Filter<Path> filter = entry -> Files.isDirectory(entry) || Files.isRegularFile(entry);
		
		try (DirectoryStream<Path> content = Files.newDirectoryStream(directory, filter))
		{
			for (Path path : content)
			{
				System.out.println(path.getFileName());
			}
		}
		catch (IOException | DirectoryIteratorException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try
		{
			Path tempFile = Files.createTempFile("myapp", ".appdat");
			System.out.println(tempFile.toAbsolutePath());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
		for (FileStore store : stores)
		{
			System.out.println(store);
		}
		
		Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
		for (Path root: rootPaths)
		{
			System.out.println(root);
		}
		
		System.out.println("Walking tree for ./Examples folder");
		try
		{
			Files.walkFileTree(directory, new PrintNames());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
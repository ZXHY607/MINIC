package cn.etl.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import cn.etl.util.FileUtil;

public class FileUtilTest {
	@Test
	public void renameFileTest() throws IOException
	{
		File f = new File("E:\\test.txt");
		f.createNewFile();
		System.out.println(f.getParent());
		System.out.println(f.getName());
		System.out.println(FileUtil.renameFile(f));
	}
}

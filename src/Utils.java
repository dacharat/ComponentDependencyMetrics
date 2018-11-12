import java.io.File;
import java.text.DecimalFormat;

public class Utils {

	public static void main(String[] args) {

		File jcdFile = new File("/Users/jack/eclipse-workspace/groovy/src/main/java/org/codehaus/groovy/transform");

		String[] jcdFiles = jcdFile.list();
		FileRead read = new FileRead();

		System.out.println("Files Found: " + jcdFiles.length);

		for (String myFile : jcdFiles) {
			if (myFile.contains(".java"))
				read.readInFile(jcdFile.toString(), myFile);
		}

		PackageInfo pack = new PackageInfo(read.getNa(), read.getNc(), read.getCa(), read.getCe());
		DecimalFormat df = new DecimalFormat("#.######");

		System.out.println("ca: " + read.getCa());
		System.out.println("ce: " + read.getCe());
		System.out.println("nc: " + read.getNc());
		System.out.println("na: " + read.getNa());
		System.out.println("Instability: " + df.format(pack.getInstability()));
		System.out.println("Abstractness: " + df.format(pack.getAbstractness()));

	}

}
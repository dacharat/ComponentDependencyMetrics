import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.stream.Stream;

public class Utils {
	public static void main(String[] args) {
		try (Stream<Path> paths = Files.walk(Paths.get("/Users/jack/eclipse-workspace/groovy/src/main/java/org"))) {
			paths.forEach(file -> {
				FileRead read = new FileRead();
				File f = new File(file.toString());
				if (f.isDirectory()) {
					File folder = new File(f.getPath());
					String[] files = folder.list();
					for (String myFile : files) {
						if (myFile.contains(".java")) {
							read.readTextFile(folder.toString() + "/" + myFile);
						}
					}
					PackageInfo pack = new PackageInfo(read.getNa(), read.getNc(), read.getCa(), read.getCe());
					DecimalFormat df = new DecimalFormat("#.######");
					try {
						if (!((Double) pack.getInstability()).isNaN() && !((Double) pack.getAbstractness()).isNaN()) {
							// System.out.println(df.format(pack.getInstability()) + ", " +
							// df.format(pack.getAbstractness()));
							System.out.println("Ce: " + read.getCe());
							System.out.println("Ca: " + read.getCa());
							System.out.println("Nc: " + read.getNc());
							System.out.println("Na: " + read.getNa());
							System.out.println("Instability: " + df.format(pack.getInstability()));
							System.out.println("Abstractness: " + df.format(pack.getAbstractness()));
							System.out.println("------------------------------");
						}
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
import java.io.File;

public class Hello {
    static void main(String[] args) {
        System.out.println("Hello world!");

        File configFile = new File("sandbox/build.gradle.kts");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());
    }
}

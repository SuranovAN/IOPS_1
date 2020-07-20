package IOPS_FILES.Install;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("D:\\Games");
        if (file.mkdir()) {
            stringBuilder.append("Папка успешно создана\n");
        } else {
            stringBuilder.append("Не удалось создать папку или она уже создана\n");
        }

        String[] arr = {"src", "res", "savegames", "temp"};
        String[] arr2 = {"main", "test"};
        String[] arr3 = {"Main.java", "Utils.java"};
        String[] arr4 = {"drawables", "vectors", "icons"};

        createFolders(arr, file, "", stringBuilder);
        createFolders(arr2, file, "src\\", stringBuilder);
        createFiles(arr3, file, "src\\main\\", stringBuilder);
        createFolders(arr4, file, "res\\", stringBuilder);

        try {
            stringBuilder.append("temp.txt").append(" ")
                    .append(new File(file.getPath() + "\\" + "temp" + "\\" + "temp.txt").createNewFile())
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("D:\\Games\\temp\\temp.txt", false)) {
            fw.write(String.valueOf(stringBuilder));
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createFolders(String[] arr, File file, String folder, StringBuilder stringBuilder) {
        for (String s : arr) {
            stringBuilder.append(s).append(" ")
                    .append(new File(file.getPath() + "\\" + folder + s).mkdir())
                    .append("\n");
        }
    }

    static void createFiles(String[] arr, File file, String folder, StringBuilder stringBuilder) {
        for (String s : arr) {
            try {
                stringBuilder.append(s).append(" ")
                        .append(new File(file.getPath() + "\\" + folder + s).createNewFile())
                        .append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

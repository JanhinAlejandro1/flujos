
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlujoBytes {
    public static void main(String[] args) throws IOException {
        escribir();
        leer();
        System.out.println();
        leerTodo();
        System.out.println();
        leerPrimeroYultimo();

    }

    public static void leer() throws IOException {
        FileInputStream lector = null;

        try {
            lector = new FileInputStream("datos.txt");
            int num = lector.read();

            while (num != -1) {
                System.out.print((char) num + " ");
                num = lector.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null)
                lector.close();
        }

    }
    public static void leerPrimeroYultimo() throws IOException {
        FileInputStream lector = null;
        try {
            lector = new FileInputStream("datos.txt");
            int[] miArray = new int[2];
            miArray[0]= lector.read();
            lector.skip(24);
            miArray[1]= lector.read();
            System.out.println((char)miArray[0]+" "+(char)miArray[1]);

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            if (lector != null)
                lector.close();
        }
    }

    public static void leerTodo() throws IOException {
        FileInputStream lector = null;
        try {
            lector = new FileInputStream("datos.txt");
            byte[] myArray = new byte[13];
            for (int j = 0; j < 2; j++) {
                System.out.println();
                lector.read(myArray);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.print((char) myArray[i] + " ");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null)
                lector.close();
        }

    }

    public static void escribir() throws IOException {
        FileOutputStream escritor = null;
        try {
            escritor = new FileOutputStream("datos.dat");
            for (int i = 97; i < 123; i++) {
                escritor.write(i);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null)
                escritor.close();
        }
    }
}

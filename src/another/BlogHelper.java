package another;

import java.util.Scanner;

/**
 * 将![[Pasted image 20230331172501.png]]替换为<img src="/post-img/Pasted image 20230331172501.png" alt="图片损坏" style="zoom:50%;" />
 */


public class BlogHelper {
    public static String replaceImageSyntax(String inputText) {
        // 将 ![[xxx.png]] 替换为 <img src="/post-img/xxx.png" alt="图片损坏" style="zoom:50%;" />
        return inputText.replace("![[", "<img src=\"/post-img/")
                .replace("]]", "\" alt=\"图片损坏\" style=\"zoom:100%;\" />");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the image syntax (or type 'exit' to quit): \n");
        while (true) {

            String input = scanner.nextLine(); // 读取整行输入

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            String result = replaceImageSyntax(input);
            System.out.println(result);
        }

        scanner.close();
    }
}

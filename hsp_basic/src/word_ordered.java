import java.io.*;

/**
 * 大雁单词排版
 */

public class word_ordered {
    public static void main(String[] args) {
//        目的：先计算行数,将整体分为三部分
//        第一部分在最后添加”  1.1“，第二部分添加”    1.2“，第三部分添加”    1.3“
//        1.计算行数
        int rows = 0;
        String wordNum = "10";
        String path = "D:\\0Javaer\\Java-demo\\hsp_basic\\word"+wordNum+".txt";
        File file = new File(path);
        rows = CalulateRowsOfTXT(file);
        System.out.println("rows="+rows);

//        1.1 数据预处理，处理非法字符
        RemoveNonAlphabetCharacters(path);

//        2.分为三部分
        int first = 1;
        int second = rows/3+1;
        int third = rows/3 *2 +1;

        AppendToLines(path,first,second-1,"\t"+wordNum+".1");
        AppendToLines(path,second,third-1,"\t"+wordNum+".2");
        AppendToLines(path,third,rows,"\t"+wordNum+".3");


    }

//    函数：计算行数
    private static Integer CalulateRowsOfTXT(File file) {
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("行数：" + count);
        return count;
    }
//  函数：指定行数范围内，每行行末添加指定内容
    private static void AppendToLines(String filepath,int startLine,int endLine,String appendText){
        try {
            // 创建临时文件
            File inputFile = new File(filepath);
            File tempFile = new File("tempfile");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            int lineNumber = 1;

            while ((currentLine = reader.readLine())!=null){
                if (lineNumber >= startLine && lineNumber <=endLine){
                    currentLine += appendText;
                }
                writer.write(currentLine+System.lineSeparator());
                lineNumber++;
            }

            writer.close();
            reader.close();
            // 删除原文件，重命名临时文件
            if (inputFile.delete()){
                tempFile.renameTo(inputFile);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//  函数：删除文本中非字母的字符
    private static void RemoveNonAlphabetCharacters(String filepath){
        try {
            // 创建临时文件
            File inputFile = new File(filepath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine())!=null){
                // 使用正则表达式去除每行开头非字母的字符
                currentLine = currentLine.replaceAll("^[^a-zA-Z]+","");
                writer.write(currentLine+System.lineSeparator());
            }
            writer.close();
            reader.close();

            // 删除原文件，重命名临时文件
            if(inputFile.delete()){
                tempFile.renameTo(inputFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//String currentLine;
//
//            while ((currentLine = reader.readLine()) != null) {
//                    // 使用正则表达式去除每行开头非字母的字符
//                    currentLine = currentLine.replaceAll("^[^a-zA-Z]+", "");
//                    writer.write(currentLine + System.lineSeparator());
//                    }
//
//                    writer.close();
//                    reader.close();
//
//                    // 删除原文件并重命名临时文件
//                    if (inputFile.delete()) {
//                    tempFile.renameTo(inputFile);
//                    }


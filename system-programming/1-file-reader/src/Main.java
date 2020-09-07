import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // init input file
        initFile("in.txt");
        String data = "";
        try {
            data = readFileAsString("in.txt");
            System.out.println("Reading from file...");
        } catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println(data);
        data = data.replaceAll("[\n]", "");
        List<String> words = new ArrayList<>(Arrays.asList(data.split("[-+*/= (),.?!&`';:]")));
        HashSet<String> doubleConsonants = new HashSet<>(
                Arrays.asList(
                        "bb", "cc", "dd", "ff", "gg", "hh", "jj", "kk", "ll", "mm", "nn", "pp",
                        "qq", "rr", "ss", "tt", "vv", "ww", "xx", "zz"));
        List<String> result = new ArrayList<>();
        int i = 0;
        for (String word : words) {
            i++;
            for (String pair : doubleConsonants) {
                if (word.contains(pair)) {
                    if (!result.contains(word)) {
                        result.add(word);
                        break;
                    }
                }
            }
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println(result);
        try {
            FileWriter myWriter = new FileWriter("out.txt");
            myWriter.write("Results:\n");
            for (String word : result) {
                if (!word.isEmpty()) {
                    myWriter.write(word + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String data = "";
        String s;
        while ((s = reader.readLine()) != null) {
            data = data + " " + s;
        }
        return data;
    }

    private static void initFile(String fileName) {
        final int N = 1;
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (int i = 0; i < N; i++) {
                myWriter.write("Assessment\n" +
                        "Assessment at senior cycle takes different forms and can be used in a variety of ways. " +
                        "Assessment can and should be supportive of learning.\n" +
                        "\n" +
                        "Assessment in the classroom\n" +
                        "Assessment is an integral part of teaching and learning and, as such, it is used to support " +
                        "and improve learning by helping learners and teachers to identify next steps in their learning. " +
                        "In this sense, the most valuable assessment takes place at the site of learning where learners " +
                        "receive support and guidance. Learning is best supported in the classroom context when clear " +
                        "goals are established between teacher and learner and when images of successful learning can " +
                        "be shared by reference to those goals. The process of providing effective feedback to learners " +
                        "is supported through the statements of learning outcomes in syllabus documents.\n" +
                        "\n" +
                        "Assessment in the state examinations\n" +
                        "Formal assessment in senior cycle, as used to test and certify achievement, is managed through " +
                        "the State examinations, administered by the State Examinations Commission. A broad range of " +
                        "assessment methods are used across the range of Leaving Certificate subjects, including oral " +
                        "and aural examinations, coursework and practical examinations.\n" +
                        "\n" +
                        "At the end of senior cycle, students who have followed the Leaving Certificate (Established) take " +
                        "the Leaving Certificate examination. Student achievement in this examination is directly linked " +
                        "to processes of selection for courses of study in further and higher education. In addition to the" +
                        " examinations taken by other students, students who follow the Leaving Certificate Vocational " +
                        "Programme take an examination paper and submit a portfolio in the Link Modules. " +
                        "Students who follow the Leaving Certificate Applied programme take a final examination and also " +
                        "accumulate credits over the two years of study. Further information on the assessment of the " +
                        "various subjects is found in the syllabus of each subject.\n");
            }
            myWriter.close();
            System.out.println("Successfully init input file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

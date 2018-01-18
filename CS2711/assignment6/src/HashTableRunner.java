import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program creates four different hash tables to showcase the linear probing and separate chaining collision handling methods in
 * use with two different hash functions, the division method, and the MAD method.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public class HashTableRunner {
    public static void main(String[] args) {
        //Create the students which will be input into the hash table.
        Student stud1 = new Student("201237670", "Brandon", 3.7);
        Student stud2 = new Student("201176427", "Adam", 3.9);
        Student stud3 = new Student("201256257", "Griffin", 4.0);
        Student stud4 = new Student("200998724", "Shawn", 3.1);
        Student stud5 = new Student("200887243", "Michelle", 3.3);
        Student stud6 = new Student("201378334", "Irene", 2.8);
        Student stud7 = new Student("201453209", "Lukas", 3.2);
        Student stud8 = new Student("200709824", "Tyler", 2.5);

        ArrayList<Student> studList = new ArrayList<>(Arrays.asList(stud1,stud2,stud3,stud4,stud5,stud6,stud7,stud8));
        ArrayList<String> keys = new ArrayList<>(Arrays.asList(
                stud1.getStudentNum(),
                stud2.getStudentNum(),
                stud3.getStudentNum(),
                stud4.getStudentNum(),
                stud5.getStudentNum(),
                stud6.getStudentNum(),
                stud7.getStudentNum(),
                stud8.getStudentNum()
        ));

        //Create the four different hash tables.
        LinearProbeHashMap<Student> probeFirstFunction = new LinearProbeHashMap<>(31, 101);
        LinearProbeHashMap<Student> probeSecondFunction = new LinearProbeHashMap<>(31, 101);
        SeparateChainHashMap<Student> chainFirstFunction = new SeparateChainHashMap<>(31, 101);
        SeparateChainHashMap<Student> chainSecondFunction = new SeparateChainHashMap<>(31, 101);

        //Input the students into the hash tables.
        for(Student stud: studList) {
            String studentNum = stud.getStudentNum();
            int firstFunctionCode = probeFirstFunction.firstHashFunction(studentNum);
            int secondFunctionCode = probeSecondFunction.secondHashFunction(studentNum);

            probeFirstFunction.put(firstFunctionCode, studentNum, stud);
            probeSecondFunction.put(secondFunctionCode, studentNum, stud);

            chainFirstFunction.put(firstFunctionCode, studentNum, stud);
            chainSecondFunction.put(secondFunctionCode, studentNum, stud);
        }

        //Output the prob sequence for the keys given in their original order.
        System.out.println("This is the probe sequence for the first hash function with linear probing \n" + probeFirstFunction.firstFunctProbeSequence(keys));
        System.out.println("This is the probe sequence for the first hash function with separate chaining \n" + chainFirstFunction.firstFunctProbeSequence(keys));
        System.out.println("This is the probe sequence for the second hash function with linear probing \n" + probeSecondFunction.secondFunctProbeSequence(keys));
        System.out.println("This is the probe sequence for the second hash function with separate chaining \n" + chainSecondFunction.secondFunctProbeSequence(keys));

    }
}

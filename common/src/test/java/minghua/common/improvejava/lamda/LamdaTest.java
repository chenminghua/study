package minghua.common.improvejava.lamda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author: minghua
 * @date: 2019/8/6 15:29
 * @modified By:
 */
public class LamdaTest {
    @Test
    public void testCommon() {
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("小明", 25, 175);
        System.out.println(student.getName() + "身高大于185吗？" + predicate.test(student.getStature()));

        Consumer<String> consumer = System.out::println;
        consumer.accept("你再说设呢么？");
        consumer.accept("你再说设呢么？？");

        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);

        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);

        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);
    }

    @Test
    public void testMap() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void testFilter() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        List<Student> list = students.stream()
                .filter(stu -> stu.getStature() < 180)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testCollect() {
        List<Student> studentList = Stream.of(
                new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toList());
        System.out.println(studentList);
    }

    @Test
    public void testFlatMap() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));


        List<Student> studentList = Stream.of(students, asList(new Student("艾斯", 25, 183),
                new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);
    }

    @Test
    public void testMaxMin() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        Optional<Student> max = students.stream()
                .max(Comparator.comparing(Student::getAge));
        Optional<Student> min = students.stream()
                .min(Comparator.comparing(Student::getAge));
        //判断是否有值
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        if (min.isPresent()) {
            System.out.println(min.get());
        }
    }

    @Test
    public void testCount() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        long count = students.stream().filter(s1 -> s1.getAge() < 45).count();
        System.out.println("年龄小于45岁的人数是：" + count);
    }

    @Test
    public void testReduce() {
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc+ x);
        System.out.println(reduce);
    }

}

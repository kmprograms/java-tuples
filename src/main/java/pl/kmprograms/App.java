package pl.kmprograms;


import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import org.javatuples.*;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class App
{
    public static void main( String[] args )
    {
        // ----------------------------------------------------------------------
        // ------------------------- JAVATUPLES ---------------------------------
        // ----------------------------------------------------------------------

        // ------------------------- TWORZENIE ----------------------------------
        Pair<String, Integer> pair1 = Pair.with("JOHN", 10);
        Triplet<String, Integer, LocalDate> triplet1 = Triplet.with("JOHN", 10, LocalDate.now());
        // Quartet, Quintet, Sextet, Septet, Octet, Ennead, Decade

        Triplet<Integer, Integer, Integer> triplet2
                = Triplet.fromIterable(IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList()));

        Triplet<Integer, Integer, Integer> triplet3 = Triplet.fromArray(new Integer[]{ 10, 20, 30 });

        // --------------------- ZARZADZANIE POLAMI -----------------------------
        System.out.println(triplet3.getValue0());
        System.out.println(triplet3.getValue1());
        System.out.println(triplet3.getValue2());

        Triplet<Integer, Integer, Integer> triplet33;
        triplet33 = triplet3.setAt0(100);
        triplet33 = triplet33.setAt1(200);
        triplet33 = triplet33.setAt2(300);
        System.out.println(triplet33.getValue0());
        System.out.println(triplet33.getValue1());
        System.out.println(triplet33.getValue2());

        // ------------------------- KONWERSJE ----------------------------------
        Pair<String, String> pair2 = Pair.with("A", "B");
        Triplet<String, String, String> triplet4 = pair2.add("C");
        Pair<String, String> pair3 = triplet4.removeFrom2();
        System.out.println(pair2);
        System.out.println(triplet4);
        System.out.println(pair3);


        // ---------------------------- VAVR ------------------------------------
        Tuple2<String, Integer> t1 = Tuple.of("ANDY", 30);
        // Tuple3, Tuple4, Tuple5
        System.out.println(t1._1());
        System.out.println(t1._2());
        System.out.println(t1);

        Tuple2<Integer, String> t2 = t1.map( String::length, String::valueOf );
        System.out.println(t2);

        Tuple2<Integer, String> t3 = t1.map(( s, i ) -> Tuple.of(i, s));
        System.out.println(t3);

        String res = t1.apply(( s, i ) -> s + String.valueOf(i));
        System.out.println(res);




    }
}

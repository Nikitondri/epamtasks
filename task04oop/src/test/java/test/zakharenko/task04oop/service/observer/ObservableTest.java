package test.zakharenko.task04oop.service.observer;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.observer.impl.QuadrangleObserverImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ObservableTest {

    public static Stream<Arguments> unsubscribeData(){
        Quadrangle quadrangle1 = new Quadrangle();
        quadrangle1.subscribe(new QuadrangleObserverImpl());
        Quadrangle quadrangle2 = new Quadrangle();
        QuadrangleObserverImpl quadrangleObserver = new QuadrangleObserverImpl();
        quadrangle2.subscribe(quadrangleObserver);
        quadrangle2.subscribe(new QuadrangleObserverImpl());
        quadrangle2.unsubscribe(quadrangleObserver);
        quadrangle2.subscribe(new QuadrangleObserverImpl());
        return Stream.of(
                Arguments.of(new Quadrangle(), 0),
                Arguments.of(quadrangle1, 1),
                Arguments.of(quadrangle2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("unsubscribeData")
    void unsubscribeTest(Quadrangle quadrangle, int expected){
        Assertions.assertEquals(expected, quadrangle.findObserversSize());
    }
}

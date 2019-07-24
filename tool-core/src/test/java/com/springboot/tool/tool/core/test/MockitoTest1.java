package com.springboot.tool.tool.core.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @Author chenjunbin
 * @Date 2019/7/4
 * @Description
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest1 {

    @Mock
    private List mockedList;

    @Test
    public void test1() {

        List mockedList = mock(List.class);

        //using mock object
//        mockedList.add("one");
//        mockedList.clear();
//
//        System.out.println(11);
//
//        //verification
//        verify(mockedList).add("one");
//        verify(mockedList).clear();
//        System.out.println(JSON.toJSONString(mockedList));


        //stubbing
//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
//
//        System.out.println(mockedList.get(0));
//
//        try {
//            System.out.println(mockedList.get(1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(mockedList.get(0));

//        System.out.println(mockedList.get(999));
//
//        verify(mockedList).get(0);


//        when(mockedList.get(anyInt())).thenReturn("first");
//
//        mockedList.add("1");
//        mockedList.add("2");
//
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
//        System.out.println(mockedList.get(2));


//        verify(mockedList,times(2)).someM(anyInt(), anyString(), eq("third argument"));


//        doThrow(new RuntimeException()).when(mockedList).clear();

//        doThrow((new Exception())).when(mockedList).clear();

//        verifyNoMoreInteractions(mockedList);

//        System.out.println("--------");
//        when(mockedList.get(anyInt())).thenReturn(anyString(), "11", "12", "11");
//        System.out.println(mockedList.get(10));
//
//
//        System.out.println("--------");
//        System.out.println(mockedList.get(10));
//        System.out.println(mockedList.get(10));
//        System.out.println(mockedList.get(10));
//        System.out.println(mockedList.get(10));
//
//
//        when(mockedList.get(anyInt())).thenAnswer(
//                new Answer() {
//                    public Object answer(InvocationOnMock invocation) {
//                        Object[] args = invocation.getArguments();
//                        Object mock = invocation.getMock();
//                        Method method = invocation.getMethod();
////                        Object realMethod = invocation.callRealMethod();
//                        System.out.println(JSON.toJSONString(mock));
//                        System.out.println(JSON.toJSONString(method));
//                        return "called with arguments: " + Arrays.toString(args) ;
//                    }
//                });
//
//        //Following prints "called with arguments: [foo]"
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(2));
//
//
//        System.out.println("mockedList:"+mockedList);
//        doReturn(false).when(mockedList).add("1");
//        System.out.println(mockedList.add("1"));
//
//        System.out.println("mockedList:"+mockedList);



        List list = new LinkedList();
        list.add("1");
        list.add("23");
        List spy = spy(list);

//        System.out.println(list.get(0));
//        System.out.println(spy.get(1));
//        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
//        when(spy.get(0)).thenReturn("foo");
//
//        System.out.println(list.get(1));
//        System.out.println(spy.get(0));
//        //You have to use doReturn() for stubbing
//        doReturn("foo22").when(spy).get(0);
//
//        System.out.println(spy.get(0));
        when(spy.add("11")).thenReturn(true);
        System.out.println(spy.get(2));

        when(spy.add("22")).thenCallRealMethod();
        System.out.println(spy.get(3));



        List<String> spyList = Mockito.spy(list);

        when(spyList.size()).thenReturn(99);
        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        System.out.println(spyList.size());
        System.out.println(list.size());
//        assertEquals(2, spyList.size());


    }
}

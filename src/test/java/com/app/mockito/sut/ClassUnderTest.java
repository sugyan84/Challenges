package com.app.mockito.sut;

import java.util.List;
import java.util.stream.Collectors;


public class ClassUnderTest {

    private ActiveMQInterface activeMQInterface;

    public List<String> getCourseNames(String user) {
        List<String> courseNames = activeMQInterface.getCourseNames(user);

        List<String> spring = courseNames.stream().filter(courseName -> courseName.contains("Spring"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return spring;
    }
}

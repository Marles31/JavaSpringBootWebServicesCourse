package com.bm.soap.webservices.coursemanagement.soap;

import com.bm.soap.webservices.coursemanagement.soap.bean.Course;
import com.bm.soap.webservices.coursemanagement.soap.exception.CourseNotFoundException;
import com.bm.soap.webservices.coursemanagement.soap.service.CourseDetailsService;
import com.in28minutes.courses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;

    //method
    //input - GetCourseDetailsRequest
    //output - GetCourseDetailsResponse

    //http://in28minutes.com/courses
    //GetCourseDatailsRequest

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse proccessCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

        Course course = service.findById(request.getId());

        if(course==null){
            throw new CourseNotFoundException("Invalid Course Id "+request.getId());
        }

        return mapCourseDetails(course);
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();

        response.setCourseDetails(mapCourse(course));

        return response;
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();

        for(Course course:courses){
            CourseDetails mapCourse = mapCourse(course);
            response.getCourseDetails().add(mapCourse);
        }

        return response;
    }

    private CourseDetails mapCourse(Course course) {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse
    proccessAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {

        List<Course> courses = service.findAll();

        return mapAllCourseDetails(courses);
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse
    deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {

        CourseDetailsService.Status status = service.deleteById(request.getId());

        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(mapStatus(status));

        return response;
    }

    private Status mapStatus(CourseDetailsService.Status status) {
        if(status== CourseDetailsService.Status.FAILURE){
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

}

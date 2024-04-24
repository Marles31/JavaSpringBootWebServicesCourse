//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.04.05 a las 01:24:37 PM COT 
//


package com.in28minutes.courses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseDetails" type="{http://in28minutes.com/courses}CourseDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "courseDetails"
})
@XmlRootElement(name = "GetCourseDetailsResponse")
public class GetCourseDetailsResponse {

    @XmlElement(name = "CourseDetails", required = true)
    protected CourseDetails courseDetails;

    /**
     * Obtiene el valor de la propiedad courseDetails.
     * 
     * @return
     *     possible object is
     *     {@link CourseDetails }
     *     
     */
    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    /**
     * Define el valor de la propiedad courseDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseDetails }
     *     
     */
    public void setCourseDetails(CourseDetails value) {
        this.courseDetails = value;
    }

}

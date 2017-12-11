/**
 * 
 */
package com.avinash.taskmanager.demo.common.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;

/**
 * @author Avinash
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface DeleteDocumentType {

	String name() default "";

	Class<?> documentType() default DeleteDocument.class;
}

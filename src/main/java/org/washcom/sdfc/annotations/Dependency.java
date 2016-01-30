package org.washcom.sdfc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a field that is part of a class' externally-managed dependency.
 * @author Joe
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD) 
public @interface Dependency {
    
}

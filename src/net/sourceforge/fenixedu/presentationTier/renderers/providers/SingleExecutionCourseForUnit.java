package net.sourceforge.fenixedu.presentationTier.renderers.providers;

import net.sourceforge.fenixedu.presentationTier.renderers.converters.DomainObjectKeyConverter;
import pt.ist.fenixWebFramework.renderers.DataProvider;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

public class SingleExecutionCourseForUnit extends ExecutionCoursesForUnit implements DataProvider {

	@Override
	public Converter getConverter() {
        return new DomainObjectKeyConverter();
    }
}

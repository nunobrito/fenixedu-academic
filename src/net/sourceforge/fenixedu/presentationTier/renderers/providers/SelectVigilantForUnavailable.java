package net.sourceforge.fenixedu.presentationTier.renderers.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.fenixedu.domain.vigilancy.Vigilant;
import net.sourceforge.fenixedu.domain.vigilancy.VigilantGroup;
import net.sourceforge.fenixedu.presentationTier.Action.vigilancy.UnavailablePeriodBean;
import net.sourceforge.fenixedu.presentationTier.renderers.converters.DomainObjectKeyConverter;
import pt.ist.fenixWebFramework.renderers.DataProvider;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

import org.apache.commons.beanutils.BeanComparator;

public class SelectVigilantForUnavailable implements DataProvider {

    public Object provide(Object source, Object currentValue) {

        UnavailablePeriodBean bean = (UnavailablePeriodBean) source;
        VigilantGroup vigilantGroup = bean.getSelectedVigilantGroup();

        List<Vigilant> vigilants = new ArrayList<Vigilant>();
        if (vigilantGroup != null) {
            vigilants.addAll(vigilantGroup.getVigilants());
            Collections.sort(vigilants, new BeanComparator("person.name"));
        }
        return vigilants;

    }

    public Converter getConverter() {
        return new DomainObjectKeyConverter();
    }

}
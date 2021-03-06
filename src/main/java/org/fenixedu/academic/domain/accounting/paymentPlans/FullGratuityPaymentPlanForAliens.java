/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Academic.
 *
 * FenixEdu Academic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Academic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Academic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.fenixedu.academic.domain.accounting.paymentPlans;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.fenixedu.academic.domain.ExecutionYear;
import org.fenixedu.academic.domain.accounting.paymentPlanRules.FirstTimeInstitutionStudentsPaymentPlanRule;
import org.fenixedu.academic.domain.accounting.paymentPlanRules.HasEnrolmentsForExecutionSemesterPaymentPlanRule;
import org.fenixedu.academic.domain.accounting.paymentPlanRules.IsAlienRule;
import org.fenixedu.academic.domain.accounting.paymentPlanRules.PaymentPlanRule;
import org.fenixedu.academic.domain.accounting.paymentPlanRules.PaymentPlanRuleFactory;
import org.fenixedu.academic.domain.accounting.serviceAgreementTemplates.DegreeCurricularPlanServiceAgreementTemplate;

public class FullGratuityPaymentPlanForAliens extends FullGratuityPaymentPlanForAliens_Base {

    protected FullGratuityPaymentPlanForAliens() {
        super();
    }

    public FullGratuityPaymentPlanForAliens(final ExecutionYear executionYear,
            final DegreeCurricularPlanServiceAgreementTemplate serviceAgreementTemplate, final Boolean defaultPlan) {
        this();
        super.init(executionYear, serviceAgreementTemplate, defaultPlan);
    }

    public FullGratuityPaymentPlanForAliens(final ExecutionYear executionYear,
            final DegreeCurricularPlanServiceAgreementTemplate serviceAgreementTemplate) {
        this(executionYear, serviceAgreementTemplate, false);
    }

    @Override
    protected Collection<PaymentPlanRule> getSpecificPaymentPlanRules() {
        return Arrays.asList(PaymentPlanRuleFactory.create(IsAlienRule.class),
                PaymentPlanRuleFactory.create(HasEnrolmentsForExecutionSemesterPaymentPlanRule.class),
                PaymentPlanRuleFactory.create(FirstTimeInstitutionStudentsPaymentPlanRule.class));
    }

    @Override
    protected Set<Class<? extends GratuityPaymentPlan>> getPaymentPlansWhichHasPrecedence() {
        Set<Class<? extends GratuityPaymentPlan>> plans = new HashSet<Class<? extends GratuityPaymentPlan>>();
        plans.add(FullGratuityPaymentPlan.class);
        plans.add(FullGratuityPaymentPlanForFirstTimeInstitutionStudents.class);
        plans.add(FullGratuityPaymentPlanForPartialRegime.class);
        plans.add(GratuityForStudentsInSecondCurricularYear.class);
        plans.add(GratuityForStudentsInSecondCurricularYearForPartialRegime.class);
        plans.add(GratuityPaymentPlanForPartialRegimeEnroledOnlyInSecondSemester.class);
        plans.add(GratuityPaymentPlanForStudentsEnroledOnlyInSecondSemester.class);
        return plans;
    }

}

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
package org.fenixedu.academic.domain.degreeStructure;

import static org.fenixedu.academic.predicate.AccessControl.check;

import org.fenixedu.academic.domain.ExecutionSemester;
import org.fenixedu.academic.domain.exceptions.DomainException;
import org.fenixedu.academic.predicate.RolePredicates;

public class BranchCourseGroup extends BranchCourseGroup_Base {

    protected BranchCourseGroup() {
        super();
    }

    public BranchCourseGroup(final String name, final String nameEn, final BranchType branchType) {
        check(this, RolePredicates.MANAGER_PREDICATE);
        super.init(name, nameEn);
        String[] args = {};
        if (branchType == null) {
            throw new DomainException("error.degreeStructure.BranchCourseGroup.branch.type.cannot.be.null", args);
        }
        setBranchType(branchType);
    }

    public BranchCourseGroup(final CourseGroup parentCourseGroup, final String name, final String nameEn,
            final BranchType branchType, final ExecutionSemester begin, final ExecutionSemester end) {

        String[] args = {};
        if (branchType == null) {
            throw new DomainException("error.degreeStructure.BranchCourseGroup.branch.type.cannot.be.null", args);
        }

        init(parentCourseGroup, name, nameEn, begin, end);
        setBranchType(branchType);
    }

    @Override
    public boolean isBranchCourseGroup() {
        return true;
    }

    public boolean isMajor() {
        return getBranchType() == BranchType.MAJOR;
    }

    public boolean isMinor() {
        return getBranchType() == BranchType.MINOR;
    }

}

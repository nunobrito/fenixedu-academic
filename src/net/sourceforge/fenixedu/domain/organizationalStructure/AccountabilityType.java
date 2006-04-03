package net.sourceforge.fenixedu.domain.organizationalStructure;

import java.util.List;

import net.sourceforge.fenixedu.domain.RootDomainObject;

public class AccountabilityType extends AccountabilityType_Base {
    
    public AccountabilityType(AccountabilityTypeEnum accountabilityTypeEnum) {
        super();
        setRootDomainObject(RootDomainObject.getInstance());
        setType(accountabilityTypeEnum);
    }

    public static AccountabilityType readAccountabilityTypeByType(AccountabilityTypeEnum typeEnum) {
        List<AccountabilityType> allAccountabilityTypes = RootDomainObject.getInstance()
                .getAccountabilityTypes();
        for (AccountabilityType accountabilityType : allAccountabilityTypes) {
            if (accountabilityType.getType().equals(typeEnum)) {
                return accountabilityType;
            }
        }
        return null;
    }   
}

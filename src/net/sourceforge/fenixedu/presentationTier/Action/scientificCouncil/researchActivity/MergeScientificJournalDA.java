package net.sourceforge.fenixedu.presentationTier.Action.scientificCouncil.researchActivity;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.fenixedu.dataTransferObject.MergeResearchActivityPageContainerBean;
import net.sourceforge.fenixedu.dataTransferObject.MergeScientificJournalPageContainerBean;
import net.sourceforge.fenixedu.domain.research.activity.ScientificJournal;
import pt.ist.fenixWebFramework.renderers.utils.RenderUtils;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MergeScientificJournalDA extends MergeResearchActivityDA {
    
    public ActionForward chooseScientificJournal(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) {
	MergeScientificJournalPageContainerBean researchActivityPageContainerBean = 
	    (MergeScientificJournalPageContainerBean) getRenderedObject("mergeList");
	ScientificJournal scientificJournal = (ScientificJournal) researchActivityPageContainerBean.getSelected();
	researchActivityPageContainerBean.setSelected(null);
	
	copyProperties(scientificJournal, researchActivityPageContainerBean);
	
	RenderUtils.invalidateViewState();
	request.setAttribute("mergeList", researchActivityPageContainerBean);
	return mapping.findForward("show-research-activity-merge-list");
    }

    private void copyProperties(ScientificJournal scientificJournal, MergeScientificJournalPageContainerBean researchActivityPageContainerBean) {
	researchActivityPageContainerBean.setName(scientificJournal.getName());
	researchActivityPageContainerBean.setIssn(scientificJournal.getIssn());
	researchActivityPageContainerBean.setUrl(scientificJournal.getUrl());
	researchActivityPageContainerBean.setResearchActivityLocationType(scientificJournal.getLocationType());
	researchActivityPageContainerBean.setStage(scientificJournal.getStage());
    }
    
    
    @Override
    protected MergeResearchActivityPageContainerBean getNewBean() {
        return new MergeScientificJournalPageContainerBean();
    }

    @Override
    protected String getServiceName() {
	return "MergeScientificJournals";
    }
    
    @Override
    protected List getObjects(MergeResearchActivityPageContainerBean researchActivityPageContainerBean) {
	List<ScientificJournal> scientificJournals = new ArrayList<ScientificJournal>(rootDomainObject.getScientificJournals());
	Collections.sort(scientificJournals, new BeanComparator("name", Collator.getInstance()));
        return scientificJournals;
    }

    
    
}

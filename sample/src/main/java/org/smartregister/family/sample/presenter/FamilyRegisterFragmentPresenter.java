package org.smartregister.family.sample.presenter;

import org.smartregister.family.contract.FamilyRegisterFragmentContract;
import org.smartregister.family.presenter.BaseFamilyRegisterFragmentPresenter;
import org.smartregister.family.util.DBConstants;

public class FamilyRegisterFragmentPresenter extends BaseFamilyRegisterFragmentPresenter {

    public FamilyRegisterFragmentPresenter(FamilyRegisterFragmentContract.View view, String viewConfigurationIdentifier) {
        super(view, viewConfigurationIdentifier);
    }

    @Override
    public String getMainCondition() {
        return "";
    }

    @Override
    public String getDefaultSortQuery() {
        return DBConstants.KEY.LAST_INTERACTED_WITH + " DESC ";
    }

}
